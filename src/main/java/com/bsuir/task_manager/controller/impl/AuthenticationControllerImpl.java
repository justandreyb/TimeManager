package com.bsuir.task_manager.controller.impl;

import com.bsuir.task_manager.bean.view.UserView;
import com.bsuir.task_manager.controller.AuthenticationController;
import com.bsuir.task_manager.controller.exception.ControllerException;
import com.bsuir.task_manager.controller.exception.WrongInputControllerException;
import com.bsuir.task_manager.controller.exception.user.UserExistsControllerException;
import com.bsuir.task_manager.controller.exception.user.UserNotFoundControllerException;
import com.bsuir.task_manager.service.UserService;
import com.bsuir.task_manager.service.exception.ExistsServiceException;
import com.bsuir.task_manager.service.exception.ServiceException;
import com.bsuir.task_manager.service.exception.WrongInputServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationControllerImpl implements AuthenticationController {

    private final UserService service;

    @Autowired
    public AuthenticationControllerImpl(UserService service) {
        this.service = service;
    }

    @Override
    public void signUp(@RequestBody UserView user) throws ControllerException {
        try {
            service.createUser(user);
        } catch (ExistsServiceException e) {
            throw new UserExistsControllerException("User already exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform registration", e);
        }
    }

    @Override
    public UserView signIn(@RequestParam("email") String email, @RequestParam("password") String password) throws ControllerException {
        try {
            return service.getUser(email, password);
        } catch (ExistsServiceException e) {
            throw new UserNotFoundControllerException("User doesn't exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform login", e);
        }
    }

    @Override
    public void signOut() {
        // TODO: Sign OUT
    }
}
