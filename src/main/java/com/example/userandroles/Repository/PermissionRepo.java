package com.example.userandroles.Repository;

import com.example.userandroles.Entities.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepo extends JpaRepository<Permissions,Long> {
}
