package com.yoprogramo.ArgPro.controller;

import com.yoprogramo.ArgPro.entity.Experiencia;
import com.yoprogramo.ArgPro.security.controller.Mensaje;
import com.yoprogramo.ArgPro.service.SExperiencia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("experiencia")
@CrossOrigin(origins = "https://luciafeliuportfolio.web.app/")
public class CExperiencia {
    
    @Autowired
    SExperiencia expServ;
    
    @GetMapping("/lista")
    @ResponseBody
    public List <Experiencia> list(){
    return expServ.list();
    }
    
   
     @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!expServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = expServ.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody Experiencia exp){
        expServ.crearExperiencia(exp);
        return new ResponseEntity(new Mensaje("Experiencia creada"), HttpStatus.OK);
    }
    
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") int id){
        expServ.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
    
   
    @PostMapping("/editar/{id}")
    public ResponseEntity<?> update(@RequestBody Experiencia exp) {
            expServ.editEducacion(exp);
            return new ResponseEntity(new Mensaje("¡Experiencia modificada!"), HttpStatus.OK);
        }
    }
