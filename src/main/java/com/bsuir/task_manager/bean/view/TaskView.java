package com.bsuir.task_manager.bean.view;

import java.util.Objects;

public class TaskView {
    private int id;
    private String name;
    private String description;
    private boolean deleted;
    private byte importance;
    private boolean finished;
    private byte complexity;
    private byte urgency;
    private CategoryView category;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public byte getImportance() {
        return importance;
    }

    public void setImportance(byte importance) {
        this.importance = importance;
    }

    public CategoryView getCategory() {
        return category;
    }

    public void setCategory(CategoryView category) {
        this.category = category;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public byte getComplexity() {
        return complexity;
    }

    public void setComplexity(byte complexity) {
        this.complexity = complexity;
    }

    public byte getUrgency() {
        return urgency;
    }

    public void setUrgency(byte urgency) {
        this.urgency = urgency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskView taskView = (TaskView) o;
        return id == taskView.id &&
                deleted == taskView.deleted &&
                importance == taskView.importance &&
                finished == taskView.finished &&
                complexity == taskView.complexity &&
                urgency == taskView.urgency &&
                Objects.equals(name, taskView.name) &&
                Objects.equals(description, taskView.description) &&
                Objects.equals(category, taskView.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, deleted, importance, finished, complexity, urgency, category);
    }
}
