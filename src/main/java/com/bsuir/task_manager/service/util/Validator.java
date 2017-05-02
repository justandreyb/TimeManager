package com.bsuir.task_manager.service.util;

import com.bsuir.task_manager.bean.view.CategoryView;
import com.bsuir.task_manager.bean.view.RoleView;
import com.bsuir.task_manager.bean.view.TaskView;
import com.bsuir.task_manager.bean.view.UserView;

public class Validator {

    public static boolean isValid(UserView user) {
        return false;
    }

    public static boolean isValid(TaskView task) {
        return false;
    }

    public static boolean isValid(CategoryView category) {
        return false;
    }

    public static boolean isValid(RoleView role) {
        return false;
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
