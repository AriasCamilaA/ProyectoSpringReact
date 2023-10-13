package com.api.services;

import com.api.models.RolModel;
import com.api.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RolService {
    @Autowired
    private RolRepository rolRepository;
    public RolModel createRol(RolModel rol){
        rol.setEstado(true);
        return rolRepository.save(rol);
    }
    public RolModel getRolById(Integer id){
        Optional<RolModel> optionalRol = rolRepository.findById(id);
        return optionalRol.get();
    }
    public List<RolModel> getAllRoles(){
        return rolRepository.findAll();
    }
    public void deleteRolById(Integer id){
        rolRepository.deleteById(id);
    }

}


