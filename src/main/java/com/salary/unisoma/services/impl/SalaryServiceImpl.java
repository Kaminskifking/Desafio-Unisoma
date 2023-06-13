package com.salary.unisoma.services.impl;

import com.salary.unisoma.dtos.ReadjustmentDTO;
import com.salary.unisoma.dtos.SalaryDTO;
import com.salary.unisoma.models.EmployeeModel;
import com.salary.unisoma.repositories.EmployeeRepository;
import com.salary.unisoma.services.SalaryService;
import com.salary.unisoma.utils.PercentualAdjustment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public ReadjustmentDTO findByCpf(String cpf) {
        EmployeeModel employee = employeeRepository.findByCpf(cpf);
        ReadjustmentDTO employeeDTO = new ReadjustmentDTO();
        if (employee == null) {
            return null;
        }
        double salary = employee.getSalary();
        SalaryDTO results = new PercentualAdjustment().percentual(salary);

        employee.setSalary(results.getReadjustedSalary());
        employeeRepository.save(employee);
        employeeDTO.setCPF(cpf);
        employeeDTO.setNewSalary(results.getReadjustedSalary());
        employeeDTO.setWonReadjustment(results.getReadjustedValue());
        employeeDTO.setInPercentage(results.getPercentageAdjustment());
        return employeeDTO;
    }
}
