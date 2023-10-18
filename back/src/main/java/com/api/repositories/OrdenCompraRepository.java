package com.api.repositories;

import com.api.models.OrdenCompraModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenCompraRepository extends JpaRepository<OrdenCompraModel, Integer> {
}
