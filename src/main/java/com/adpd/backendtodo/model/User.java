package com.adpd.backendtodo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
	private String id;
    private String name;
    private String avatar;
    @OneToMany(mappedBy = "userId")
    private List<Todo> todoList = new ArrayList<>();

    public User() {}

    public User(String id, String name, String avatar) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
    }

    @Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }
}
