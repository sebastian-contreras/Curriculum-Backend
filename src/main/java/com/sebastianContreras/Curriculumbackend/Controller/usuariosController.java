/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebastianContreras.Curriculumbackend.Controller;

import com.sebastianContreras.Curriculumbackend.Model.User;
import com.sebastianContreras.Curriculumbackend.Services.UserService;
import com.sebastianContreras.Curriculumbackend.config.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author root
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class usuariosController {

    String origen = "";
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsuarios() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUsuarios(@PathVariable int id) {
        return userService.getUser(id);
    }

    @PostMapping("/users")
    public String createUser(@NonNull HttpServletRequest request, @RequestBody User newUsuario) {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        jwt = authHeader.substring(7);
        Integer idToken;
        idToken = (Integer) jwtService.extractAllClaims(jwt).get("idUsuario");
        if (idToken != newUsuario.getId()) {
            return "No puede realizar esta accion";
        }
        userService.saveUser(newUsuario);
        return "Usuario Creado";
    }

    @PutMapping("/users/{id}")
    public String editUser(@NonNull HttpServletRequest request, @PathVariable int id,
            @RequestBody User editUsuario) {
        User userFound = userService.findUser(id);
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        jwt = authHeader.substring(7);
        Integer idToken;
        idToken = (Integer) jwtService.extractAllClaims(jwt).get("idUsuario");
        if (idToken != userFound.getId()) {
            return "No puede realizar esta accion";
        }
        if (userFound != null) {
            userFound.setAboutMe(editUsuario.getAboutMe());
            userService.saveUser(userFound);
            return "Edicion Correcta";
        }
        return "No se escontro usuario";
    }
}
