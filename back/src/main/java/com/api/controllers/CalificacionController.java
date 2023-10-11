package com.api.controllers;

import com.api.models.CalificacionModel;
import com.api.services.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.concurrent.CompletableToListenableFutureAdapter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/calificaciones")
public class CalificacionController {
    @Autowired
    private CalificacionService calificacionService;

    @PostMapping
    public CalificacionModel createCalificacion(@RequestBody CalificacionModel calificacion){
        return calificacionService.createCalificacion(calificacion);
    }

    @GetMapping("/{id}")
    public CalificacionModel getCalificacionById(@PathVariable Integer id){
        return calificacionService.getCalificacionById(id);
    }

    @GetMapping
    public List<CalificacionModel> getAllCalificaciones(){
        return calificacionService.getAllCalificaciones();
    }

    @DeleteMapping("/{id}")
    private void deleteCalificacionById(@PathVariable Integer id){
        calificacionService.deleteCalificacionById(id);
    }


}
