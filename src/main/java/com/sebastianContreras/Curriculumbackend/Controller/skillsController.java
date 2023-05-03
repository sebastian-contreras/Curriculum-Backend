/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebastianContreras.Curriculumbackend.Controller;

import com.sebastianContreras.Curriculumbackend.Model.Skill;
import com.sebastianContreras.Curriculumbackend.Services.ISkillService;
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

public class skillsController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ISkillService interSkills;

    @GetMapping("/skills/{id}")
    public List<Skill> getSkill(@PathVariable int id) {
        List<Skill> skillUsuario = interSkills.getSkills(id);
        return skillUsuario;
    }

    @PostMapping("/skills")
    public String saveSkill(@NonNull HttpServletRequest request, @RequestBody Skill newSkill) {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        jwt = authHeader.substring(7);
        Integer idToken;
        idToken = (Integer) jwtService.extractAllClaims(jwt).get("idUsuario");
        if (idToken != newSkill.getIdusuario()) {
            return "No puede realizar esta accion";
        }
        interSkills.saveSkill(newSkill);
        return "Skill creado correctamente";
    }

    @DeleteMapping("/skills/{id}")
    public String deleteSkill(@NonNull HttpServletRequest request, @PathVariable int id) {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        jwt = authHeader.substring(7);
        Integer idToken;
        idToken = (Integer) jwtService.extractAllClaims(jwt).get("idUsuario");
        if (idToken != interSkills.getSkill(id).getIdusuario()) {
            return "No puede realizar esta accion";
        }
        interSkills.deleteSkill(id);
        return "Skill Eliminada correctamente";
    }

    @PutMapping("/skills/{id}")
    public String editSkill(@NonNull HttpServletRequest request, @PathVariable int id, @RequestBody Skill editSkill) {
        Skill encontrada = interSkills.getSkill(id);
         final String authHeader = request.getHeader("Authorization");
        final String jwt;
        jwt = authHeader.substring(7);
        Integer idToken;
        idToken = (Integer) jwtService.extractAllClaims(jwt).get("idUsuario");
        if (idToken != encontrada.getIdusuario()) {
            return "No puede realizar esta accion";
        }
        if (encontrada != null) {
            interSkills.saveSkill(editSkill);
            return "Skill Modificada Correctamente";
        }
        return "No se encontro skill";
    }

}
