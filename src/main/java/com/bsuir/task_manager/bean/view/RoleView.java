package com.bsuir.task_manager.bean.view;

public class RoleView {
    private int id;
    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleView roleView = (RoleView) o;

        if (id != roleView.id) return false;
        return value.equals(roleView.value);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + value.hashCode();
        return result;
    }
}
