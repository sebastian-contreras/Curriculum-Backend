/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebastianContreras.Curriculumbackend.Controller;

import com.sebastianContreras.Curriculumbackend.Model.Proyecto;
import com.sebastianContreras.Curriculumbackend.Services.IProyectoService;
import java.util.List;
import org.h2.util.json.JSONObject;
import org.h2.util.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author root
 */
@RestController
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT})
public class proyectosController {
    @Autowired
    private IProyectoService interProyecto;
    
    @GetMapping("/proyects/{id}")
    public List<Proyecto> getProyectos(@PathVariable int id){
        List<Proyecto> encontrados = interProyecto.getProyectos(id);
        return encontrados;
    }
    @PostMapping("/proyects")
    public String saveProyecto(@RequestBody Proyecto newProyecto){
        interProyecto.saveProyecto(newProyecto);
        return "Agregado Proyecto";
    }
    @DeleteMapping("/proyects/{id}")
    public String deleteProyecto(@PathVariable int id){
        interProyecto.deleteProyecto(id);
        return "Borrado Correctamente";
    }
    @PutMapping("/proyects/{id}")
    public String editProyecto(@PathVariable int id, @RequestBody Proyecto editProyecto){
        Proyecto encontrado = interProyecto.getProyecto(id);
        if(encontrado != null){
            interProyecto.saveProyecto(editProyecto);
            return "Modificado Correctamente";
        }
        return "No se encontro proyecto";
    }
}
