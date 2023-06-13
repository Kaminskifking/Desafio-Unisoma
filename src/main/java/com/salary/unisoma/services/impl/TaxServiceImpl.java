package com.salary.unisoma.services.impl;

import com.salary.unisoma.dtos.TaxDTO;
import com.salary.unisoma.models.EmployeeModel;
import com.salary.unisoma.repositories.EmployeeRepository;
import com.salary.unisoma.services.TaxService;
import com.salary.unisoma.utils.TaxAdjustment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxServiceImpl implements TaxService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public TaxDTO findByCpf(String cpf) {
        TaxDTO taxDTO = new TaxDTO();
        EmployeeModel employee = employeeRepository.findByCpf(cpf);
        if (employee == null) {
            return null;
        }

        double taxAdjustment = new TaxAdjustment().tax(employee.getSalary());
        String tax = (taxAdjustment > 0) ? "R$ " + String.format("%.2f", taxAdjustment) : "Isento";

        taxDTO.setCpf(cpf);
        taxDTO.setTax(tax);
        return taxDTO;
    }
}
