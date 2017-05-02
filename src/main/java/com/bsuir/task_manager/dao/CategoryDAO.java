package com.bsuir.task_manager.dao;

import com.bsuir.task_manager.bean.entity.CategoryEntity;
import com.bsuir.task_manager.dao.exception.DAOException;

import java.util.List;

public interface CategoryDAO {

    void addCategory(int userId, CategoryEntity category) throws DAOException;

    CategoryEntity getCategory(int categoryId) throws DAOException;

    List<CategoryEntity> getCategoriesByUser(int userId) throws DAOException;
    List<CategoryEntity> getDefaultCategories() throws DAOException;

    void updateCategory(int categoryId, CategoryEntity category) throws DAOException;

    void deleteCategory(int categoryId) throws DAOException;

}
