package com.bsuir.task_manager.service;

import com.bsuir.task_manager.bean.view.ProjectView;
import com.bsuir.task_manager.service.exception.ServiceException;

import java.util.List;

public interface ProjectService {

    void createProject(int userId, ProjectView project) throws ServiceException;

    ProjectView getProject(int projectId) throws ServiceException;
    List<ProjectView> getProjectsByUser(int userId) throws ServiceException;

    void updateProject(int projectId, ProjectView project) throws ServiceException;

    void deleteProject(int projectId) throws ServiceException;
}
