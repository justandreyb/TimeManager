package com.bsuir.task_manager.controller;

import com.bsuir.task_manager.bean.view.UserView;
import com.bsuir.task_manager.controller.exception.ControllerException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/users")
public interface UserController {

    @PreAuthorize("hasAuthority('user')")
    @GetMapping("/{userId}")
    @ResponseBody
    UserView getUser(@PathVariable int userId) throws ControllerException;

    @PreAuthorize("hasAuthority('user')")
    @PostMapping("/{userId}/edit")
    void updateUser(@PathVariable int userId, @RequestBody UserView user) throws ControllerException;

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/{userId}/delete")
    void deleteUser(@PathVariable int userId) throws ControllerException;

}
