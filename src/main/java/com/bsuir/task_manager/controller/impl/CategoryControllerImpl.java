package com.bsuir.task_manager.controller.impl;

import com.bsuir.task_manager.bean.view.CategoryView;
import com.bsuir.task_manager.controller.CategoryController;
import com.bsuir.task_manager.controller.exception.ControllerException;
import com.bsuir.task_manager.controller.exception.WrongInputControllerException;
import com.bsuir.task_manager.controller.exception.category.CategoryExistsControllerException;
import com.bsuir.task_manager.controller.exception.category.CategoryNotFoundControllerException;
import com.bsuir.task_manager.service.CategoryService;
import com.bsuir.task_manager.service.exception.ExistsServiceException;
import com.bsuir.task_manager.service.exception.NotFoundServiceException;
import com.bsuir.task_manager.service.exception.ServiceException;
import com.bsuir.task_manager.service.exception.WrongInputServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryControllerImpl implements CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryControllerImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void addCategory(@RequestBody CategoryView category, @RequestParam("userId") int userId) throws ControllerException {
        try {
            categoryService.createCategory(userId, category);
        } catch (ExistsServiceException e) {
            throw new CategoryExistsControllerException("Category already exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform adding category", e);
        }
    }

    @Override
    public CategoryView getCategory(@PathVariable int categoryId) throws ControllerException {
        try {
            return categoryService.getCategory(categoryId);
        } catch (NotFoundServiceException e) {
            throw new CategoryNotFoundControllerException("Category doesn't exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform getting category", e);
        }
    }

    @Override
    public List<CategoryView> getCategories(@RequestParam("userId") int userId) throws ControllerException {
        try {
            List<CategoryView> categories = categoryService.getDefaultCategories();
            List<CategoryView> userCategories = categoryService.getCategoriesByUser(userId);
            return putUserCategoriesInList(categories, userCategories);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform getting categories", e);
        }
    }

    private List<CategoryView> putUserCategoriesInList(List<CategoryView> categories,
                                                       List<CategoryView> userCategories) {
        for (CategoryView category : userCategories) {
            categories.add(category);
        }

        return categories;
    }

    @Override
    public List<CategoryView> getDefaultCategories() throws ControllerException {
        try {
            return categoryService.getDefaultCategories();
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform getting default categories", e);
        }
    }

    @Override
    public List<CategoryView> getCategoriesByUser(@RequestParam("userId") int userId) throws ControllerException {
        try {
            return categoryService.getCategoriesByUser(userId);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform getting user's categories", e);
        }
    }

    @Override
    public void updateCategory(@PathVariable int categoryId, @RequestBody CategoryView category) throws ControllerException {
        try {
            categoryService.updateCategory(categoryId, category);
        } catch (NotFoundServiceException e) {
            throw new CategoryNotFoundControllerException("Category doesn't exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform updating category", e);
        }
    }

    @Override
    public void deleteCategory(@PathVariable int categoryId) throws ControllerException {
        try {
            categoryService.deleteCategory(categoryId);
        } catch (NotFoundServiceException e) {
            throw new CategoryNotFoundControllerException("Category doesn't exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform deleting category", e);
        }
    }

}
