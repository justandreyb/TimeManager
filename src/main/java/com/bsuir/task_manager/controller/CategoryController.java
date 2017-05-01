package com.bsuir.task_manager.controller;

import com.bsuir.task_manager.bean.view.CategoryView;
import com.bsuir.task_manager.bean.view.TaskView;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user/categories")
public interface CategoryController {

    @PostMapping("/add")
    void addCategory(@RequestBody CategoryView category);

    @GetMapping("/{categoryId}")
    @ResponseBody
    CategoryView getCategory(@PathVariable int categoryId);

    @GetMapping
    @ResponseBody
    List<CategoryView> getCategories();

    @PostMapping("/{categoryId}/edit")
    void updateCategory(@PathVariable int categoryId, @RequestBody CategoryView category);

    @PostMapping("/{categoryId}/tasks/add")
    void addTaskToCategory(@PathVariable int categoryId, @RequestBody TaskView task);

    @GetMapping("/{categoryId}/tasks/{taskId}/delete")
    void deleteTaskFromCategory(@PathVariable int categoryId, @PathVariable int taskId);
}
