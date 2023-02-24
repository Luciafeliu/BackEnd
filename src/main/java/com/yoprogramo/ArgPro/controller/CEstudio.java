package com.yoprogramo.ArgPro.controller;

import com.yoprogramo.ArgPro.entity.Estudio;
import com.yoprogramo.ArgPro.security.controller.Mensaje;
import com.yoprogramo.ArgPro.service.SEstudio;
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
@RequestMapping("estudio")
@CrossOrigin(origins = "http://localhost:4200")
public class CEstudio {
    
    @Autowired
    SEstudio estudioServ;
    
    @GetMapping("/lista")
    @ResponseBody
    public List <Estudio> verEstudios(){
    return estudioServ.verEstudios();
    }
    
    @GetMapping("/ver/{id}")
    @ResponseBody
    public Estudio verEstudios (@PathVariable int id){
    return estudioServ.buscarEstudio(id);
    } 
   
     @GetMapping("/detail/{id}")
    public ResponseEntity<Estudio> getById(@PathVariable("id") int id){
        if(!estudioServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Estudio estudio = estudioServ.getOne(id).get();
        return new ResponseEntity(estudio, HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody Estudio est){
        estudioServ.crearEstudio(est);
        return new ResponseEntity(new Mensaje("Estudio agregado"), HttpStatus.OK);
    }
    
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") int id){
        estudioServ.delete(id);
        return new ResponseEntity(new Mensaje("Estudio eliminado"), HttpStatus.OK);
    }
    
   
    @PostMapping("/editar/{id}")
    public ResponseEntity<?> update(@RequestBody Estudio est) {
            estudioServ.editEducacion(est);
            return new ResponseEntity(new Mensaje("¡Estudio modificado!"), HttpStatus.OK);
        }
    }

    

