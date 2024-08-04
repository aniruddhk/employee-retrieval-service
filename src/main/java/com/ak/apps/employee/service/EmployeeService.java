package com.ak.apps.employee.service;

import com.ak.apps.employee.model.Employee;
import com.ak.apps.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Page<Employee> getEmployees(int page, int size) {
        return employeeRepository.findAll(PageRequest.of(page, size));
    }
}
