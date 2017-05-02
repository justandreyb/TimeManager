package com.bsuir.task_manager.service;

import com.bsuir.task_manager.bean.view.CategoryView;
import com.bsuir.task_manager.service.exception.ServiceException;

import java.util.List;

public interface CategoryService {

    void createCategory(int userId, CategoryView category) throws ServiceException;

    CategoryView getCategory(int categoryId) throws ServiceException;
    List<CategoryView> getDefaultCategories() throws ServiceException;
    List<CategoryView> getCategoriesByUser(int userId) throws ServiceException;

    void updateCategory(int categoryId, CategoryView category) throws ServiceException;

    void deleteCategory(int categoryId) throws ServiceException;
}
