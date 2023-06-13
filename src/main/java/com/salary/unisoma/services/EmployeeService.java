package com.salary.unisoma.services;

import com.salary.unisoma.dtos.EmployeeDTO;
import com.salary.unisoma.models.EmployeeModel;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeModel findByCpf(String cpf);

    List<EmployeeDTO> findAll();
    EmployeeDTO save(EmployeeDTO employee);

    Optional<EmployeeDTO> findById(Long id);

    void delete(EmployeeDTO employeeModel);

    EmployeeDTO update(EmployeeDTO employeeDTO);
}
