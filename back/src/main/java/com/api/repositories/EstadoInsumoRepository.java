package com.api.repositories;

import com.api.models.EstadoInsumoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoInsumoRepository extends JpaRepository<EstadoInsumoModel, Integer> {
}
