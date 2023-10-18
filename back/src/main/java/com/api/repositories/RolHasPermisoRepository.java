package com.api.repositories;

import com.api.models.RolHasPermisoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolHasPermisoRepository extends JpaRepository<RolHasPermisoModel, Integer> {
}
