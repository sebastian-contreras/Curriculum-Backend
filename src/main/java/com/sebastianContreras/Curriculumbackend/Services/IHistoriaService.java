/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebastianContreras.Curriculumbackend.Services;

import com.sebastianContreras.Curriculumbackend.Model.Historia;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author root
 */
public interface IHistoriaService {

    public List<Historia> getHistorias(int idUser);

    public Historia getHistoria(int id);

    public void saveHistoria(Historia newHistoria);

    public void deleteHistoria(int id);
}
