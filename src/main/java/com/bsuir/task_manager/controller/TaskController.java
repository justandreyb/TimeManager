package com.bsuir.task_manager.controller;

import com.bsuir.task_manager.bean.view.TaskView;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/user/tasks")
public interface TaskController {

    @GetMapping
    @ResponseBody
    List<TaskView> getTasks();

    @PostMapping("/add")
    void addTask(@RequestBody TaskView task);

    @GetMapping("/{taskId}")
    @ResponseBody
    TaskView getTask(@PathVariable int taskId);

    @PostMapping("/{taskId}/edit")
    void updateTask(@PathVariable int taskId, @RequestBody TaskView task);

    @GetMapping("/{taskId}/delete")
    void deleteTask(@PathVariable int taskId);

}
