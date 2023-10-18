package com.api.controllers;

import com.api.models.HistoricoModel;
import com.api.services.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/historicos")
public class HistoricoController {
    @Autowired
    private HistoricoService historicoService;

    @PostMapping
    public HistoricoModel createHistorico(@RequestBody HistoricoModel historico){
        return historicoService.createHistorico(historico);
    }

    @GetMapping("/{id}")
    public HistoricoModel getHistoricoById(@PathVariable Integer id){
        return historicoService.getHistoricoById(id);
    }

    @GetMapping
    public List<HistoricoModel> getAllHistoricos(){
        return historicoService.getAllHistoricos();
    }

    @DeleteMapping("/{id}")
    private void deleteHistoricoById(@PathVariable Integer id){
        historicoService.deleteHistoricoById(id);
    }
}
