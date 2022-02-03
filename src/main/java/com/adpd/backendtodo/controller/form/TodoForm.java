package com.adpd.backendtodo.controller.form;

import com.adpd.backendtodo.model.Todo;

import java.time.LocalDate;

public class TodoForm {
    private String userId;
    private String content;
    private LocalDate deadline;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Todo converter() {
        return new Todo(userId, content, deadline);
    }

    @Override
    public String toString() {
        return "TodoForm{" +
                "userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}
