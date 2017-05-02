package com.bsuir.task_manager.bean.view;

public class TaskView {
    private int id;
    private String name;
    private String description;
    private boolean deleted;
    private boolean active;
//    private Timestamp startDate;
//    private Timestamp finishDate;
    private byte importance;
    private byte priority;
    private byte interestingness;
    private int categoryId;
    private CategoryView category;
    private UserView user;

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public byte getImportance() {
        return importance;
    }

    public void setImportance(byte importance) {
        this.importance = importance;
    }

    public byte getPriority() {
        return priority;
    }

    public void setPriority(byte priority) {
        this.priority = priority;
    }

    public byte getInterestingness() {
        return interestingness;
    }

    public void setInterestingness(byte interestingness) {
        this.interestingness = interestingness;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public CategoryView getCategory() {
        return category;
    }

    public void setCategory(CategoryView category) {
        this.category = category;
    }

    public UserView getUser() {
        return user;
    }

    public void setUser(UserView user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskView taskView = (TaskView) o;

        if (id != taskView.id) return false;
        if (deleted != taskView.deleted) return false;
        if (active != taskView.active) return false;
        if (importance != taskView.importance) return false;
        if (priority != taskView.priority) return false;
        if (interestingness != taskView.interestingness) return false;
        if (categoryId != taskView.categoryId) return false;
        if (!name.equals(taskView.name)) return false;
        if (description != null ? !description.equals(taskView.description) : taskView.description != null)
            return false;
        if (!category.equals(taskView.category)) return false;
        return user.equals(taskView.user);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (deleted ? 1 : 0);
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (int) importance;
        result = 31 * result + (int) priority;
        result = 31 * result + (int) interestingness;
        result = 31 * result + categoryId;
        result = 31 * result + category.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }
}
