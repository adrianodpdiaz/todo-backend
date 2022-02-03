package com.adpd.backendtodo.controller.form;

import com.adpd.backendtodo.model.User;

public class UserForm {
    private String id;
    private String name;
    private String avatar;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public User converter() {
        return new User(id, name, avatar);
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", avatar=" + avatar +
                '}';
    }
}
