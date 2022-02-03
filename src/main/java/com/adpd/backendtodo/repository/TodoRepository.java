package com.adpd.backendtodo.repository;

import com.adpd.backendtodo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByUserId(String userId);

}
