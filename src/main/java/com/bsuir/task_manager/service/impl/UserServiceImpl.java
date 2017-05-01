package com.bsuir.task_manager.service.impl;

import com.bsuir.task_manager.bean.view.UserView;
import com.bsuir.task_manager.service.UserService;
import com.bsuir.task_manager.service.exception.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void createUser(UserView user) throws ServiceException {

    }

    @Override
    public UserView getUser(String email, String password) throws ServiceException {
        return null;
    }

    @Override
    public void updateUser(int userId, UserView user) throws ServiceException {

    }

    @Override
    public void deleteUser(int userId) throws ServiceException {

    }
}
