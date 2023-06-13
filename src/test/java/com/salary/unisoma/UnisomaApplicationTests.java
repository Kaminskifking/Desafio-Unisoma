package com.salary.unisoma;

import com.salary.unisoma.controllers.EmployeeController;
import com.salary.unisoma.dtos.EmployeeDTO;
import com.salary.unisoma.services.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UnisomaApplicationTests {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        EmployeeDTO employee1 = new EmployeeDTO();
        employee1.setId(1L);
        employee1.setName("Vinicius Kaminski");
        employee1.setCpf("123.456.789-00");
        employee1.setBirthday(LocalDate.of(1990, 1, 1));
        employee1.setPhoneNumber("1123456789");
        employee1.setAddress("Rua teste, 300");
        employee1.setSalary(1000.0);

        EmployeeDTO employee2 = new EmployeeDTO();
        employee2.setId(2L);
        employee2.setName("Vinicius Teste");
        employee2.setCpf("987.654.321-00");
        employee2.setBirthday(LocalDate.of(1995, 5, 5));
        employee2.setPhoneNumber("11987654321");
        employee2.setAddress("Rua teste, 200");
        employee2.setSalary(2000.0);

        List<EmployeeDTO> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

        when(employeeService.findAll()).thenReturn(employees);

        ResponseEntity<List<EmployeeDTO>> response = employeeController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employees, response.getBody());
    }

}
