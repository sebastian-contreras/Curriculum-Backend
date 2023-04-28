/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebastianContreras.Curriculumbackend.Services;

import com.sebastianContreras.Curriculumbackend.Model.Skill;
import com.sebastianContreras.Curriculumbackend.Repository.SkillsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service
public class SkillService implements ISkillService{
    @Autowired
    private SkillsRepository skillRepository;
    @Override
    public List<Skill> getSkills(int idUser) {
        List<Skill> encontradas = skillRepository.findByIdusuario(idUser);
                return encontradas;
    }

    @Override
    public Skill getSkill(int id) {
        return skillRepository.findById(id).orElse(null);
    }

    @Override
    public void saveSkill(Skill newSkill) {
        skillRepository.save(newSkill);
    }

    @Override
    public void deleteSkill(int id) {
        skillRepository.deleteById(id);
    }
    
}
