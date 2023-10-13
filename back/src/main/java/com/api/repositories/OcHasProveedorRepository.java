package com.api.repositories;

import com.api.models.OcHasProveedorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcHasProveedorRepository extends JpaRepository<OcHasProveedorModel, Integer> {
}