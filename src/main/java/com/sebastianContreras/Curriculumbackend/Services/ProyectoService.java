/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebastianContreras.Curriculumbackend.Services;

import com.sebastianContreras.Curriculumbackend.Model.Proyecto;
import com.sebastianContreras.Curriculumbackend.Repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class ProyectoService implements IProyectoService{
    @Autowired
    private ProyectoRepository proyectoRepository;
    @Override
    public List<Proyecto> getProyectos(int idUser) {
        List<Proyecto> encontrados = proyectoRepository.findByIdusuario(idUser);
        return encontrados;
    }

    @Override
    public Proyecto getProyecto(int id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProyecto(Proyecto newProyecto) {
        proyectoRepository.save(newProyecto);
    }

    @Override
    public void deleteProyecto(int id) {
        proyectoRepository.deleteById(id);
    }
    
}
