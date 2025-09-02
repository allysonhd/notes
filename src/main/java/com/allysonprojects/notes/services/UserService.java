package com.allysonprojects.notes.services;

import com.allysonprojects.notes.dtos.UserDTO;
import com.allysonprojects.notes.models.User;

import java.util.List;

public interface UserService {
    void updateUserRole(Long userId, String roleName);

    List<User> getAllUsers();

    UserDTO getUserById(Long id);
}
