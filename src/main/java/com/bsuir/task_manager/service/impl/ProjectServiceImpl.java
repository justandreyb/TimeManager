package com.bsuir.task_manager.service.impl;

import com.bsuir.task_manager.bean.entity.ProjectEntity;
import com.bsuir.task_manager.bean.view.ProjectView;
import com.bsuir.task_manager.dao.ProjectDAO;
import com.bsuir.task_manager.dao.exception.DAOException;
import com.bsuir.task_manager.dao.exception.ExistsDAOException;
import com.bsuir.task_manager.dao.exception.NotFoundDAOException;
import com.bsuir.task_manager.service.ProjectsService;
import com.bsuir.task_manager.service.exception.ExistsServiceException;
import com.bsuir.task_manager.service.exception.NotFoundServiceException;
import com.bsuir.task_manager.service.exception.ServiceException;
import com.bsuir.task_manager.service.exception.WrongInputServiceException;
import com.bsuir.task_manager.service.util.Exchanger;
import com.bsuir.task_manager.service.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectsService {

    private ProjectDAO projectDAO;

    @Autowired
    public ProjectServiceImpl(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @Override
    public void createProject(int userId, ProjectView project) throws ServiceException {
        if (!Validator.isValid(userId)) {
            throw new WrongInputServiceException("Incorrect user id");
        }
        if (!Validator.isValid(project)) {
            throw new WrongInputServiceException("Invalid fields in new category");
        }
        ProjectEntity projectEntity = Exchanger.exchange(project);
        try {
            projectDAO.addProject(userId, projectEntity);
        } catch (ExistsDAOException e) {
            throw new ExistsServiceException("Project already exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while creating project", e);
        }
    }

    @Override
    public ProjectView getProject(int projectId) throws ServiceException {
        if (!Validator.isValid(projectId)) {
            throw new WrongInputServiceException("Incorrect project id");
        }
        try {
            ProjectEntity projectEntity = projectDAO.getProject(projectId);
            return Exchanger.exchange(projectEntity);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Project doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while getting project", e);
        }
    }

    @Override
    public List<ProjectView> getProjectsByUser(int userId) throws ServiceException {
        if (!Validator.isValid(userId)) {
            throw new WrongInputServiceException("Incorrect user id");
        }
        try {
            List<ProjectEntity> projectEntities = projectDAO.getProjectsByUser(userId);
            List<ProjectView> projectViews = new ArrayList<ProjectView>();

            for (ProjectEntity projectEntity : projectEntities) {
                projectViews.add(Exchanger.exchange(projectEntity));
            }

            return projectViews;
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while getting projects", e);
        }
    }

    @Override
    public void updateProject(int projectId, ProjectView project) throws ServiceException {
        if (!Validator.isValid(projectId)) {
            throw new WrongInputServiceException("Incorrect project id");
        }
        if (!Validator.isValid(project)) {
            throw new WrongInputServiceException("Invalid fields in new project");
        }
        try {
            ProjectEntity projectEntity = Exchanger.exchange(project);
            projectDAO.updateProject(projectId, projectEntity);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Project doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while getting project", e);
        }
    }

    @Override
    public void deleteProject(int projectId) throws ServiceException {
        if (!Validator.isValid(projectId)) {
            throw new WrongInputServiceException("Incorrect project id");
        }
        try {
            projectDAO.deleteProject(projectId);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Project doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while getting project", e);
        }
    }
}
