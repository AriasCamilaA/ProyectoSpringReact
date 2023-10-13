package com.api.repositories;

import com.api.models.RolModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<RolModel, Integer> {
}
