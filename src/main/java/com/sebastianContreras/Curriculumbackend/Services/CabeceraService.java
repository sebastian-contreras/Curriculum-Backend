/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebastianContreras.Curriculumbackend.Services;

import com.sebastianContreras.Curriculumbackend.Model.Cabecera;
import com.sebastianContreras.Curriculumbackend.Repository.CabeceraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class CabeceraService {
    @Autowired
    private CabeceraRepository cabeceraRepository ;
    
    public Cabecera getCabecera(int idUsuario){
        Cabecera encontrada = cabeceraRepository.findById(idUsuario).orElse(null);
        return encontrada;
    }
    public void saveCabecera(Cabecera newcabe){
         cabeceraRepository.save(newcabe);
    }
}
