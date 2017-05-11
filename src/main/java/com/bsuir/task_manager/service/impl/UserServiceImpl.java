package com.bsuir.task_manager.service.impl;

import com.bsuir.task_manager.bean.entity.UserEntity;
import com.bsuir.task_manager.bean.view.UserView;
import com.bsuir.task_manager.dao.UserDAO;
import com.bsuir.task_manager.dao.exception.DAOException;
import com.bsuir.task_manager.dao.exception.ExistsDAOException;
import com.bsuir.task_manager.dao.exception.NotFoundDAOException;
import com.bsuir.task_manager.service.UserService;
import com.bsuir.task_manager.service.exception.ExistsServiceException;
import com.bsuir.task_manager.service.exception.NotFoundServiceException;
import com.bsuir.task_manager.service.exception.ServiceException;
import com.bsuir.task_manager.service.exception.WrongInputServiceException;
import com.bsuir.task_manager.service.util.Exchanger;
import com.bsuir.task_manager.service.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void createUser(UserView user) throws ServiceException {
        if (!Validator.isValid(user)) {
            throw new WrongInputServiceException("Invalid fields in user");
        }
        UserEntity userEntity = Exchanger.exchange(user);
        try {
            userDAO.createUser(userEntity);
        } catch (ExistsDAOException e) {
            throw new ExistsServiceException("User already exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while adding user", e);
        }
    }

    @Override
    public UserView getUser(String email, String password) throws ServiceException {
        if (!Validator.isValidEmail(email)) {
            throw new WrongInputServiceException("Incorrect email");
        }
        if (!Validator.isValidPassword(password)) {
            throw new WrongInputServiceException("Incorrect password");
        }
        try {
            UserEntity userEntity = userDAO.getUser(email, password);
            return Exchanger.exchange(userEntity);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("User doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while getting user", e);
        }
    }

    @Override
    public void updateUser(int userId, UserView user) throws ServiceException {
        if (!Validator.isValid(userId)) {
            throw new WrongInputServiceException("Incorrect user id");
        }
        if (!Validator.isValid(user)) {
            throw new WrongInputServiceException("Invalid fields in user");
        }
        try {
            UserEntity userEntity = Exchanger.exchange(user);
            userDAO.updateUser(userId, userEntity);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("User doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating user", e);
        }
    }

    @Override
    public void deleteUser(int userId) throws ServiceException {
        if (!Validator.isValid(userId)) {
            throw new WrongInputServiceException("Incorrect user id");
        }
        try {
            userDAO.deleteUser(userId);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("User doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while deleting user", e);
        }
    }
}
