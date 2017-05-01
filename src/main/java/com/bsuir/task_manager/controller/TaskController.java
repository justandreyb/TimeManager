package com.bsuir.task_manager.controller;

import com.bsuir.task_manager.bean.view.TaskView;
import com.bsuir.task_manager.controller.exception.ControllerException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/user/tasks")
public interface TaskController {

    @GetMapping
    @ResponseBody
    List<TaskView> getTasks(@RequestParam("userId") int userId) throws ControllerException;

    @PostMapping("/add")
    void addTask(@RequestBody TaskView task, @RequestParam("userId") int userId) throws ControllerException;

    @GetMapping("/{taskId}")
    @ResponseBody
    TaskView getTask(@PathVariable int taskId) throws ControllerException;

    @PostMapping("/{taskId}/edit")
    void updateTask(@PathVariable int taskId, @RequestBody TaskView task) throws ControllerException;

    @GetMapping("/{taskId}/delete")
    void deleteTask(@PathVariable int taskId) throws ControllerException;

}
