package com.bsuir.task_manager.controller;

import com.bsuir.task_manager.bean.view.TaskView;
import com.bsuir.task_manager.controller.exception.ControllerException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/users/{userId}/projects/{projectId}/tasks")
public interface TaskController {

    @PreAuthorize("hasAuthority('user')")
    @GetMapping
    @ResponseBody
    List<TaskView> getTasks(@PathVariable int projectId, @PathVariable int userId) throws ControllerException;

    @PreAuthorize("hasAuthority('user')")
    @PostMapping("/add")
    void addTask(@RequestBody TaskView task, @PathVariable int projectId, @PathVariable int userId) throws ControllerException;

    @PreAuthorize("hasAuthority('user')")
    @GetMapping("/{taskId}")
    @ResponseBody
    TaskView getTask(@PathVariable int taskId, @PathVariable int userId) throws ControllerException;

    @PreAuthorize("hasAuthority('user')")
    @PostMapping("/{taskId}/edit")
    void updateTask(@PathVariable int taskId, @PathVariable int projectId, @PathVariable int userId, @RequestBody TaskView task) throws ControllerException;

    @PreAuthorize("hasAuthority('user')")
    @GetMapping("/{taskId}/delete")
    void deleteTask(@PathVariable int taskId, @PathVariable int userId) throws ControllerException;

    @PreAuthorize("hasAuthority('user')")
    @GetMapping("/categories/{categoryId}")
    @ResponseBody
    List<TaskView> getTasksByCategory(@PathVariable int categoryId, @PathVariable int projectId, @PathVariable int userId) throws ControllerException;


}
