package com.bsuir.task_manager.controller.impl;

import com.bsuir.task_manager.bean.view.UserView;
import com.bsuir.task_manager.controller.UserController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserControllerImpl implements UserController {
    @Override
    public void addUser(@RequestBody UserView user) {
        System.out.println("Add user");
    }

    @Override
    public UserView getUser(@PathVariable int userId) {
        System.out.println("Get user");

        return null;
    }

    @Override
    public void updateUser(@PathVariable int userId, @RequestBody UserView user) {
        System.out.println("Update user");

    }

    @Override
    public void deleteUser(@PathVariable int userId) {
        System.out.println("Delete user");

    }
}
