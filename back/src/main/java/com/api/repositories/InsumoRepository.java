package com.api.repositories;

import com.api.models.InsumoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsumoRepository extends JpaRepository<InsumoModel, Integer> {
}
