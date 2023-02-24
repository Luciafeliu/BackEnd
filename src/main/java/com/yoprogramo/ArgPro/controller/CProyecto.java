package com.yoprogramo.ArgPro.controller;

import com.yoprogramo.ArgPro.entity.Proyecto;
import com.yoprogramo.ArgPro.security.controller.Mensaje;
import com.yoprogramo.ArgPro.service.SProyecto;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class CProyecto {
    
    @Autowired
    SProyecto proyectoServ;
    
    @GetMapping("/lista")
    @ResponseBody
    public List <Proyecto> verProyectos(){
    return proyectoServ.verProyectos();
    }
    
    @GetMapping("/ver/{id}")
    @ResponseBody
    public Proyecto verProyectos (@PathVariable int id){
    return proyectoServ.buscarProyecto(id);
    } 
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody Proyecto pro){
        proyectoServ.crearProyecto(pro);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);
    }
    
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") int id){
        proyectoServ.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!proyectoServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = proyectoServ.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @PostMapping("/editar/{id}")
    public ResponseEntity<?> update(@RequestBody Proyecto proy) {
            proyectoServ.editProyecto(proy);
            return new ResponseEntity(new Mensaje("¡Proyecto modificado!"), HttpStatus.OK);
        }
    }
    
    
