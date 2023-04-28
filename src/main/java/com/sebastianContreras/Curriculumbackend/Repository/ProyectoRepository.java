/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sebastianContreras.Curriculumbackend.Repository;

import com.sebastianContreras.Curriculumbackend.Model.Proyecto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author root
 */
@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {

    List<Proyecto> findByIdusuario(int idUsuario);
}
