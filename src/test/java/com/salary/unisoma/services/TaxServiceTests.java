package com.salary.unisoma.services;

import com.salary.unisoma.dtos.TaxDTO;
import com.salary.unisoma.models.EmployeeModel;
import com.salary.unisoma.repositories.EmployeeRepository;
import com.salary.unisoma.services.impl.TaxServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaxServiceTests {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private TaxServiceImpl taxService;

    @Before
    public void setup() {
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setSalary(2500.00);
        when(employeeRepository.findByCpf("123456789")).thenReturn(employeeModel);
    }

    @Test
    public void testFindByCpf() {

        TaxDTO result = taxService.findByCpf("123456789");

        assertEquals("R$ 40,00", result.getTax());
        assertEquals("123456789", result.getCpf());
    }
}
