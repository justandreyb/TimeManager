package com.bsuir.task_manager.service.impl;

import com.bsuir.task_manager.bean.view.TaskView;
import com.bsuir.task_manager.service.TaskService;
import com.bsuir.task_manager.service.exception.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Override
    public void createTask(int userId, TaskView task) throws ServiceException {

    }

    @Override
    public TaskView getTask(int taskId) throws ServiceException {
        return null;
    }

    @Override
    public List<TaskView> getTasks(int userId) throws ServiceException {
        throw new ServiceException("Error");
    }

    @Override
    public void updateTask(int taskId, TaskView task) throws ServiceException {

    }

    @Override
    public void deleteTask(int taskId) throws ServiceException {

    }
}
