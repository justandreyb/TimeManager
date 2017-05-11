package com.bsuir.task_manager.bean.view;

import java.util.List;
import java.util.Objects;

public class UserView {
    private int id;
    private String nickname;
    private String email;
    private String password;
    private boolean deleted;
    private List<ProjectView> projects;
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

    public RoleView getRole() {
        return role;
    }

    public void setRole(RoleView role) {
        this.role = role;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public List<ProjectView> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectView> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserView userView = (UserView) o;
        return id == userView.id &&
                deleted == userView.deleted &&
                Objects.equals(nickname, userView.nickname) &&
                Objects.equals(email, userView.email) &&
                Objects.equals(password, userView.password) &&
                Objects.equals(projects, userView.projects) &&
                Objects.equals(role, userView.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, email, password, deleted, projects, role);
    }
}
