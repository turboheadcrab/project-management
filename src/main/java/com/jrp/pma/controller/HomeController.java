package com.jrp.pma.controller;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.dto.ProjectStage;
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
        List<ProjectStage> projectStageCount = projectRepository.projectStages();
        model.addAttribute("projectListStageCount", projectStageCount);

        //querying the database for employees
        List<EmployeeProject> employeeProjectCount = employeeRepository.employeeProjects();
        model.addAttribute("employeeListProjectCount", employeeProjectCount);

        return "main/home";
    }
}
