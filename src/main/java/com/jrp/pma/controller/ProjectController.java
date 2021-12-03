package com.jrp.pma.controller;

import com.jrp.pma.dao.ProjectRepo;
import com.jrp.pma.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepo projectRepo;

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        Project project = new Project();
        model.addAttribute("project", project);
        return "new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {
        projectRepo.save(project);

        // use a redirect to prevent duplicate submissions
        return "redirect:/projects/new";
    }
}
