package com.bsuir.task_manager.controller.impl;

import com.bsuir.task_manager.bean.view.ProjectView;
import com.bsuir.task_manager.controller.ProjectController;
import com.bsuir.task_manager.controller.exception.ControllerException;
import com.bsuir.task_manager.controller.exception.WrongInputControllerException;
import com.bsuir.task_manager.controller.exception.project.ProjectExistsControllerException;
import com.bsuir.task_manager.controller.exception.project.ProjectNotFoundControllerException;
import com.bsuir.task_manager.security.TokenAuthentication;
import com.bsuir.task_manager.service.ProjectsService;
import com.bsuir.task_manager.service.exception.ExistsServiceException;
import com.bsuir.task_manager.service.exception.NotFoundServiceException;
import com.bsuir.task_manager.service.exception.ServiceException;
import com.bsuir.task_manager.service.exception.WrongInputServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ProjectControllerImpl implements ProjectController {

    private ProjectsService projectsService;

    @Autowired
    public ProjectControllerImpl(ProjectsService projectsService) {
        this.projectsService = projectsService;
    }

    @Override
    public void addProject(@RequestBody ProjectView project, @PathVariable int userId) throws ControllerException {
        try {
            int currentUserId = getSessionUserId();
            if (currentUserId != userId) {
                throw new ControllerException("Forbidden");
            }
            projectsService.createProject(userId, project);
        } catch (ExistsServiceException e) {
            throw new ProjectExistsControllerException("Project already exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform adding category", e);
        }
    }

    @Override
    public ProjectView getProject(@PathVariable int projectId, @PathVariable int userId) throws ControllerException {
        try {
            int currentUserId = getSessionUserId();
            if (currentUserId != userId) {
                throw new ControllerException("Forbidden");
            }
            return projectsService.getProject(projectId);
        } catch (NotFoundServiceException e) {
            throw new ProjectNotFoundControllerException("Project doesn't exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform getting project", e);
        }
    }

    @Override
    public List<ProjectView> getProjects(@PathVariable int userId) throws ControllerException {
        try {
            int currentUserId = getSessionUserId();
            if (currentUserId != userId) {
                throw new ControllerException("Forbidden");
            }
            return projectsService.getProjectsByUser(userId);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform getting projects", e);
        }
    }

    @Override
    public void updateProject(@PathVariable int projectId, @RequestBody ProjectView project, @PathVariable int userId) throws ControllerException {
        try {
            int currentUserId = getSessionUserId();
            if (currentUserId != userId) {
                throw new ControllerException("Forbidden");
            }
            projectsService.updateProject(projectId, project);
        } catch (NotFoundServiceException e) {
            throw new ProjectNotFoundControllerException("Project doesn't exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform updating project", e);
        }
    }

    @Override
    public void deleteProject(@PathVariable int projectId, @PathVariable int userId) throws ControllerException {
        try {
            int currentUserId = getSessionUserId();
            if (currentUserId != userId) {
                throw new ControllerException("Forbidden");
            }
            projectsService.deleteProject(projectId);
        } catch (NotFoundServiceException e) {
            throw new ProjectNotFoundControllerException("Project doesn't exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform deleting project", e);
        }
    }

    private int getSessionUserId() {
        TokenAuthentication tokenAuthentication;
        tokenAuthentication = (TokenAuthentication) SecurityContextHolder.getContext().getAuthentication();
        return ((int)tokenAuthentication.getDetails());
    }
}
