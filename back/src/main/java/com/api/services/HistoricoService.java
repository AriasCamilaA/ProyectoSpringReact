package com.api.services;

import com.api.models.HistoricoModel;
import com.api.repositories.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class HistoricoService {
    @Autowired
    public HistoricoRepository historicoRepository;

    public HistoricoModel createHistorico(HistoricoModel historico){
        historico.setEstado(true);
        return historicoRepository.save(historico);
    }

    public HistoricoModel getHistoricoById(Integer id){
        Optional<HistoricoModel> optionalHistoricoModel = historicoRepository.findById(id);
        return optionalHistoricoModel.get();
    }

    public List<HistoricoModel> getAllHistoricos(){
        return historicoRepository.findAll();
    }

    public void deleteHistoricoById(Integer id){
        historicoRepository.deleteById(id);
    }
}
