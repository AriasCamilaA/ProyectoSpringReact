package com.api.services;

import com.api.models.PermisoModel;
import com.api.repositories.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PermisoService {
    @Autowired
    public PermisoRepository permisoRepository;

    public PermisoModel createPermiso(PermisoModel permiso){
        return permisoRepository.save(permiso);
    }

    public PermisoModel getPermisoById(Integer id){
        Optional<PermisoModel> optionalPermiso = permisoRepository.findById(id);
        return optionalPermiso.get();
    }

    public List<PermisoModel> getAllPermisos(){
        return permisoRepository.findAll();
    }

    public void deletePermisoById(Integer id){
        permisoRepository.deleteById(id);
    }
}
