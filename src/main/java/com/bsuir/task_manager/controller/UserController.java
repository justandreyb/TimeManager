package com.bsuir.task_manager.controller;

import com.bsuir.task_manager.bean.view.UserView;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/users")
public interface UserController {

    @PostMapping("/add")
    void addUser(@RequestBody UserView user);

    @GetMapping("/{userId}")
    @ResponseBody
    UserView getUser(@PathVariable int userId);

    @PostMapping("/{userId}/edit")
    void updateUser(@PathVariable int userId, @RequestBody UserView user);

    @GetMapping("/{userId}/delete")
    void deleteUser(@PathVariable int userId);

}
