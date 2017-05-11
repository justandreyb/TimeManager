package com.bsuir.task_manager.dao.impl;

import com.bsuir.task_manager.bean.entity.CategoryEntity;
import com.bsuir.task_manager.dao.CategoryDAO;
import com.bsuir.task_manager.dao.exception.DAOException;
import com.bsuir.task_manager.dao.exception.ExistsDAOException;
import com.bsuir.task_manager.dao.exception.NotFoundDAOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

    private final SessionFactory sessionFactory;

    private static final String STORAGE_EXCEPTION = "Something went wrong while trying to access storage";

    private static final boolean GLOBAL_STATE = true;
    private static final boolean NOT_DELETED_STATE = false;
    private static final boolean DELETED_STATE = true;

    private static final String GET_CATEGORY_QUERY =
            "from CategoryEntity " +
            "where " +
                "creatorId = :inputUser and " +
                "name = :inputName and " +
                "active = :inputDeleted";

    private static final String GET_CATEGORIES_BY_USER_QUERY =
            "from CategoryEntity " +
            "where " +
                "creatorId = :inputUser and " +
                "active = :inputDeleted";

    private static final String GET_DEFAULT_CATEGORIES_QUERY =
            "from CategoryEntity " +
            "where " +
                "global = :inputGlobal and " +
                "active = :inputDeleted";

    private static final String DELETE_CATEGORY_QUERY =
            "update CategoryEntity " +
            "set " +
                "active = :inputDeleted " +
            "where " +
                "id = :inputId";

    @Autowired
    public CategoryDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private CategoryEntity getCategoryFromStorage(Session session, int userId, String categoryName) throws DAOException {
        Query query = session.createQuery(GET_CATEGORY_QUERY);
        query.setParameter("inputUser", userId);
        query.setParameter("inputName", categoryName);
        query.setParameter("inputDeleted", NOT_DELETED_STATE);

        return (CategoryEntity) query.getSingleResult();
    }


    @Override
    public void addCategory(int userId, CategoryEntity category) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            throw new DAOException(STORAGE_EXCEPTION);
        }

        CategoryEntity categoryEntity = getCategoryFromStorage(session, userId, category.getName());
        if (categoryEntity != null) {
            throw new ExistsDAOException("Category already exists");
        }

        session.save(category);
    }

    @Override
    public CategoryEntity getCategory(int categoryId) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            throw new DAOException(STORAGE_EXCEPTION);
        }

        CategoryEntity categoryEntity = session.get(CategoryEntity.class, categoryId);
        if (categoryEntity == null) {
            throw new NotFoundDAOException("Category not found");
        }

        return categoryEntity;
    }

    @Override
    public List<CategoryEntity> getCategoriesByUser(int userId) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            throw new DAOException(STORAGE_EXCEPTION);
        }

        Query query = session.createQuery(GET_CATEGORIES_BY_USER_QUERY);
        query.setParameter("inputUser", userId);
        query.setParameter("inputDeleted", NOT_DELETED_STATE);

        List<CategoryEntity> categories = (List<CategoryEntity>) query.getResultList();

        if (categories == null) {
            throw new DAOException("Error while getting categories by user");
        }
        return categories;
    }

    @Override
    public List<CategoryEntity> getDefaultCategories() throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            throw new DAOException(STORAGE_EXCEPTION);
        }

        Query query = session.createQuery(GET_DEFAULT_CATEGORIES_QUERY);
        query.setParameter("inputGlobal", GLOBAL_STATE);
        query.setParameter("inputDeleted", NOT_DELETED_STATE);

        List<CategoryEntity> tasks = (List<CategoryEntity>) query.getResultList();

        if (tasks == null) {
            throw new DAOException("Error while getting default categories");
        }
        return tasks;
    }

    @Override
    public void updateCategory(int categoryId, CategoryEntity category) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            throw new DAOException(STORAGE_EXCEPTION);
        }

        CategoryEntity existsCategory = session.get(CategoryEntity.class, categoryId);
        if (existsCategory == null) {
            throw new NotFoundDAOException("Category not found");
        }

        session.saveOrUpdate(category);
    }

    @Override
    public void deleteCategory(int categoryId) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            throw new DAOException(STORAGE_EXCEPTION);
        }

        CategoryEntity existsCategory = session.get(CategoryEntity.class, categoryId);
        if (existsCategory == null) {
            throw new NotFoundDAOException("Category not found");
        }

        Query query = session.createQuery(DELETE_CATEGORY_QUERY);
        query.setParameter("inputDeleted", DELETED_STATE);
        query.setParameter("inputId", categoryId);
        if (query.executeUpdate() < 1) {
            throw new DAOException("Category wasn't deleted");
        }
    }
}
