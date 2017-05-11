package com.bsuir.task_manager.controller;

import com.bsuir.task_manager.bean.view.ProjectView;
import com.bsuir.task_manager.controller.exception.ControllerException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users/{userId}/projects")
public interface ProjectController {
    @PostMapping("/add")
    void addProject(@RequestBody ProjectView project, @PathVariable int userId) throws ControllerException;

    @GetMapping("/{projectId}")
    @ResponseBody
    ProjectView getProject(@PathVariable int projectId) throws ControllerException;

    @GetMapping
    @ResponseBody
    List<ProjectView> getProjects(@PathVariable int userId) throws ControllerException;

    @PostMapping("/{projectId}/edit")
    void updateProject(@PathVariable int projectId, @RequestBody ProjectView project) throws ControllerException;

    @GetMapping("/{projectId}/delete")
    void deleteProject(@PathVariable int projectId) throws ControllerException;
}
