package com.jrp.pma.controllers;

import com.jrp.pma.entities.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        Project project = new Project();
        model.addAttribute("project", project);
        return "new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {
        // this should handle saving to the database...

    }
}
