package com.bsuir.task_manager.service.impl;

import com.bsuir.task_manager.bean.view.CategoryView;
import com.bsuir.task_manager.bean.view.TaskView;
import com.bsuir.task_manager.service.CategoryService;
import com.bsuir.task_manager.service.exception.ServiceException;
import com.bsuir.task_manager.service.exception.category.CategoryExistsServiceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Override
    public void createCategory(int userId, CategoryView category) throws ServiceException {

    }

    @Override
    public void addTask(int userId, int categoryId, int taskId) throws ServiceException {

    }

    @Override
    public void deleteTask(int categoryId, int taskId) throws ServiceException {

    }

    @Override
    public CategoryView getCategory(int categoryId) throws ServiceException {
        return null;
    }

    @Override
    public List<CategoryView> getDefaultCategories() throws ServiceException {
        return null;
    }

    @Override
    public List<CategoryView> getCategoriesByUser(int userId) throws ServiceException {
        return null;
    }

    @Override
    public List<TaskView> getTasksByCategory(int categoryId) throws ServiceException {
        return null;
    }

    @Override
    public void updateCategory(int categoryId, CategoryView category) throws ServiceException {

    }

    @Override
    public void deleteCategory(int categoryId) throws ServiceException {

    }
}
