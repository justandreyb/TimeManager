package com.bsuir.task_manager.bean.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "role", schema = "time_manager")
public class RoleEntity {
    private int id;
    private String value;
    private List<UserEntity> users;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "value", nullable = false, length = 25)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @OneToMany(mappedBy = "role")
    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return id == that.id &&
                Objects.equals(value, that.value) &&
                Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, users);
    }
}
