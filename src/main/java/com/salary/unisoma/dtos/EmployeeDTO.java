package com.salary.unisoma.dtos;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDTO {

        private Long id;

        @NotNull
        private String name;

        @NotNull
        @Pattern(regexp = "^([0-9]{3}\\.?){3}-?[0-9]{2}$")
        private String cpf;

        @NotNull
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        private LocalDate birthday;

        @NotNull
        private String phoneNumber;

        @NotNull
        private String address;

        @NotNull
        private double salary;
}
