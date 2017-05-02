package com.bsuir.task_manager.bean.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "task", schema = "time_manager")
public class TaskEntity {
    private int id;
    private String name;
    private String description;
    private boolean deleted;
    private boolean active;
    private Timestamp startDate;
    private Timestamp finishDate;
    private byte importance;
    private byte priority;
    private Byte interestingness;
    private CategoryEntity category;
    private UserEntity user;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 150)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "is_deleted", nullable = false, columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Basic
    @Column(name = "is_active", nullable = false, columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Basic
    @Column(name = "start_date", nullable = false)
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "finish_date", nullable = false)
    public Timestamp getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Timestamp finishDate) {
        this.finishDate = finishDate;
    }

    @Basic
    @Column(name = "importance", nullable = false)
    public byte getImportance() {
        return importance;
    }

    public void setImportance(byte importance) {
        this.importance = importance;
    }

    @Basic
    @Column(name = "priority", nullable = false)
    public byte getPriority() {
        return priority;
    }

    public void setPriority(byte priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "interestingness", nullable = true)
    public Byte getInterestingness() {
        return interestingness;
    }

    public void setInterestingness(Byte interestingness) {
        this.interestingness = interestingness;
    }


    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskEntity that = (TaskEntity) o;
        return id == that.id &&
                deleted == that.deleted &&
                active == that.active &&
                importance == that.importance &&
                priority == that.priority &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(finishDate, that.finishDate) &&
                Objects.equals(interestingness, that.interestingness) &&
                Objects.equals(category, that.category) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, deleted, active, startDate, finishDate, importance, priority, interestingness, category, user);
    }
}
