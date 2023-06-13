package com.salary.unisoma.services.impl;

import com.salary.unisoma.dtos.EmployeeDTO;
import com.salary.unisoma.mapper.EmployeeMapper;
import com.salary.unisoma.models.EmployeeModel;
import com.salary.unisoma.repositories.EmployeeRepository;
import com.salary.unisoma.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper mapper;
    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public EmployeeModel findByCpf(String cpf) {
        return employeeRepository.findByCpf(cpf);
    }

    @Override
    public List<EmployeeDTO> findAll() {
        return mapper.toDto(employeeRepository.findAll());
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        EmployeeModel employeeSave = mapper.toEntity(employeeDTO);
        EmployeeModel employee = employeeRepository.save(employeeSave);

        return mapper.toDto(employee);
    }

    @Override
    public Optional<EmployeeDTO> findById(Long id) {
        return employeeRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public void delete(EmployeeDTO employeeDTO) {
        employeeRepository.deleteById(employeeDTO.getId());
    }

    @Override
    public EmployeeDTO update(EmployeeDTO employeeDTO) {
        EmployeeModel employee = mapper.toEntity(employeeDTO);
        employeeRepository.save(employee);
        return mapper.toDto(employee);
    }

}
