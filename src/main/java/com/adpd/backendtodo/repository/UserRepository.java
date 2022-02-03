package com.adpd.backendtodo.repository;

import com.adpd.backendtodo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
