package com.bsuir.task_manager.controller.impl;

import com.bsuir.task_manager.bean.view.TokenView;
import com.bsuir.task_manager.bean.view.UserView;
import com.bsuir.task_manager.controller.AuthenticationController;
import com.bsuir.task_manager.controller.exception.ControllerException;
import com.bsuir.task_manager.controller.exception.WrongInputControllerException;
import com.bsuir.task_manager.controller.exception.user.UserExistsControllerException;
import com.bsuir.task_manager.controller.exception.user.UserNotFoundControllerException;
import com.bsuir.task_manager.controller.util.ArgumentUtil;
import com.bsuir.task_manager.security.service.TokenService;
import com.bsuir.task_manager.security.service.exception.AuthenticationException;
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
    private final TokenService tokenService;

    @Autowired
    public AuthenticationControllerImpl(UserService service, TokenService tokenService) {
        this.service = service;
        this.tokenService = tokenService;
    }

    @Override
    public TokenView signUp(@RequestBody UserView user) throws ControllerException {
        try {
            user.setPassword(ArgumentUtil.generatePass(user.getPassword()));
            service.createUser(user);

            String token = tokenService.getToken(user.getEmail(), user.getPassword());
            return new TokenView(token);


        } catch (ExistsServiceException e) {
            throw new UserExistsControllerException("User already exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException | AuthenticationException e) {
            throw new ControllerException("Error while perform registration", e);
        }
    }

    @Override
    public TokenView signIn(@RequestParam("email") String email, @RequestParam("password") String password) throws ControllerException {
        try {
            UserView user = service.getUser(email, password);
            String token = tokenService.getToken(user.getEmail(), user.getPassword());
            return new TokenView(token);
        } catch (ExistsServiceException e) {
            throw new UserNotFoundControllerException("User doesn't exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException | AuthenticationException e) {
            throw new ControllerException("Error while perform login", e);
        }
    }

    @Override
    public void signOut() {
        // TODO: Sign OUT
    }
}
