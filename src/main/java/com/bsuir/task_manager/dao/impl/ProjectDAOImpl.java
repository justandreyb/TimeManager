package com.bsuir.task_manager.dao.impl;

import com.bsuir.task_manager.bean.entity.ProjectEntity;
import com.bsuir.task_manager.bean.entity.UserEntity;
import com.bsuir.task_manager.dao.ProjectDAO;
import com.bsuir.task_manager.dao.exception.DAOException;
import com.bsuir.task_manager.dao.exception.ExistsDAOException;
import com.bsuir.task_manager.dao.exception.NotFoundDAOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

    private final SessionFactory sessionFactory;

    private static final String STORAGE_EXCEPTION = "Something went wrong while trying to access storage";

    private static final boolean NOT_DELETED_STATE = false;
    private static final boolean DELETED_STATE = true;


    private static final String GET_USER_QUERY =
            "from UserEntity " +
            "where " +
                "id = :inputUser and " +
                "deleted = :inputDeleted";

    private static final String GET_PROJECT_QUERY =
            "from ProjectEntity " +
            "where " +
                "user = :inputUser and " +
                "name = :inputName and " +
                "deleted = :inputDeleted";

    private static final String GET_PROJECTS_BY_USER_QUERY =
            "from ProjectEntity " +
            "where " +
                "user = :inputUser and " +
                "deleted = :inputDeleted";

    private static final String DELETE_PROJECT_QUERY =
            "update ProjectEntity " +
            "set " +
                "deleted = :inputDeleted " +
            "where " +
                "id = :inputId";

    @Autowired
    public ProjectDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private UserEntity getUserFromStorage(Session session, int userId) throws DAOException {
        Query query = session.createQuery(GET_USER_QUERY);

        query.setParameter("inputUser", userId);
        query.setParameter("inputDeleted", NOT_DELETED_STATE);

        return (UserEntity) query.getSingleResult();
    }

    private ProjectEntity getProjectFromStorage(Session session, int userId, String projectName) throws DAOException {
        Query query = session.createQuery(GET_PROJECT_QUERY);

        query.setParameter("inputUser", getUserFromStorage(session, userId));
        query.setParameter("inputName", projectName);
        query.setParameter("inputDeleted", NOT_DELETED_STATE);

        return (ProjectEntity) query.getSingleResult();
    }

    @Override
    public void addProject(int userId, ProjectEntity project) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            throw new DAOException(STORAGE_EXCEPTION);
        }
        UserEntity userEntity = session.load(UserEntity.class, userId);
        project.setUser(userEntity);

        project.setStartDate(new Timestamp(System.currentTimeMillis()));

        /*ProjectEntity projectEntity = getProjectFromStorage(session, userId, project.getName());
        if (projectEntity != null) {
            throw new ExistsDAOException("Project already exists");
        }*/

        session.save(project);
    }

    @Override
    public ProjectEntity getProject(int projectId) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            throw new DAOException(STORAGE_EXCEPTION);
        }

        ProjectEntity projectEntity = session.get(ProjectEntity.class, projectId);
        if (projectEntity == null) {
            throw new NotFoundDAOException("Project not found");
        }

        return projectEntity;
    }

    @Override
    public List<ProjectEntity> getProjectsByUser(int userId) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            throw new DAOException(STORAGE_EXCEPTION);
        }

        Query query = session.createQuery(GET_PROJECTS_BY_USER_QUERY);
        query.setParameter("inputUser", getUserFromStorage(session, userId));
        query.setParameter("inputDeleted", NOT_DELETED_STATE);

        List<ProjectEntity> projects = (List<ProjectEntity>) query.getResultList();

        if (projects == null) {
            throw new DAOException("Error while getting projects");
        }
        return projects;
    }

    @Override
    public void updateProject(int projectId, ProjectEntity project) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            throw new DAOException(STORAGE_EXCEPTION);
        }

        ProjectEntity existsProject = session.get(ProjectEntity.class, projectId);
        if (existsProject == null) {
            throw new NotFoundDAOException("Project not found");
        }

        session.saveOrUpdate(project);
    }

    @Override
    public void deleteProject(int projectId) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            throw new DAOException(STORAGE_EXCEPTION);
        }

        ProjectEntity existsCategory = session.get(ProjectEntity.class, projectId);
        if (existsCategory == null) {
            throw new NotFoundDAOException("Project not found");
        }

        Query query = session.createQuery(DELETE_PROJECT_QUERY);
        query.setParameter("inputDeleted", DELETED_STATE);
        query.setParameter("inputId", projectId);
        if (query.executeUpdate() < 1) {
            throw new DAOException("Project wasn't deleted");
        }
    }
}
