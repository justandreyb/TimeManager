package com.bsuir.task_manager.controller;

import com.bsuir.task_manager.bean.view.CategoryView;
import com.bsuir.task_manager.bean.view.TaskView;
import com.bsuir.task_manager.controller.exception.ControllerException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user/categories")
public interface CategoryController {

    @PostMapping("/add")
    void addCategory(@RequestBody CategoryView category, @RequestParam("userId") int userId) throws ControllerException;

    @GetMapping("/{categoryId}")
    @ResponseBody
    CategoryView getCategory(@PathVariable int categoryId) throws ControllerException;

    @GetMapping
    @ResponseBody
    List<CategoryView> getCategories(@RequestParam("userId") int userId) throws ControllerException;

    @GetMapping("/default")
    @ResponseBody
    List<CategoryView> getDefaultCategories() throws ControllerException;

    @GetMapping("/user")
    @ResponseBody
    List<CategoryView> getCategoriesByUser(@RequestParam("userId") int userId) throws ControllerException;

    @PostMapping("/{categoryId}/edit")
    void updateCategory(@PathVariable int categoryId, @RequestBody CategoryView category) throws ControllerException;

    @GetMapping("/{categoryId}/delete")
    void deleteCategory(@PathVariable int categoryId) throws ControllerException;

    @GetMapping("/{categoryId}/tasks/")
    @ResponseBody
    List<TaskView> getTasksByCategory(@PathVariable int categoryId) throws ControllerException;

    @PostMapping("/{categoryId}/tasks/add")
    void addTaskToCategory(@PathVariable int categoryId, @RequestParam("taskId") int taskId, @RequestParam("userId") int userId) throws ControllerException;

    @GetMapping("/{categoryId}/tasks/{taskId}/delete")
    void deleteTaskFromCategory(@PathVariable int categoryId, @PathVariable int taskId) throws ControllerException;
}
