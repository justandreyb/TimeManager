package com.bsuir.task_manager.service;

import com.bsuir.task_manager.bean.view.UserView;
import com.bsuir.task_manager.service.exception.ServiceException;

public interface UserService {

    void createUser(UserView user) throws ServiceException;

    UserView getUser(String email, String password) throws ServiceException;
    UserView getUserById(int userId) throws ServiceException;
    UserView getUserByEmail(String email) throws ServiceException;

    void updateUser(int userId, UserView user) throws ServiceException;

    void deleteUser(int userId) throws ServiceException;

}
