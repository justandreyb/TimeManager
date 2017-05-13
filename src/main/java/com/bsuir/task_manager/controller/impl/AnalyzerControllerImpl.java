package com.bsuir.task_manager.controller.impl;

import com.bsuir.task_manager.bean.view.ProjectView;
import com.bsuir.task_manager.bean.view.TaskView;
import com.bsuir.task_manager.controller.AnalyzerController;
import com.bsuir.task_manager.controller.exception.ControllerException;
import com.bsuir.task_manager.service.ProjectService;
import com.bsuir.task_manager.service.TaskService;
import com.bsuir.task_manager.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AnalyzerControllerImpl implements AnalyzerController {

    private TaskService taskService;
    private ProjectService projectService;

    @Autowired
    public AnalyzerControllerImpl(TaskService taskService, ProjectService projectService) {
        this.taskService = taskService;
        this.projectService = projectService;
    }

    @Override
    public Map<Integer, ProjectView> analyzeProjects(@PathVariable int userId) throws ControllerException {
        try {
            List<ProjectView> projects = projectService.getProjectsByUser(userId);
            HashMap<Integer, ProjectView> analyzedProjects = new HashMap<>();
            for (ProjectView projectView : projects) {
                for (ProjectView secondProject : projects) {
                    projectView.getImportance();
                }
            }

        } catch (ServiceException e) {
            throw new ControllerException(e);
        }

        return null;
    }

    @Override
    public Map<Integer, TaskView> analyzeTasks(@PathVariable int userId, @PathVariable int projectId) throws ControllerException {
        return null;
    }
}
