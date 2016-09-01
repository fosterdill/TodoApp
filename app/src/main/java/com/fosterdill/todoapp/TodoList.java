package com.fosterdill.todoapp;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by dylan on 8/30/16.
 */
@Entity
public class TodoList {
    @Id
    private Long id;

    @Property
    private String name;

    @Property
    private String description;

    @Generated(hash = 347152246)
    public TodoList(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Generated(hash = 902470114)
    public TodoList() {
    }

    public String toString() {
        return this.name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
