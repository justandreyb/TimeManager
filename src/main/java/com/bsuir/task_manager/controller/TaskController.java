package com.bsuir.task_manager.controller;

import com.bsuir.task_manager.bean.view.TaskView;
import com.bsuir.task_manager.controller.exception.ControllerException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/users/{userId}/projects/{projectId}/tasks")
public interface TaskController {

    @GetMapping
    @ResponseBody
    List<TaskView> getTasks(@PathVariable int projectId) throws ControllerException;

    @PostMapping("/add")
    void addTask(@RequestBody TaskView task, @PathVariable int projectId) throws ControllerException;

    @GetMapping("/{taskId}")
    @ResponseBody
    TaskView getTask(@PathVariable int taskId) throws ControllerException;

    @PostMapping("/{taskId}/edit")
    void updateTask(@PathVariable int taskId, @RequestBody TaskView task) throws ControllerException;

    @GetMapping("/{taskId}/delete")
    void deleteTask(@PathVariable int taskId) throws ControllerException;

    @GetMapping("/categories/{categoryId}")
    @ResponseBody
    List<TaskView> getTasksByCategory(@PathVariable int categoryId, @PathVariable int projectId) throws ControllerException;


}
