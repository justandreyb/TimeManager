package com.bsuir.task_manager.service.impl;

import com.bsuir.task_manager.bean.entity.TaskEntity;
import com.bsuir.task_manager.bean.view.TaskView;
import com.bsuir.task_manager.dao.TaskDAO;
import com.bsuir.task_manager.dao.exception.DAOException;
import com.bsuir.task_manager.dao.exception.ExistsDAOException;
import com.bsuir.task_manager.dao.exception.NotFoundDAOException;
import com.bsuir.task_manager.service.TaskService;
import com.bsuir.task_manager.service.exception.ExistsServiceException;
import com.bsuir.task_manager.service.exception.NotFoundServiceException;
import com.bsuir.task_manager.service.exception.ServiceException;
import com.bsuir.task_manager.service.exception.WrongInputServiceException;
import com.bsuir.task_manager.service.util.Exchanger;
import com.bsuir.task_manager.service.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskDAO taskDAO;

    @Autowired
    public TaskServiceImpl(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    public void createTask(int userId, TaskView task) throws ServiceException {
        if (!Validator.isValid(userId)) {
            throw new WrongInputServiceException("Invalid user id");
        }
        if (!Validator.isValid(task)) {
            throw new WrongInputServiceException("Invalid fields in new task");
        }
        TaskEntity taskEntity = Exchanger.exchange(task);
        try {
            taskDAO.addTask(userId, taskEntity);
        } catch (ExistsDAOException e) {
            throw new ExistsServiceException("Task already exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while adding task", e);
        }
    }

    @Override
    public TaskView getTask(int taskId) throws ServiceException {
        if (!Validator.isValid(taskId)) {
            throw new WrongInputServiceException("Incorrect task id");
        }
        try {
            TaskEntity taskEntity = taskDAO.getTask(taskId);
            return Exchanger.exchange(taskEntity);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Task doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while getting task", e);
        }
    }

    @Override
    public List<TaskView> getTasks(int userId) throws ServiceException {
        if (!Validator.isValid(userId)) {
            throw new WrongInputServiceException("Incorrect user id");
        }
        try {
            List<TaskEntity> taskEntities = taskDAO.getTasks(userId);
            List<TaskView> taskViews = new LinkedList<TaskView>();
            for (TaskEntity taskEntity : taskEntities) {
                TaskView taskView = Exchanger.exchange(taskEntity);
                taskViews.add(taskView);
            }
            return taskViews;
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while getting tasks", e);
        }
    }

    @Override
    public List<TaskView> getTasksByCategory(int userId, int categoryId) throws ServiceException {
        if (!Validator.isValid(userId)) {
            throw new WrongInputServiceException("Incorrect user id");
        }
        if (!Validator.isValid(categoryId)) {
            throw new WrongInputServiceException("Incorrect category id");
        }
        try {
            List<TaskEntity> taskEntities = taskDAO.getTasksByCategory(userId, categoryId);
            List<TaskView> taskViews = new LinkedList<TaskView>();
            for (TaskEntity taskEntity : taskEntities) {
                TaskView taskView = Exchanger.exchange(taskEntity);
                taskViews.add(taskView);
            }
            return taskViews;
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while getting tasks by category", e);
        }
    }

    @Override
    public void updateTask(int taskId, TaskView task) throws ServiceException {
        if (!Validator.isValid(taskId)) {
            throw new WrongInputServiceException("Incorrect task id");
        }
        if (!Validator.isValid(task)) {
            throw new WrongInputServiceException("Invalid fields in task");
        }
        TaskEntity taskEntity = Exchanger.exchange(task);
        try {
            taskDAO.updateTask(taskId, taskEntity);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Task doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating task", e);
        }
    }

    @Override
    public void deleteTask(int taskId) throws ServiceException {
        if (!Validator.isValid(taskId)) {
            throw new WrongInputServiceException("Incorrect task id");
        }
        try {
            taskDAO.deleteTask(taskId);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Task doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while deleting task", e);
        }
    }
}
