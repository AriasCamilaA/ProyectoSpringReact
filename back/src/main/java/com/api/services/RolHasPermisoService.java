package com.api.services;

import com.api.models.RolHasPermisoModel;
import com.api.repositories.RolHasPermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RolHasPermisoService {
    @Autowired
    public RolHasPermisoRepository rolHasPermisoRepository;

    public RolHasPermisoModel createRolHasPermiso(RolHasPermisoModel rolHasPermiso){
        rolHasPermiso.setEstado(true);
        return rolHasPermisoRepository.save(rolHasPermiso);
    }

    public RolHasPermisoModel getRolHasPermisoById(Integer id){
        Optional<RolHasPermisoModel> optionalRolHasPermiso = rolHasPermisoRepository.findById(id);
        return optionalRolHasPermiso.get();
    }

    public List<RolHasPermisoModel> getAllRolHasPermisos(){
        return rolHasPermisoRepository.findAll();
    }

    public void deleteRolHasPermisoById(Integer id){
        rolHasPermisoRepository.deleteById(id);
    }
}
