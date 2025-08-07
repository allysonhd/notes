package com.allysonprojects.notes.repositories;
import com.allysonprojects.notes.models.AppRole;
import com.allysonprojects.notes.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}
