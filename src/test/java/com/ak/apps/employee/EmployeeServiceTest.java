package com.ak.apps.employee;


import com.ak.apps.employee.model.Employee;
import com.ak.apps.employee.repository.EmployeeRepository;
import com.ak.apps.employee.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Spy
    private Page<Employee> mockPage = new PageImpl<>(Collections.singletonList(new Employee()));

    public EmployeeServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetEmployees() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        when(employeeRepository.findAll(pageRequest)).thenReturn(mockPage);

        Page<Employee> employees = employeeService.getEmployees(0, 10);

        assertEquals(1, employees.getTotalElements());
        Mockito.verify(employeeRepository).findAll(pageRequest);
    }
}

