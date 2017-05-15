package com.bsuir.task_manager.controller;

import com.bsuir.task_manager.bean.view.TokenView;
import com.bsuir.task_manager.bean.view.UserView;
import com.bsuir.task_manager.controller.exception.ControllerException;
import org.springframework.web.bind.annotation.*;

public interface AuthenticationController {

    @PostMapping("/registration")
    TokenView signUp(@RequestBody UserView user) throws ControllerException;

    @PostMapping("/login")
    @ResponseBody
    TokenView signIn(@RequestBody UserView user) throws ControllerException;

    @GetMapping("/logout")
    void signOut() throws ControllerException;
}
