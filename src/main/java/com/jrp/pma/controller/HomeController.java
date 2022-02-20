package com.jrp.pma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.dto.ChartData;
import com.jrp.pma.entity.Project;
import com.jrp.pma.springExample.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    Car car;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();

        // querying the database for projects
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projectList", projects);

        List<ChartData> projectData = projectRepository.getProjectStatus();

        // Let's convert projectData into a JSON structure for use in JavaScript
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);
        // ["NOTSTARTED", 1], ["INPROGRESS", 2], ["COMPLETED", 1]

        model.addAttribute("projectStatusCount", jsonString);

        //querying the database for employees
        List<EmployeeProject> employeeProjectCount = employeeRepository.getEmployeeProjects();
        model.addAttribute("employeeListProjectCount", employeeProjectCount);

        return "main/home";
    }
}
