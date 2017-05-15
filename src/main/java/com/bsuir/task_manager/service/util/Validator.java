package com.bsuir.task_manager.service.util;

import com.bsuir.task_manager.bean.view.*;

public class Validator {

    public static boolean isValid(UserView user) {
        if (user.getEmail() == null || "".equals(user.getEmail())) {
            return false;
        }
        if (user.getPassword() == null || "".equals(user.getPassword())) {
            return false;
        }
        if (user.getNickname() == null || "".equals(user.getNickname())) {
            return false;
        }
        return true;
    }

    public static boolean isValid(TaskView task) {
        if (task.getName() == null || "".equals(task.getName())) {
            return false;
        }
        if (task.getImportance() < 25 || task.getImportance() > 100) {
            return false;
        }
        if (task.getComplexity() < 25 || task.getComplexity() > 100) {
            return false;
        }
        if (task.getUrgency() < 25 || task.getUrgency() > 100) {
            return false;
        }
        return true;
    }

    public static boolean isValid(CategoryView category) {
        if (category.getName() == null || "".equals(category.getName())) {
            return false;
        }
        return true;
    }

    public static boolean isValid(RoleView role) {
        if (role.getValue() == null || "".equals(role.getValue())) {
            return false;
        }
        return true;
    }

    public static boolean isValid(ProjectView project) {
        if (project.getName() == null || "".equals(project.getName())) {
            return false;
        }
        if (project.getImportance() < 0 || project.getImportance() > 100) {
            return false;
        }
        return true;
    }

    public static boolean isValid(int id) {
        return id > 0;
    }

    public static boolean isValidPassword(String password) {
        return password != null && !password.equals("") && password.length() > 5;
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.length() > 5 && email.contains("@") && !email.equals("");
    }
}
