/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebastianContreras.Curriculumbackend.Controller;

import com.sebastianContreras.Curriculumbackend.Model.Proyecto;
import com.sebastianContreras.Curriculumbackend.Services.IProyectoService;
import com.sebastianContreras.Curriculumbackend.config.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
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
    @Autowired
    private JwtService jwtService;

    @GetMapping("/proyects/{id}")
    public List<Proyecto> getProyectos(@PathVariable int id) {
        List<Proyecto> encontrados = interProyecto.getProyectos(id);
        return encontrados;
    }

    @PostMapping("/proyects")
    public String saveProyecto(@NonNull HttpServletRequest request, @RequestBody Proyecto newProyecto) {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        jwt = authHeader.substring(7);
        Integer idToken;
        idToken = (Integer) jwtService.extractAllClaims(jwt).get("idUsuario");
        if (idToken != newProyecto.getIdusuario()) {
            return "No puede realizar esta accion";
        }
        interProyecto.saveProyecto(newProyecto);
        return "Agregado Proyecto";
    }

    @DeleteMapping("/proyects/{id}")
    public String deleteProyecto(@NonNull HttpServletRequest request, @PathVariable int id) {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        jwt = authHeader.substring(7);
        Integer idToken;
        idToken = (Integer) jwtService.extractAllClaims(jwt).get("idUsuario");
        if (idToken != interProyecto.getProyecto(id).getIdusuario()) {
            return "No puede realizar esta accion";
        }
        interProyecto.deleteProyecto(id);
        return "Borrado Correctamente";
    }

    @PutMapping("/proyects/{id}")
    public String editProyecto(@NonNull HttpServletRequest request, @PathVariable int id, @RequestBody Proyecto editProyecto) {
        Proyecto encontrado = interProyecto.getProyecto(id);
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        jwt = authHeader.substring(7);
        Integer idToken;
        idToken = (Integer) jwtService.extractAllClaims(jwt).get("idUsuario");
        if (idToken != encontrado.getIdusuario()) {
            return "No puede realizar esta accion";
        }

        if (encontrado != null) {
            interProyecto.saveProyecto(editProyecto);
            return "Modificado Correctamente";
        }
        return "No se encontro proyecto";
    }
}
