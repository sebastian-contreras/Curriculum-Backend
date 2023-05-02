/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebastianContreras.Curriculumbackend.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author root
 */
@Getter
@Setter
@Entity
public class Cabecera {

    @Id
    private int id;
    private String fullname;
    private String aboutMe;
    private String shortEducation;
    private String image;
    private String email;

    private String portraitImage;

    public Cabecera() {
    }

    public Cabecera(int idusuario, String name,String email) {
        this.id = idusuario;
        this.fullname = name;
        this.email = email;
        this.aboutMe = "¡Hola! Me llamo [nombre] y me describo como una persona [adjetivo] y [adjetivo]. Me considero [otro adjetivo] y [otro adjetivo], siempre estoy buscando nuevas formas de crecer y aprender en mi vida personal y profesional.\n";
        this.shortEducation = "Educacion Principal";
        this.portraitImage = "https://i.pinimg.com/originals/95/d4/e8/95d4e875591284d16207c238b11906eb.jpg";
        this.image = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png";
    }

    public Cabecera(int idusuario, String aboutMe, String shortEducation, String image, String portraitImage) {
        this.id = idusuario;
        this.aboutMe = aboutMe;
        this.shortEducation = shortEducation;
        this.image = image;
        this.portraitImage = portraitImage;
    }

}
