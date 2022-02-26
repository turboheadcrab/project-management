package com.jrp.pma.services;

import com.jrp.pma.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    // Field Injection
    //@Autowired
    EmployeeRepository employeeRepository;

    // Constructor Injection
    //public EmployeeService(EmployeeRepository employeeRepository) {
    //    this.employeeRepository = employeeRepository;
    //}

    // Setter Injection
    //@Autowired
    //public void setEmployeeRepository(EmployeeRepository employeeRepository) {
    //    this.employeeRepository = employeeRepository;
    //}
}
