package com.allysonprojects.notes.services.impl;

import com.allysonprojects.notes.dtos.UserDTO;
import com.allysonprojects.notes.models.AppRole;
import com.allysonprojects.notes.models.Role;
import com.allysonprojects.notes.models.User;
import com.allysonprojects.notes.repositories.RoleRepository;
import com.allysonprojects.notes.repositories.UserRepository;
import com.allysonprojects.notes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public void updateUserRole(Long userId, String roleName){
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found."));
    AppRole appRole = AppRole.valueOf(roleName);
    Role role = roleRepository.findByRoleName(appRole).orElseThrow(()-> new RuntimeException("Role not found."));
    user.setRole(role);
    userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public UserDTO getUserById(Long id){
        User user = userRepository.findById(id).orElseThrow();
        return convertToDto(user);
    }

    private UserDTO convertToDto(User user) {
        return new UserDTO(
                user.getUserId(),
                user.getUserName(),
                user.getEmail(),
                user.isAccountNonLocked(),
                user.isAccountNonExpired(),
                user.isCredentialsNonExpired(),
                user.isEnabled(),
                user.getCredentialsExpiryDate(),
                user.getAccountExpiryDate(),
                user.getTwoFactorSecret(),
                user.isTwoFactorEnabled(),
                user.getSignUpMethod(),
                user.getRole(),
                user.getCreatedDate(),
                user.getUpdatedDate()
        );
    }
}
