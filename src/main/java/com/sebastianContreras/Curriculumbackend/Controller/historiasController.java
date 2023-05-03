/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebastianContreras.Curriculumbackend.Controller;

import com.sebastianContreras.Curriculumbackend.Model.Historia;
import com.sebastianContreras.Curriculumbackend.Services.IHistoriaService;
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
public class historiasController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IHistoriaService interHistorias;

    @GetMapping("tests")
    public String prueva() {
        return "asdas";
    }

    @GetMapping("/historias/{idusuario}")
    public List<Historia> getHistoriasCon(@PathVariable int idusuario) {
        return interHistorias.getHistorias(idusuario);
    }

    @PostMapping("historias")
    public String newHistoria(@RequestBody Historia newHistorias, @NonNull HttpServletRequest request) {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        jwt = authHeader.substring(7);
        Integer idToken;
        idToken = (Integer) jwtService.extractAllClaims(jwt).get("idUsuario");
                System.out.println(idToken);
                                System.out.println(newHistorias.getIdusuario());


        if (idToken != newHistorias.getIdusuario()){
           return "No puede realizar esta accion";
        }
        interHistorias.saveHistoria(newHistorias);
        return "Historias Creada";
    }

    @PutMapping("historias/{id}")
    public String editHistoria(@NonNull HttpServletRequest request,@PathVariable int id,
            @RequestBody Historia sendHistoria) {
        Historia editHistoria = interHistorias.getHistoria(id);
        editHistoria.setTitle(sendHistoria.getTitle());
        editHistoria.setDate(sendHistoria.getDate());
        editHistoria.setImage(sendHistoria.getImage());
        editHistoria.setPlace(sendHistoria.getPlace());
                final String authHeader = request.getHeader("Authorization");
        final String jwt;
        jwt = authHeader.substring(7);
        Integer idToken;
        idToken = (Integer) jwtService.extractAllClaims(jwt).get("idUsuario");
        if (idToken != editHistoria.getIdusuario()){
           return "No puede realizar esta accion";
        }
        interHistorias.saveHistoria(editHistoria);
        return "Historia Editada";
    }

    @DeleteMapping("historias/{id}")
    public String deleteHistoria(@NonNull HttpServletRequest request,@PathVariable int id) {
         final String authHeader = request.getHeader("Authorization");
        final String jwt;
        jwt = authHeader.substring(7);
        Integer idToken;
        idToken = (Integer) jwtService.extractAllClaims(jwt).get("idUsuario");
        if (idToken != interHistorias.getHistoria(id).getIdusuario()){
           return "No puede realizar esta accion";
        }
        interHistorias.deleteHistoria(id);
        return "Borrado correctamente";
    }
}
