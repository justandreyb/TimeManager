package com.bsuir.task_manager.dao.impl;

import com.bsuir.task_manager.bean.entity.RoleEntity;
import com.bsuir.task_manager.bean.entity.UserEntity;
import com.bsuir.task_manager.dao.UserDAO;
import com.bsuir.task_manager.dao.exception.DAOException;
import com.bsuir.task_manager.dao.exception.ExistsDAOException;
import com.bsuir.task_manager.dao.exception.NotFoundDAOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    private final SessionFactory sessionFactory;

    private static final String STORAGE_EXCEPTION = "Something went wrong while trying to access storage";
    
    private static final int USER_ROLE = 2;
    private static final boolean DELETED_STATE = true;
    private static final boolean ACTIVE_STATE = false;

    private static final String GET_USER_QUERY =
            "from UserEntity " +
            "where " +
                "email = :inputEmail and " +
                "password = :inputPass and " +
                "deleted = :inputActive";

    private static final String DELETE_USER_QUERY =
            "update UserEntity " +
            "set " +
                "deleted = :inputActive " +
            "where " +
                "id = :inputId";

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private UserEntity getUserFromStorage(Session session, String email, String password) {
        Query query = session.createQuery(GET_USER_QUERY);
        query.setParameter("inputEmail", email);
        query.setParameter("inputPass", password);
        query.setParameter("inputActive", ACTIVE_STATE);

        return (UserEntity) query.getSingleResult();
    }

    @Override
    public void createUser(UserEntity user) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            throw new DAOException(STORAGE_EXCEPTION);
        }

        UserEntity existsUser = getUserFromStorage(session, user.getEmail(), user.getPassword());
        if (existsUser != null) {
            throw new ExistsDAOException("User already exists");
        }

        RoleEntity role = session.load(RoleEntity.class, USER_ROLE);
        user.setRole(role);
        session.save(user);
    }

    @Override
    public UserEntity getUser(String email, String password) throws DAOException {
        UserEntity user;
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            throw new DAOException(STORAGE_EXCEPTION);
        }

        user = getUserFromStorage(session, email, password);
        if (user == null) {
            throw new NotFoundDAOException("User not found");
        }
        return user;
    }

    @Override
    public void updateUser(int userId, UserEntity user) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            throw new DAOException(STORAGE_EXCEPTION);
        }

        UserEntity existsUser = getUserFromStorage(session, user.getEmail(), user.getPassword());
        if (existsUser == null) {
            throw new NotFoundDAOException("User doesn't exists");
        }

        session.saveOrUpdate(user);
    }

    @Override
    public void deleteUser(int userId) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            throw new DAOException(STORAGE_EXCEPTION);
        }
        Query query = session.createQuery(DELETE_USER_QUERY);
        query.setParameter("inputActive", DELETED_STATE);
        query.setParameter("inputId", userId);
        if (query.executeUpdate() < 1) {
            throw new DAOException("User wasn't deleted");
        }
    }
}
