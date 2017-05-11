package com.bsuir.task_manager.controller.impl;

import com.bsuir.task_manager.bean.view.TaskView;
import com.bsuir.task_manager.controller.TaskController;
import com.bsuir.task_manager.controller.exception.ControllerException;
import com.bsuir.task_manager.controller.exception.WrongInputControllerException;
import com.bsuir.task_manager.controller.exception.task.TaskExistsControllerException;
import com.bsuir.task_manager.controller.exception.task.TaskNotFoundControllerException;
import com.bsuir.task_manager.security.TokenAuthentication;
import com.bsuir.task_manager.service.TaskService;
import com.bsuir.task_manager.service.exception.ExistsServiceException;
import com.bsuir.task_manager.service.exception.NotFoundServiceException;
import com.bsuir.task_manager.service.exception.ServiceException;
import com.bsuir.task_manager.service.exception.WrongInputServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public void addTask(@RequestBody TaskView task, @PathVariable int projectId, @PathVariable int userId) throws ControllerException {
        try {
            int currentUserId = getSessionUserId();
            if (currentUserId != userId) {
                throw new ControllerException("Forbidden");
            }
            service.createTask(projectId, task);
        } catch (ExistsServiceException e) {
            throw new TaskExistsControllerException("Task already exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform adding task", e);
        }
    }

    @Override
    public TaskView getTask(@PathVariable int taskId, @PathVariable int userId) throws ControllerException {
        try {
            int currentUserId = getSessionUserId();
            if (currentUserId != userId) {
                throw new ControllerException("Forbidden");
            }
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
    public void updateTask(@PathVariable int taskId, @PathVariable int projectId, @PathVariable int userId, @RequestBody TaskView task) throws ControllerException {
        try {
            int currentUserId = getSessionUserId();
            if (currentUserId != userId) {
                throw new ControllerException("Forbidden");
            }
            service.updateTask(projectId, task);
        } catch (NotFoundServiceException e) {
            throw new TaskNotFoundControllerException("Task doesn't exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform updating task", e);
        }
    }

    @Override
    public void deleteTask(@PathVariable int taskId, @PathVariable int userId) throws ControllerException {
        try {
            int currentUserId = getSessionUserId();
            if (currentUserId != userId) {
                throw new ControllerException("Forbidden");
            }
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
    public List<TaskView> getTasksByCategory(@PathVariable int categoryId, @PathVariable int projectId, @PathVariable int userId) throws ControllerException {
        try {
            int currentUserId = getSessionUserId();
            if (currentUserId != userId) {
                throw new ControllerException("Forbidden");
            }
            return service.getTasksByCategory(projectId, categoryId);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform getting tasks by category", e);
        }
    }

    @Override
    public List<TaskView> getTasks(@PathVariable int projectId, @PathVariable int userId) throws ControllerException {
        try {
            int currentUserId = getSessionUserId();
            if (currentUserId != userId) {
                throw new ControllerException("Forbidden");
            }
            return service.getTasks(projectId);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform getting tasks", e);
        }
    }

    private int getSessionUserId() {
        TokenAuthentication tokenAuthentication;
        tokenAuthentication = (TokenAuthentication) SecurityContextHolder.getContext().getAuthentication();
        return ((int)tokenAuthentication.getDetails());
    }
}
