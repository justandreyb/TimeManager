package com.bsuir.task_manager.bean.view;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class ProjectView {
    private int id;
    private String name;
    private Timestamp startDate;
    private Timestamp deadline;
    private byte importance;
    private boolean finished;
    private boolean deleted;
    private UserView user;
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

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public byte getImportance() {
        return importance;
    }

    public void setImportance(byte importance) {
        this.importance = importance;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public UserView getUser() {
        return user;
    }

    public void setUser(UserView user) {
        this.user = user;
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
        ProjectView that = (ProjectView) o;
        return id == that.id &&
                importance == that.importance &&
                finished == that.finished &&
                deleted == that.deleted &&
                Objects.equals(name, that.name) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(deadline, that.deadline) &&
                Objects.equals(user, that.user) &&
                Objects.equals(tasks, that.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startDate, deadline, importance, finished, deleted, user, tasks);
    }
}
