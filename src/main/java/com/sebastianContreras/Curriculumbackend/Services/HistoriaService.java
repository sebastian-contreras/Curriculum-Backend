/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebastianContreras.Curriculumbackend.Services;

import com.sebastianContreras.Curriculumbackend.Model.Historia;
import com.sebastianContreras.Curriculumbackend.Repository.HistoriaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class HistoriaService implements IHistoriaService{
    @Autowired
    private HistoriaRepository historiaRepository;
    
    @Override
    public List<Historia> getHistorias(int idUser) {
        List<Historia> historias = historiaRepository.findByIdusuario(idUser);
                return historias;
    }

    @Override
    public void saveHistoria(Historia newHistoria) {
        historiaRepository.save(newHistoria);
    }

    @Override
    public void deleteHistoria(int id) {
        historiaRepository.deleteById(id);
    }

    @Override
    public Historia getHistoria(int id) {
        Historia historia = historiaRepository.findById(id).orElse(null);
        return historia;
    }
    
}
