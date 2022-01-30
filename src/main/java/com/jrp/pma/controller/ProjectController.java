package com.jrp.pma.controller;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entity.Employee;
import com.jrp.pma.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projectList = projectRepository.findAll();
        model.addAttribute("projectList", projectList);
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {

        Project project = new Project();
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("allEmployees", employees);
        model.addAttribute("project", project);

        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, @RequestParam List<Long> employees, Model model) {
        projectRepository.save(project);

        Iterable<Employee> chosenEmployees = employeeRepository.findAllById(employees);
        for (Employee employee :
                chosenEmployees) {
            employee.setProject(project);
            employeeRepository.save(employee);
        }
        // use a redirect to prevent duplicate submissions
        return "redirect:/projects/new";
    }
}
