package com.salary.unisoma.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SalaryDTO {

    @NotNull
    private double readjustedValue;

    @NotNull
    private double readjustedSalary;

    @NotNull
    private int percentageAdjustment;
}
