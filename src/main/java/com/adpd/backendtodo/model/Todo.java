package com.adpd.backendtodo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private LocalDate deadline;
    private boolean completed = Boolean.FALSE;
    @Column(name = "userId")
    private String userId;

    public Todo() {}

    public Todo(String userId, String content, LocalDate deadline) {
        this.userId = userId;
        this.content = content;
        this.deadline = deadline;
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
        Todo other = (Todo) obj;
        return Objects.equals(id, other.id);
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getUserId() {
        return userId;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
