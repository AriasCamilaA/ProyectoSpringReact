package com.api.repositories;

import com.api.models.HistoricoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoRepository extends JpaRepository<HistoricoModel, Integer> {
}
