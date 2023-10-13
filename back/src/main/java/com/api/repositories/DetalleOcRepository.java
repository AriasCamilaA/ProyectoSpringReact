package com.api.repositories;

import com.api.models.DetalleOcModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleOcRepository extends JpaRepository<DetalleOcModel, Integer> {
}