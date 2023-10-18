package com.api.repositories;

import com.api.models.TipoMovimientoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMovimientoRepository extends JpaRepository<TipoMovimientoModel, Integer> {
}
