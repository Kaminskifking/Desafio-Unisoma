package com.salary.unisoma.controllers;


import com.salary.unisoma.dtos.EmployeeDTO;
import com.salary.unisoma.mapper.EmployeeMapper;

import com.salary.unisoma.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/employee")
    public ResponseEntity<List<EmployeeDTO>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAll());
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        Optional<EmployeeDTO> employee = employeeService.findById(id);
        if(!employee.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee Not Found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findById(id));
    }

    @PutMapping("/employee")
    public ResponseEntity update(@RequestBody EmployeeDTO employeeDTO) {
        Optional<EmployeeDTO> employeeModelOptional = employeeService.findById(employeeDTO.getId());
        if(!employeeModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee Not Found");
        }
            var employeeUpdated = employeeService.update(employeeDTO);
            return ResponseEntity.status(HttpStatus.OK).body(employeeUpdated);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Optional<EmployeeDTO> userModelOptional = employeeService.findById(id);
        if (!userModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee Not Found");
        } else {
            employeeService.delete(userModelOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Employee deleted success");
        }
    }

    @PostMapping("/employee")
    public ResponseEntity create(@Valid @RequestBody EmployeeDTO employeeDto) {
        if(employeeService.findByCpf(employeeDto.getCpf()) != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Employee already exists in the database");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employeeDto));
    }

}

