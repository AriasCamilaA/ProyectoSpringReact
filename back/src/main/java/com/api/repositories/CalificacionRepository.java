package com.api.repositories;

import com.api.models.CalificacionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalificacionRepository extends JpaRepository<CalificacionModel, Integer> {


}
