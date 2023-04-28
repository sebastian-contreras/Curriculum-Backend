/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sebastianContreras.Curriculumbackend.Controller;

import com.sebastianContreras.Curriculumbackend.Model.Historia;
import com.sebastianContreras.Curriculumbackend.Services.IHistoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT})
public class historiasController {
    @Autowired
    private IHistoriaService interHistorias;
    
        @GetMapping("tests")
    public String prueva(){
        return "asdas";
    }
    
    @GetMapping("/historias/{idusuario}")
    public List<Historia> getHistoriasCon(@PathVariable int idusuario){
        return interHistorias.getHistorias(idusuario);
    }
    
    @PostMapping("historias")
    public String newHistoria(@RequestBody Historia newHistorias){
        interHistorias.saveHistoria(newHistorias);
        return "Historia Creada";
    }
    @PutMapping("historias/{id}")
    public String editHistoria(@PathVariable int id,
                                @RequestBody Historia sendHistoria){
        Historia editHistoria = interHistorias.getHistoria(id);
        editHistoria.setTitle(sendHistoria.getTitle());
        editHistoria.setDate(sendHistoria.getDate());
        editHistoria.setImage(sendHistoria.getImage());
        editHistoria.setPlace(sendHistoria.getPlace());
        interHistorias.saveHistoria(editHistoria);
        return "Historia Editada";
    }
    @DeleteMapping("historias/{id}")
    public String deleteHistoria(@PathVariable int id){
        interHistorias.deleteHistoria(id);
        return "Borrado correctamente";
    }
}
