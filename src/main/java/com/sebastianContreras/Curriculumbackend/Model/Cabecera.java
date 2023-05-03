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
    private String github;
    private String instagram;
    private String linkedin;

    public Cabecera() {
    }

    public Cabecera(int idusuario, String name,String email) {
        this.id = idusuario;
        this.fullname = name;
        this.email = email;
        this.aboutMe = "¡Hola! Me llamo [nombre] y me describo como una persona [adjetivo] y [adjetivo]. Me considero [otro adjetivo] y [otro adjetivo], siempre estoy buscando nuevas formas de crecer y aprender en mi vida personal y profesional.\n";
        this.shortEducation = "Educacion Principal";
        this.portraitImage = "https://get.wallhere.com/photo/soft-gradient-gradient-solid-color-1537839.jpg";
        this.image = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png";
        this.github="https://github.com";
        this.instagram="https://instagram.com";
        this.linkedin="https://linkedin.com";
    }

    public Cabecera(int idusuario, String aboutMe, String shortEducation, String image, String portraitImage) {
        this.id = idusuario;
        this.aboutMe = aboutMe;
        this.shortEducation = shortEducation;
        this.image = image;
        this.portraitImage = portraitImage;
    }

    public Cabecera(int id, String fullname, String aboutMe, String shortEducation, String image, String email, String portraitImage, String github, String instagram, String linkedin) {
        this.id = id;
        this.fullname = fullname;
        this.aboutMe = aboutMe;
        this.shortEducation = shortEducation;
        this.image = image;
        this.email = email;
        this.portraitImage = portraitImage;
        this.github = github;
        this.instagram = instagram;
        this.linkedin = linkedin;
    }

}
