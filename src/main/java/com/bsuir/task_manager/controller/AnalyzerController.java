package com.bsuir.task_manager.controller;

import com.bsuir.task_manager.bean.view.ProjectView;
import com.bsuir.task_manager.bean.view.TaskView;
import com.bsuir.task_manager.controller.exception.ControllerException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/users/{userId}/today")
public interface AnalyzerController {
    @PostMapping("/projects")
    Map<Integer, ProjectView> analyzeProjects(@PathVariable int userId) throws ControllerException;

    @PostMapping("/projects/{projectId}/tasks")
    @ResponseBody
    Map<Integer, TaskView> analyzeTasks(@PathVariable int userId, @PathVariable int projectId) throws ControllerException;
}
