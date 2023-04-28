/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sebastianContreras.Curriculumbackend.Repository;

import com.sebastianContreras.Curriculumbackend.Model.Historia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author root
 */
@Repository
public interface HistoriaRepository extends JpaRepository<Historia, Integer> {
        List<Historia> findByIdusuario(int idUser);
}
