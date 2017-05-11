package com.bsuir.task_manager.service.util;

import com.bsuir.task_manager.bean.entity.*;
import com.bsuir.task_manager.bean.view.*;

import java.util.ArrayList;
import java.util.List;

public class Exchanger {

    public static UserView exchange(UserEntity userEntity) {
        UserView userView = new UserView();

        userView.setId(userEntity.getId());
        userView.setEmail(userEntity.getEmail());
        userView.setPassword(userEntity.getPassword());
        userView.setNickname(userEntity.getNickname());
        userView.setRole(exchange(userEntity.getRole()));
        userView.setDeleted(userEntity.isDeleted());

        List<ProjectView> projectViews = new ArrayList<ProjectView>();
        for (ProjectEntity projectEntity : userEntity.getProjects()) {
            projectViews.add(exchange(projectEntity));
        }

        userView.setProjects(projectViews);

        return userView;
    }

    public static CategoryView exchange(CategoryEntity categoryEntity) {
        CategoryView categoryView = new CategoryView();

        categoryView.setId(categoryEntity.getId());
        categoryView.setActive(categoryEntity.isActive());
        categoryView.setGlobal(categoryEntity.isGlobal());
        categoryView.setCreatorId(categoryEntity.getCreatorId());
        categoryView.setName(categoryEntity.getName());

        List<TaskView> taskViews = new ArrayList<TaskView>();
        for (TaskEntity taskEntity : categoryEntity.getTasks()) {
            taskViews.add(exchange(taskEntity));
        }

        categoryView.setTasks(taskViews);

        return categoryView;
    }

    public static TaskView exchange(TaskEntity taskEntity) {
        TaskView taskView = new TaskView();

        taskView.setId(taskEntity.getId());
        taskView.setName(taskEntity.getName());
        taskView.setDeleted(taskEntity.isDeleted());
        taskView.setDescription(taskEntity.getDescription());
        taskView.setCategory(exchange(taskEntity.getCategory()));
        taskView.setComplexity(taskEntity.getComplexity());
        taskView.setImportance(taskEntity.getImportance());
        taskView.setUrgency(taskEntity.getUrgency());
        taskView.setFinished(taskEntity.isFinished());

        return taskView;
    }

    public static RoleView exchange(RoleEntity roleEntity) {
        RoleView roleView = new RoleView();

        roleView.setId(roleEntity.getId());
        roleView.setValue(roleEntity.getValue());

        return roleView;
    }

    public static ProjectView exchange(ProjectEntity projectEntity) {
        ProjectView projectView = new ProjectView();

        projectView.setId(projectEntity.getId());
        projectView.setName(projectEntity.getName());
        projectView.setUser(exchange(projectEntity.getUser()));
        projectView.setFinished(projectEntity.isFinished());
        projectView.setDeleted(projectEntity.isDeleted());
        projectView.setStartDate(projectEntity.getStartDate());
        projectView.setDeadline(projectEntity.getDeadline());
        projectView.setImportance(projectEntity.getImportance());

        List<TaskView> taskViews = new ArrayList<TaskView>();
        for (TaskEntity taskEntity : projectEntity.getTasks()) {
            taskViews.add(exchange(taskEntity));
        }

        projectView.setTasks(taskViews);

        return projectView;
    }

    public static UserEntity exchange(UserView userView) {
        UserEntity userEntity = new UserEntity();

        userEntity.setId(userView.getId());
        userEntity.setEmail(userView.getEmail());
        userEntity.setPassword(userView.getPassword());
        userEntity.setNickname(userView.getNickname());
        userEntity.setRole(exchange(userView.getRole()));
        userEntity.setDeleted(userView.isDeleted());

        List<ProjectEntity> projectEntities = new ArrayList<ProjectEntity>();
        for (ProjectView projectView : userView.getProjects()) {
            projectEntities.add(exchange(projectView));
        }

        userEntity.setProjects(projectEntities);

        return userEntity;
    }

    public static CategoryEntity exchange(CategoryView categoryView) {
        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId(categoryView.getId());
        categoryEntity.setActive(categoryView.isActive());
        categoryEntity.setGlobal(categoryView.isGlobal());
        categoryEntity.setCreatorId(categoryView.getCreatorId());
        categoryEntity.setName(categoryView.getName());

        List<TaskEntity> taskEntities = new ArrayList<TaskEntity>();
        for (TaskView taskView : categoryView.getTasks()) {
            taskEntities.add(exchange(taskView));
        }

        categoryEntity.setTasks(taskEntities);

        return categoryEntity;
    }

    public static TaskEntity exchange(TaskView taskView) {
        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setId(taskView.getId());
        taskEntity.setName(taskView.getName());
        taskEntity.setDeleted(taskView.isDeleted());
        taskEntity.setDescription(taskView.getDescription());
        taskEntity.setCategory(exchange(taskView.getCategory()));
        taskEntity.setComplexity(taskView.getComplexity());
        taskEntity.setImportance(taskView.getImportance());
        taskEntity.setUrgency(taskView.getUrgency());
        taskEntity.setFinished(taskView.isFinished());

        return taskEntity;
    }

    public static RoleEntity exchange(RoleView roleView) {
        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setId(roleView.getId());
        roleEntity.setValue(roleView.getValue());

        return roleEntity;
    }

    public static ProjectEntity exchange(ProjectView projectView) {
        ProjectEntity projectEntity = new ProjectEntity();

        projectEntity.setId(projectView.getId());
        projectEntity.setName(projectView.getName());
        projectEntity.setUser(exchange(projectView.getUser()));
        projectEntity.setFinished(projectView.isFinished());
        projectEntity.setDeleted(projectView.isDeleted());
        projectEntity.setStartDate(projectView.getStartDate());
        projectEntity.setDeadline(projectView.getDeadline());
        projectEntity.setImportance(projectView.getImportance());

        List<TaskEntity> taskEntities = new ArrayList<TaskEntity>();
        for (TaskView taskView : projectView.getTasks()) {
            taskEntities.add(exchange(taskView));
        }

        projectEntity.setTasks(taskEntities);

        return projectEntity;
    }

}
