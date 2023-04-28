/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sebastianContreras.Curriculumbackend.Services;

import com.sebastianContreras.Curriculumbackend.Model.Skill;
import java.util.List;

/**
 *
 * @author root
 */
public interface ISkillService {

    public List<Skill> getSkills(int idUser);

    public Skill getSkill(int id);

    public void saveSkill(Skill newSkill);

    public void deleteSkill(int id);
}
