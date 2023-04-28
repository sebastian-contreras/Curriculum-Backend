/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebastianContreras.Curriculumbackend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author root
 */
@Getter @Setter @Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int idusuario;
    private String title;
    private int percent;

    public Skill() {
    }

    public Skill(int idUsuario, String title, int porcentaje) {
        this.idusuario = idUsuario;
        this.title = title;
        this.percent = porcentaje;
    }
    

    public Skill(int id, int idUsuario, String title, int porcentaje) {
        this.id = id;
        this.idusuario = idUsuario;
        this.title = title;
        this.percent = porcentaje;
    }
}
//"id": 1,
//      "idUsuario": 1,
//      "title": "HTML",
//      "percent": 70
