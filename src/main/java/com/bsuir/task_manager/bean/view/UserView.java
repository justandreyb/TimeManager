package com.bsuir.task_manager.bean.view;

import java.util.List;

public class UserView {
    private int id;
    private String nickname;
    private String email;
    private String password;
    private boolean active;
    private List<TaskView> tasks;
    private RoleView role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TaskView> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskView> tasks) {
        this.tasks = tasks;
    }

    public RoleView getRole() {
        return role;
    }

    public void setRole(RoleView role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserView userView = (UserView) o;

        if (id != userView.id) return false;
        if (active != userView.active) return false;
        if (!nickname.equals(userView.nickname)) return false;
        if (!email.equals(userView.email)) return false;
        if (!password.equals(userView.password)) return false;
        if (tasks != null ? !tasks.equals(userView.tasks) : userView.tasks != null) return false;
        return role.equals(userView.role);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nickname.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (tasks != null ? tasks.hashCode() : 0);
        result = 31 * result + role.hashCode();
        return result;
    }
}
