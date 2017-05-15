package com.bsuir.task_manager.controller.impl;

import com.bsuir.task_manager.bean.view.UserView;
import com.bsuir.task_manager.controller.UserController;
import com.bsuir.task_manager.controller.exception.ControllerException;
import com.bsuir.task_manager.controller.exception.WrongInputControllerException;
import com.bsuir.task_manager.controller.exception.user.UserNotFoundControllerException;
import com.bsuir.task_manager.security.TokenAuthentication;
import com.bsuir.task_manager.service.UserService;
import com.bsuir.task_manager.service.exception.ExistsServiceException;
import com.bsuir.task_manager.service.exception.NotFoundServiceException;
import com.bsuir.task_manager.service.exception.ServiceException;
import com.bsuir.task_manager.service.exception.WrongInputServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserControllerImpl implements UserController {

    private final UserService service;

    @Autowired
    public UserControllerImpl(UserService service) {
        this.service = service;
    }

    @Override
    public UserView getUser(@PathVariable int userId) throws ControllerException {
        try {
            int currentUserId = getSessionUserId();
            if (currentUserId != userId) {
                throw new ControllerException("Forbidden");
            }
            return service.getUserById(userId);
        } catch (NotFoundServiceException e) {
            throw new UserNotFoundControllerException("User doesn't exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform update", e);
        }
    }

    @Override
    public void updateUser(@PathVariable int userId, @RequestBody UserView user) throws ControllerException {
        try {
            int currentUserId = getSessionUserId();
            if (currentUserId != userId) {
                throw new ControllerException("Forbidden");
            }
            service.updateUser(userId, user);
        } catch (NotFoundServiceException e) {
            throw new UserNotFoundControllerException("User doesn't exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform update", e);
        }
    }

    @Override
    public void deleteUser(@PathVariable int userId) throws ControllerException {
        try {
            int currentUserId = getSessionUserId();
            if (currentUserId != userId) {
                throw new ControllerException("Forbidden");
            }
            service.deleteUser(userId);
        } catch (ExistsServiceException e) {
            throw new UserNotFoundControllerException("User doesn't exists", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform logout", e);
        }
    }

    private int getSessionUserId() {
        TokenAuthentication tokenAuthentication;
        tokenAuthentication = (TokenAuthentication) SecurityContextHolder.getContext().getAuthentication();
        Long userIdLong = (Long) tokenAuthentication.getDetails();
        return userIdLong.intValue();
    }
}
