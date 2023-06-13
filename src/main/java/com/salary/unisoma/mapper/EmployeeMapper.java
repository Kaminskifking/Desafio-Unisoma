package com.salary.unisoma.mapper;

import com.salary.unisoma.dtos.EmployeeDTO;
import com.salary.unisoma.models.EmployeeModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

    public EmployeeModel toEntity(EmployeeDTO dto) {
        EmployeeModel employee = new EmployeeModel();
        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setCpf(dto.getCpf());
        employee.setAddress(dto.getAddress());
        employee.setPhoneNumber(dto.getPhoneNumber());
        employee.setBirthday(dto.getBirthday());
        employee.setSalary(dto.getSalary());
        return employee;
    }

    public EmployeeDTO toDto(EmployeeModel employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setCpf(employee.getCpf());
        dto.setAddress(employee.getAddress());
        dto.setPhoneNumber(employee.getPhoneNumber());
        dto.setBirthday(employee.getBirthday());
        dto.setSalary(employee.getSalary());
        return dto;
    }

    public List<EmployeeDTO> toDto(List<EmployeeModel> listStock) {
        return listStock.stream().map(this::toDto).collect(Collectors.toList());
    }
}