package com.bsuir.task_manager.dao;

import com.bsuir.task_manager.bean.entity.ProjectEntity;
import com.bsuir.task_manager.dao.exception.DAOException;

import java.util.List;

public interface ProjectDAO {
    void addProject(int userId, ProjectEntity project) throws DAOException;

    ProjectEntity getProject(int projectId) throws DAOException;

    List<ProjectEntity> getProjectsByUser(int userId) throws DAOException;

    void updateProject(int projectId, ProjectEntity project) throws DAOException;

    void deleteProject(int projectId) throws DAOException;

}
