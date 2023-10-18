package com.api.repositories;

import com.api.models.SaborHasProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaborHasProductoRepository extends JpaRepository<SaborHasProductoModel, Integer> {
}
