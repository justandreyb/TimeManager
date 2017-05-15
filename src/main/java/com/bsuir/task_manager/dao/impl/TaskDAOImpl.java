package com.bsuir.task_manager.dao.impl;

import com.bsuir.task_manager.bean.entity.CategoryEntity;
import com.bsuir.task_manager.bean.entity.TaskEntity;
import com.bsuir.task_manager.bean.entity.UserEntity;
import com.bsuir.task_manager.dao.TaskDAO;
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
public class TaskDAOImpl implements TaskDAO {

    private final SessionFactory sessionFactory;

    private static final String STORAGE_EXCEPTION = "Something went wrong while trying to access storage";

    private static final boolean NOT_DELETED_STATE = false;
    private static final boolean DELETED_STATE = true;

    private static final String GET_PROJECT_QUERY =
            "from ProjectEntity " +
            "where " +
                "id = :inputId and " +
                "deleted = :inputActive";

    private static final String GET_CATEGORY_QUERY =
            "from CategoryEntity " +
            "where " +
                "id = :inputId and " +
                "active = :inputActive";

    private static final String GET_TASK_QUERY =
            "from TaskEntity " +
            "where " +
                "project = :inputProject and " +
                "name = :inputName and " +
                "deleted = :inputDeleted";

    private static final String GET_TASKS_QUERY =
            "from TaskEntity " +
            "where " +
                "project = :inputProject and " +
                "deleted = :inputDeleted";

    private static final String GET_TASKS_BY_CATEGORY_QUERY =
            "from TaskEntity " +
            "where " +
                "project = :inputProject and " +
                "category = :inputCategory and " +
                "deleted = :inputDeleted";

    private static final String SET_ACTIVE_STATE_QUERY =
            "update TaskEntity " +
            "set " +
                "deleted = :inputActive " +
            "where " +
                "id = :inputId and " +
                "deleted = :inputDeleted";

    private static final String DELETE_TASK_QUERY =
            "update TaskEntity " +
            "set " +
                "deleted = :inputDeleted " +
            "where " +
                "id = :inputId";

    @Autowired
    public TaskDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private UserEntity getProjectFromStorage(Session session, int projectId) throws DAOException {
        Query query = session.createQuery(GET_PROJECT_QUERY);
        query.setParameter("inputId", projectId);
        query.setParameter("inputActive", NOT_DELETED_STATE);
        UserEntity userEntity = (UserEntity) query.getSingleResult();
        if (userEntity == null) {
            throw new DAOException("Project not found");
        }
        return userEntity;
    }

    private CategoryEntity getCategoryFromStorage(Session session, int categoryId) throws DAOException {
        Query query = session.createQuery(GET_CATEGORY_QUERY);
        query.setParameter("inputId", categoryId);
        query.setParameter("inputActive", NOT_DELETED_STATE);
        CategoryEntity categoryEntity = (CategoryEntity) query.getSingleResult();
        if (categoryEntity == null) {
            throw new DAOException("Category not found");
        }
        return categoryEntity;
    }

    private TaskEntity getTaskFromStorage(Session session, int projectId, String taskName) throws DAOException {
        Query query = session.createQuery(GET_TASK_QUERY);
        query.setParameter("inputProject", getProjectFromStorage(session, projectId));
        query.setParameter("inputName", taskName);
        query.setParameter("inputDeleted", NOT_DELETED_STATE);

        return (TaskEntity) query.getSingleResult();
    }

    @Override
    public void addTask(int projectId, TaskEntity task) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            throw new DAOException(STORAGE_EXCEPTION);
        }

       /* TaskEntity existsTask = getTaskFromStorage(session, projectId, task.getName());
        if (existsTask != null) {
            throw new ExistsDAOException("Task already exists");
        }*/

        session.save(task);
    }

    @Override
    public TaskEntity getTask(int taskId) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            throw new DAOException(STORAGE_EXCEPTION);
        }

        TaskEntity taskEntity = session.get(TaskEntity.class, taskId);
        if (taskEntity == null) {
            throw new NotFoundDAOException("Task not found");
        }

        return taskEntity;
    }

    @Override
    public List<TaskEntity> getTasks(int projectId) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            throw new DAOException(STORAGE_EXCEPTION);
        }
        Query query = session.createQuery(GET_TASKS_QUERY);
        query.setParameter("inputProject", getProjectFromStorage(session, projectId));
        query.setParameter("inputDeleted", NOT_DELETED_STATE);

        List<TaskEntity> tasks = (List<TaskEntity>) query.getResultList();

        if (tasks == null) {
            throw new DAOException("Error while getting tasks");
        }
        return tasks;
    }

    @Override
    public List<TaskEntity> getTasksByCategory(int projectId, int categoryId) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            throw new DAOException(STORAGE_EXCEPTION);
        }
        Query query = session.createQuery(GET_TASKS_BY_CATEGORY_QUERY);
        query.setParameter("inputProject", getProjectFromStorage(session, projectId));
        query.setParameter("inputCategory", getCategoryFromStorage(session, categoryId));
        query.setParameter("inputDeleted", NOT_DELETED_STATE);

        List<TaskEntity> tasks = (List<TaskEntity>) query.getResultList();

        if (tasks == null) {
            throw new DAOException("Error while getting tasks by category");
        }
        return tasks;
    }

    @Override
    public void updateTask(int taskId, TaskEntity task) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            throw new DAOException(STORAGE_EXCEPTION);
        }
        TaskEntity existsTask = session.get(TaskEntity.class, taskId);
        if (existsTask == null) {
            throw new NotFoundDAOException("Task not found");
        }

        session.saveOrUpdate(task);
    }

    @Override
    public void setComplete(int taskId, boolean complete) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            throw new DAOException();
        }

        TaskEntity existsTask = session.get(TaskEntity.class, taskId);
        if (existsTask == null) {
            throw new NotFoundDAOException("Task not found");
        }

        Query query = session.createQuery(SET_ACTIVE_STATE_QUERY);
        query.setParameter("inputActive", complete);
        query.setParameter("inputId", taskId);
        query.setParameter("inputDeleted", NOT_DELETED_STATE);
        if (query.executeUpdate() < 1) {
            throw new DAOException("Task wasn't mark as complete");
        }
    }

    @Override
    public void deleteTask(int taskId) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            throw new DAOException(STORAGE_EXCEPTION);
        }

        TaskEntity existsTask = session.get(TaskEntity.class, taskId);
        if (existsTask == null) {
            throw new NotFoundDAOException("Task not found");
        }

        Query query = session.createQuery(DELETE_TASK_QUERY);
        query.setParameter("inputDeleted", DELETED_STATE);
        query.setParameter("inputId", taskId);
        if (query.executeUpdate() < 1) {
            throw new DAOException("Task wasn't deleted");
        }
    }
}
