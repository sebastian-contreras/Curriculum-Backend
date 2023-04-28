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
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int idusuario;
    private String title;
    private String text;
    private String url;
//     {
//      "id": 1,
//      "idusuario": 1,
//      "title": "Bsase sde datos de Sistema de salud orientada a Covid-19",
//      "text": "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Saepe maiores cum blanditiis cupiditate adipisci suscipit minima obcaecati dolores, voluptate numquam accusamus architecto incidunt quas fuga quidem modi eum quod. Debitis!",
//      "url": "https://www.github.com"
//    },
}
