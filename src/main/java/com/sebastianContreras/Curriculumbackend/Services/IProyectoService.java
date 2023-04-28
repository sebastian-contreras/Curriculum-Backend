/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sebastianContreras.Curriculumbackend.Services;

import com.sebastianContreras.Curriculumbackend.Model.Proyecto;
import java.util.List;

/**
 *
 * @author root
 */
public interface IProyectoService {

    public List<Proyecto> getProyectos(int idUser);

    public Proyecto getProyecto(int id);

    public void saveProyecto(Proyecto newProyecto);

    public void deleteProyecto(int id);
}
