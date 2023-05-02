/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebastianContreras.Curriculumbackend.Controller;

import com.sebastianContreras.Curriculumbackend.Model.Cabecera;
import com.sebastianContreras.Curriculumbackend.Services.CabeceraService;
import com.sebastianContreras.Curriculumbackend.config.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author root
 */
@RestController

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class CabeceraController {

    @Autowired
    private JwtService jwtService;


    @Autowired
    private CabeceraService servicio;

    @GetMapping("/users/{id}")
    public Cabecera getCabecera(@PathVariable int id) {
        return servicio.getCabecera(id);
    }

    @PutMapping("/users/{id}")
    public String editCabecera(@NonNull HttpServletRequest request, @PathVariable int id,
            @RequestBody Cabecera editUsuario) {
        Cabecera cabeza = servicio.getCabecera(id);
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        jwt = authHeader.substring(7);
        Integer idToken;
        idToken = (Integer) jwtService.extractAllClaims(jwt).get("idUsuario");
        if (idToken != cabeza.getId()) {
            return "No puede realizar esta accion";
        }
        System.out.println(editUsuario);
        if (cabeza != null) {
            cabeza.setImage(editUsuario.getImage());
            cabeza.setPortraitImage(editUsuario.getPortraitImage());
            cabeza.setShortEducation(editUsuario.getShortEducation());
            cabeza.setAboutMe(editUsuario.getAboutMe());
            servicio.saveCabecera(cabeza);
            return "Edicion Correcta";
        }
        return "No se escontro usuario";
    }
}
