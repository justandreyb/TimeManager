package com.bsuir.task_manager.controller;

import com.bsuir.task_manager.bean.view.CategoryView;
import com.bsuir.task_manager.controller.exception.ControllerException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users/{userId}/categories")
public interface CategoryController {

    @PreAuthorize("hasAuthority('user')")
    @PostMapping("/add")
    void addCategory(@RequestBody CategoryView category, @PathVariable int userId) throws ControllerException;

    @PreAuthorize("hasAuthority('user')")
    @GetMapping("/{categoryId}")
    @ResponseBody
    CategoryView getCategory(@PathVariable int categoryId, @PathVariable int userId) throws ControllerException;

    @PreAuthorize("hasAuthority('user')")
    @GetMapping
    @ResponseBody
    List<CategoryView> getCategories(@PathVariable int userId) throws ControllerException;

    @PreAuthorize("hasAuthority('user')")
    @GetMapping("/default")
    @ResponseBody
    List<CategoryView> getDefaultCategories() throws ControllerException;

    @PreAuthorize("hasAuthority('user')")
    @GetMapping("/user")
    @ResponseBody
    List<CategoryView> getCategoriesByUser(@PathVariable int userId) throws ControllerException;

    @PreAuthorize("hasAuthority('user')")
    @PostMapping("/{categoryId}/edit")
    void updateCategory(@PathVariable int categoryId, @PathVariable int userId, @RequestBody CategoryView category) throws ControllerException;

    @PreAuthorize("hasAuthority('user')")
    @GetMapping("/{categoryId}/delete")
    void deleteCategory(@PathVariable int categoryId, @PathVariable int userId) throws ControllerException;

}
