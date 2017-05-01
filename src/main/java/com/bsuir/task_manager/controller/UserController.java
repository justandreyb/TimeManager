package com.bsuir.task_manager.controller;

import com.bsuir.task_manager.bean.view.UserView;
import com.bsuir.task_manager.controller.exception.ControllerException;
import com.bsuir.task_manager.controller.exception.NotFoundControllerException;
import com.bsuir.task_manager.controller.exception.WrongInputControllerException;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/users")
public interface UserController {

    @PostMapping("/{userId}/edit")
    void updateUser(@PathVariable int userId, @RequestBody UserView user) throws ControllerException;

    @GetMapping("/{userId}/delete")
    void deleteUser(@PathVariable int userId) throws ControllerException;

}
