package com.allysonprojects.notes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.allysonprojects.notes.models.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
