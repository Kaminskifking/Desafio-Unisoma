package com.salary.unisoma.controllers;


import com.salary.unisoma.dtos.ReadjustmentDTO;
import com.salary.unisoma.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/adjust")
public class SalaryController {
    @Autowired
    SalaryService salaryService;
    @GetMapping("/{cpf}")
    public ResponseEntity findByCpf(@PathVariable String cpf) {
        ReadjustmentDTO salary = salaryService.findByCpf(cpf);
        if(salary == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not Found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(salaryService.findByCpf(cpf));
    }
}
