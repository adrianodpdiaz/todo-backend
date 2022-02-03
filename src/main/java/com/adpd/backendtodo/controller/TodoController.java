package com.adpd.backendtodo.controller;

import com.adpd.backendtodo.controller.dto.TodoDTO;
import com.adpd.backendtodo.controller.form.TodoForm;
import com.adpd.backendtodo.model.Todo;
import com.adpd.backendtodo.model.User;
import com.adpd.backendtodo.repository.TodoRepository;
import com.adpd.backendtodo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<TodoDTO> getAllToDos(String userId) {
        if(userId != null) {
            List<Todo> todos = todoRepository.findByUserId(userId);
            return TodoDTO.converter(todos);
        }
        return new ArrayList<>();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TodoDTO> create(
            @RequestBody TodoForm todoForm, UriComponentsBuilder uriBuilder) {
        User user = userRepository.getById(todoForm.getUserId());
        Todo todo = todoForm.converter();

        user.getTodoList().add(todo);
        todoRepository.save(todo);

        URI uri = uriBuilder.path("/todo/{id}").buildAndExpand(todo.getId()).toUri();
        return ResponseEntity.created(uri).body(new TodoDTO(todo));
    }

    @PatchMapping("/complete/{id}")
    @Transactional
    public ResponseEntity<TodoDTO> complete(@PathVariable Long id) {
        Todo todo = todoRepository.getById(id);
        todo.setCompleted(true);

        return ResponseEntity.ok(new TodoDTO(todo));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        todoRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
