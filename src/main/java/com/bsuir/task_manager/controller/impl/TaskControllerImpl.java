package com.bsuir.task_manager.controller.impl;

import com.bsuir.task_manager.bean.view.TaskView;
import com.bsuir.task_manager.controller.TaskController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class TaskControllerImpl implements TaskController {
    @Override
    public void addTask(@RequestBody TaskView user) {
        System.out.println("Add task");

    }

    @Override
    public TaskView getTask(@PathVariable int taskId) {
        System.out.println("Get task");

        return null;
    }

    @Override
    public void updateTask(@PathVariable int taskId, @RequestBody TaskView task) {
        System.out.println("Update task");

    }

    @Override
    public void deleteTask(@PathVariable int taskId) {
        System.out.println("Delete task");

    }

    @Override
    public List<TaskView> getTasks() {
        System.out.println("Get tasks");

        return null;
    }
}
