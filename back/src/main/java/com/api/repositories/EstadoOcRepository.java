package com.api.repositories;

import com.api.models.EstadoOcModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoOcRepository extends JpaRepository<EstadoOcModel, Integer> {
}
