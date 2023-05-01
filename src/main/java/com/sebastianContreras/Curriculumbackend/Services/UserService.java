/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebastianContreras.Curriculumbackend.Services;

import com.sebastianContreras.Curriculumbackend.Model.User;
import com.sebastianContreras.Curriculumbackend.Repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        List<User> usuarios = userRepository.findAll();
        return usuarios;
    }

    @Override
    public User getUser(int id) {
        User usuario = userRepository.findById(id).orElse(null);
        return usuario;
    }

    public User loadUserbyEmail(String email) {
        User usuario = userRepository.findByEmail(email).orElse(null);
        return usuario;
    }

    @Override
    public User findUser(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void saveUser(User newUsuario) {
        userRepository.save(newUsuario);
    }

}
