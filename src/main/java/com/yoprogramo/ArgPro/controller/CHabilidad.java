package com.yoprogramo.ArgPro.controller;

import com.yoprogramo.ArgPro.entity.Habilidad;
import com.yoprogramo.ArgPro.security.controller.Mensaje;
import com.yoprogramo.ArgPro.service.SHabilidad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("habilidad")
@CrossOrigin(origins = "https://luciafeliuportfolio.web.app/")

public class CHabilidad {
    
    @Autowired
    SHabilidad habilidadServ;
    
    @GetMapping("/lista")
    @ResponseBody
    public List <Habilidad> verHabilidades(){
    return habilidadServ.verHabilidades();
    }
    
    @GetMapping("/ver/{id}")
    @ResponseBody
    public Habilidad verHabilidades (@PathVariable int id){
    return habilidadServ.buscarHabilidad(id);
    } 
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody Habilidad hab){
        habilidadServ.crearHabilidad(hab);
        return new ResponseEntity(new Mensaje("Habilidad creada"), HttpStatus.OK);
    }
    
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") int id){
        habilidadServ.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }
    
   
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable ("id") int it, @RequestBody Habilidad hab){
        hab.setNombre(hab.getNombre());
        hab.setProcentaje(hab.getProcentaje());
        habilidadServ.save(hab);
        return new ResponseEntity(new Mensaje("Habilidad modificada"), HttpStatus.OK);
    }
    
    
    
}
