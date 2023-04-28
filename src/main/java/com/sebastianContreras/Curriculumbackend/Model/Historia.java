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
@Getter @Setter
@Entity
public class Historia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int idusuario;
    private String title;
    private String place;
    private String date;
    private String image;
    private boolean tipo;

    public Historia() {
    }
    
}
//"id": 1,
//      "idUsuario": 1,
//      "title": "Backend Developers",
//      "place": "Globant - Jornada Parcial",
//      "date": "2014-2020",
//      "image": "./assets/images/trabajos/globant.png",
//      "tipo": false