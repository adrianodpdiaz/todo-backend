package com.adpd.backendtodo.controller;

import com.adpd.backendtodo.controller.dto.UserDTO;
import com.adpd.backendtodo.controller.form.UserForm;
import com.adpd.backendtodo.model.User;
import com.adpd.backendtodo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<UserDTO> create(
            @RequestBody UserForm userForm, UriComponentsBuilder uriBuilder) {
        Optional<User> userDB = userRepository.findById(userForm.getId());
        User user = userForm.converter();
        userRepository.save(user);

        URI uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();

        if(userDB.isPresent()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.created(uri).body(new UserDTO(user));
    }
}
