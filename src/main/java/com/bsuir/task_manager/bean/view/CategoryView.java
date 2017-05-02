package com.bsuir.task_manager.bean.view;

import java.util.List;

public class CategoryView {
    private int id;
    private String name;
    private boolean global;
    private boolean active;
    private int creatorId;
    private List<TaskView> tasks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGlobal() {
        return global;
    }

    public void setGlobal(boolean global) {
        this.global = global;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public List<TaskView> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskView> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryView that = (CategoryView) o;

        if (id != that.id) return false;
        if (global != that.global) return false;
        if (active != that.active) return false;
        if (creatorId != that.creatorId) return false;
        if (!name.equals(that.name)) return false;
        return tasks != null ? tasks.equals(that.tasks) : that.tasks == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + (global ? 1 : 0);
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + creatorId;
        result = 31 * result + (tasks != null ? tasks.hashCode() : 0);
        return result;
    }
}
