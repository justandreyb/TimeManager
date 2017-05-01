package com.bsuir.task_manager.controller.impl;

import com.bsuir.task_manager.bean.view.CategoryView;
import com.bsuir.task_manager.bean.view.TaskView;
import com.bsuir.task_manager.controller.CategoryController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class CategoryControllerImpl implements CategoryController {
    @Override
    public void addCategory(@RequestBody CategoryView category) {
        System.out.println("Add category");

    }

    @Override
    public CategoryView getCategory(@PathVariable int categoryId) {
        System.out.println("Get category");

        return null;
    }

    @Override
    public List<CategoryView> getCategories() {
        System.out.println("Get categories");

        return null;
    }

    @Override
    public void updateCategory(@PathVariable int categoryId, @RequestBody CategoryView category) {
        System.out.println("Update category");

    }

    @Override
    public void addTaskToCategory(@PathVariable int categoryId, @RequestBody TaskView task) {
        System.out.println("Add task to category");

    }

    @Override
    public void deleteTaskFromCategory(@PathVariable int categoryId, @PathVariable int taskId) {
        System.out.println("Delete task from category");

    }
}
