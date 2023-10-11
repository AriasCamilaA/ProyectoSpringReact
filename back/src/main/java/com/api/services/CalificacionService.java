package com.api.services;

import com.api.models.CalificacionModel;
import com.api.repositories.CalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CalificacionService {
    @Autowired
    private CalificacionRepository calificacionRepository;
    public CalificacionModel createCalificacion(CalificacionModel calificacion){
        return calificacionRepository.save(calificacion);
    }
    public CalificacionModel getCalificacionById(Integer id){
        Optional<CalificacionModel> optionalCalificacion = calificacionRepository.findById(id);
        return optionalCalificacion.get();
    }
    public List<CalificacionModel> getAllCalificaciones(){
        return calificacionRepository.findAll();
    }
    public void deleteCalificacionById(Integer id){
        calificacionRepository.deleteById(id);
    }

}

