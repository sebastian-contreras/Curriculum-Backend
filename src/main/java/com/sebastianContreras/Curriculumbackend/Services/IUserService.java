/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sebastianContreras.Curriculumbackend.Services;

import com.sebastianContreras.Curriculumbackend.Model.User;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author root
 */
public interface IUserService {
    public List<User> getUsers();
    public User getUser(int id);

    public User findUser(long id);
    public void saveUser(User per);
}
