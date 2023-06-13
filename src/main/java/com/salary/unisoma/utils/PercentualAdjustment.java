package com.salary.unisoma.utils;

import com.salary.unisoma.dtos.SalaryDTO;
import org.springframework.stereotype.Component;

@Component
public class PercentualAdjustment {
    public SalaryDTO percentual(double salary) {
        int percentageAdjustment;

        if (salary >= 0 && salary <= 400.00) {
            percentageAdjustment = 15;
        } else if (salary >= 400.01 && salary <= 800.00) {
            percentageAdjustment = 12;
        } else if (salary >= 800.01 && salary <= 1200.00) {
            percentageAdjustment = 10;
        } else if (salary >= 1200.01 && salary <= 2000.00) {
            percentageAdjustment = 7;
        } else {
            percentageAdjustment = 4;
        }

        double readjustedValue = salary * (percentageAdjustment / 100.0);
        double readjustedSalary = salary + readjustedValue;

        SalaryDTO salaryDTO = new SalaryDTO();
        salaryDTO.setReadjustedSalary(readjustedSalary);
        salaryDTO.setReadjustedValue(readjustedValue);
        salaryDTO.setPercentageAdjustment(percentageAdjustment);

        return salaryDTO;
    }
}
