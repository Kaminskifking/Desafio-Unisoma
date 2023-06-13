package com.salary.unisoma.utils;

import com.salary.unisoma.dtos.SalaryDTO;
import com.salary.unisoma.dtos.TaxDTO;
import org.springframework.stereotype.Component;

@Component
public class TaxAdjustment {
    public double tax(double salary) {
        double taxAdjustment = 0;

        if (salary >=  2000.01 && salary <= 3000.00) {
            taxAdjustment = (salary - 2000.00) * 0.08;
        } else if (salary >= 3000.01 && salary <=  4500.00) {
            taxAdjustment =  1000 * 0.08;
            taxAdjustment +=  (salary - 3000.00) * 0.18;
        } else if (salary >= 4500.00) {
            taxAdjustment =  1000 * 0.08 + 1500 * 0.18;
            taxAdjustment += (salary - 4500.00) * 0.28;
        }

        //        if (tax.getTax() == null) {
        //            tax.setTax("R$ " + String.format("%.2f", taxAdjustment));
        //        }

        return taxAdjustment;
    }
}
