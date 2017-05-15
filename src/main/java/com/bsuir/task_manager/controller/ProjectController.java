package com.bsuir.task_manager.controller;

import com.bsuir.task_manager.bean.view.ProjectView;
import com.bsuir.task_manager.controller.exception.ControllerException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users/{userId}/projects")
public interface ProjectController {

    @PreAuthorize("hasAuthority('user')")
    @PostMapping("/create")
    void addProject(@RequestBody ProjectView project, @PathVariable int userId) throws ControllerException;

    @PreAuthorize("hasAuthority('user')")
    @GetMapping("/{projectId}")
    @ResponseBody
    ProjectView getProject(@PathVariable int projectId, @PathVariable int userId) throws ControllerException;

    @PreAuthorize("hasAuthority('user')")
    @GetMapping
    @ResponseBody
    List<ProjectView> getProjects(@PathVariable int userId) throws ControllerException;

    @PreAuthorize("hasAuthority('user')")
    @PostMapping("/{projectId}/edit")
    void updateProject(@PathVariable int projectId, @RequestBody ProjectView project, @PathVariable int userId) throws ControllerException;

    @PreAuthorize("hasAuthority('user')")
    @GetMapping("/{projectId}/delete")
    void deleteProject(@PathVariable int projectId, @PathVariable int userId) throws ControllerException;
}
