package com.salary.unisoma.services;

import com.salary.unisoma.dtos.EmployeeDTO;
import com.salary.unisoma.mapper.EmployeeMapper;
import com.salary.unisoma.models.EmployeeModel;
import com.salary.unisoma.repositories.EmployeeRepository;
import com.salary.unisoma.services.impl.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTests {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeMapper employeeMapper;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private EmployeeDTO employeeDTO;
    private EmployeeModel employeeModel;

    @Before
    public void setup() {
        employeeDTO = new EmployeeDTO();

        employeeModel = new EmployeeModel();

        when(employeeMapper.toEntity(employeeDTO)).thenReturn(employeeModel);
        when(employeeMapper.toDto(employeeModel)).thenReturn(employeeDTO);
    }

    @Test
    public void testSave() {
        when(employeeRepository.save(employeeModel)).thenReturn(employeeModel);
        EmployeeDTO result = employeeService.save(employeeDTO);
        assertEquals(employeeDTO, result);
    }
}