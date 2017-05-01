package com.bsuir.task_manager.bean.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category", schema = "time_manager")
public class CategoryEntity {
    private int id;
    private String name;
    private byte isGlobal;
    private byte isActive;
    private Integer creatorId;
    private List<TaskEntity> tasks;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "is_global", nullable = false)
    public byte getIsGlobal() {
        return isGlobal;
    }

    public void setIsGlobal(byte isGlobal) {
        this.isGlobal = isGlobal;
    }

    @Basic
    @Column(name = "is_active", nullable = false)
    public byte getIsActive() {
        return isActive;
    }

    public void setIsActive(byte isActive) {
        this.isActive = isActive;
    }

    @Basic
    @Column(name = "creator_id", nullable = true)
    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (id != that.id) return false;
        if (isGlobal != that.isGlobal) return false;
        if (isActive != that.isActive) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (creatorId != null ? !creatorId.equals(that.creatorId) : that.creatorId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) isGlobal;
        result = 31 * result + (int) isActive;
        result = 31 * result + (creatorId != null ? creatorId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "category")
    public List<TaskEntity> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskEntity> tasks) {
        this.tasks = tasks;
    }
}
