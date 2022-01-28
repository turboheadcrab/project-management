package com.jrp.pma.controller;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entity.Employee;
import com.jrp.pma.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model) {
        // querying the database for projects
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projectList", projects);

        //querying the database for employees
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employeeList", employees);

        return "main/home";
    }
}
