package com.bsuir.task_manager.controller;

import com.bsuir.task_manager.bean.view.UserView;
import com.bsuir.task_manager.controller.exception.ControllerException;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/authentication")
public interface AuthenticationController {

    @PostMapping("/registration")
    void signUp(@RequestBody UserView user) throws ControllerException;

    @PostMapping("/login")
    @ResponseBody
    UserView signIn(@RequestParam("email") String email, @RequestParam("password") String password) throws ControllerException;

    @GetMapping("/logout")
    void signOut() throws ControllerException;
}
