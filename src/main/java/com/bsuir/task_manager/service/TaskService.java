package com.bsuir.task_manager.service;

import com.bsuir.task_manager.bean.view.TaskView;
import com.bsuir.task_manager.service.exception.ServiceException;

import java.util.List;

public interface TaskService {

    void createTask(int projectId, TaskView task) throws ServiceException;

    TaskView getTask(int taskId) throws ServiceException;
    List<TaskView> getTasks(int projectId) throws ServiceException;
    List<TaskView> getTasksByCategory(int projectId, int categoryId) throws ServiceException;

    void updateTask(int taskId, TaskView task) throws ServiceException;

    void deleteTask(int taskId) throws ServiceException;
}
