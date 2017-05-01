package com.bsuir.task_manager.controller.impl;

import com.bsuir.task_manager.bean.view.TaskView;
import com.bsuir.task_manager.controller.TaskController;
import com.bsuir.task_manager.controller.exception.ControllerException;
import com.bsuir.task_manager.controller.exception.WrongInputControllerException;
import com.bsuir.task_manager.controller.exception.task.TaskExistsControllerException;
import com.bsuir.task_manager.controller.exception.task.TaskNotFoundControllerException;
import com.bsuir.task_manager.service.TaskService;
import com.bsuir.task_manager.service.exception.ExistsServiceException;
import com.bsuir.task_manager.service.exception.NotFoundServiceException;
import com.bsuir.task_manager.service.exception.ServiceException;
import com.bsuir.task_manager.service.exception.WrongInputServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskControllerImpl implements TaskController {

    private final TaskService service;

    @Autowired
    public TaskControllerImpl(TaskService service) {
        this.service = service;
    }

    @Override
    public void addTask(@RequestBody TaskView task, @RequestParam("userId") int userId) throws ControllerException {
        try {
            service.createTask(userId, task);
        } catch (ExistsServiceException e) {
            throw new TaskExistsControllerException("Task already exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform adding task", e);
        }
    }

    @Override
    public TaskView getTask(@PathVariable int taskId) throws ControllerException {
        try {
            return service.getTask(taskId);
        } catch (NotFoundServiceException e) {
            throw new TaskNotFoundControllerException("Task doesn't exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform getting task", e);
        }
    }

    @Override
    public void updateTask(@PathVariable int taskId, @RequestBody TaskView task) throws ControllerException {
        try {
            service.updateTask(taskId, task);
        } catch (NotFoundServiceException e) {
            throw new TaskNotFoundControllerException("Task doesn't exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform updating task", e);
        }
    }

    @Override
    public void deleteTask(@PathVariable int taskId) throws ControllerException {
        try {
            service.deleteTask(taskId);
        } catch (NotFoundServiceException e) {
            throw new TaskNotFoundControllerException("Task doesn't exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform deleting task", e);
        }
    }

    @Override
    public List<TaskView> getTasks(@RequestParam("userId") int userId) throws ControllerException {
        try {
            return service.getTasks(userId);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform getting tasks", e);
        }
    }
}
