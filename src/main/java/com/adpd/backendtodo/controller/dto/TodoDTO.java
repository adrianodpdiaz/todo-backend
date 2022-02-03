package com.adpd.backendtodo.controller.dto;

import com.adpd.backendtodo.model.Todo;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TodoDTO {
    private Long id;
    private String content;
    private LocalDate deadline;
    private boolean completed = Boolean.FALSE;
    private String userId;

    public TodoDTO(Todo todo) {
        this.id = todo.getId();
        this.content = todo.getContent();
        this.deadline = todo.getDeadline();
        this.userId = todo.getUserId();
        this.completed = todo.getCompleted();
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

    public boolean getCompleted() {
        return completed;
    }

    public String getUserId() {
        return userId;
    }

    public static List<TodoDTO> converter(List<Todo> sites) {
        return sites.stream().map(TodoDTO::new).collect(Collectors.toList());
    }
}
