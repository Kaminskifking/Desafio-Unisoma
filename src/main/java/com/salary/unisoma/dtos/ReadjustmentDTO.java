package com.salary.unisoma.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReadjustmentDTO {

    @NotNull
    @Size(max = 11, min = 11)
    private String CPF;

    @NotNull
    private double newSalary;

    @NotNull
    private double wonReadjustment;

    @NotNull
    private int inPercentage;
}
