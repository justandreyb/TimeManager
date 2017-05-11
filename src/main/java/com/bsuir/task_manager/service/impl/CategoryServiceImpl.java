package com.bsuir.task_manager.service.impl;

import com.bsuir.task_manager.bean.entity.CategoryEntity;
import com.bsuir.task_manager.bean.view.CategoryView;
import com.bsuir.task_manager.dao.CategoryDAO;
import com.bsuir.task_manager.dao.exception.DAOException;
import com.bsuir.task_manager.dao.exception.ExistsDAOException;
import com.bsuir.task_manager.dao.exception.NotFoundDAOException;
import com.bsuir.task_manager.service.CategoryService;
import com.bsuir.task_manager.service.exception.ExistsServiceException;
import com.bsuir.task_manager.service.exception.NotFoundServiceException;
import com.bsuir.task_manager.service.exception.ServiceException;
import com.bsuir.task_manager.service.exception.WrongInputServiceException;
import com.bsuir.task_manager.service.util.Exchanger;
import com.bsuir.task_manager.service.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDAO categoryDAO;

    @Autowired
    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public void createCategory(int userId, CategoryView category) throws ServiceException {
        if (!Validator.isValid(userId)) {
            throw new WrongInputServiceException("Incorrect user id");
        }
        if (!Validator.isValid(category)) {
            throw new WrongInputServiceException("Invalid fields in new category");
        }
        CategoryEntity categoryEntity = Exchanger.exchange(category);
        try {
            categoryDAO.addCategory(userId, categoryEntity);
        } catch (ExistsDAOException e) {
            throw new ExistsServiceException("Category already exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while creating category", e);
        }
    }

    @Override
    public CategoryView getCategory(int categoryId) throws ServiceException {
        if (!Validator.isValid(categoryId)) {
            throw new WrongInputServiceException("Incorrect category id");
        }
        try {
            CategoryEntity categoryEntity = categoryDAO.getCategory(categoryId);
            return Exchanger.exchange(categoryEntity);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Category doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while getting category", e);
        }
    }

    @Override
    public List<CategoryView> getDefaultCategories() throws ServiceException {
        try {
            List<CategoryEntity> categoryEntities = categoryDAO.getDefaultCategories();
            List<CategoryView> categoryViews = new LinkedList<CategoryView>();
            for (CategoryEntity categoryEntity : categoryEntities) {
                CategoryView categoryView = Exchanger.exchange(categoryEntity);
                categoryViews.add(categoryView);
            }
            return categoryViews;
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while getting default categories", e);
        }
    }

    @Override
    public List<CategoryView> getCategoriesByUser(int userId) throws ServiceException {
        if (!Validator.isValid(userId)) {
            throw new WrongInputServiceException("Incorrect user id");
        }
        try {
            List<CategoryEntity> categoryEntities = categoryDAO.getCategoriesByUser(userId);
            List<CategoryView> categoryViews = new LinkedList<CategoryView>();
            for (CategoryEntity categoryEntity : categoryEntities) {
                CategoryView categoryView = Exchanger.exchange(categoryEntity);
                categoryViews.add(categoryView);
            }
            return categoryViews;
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while getting categories by user", e);
        }
    }

    @Override
    public void updateCategory(int categoryId, CategoryView category) throws ServiceException {
        if (!Validator.isValid(categoryId)) {
            throw new WrongInputServiceException("Incorrect category id");
        }
        if (!Validator.isValid(category)) {
            throw new WrongInputServiceException("Invalid fields in category");
        }
        CategoryEntity categoryEntity = Exchanger.exchange(category);
        try {
            categoryDAO.updateCategory(categoryId, categoryEntity);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Category doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while updating category", e);
        }
    }

    @Override
    public void deleteCategory(int categoryId) throws ServiceException {
        if (!Validator.isValid(categoryId)) {
            throw new WrongInputServiceException("Incorrect category id");
        }
        try {
            categoryDAO.deleteCategory(categoryId);
        } catch (NotFoundDAOException e) {
            throw new NotFoundServiceException("Category doesn't exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Something went wrong while deleting category", e);
        }
    }
}
