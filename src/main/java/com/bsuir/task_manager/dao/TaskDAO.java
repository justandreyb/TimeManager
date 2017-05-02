package com.bsuir.task_manager.dao;

import com.bsuir.task_manager.bean.entity.TaskEntity;
import com.bsuir.task_manager.dao.exception.DAOException;

import java.util.List;

public interface TaskDAO {

    void addTask(int userId, TaskEntity task) throws DAOException;

    TaskEntity getTask(int taskId) throws DAOException;

    List<TaskEntity> getTasks(int userId) throws DAOException;
    List<TaskEntity> getTasksByCategory(int userId, int categoryId) throws DAOException;

    void updateTask(int taskId, TaskEntity task) throws DAOException;

    void setComplete(int taskId, boolean complete) throws DAOException;

    void deleteTask(int taskId) throws DAOException;

}
