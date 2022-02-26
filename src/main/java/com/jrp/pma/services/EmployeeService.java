package com.jrp.pma.services;

import com.jrp.pma.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    // Field Injection
    //@Autowired
    IStaffRepository iStaffRepository;

    // Constructor Injection
    //public EmployeeService(IStaffRepository iStaffRepository) {
    //    this.iStaffRepository = iStaffRepository;
    //}

    // Setter Injection
    @Autowired
    @Qualifier("staffRepositoryImpl2")
    public void setEmployeeRepository(IStaffRepository iStaffRepository) {
        this.iStaffRepository = iStaffRepository;
    }
}
