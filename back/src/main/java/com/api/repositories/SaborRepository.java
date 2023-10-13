package com.api.repositories;

import com.api.models.SaborModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaborRepository extends JpaRepository<SaborModel, Integer> {
}