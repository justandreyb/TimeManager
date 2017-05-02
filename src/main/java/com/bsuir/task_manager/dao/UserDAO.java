package com.bsuir.task_manager.dao;

import com.bsuir.task_manager.bean.entity.UserEntity;
import com.bsuir.task_manager.dao.exception.DAOException;

public interface UserDAO {

    void createUser(UserEntity user) throws DAOException;

    UserEntity getUser(String email, String password) throws DAOException;

    void updateUser(int userId, UserEntity user) throws DAOException;

    void deleteUser(int userId) throws DAOException;

}
