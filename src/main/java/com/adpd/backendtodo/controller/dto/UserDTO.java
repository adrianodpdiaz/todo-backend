package com.adpd.backendtodo.controller.dto;

import com.adpd.backendtodo.model.User;
import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {
    private String id;
    private String name;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static List<UserDTO> converter(List<User> sites) {
        return sites.stream().map(UserDTO::new).collect(Collectors.toList());
    }
}
