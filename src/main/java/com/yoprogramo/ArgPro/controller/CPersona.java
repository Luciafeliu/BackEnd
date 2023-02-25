package com.yoprogramo.ArgPro.controller;
import com.yoprogramo.ArgPro.entity.Persona;
import com.yoprogramo.ArgPro.security.controller.Mensaje;
import com.yoprogramo.ArgPro.security.dto.DtoPersona;
import com.yoprogramo.ArgPro.service.SPersona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("persona")
@CrossOrigin(origins = "https://luciafeliuportfolio.web.app/")
public class CPersona {
    
    @Autowired
    SPersona persoServ;
    
    @GetMapping("/lista")
    @ResponseBody
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = persoServ.list();
    return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody Persona per){
        persoServ.crearPersona(per);
        return new ResponseEntity(new Mensaje("Persona creada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    @ResponseBody
    public ResponseEntity<Persona> getById(@PathVariable("id")int id){
        if (!persoServ.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.BAD_REQUEST);
        }
        Persona per = persoServ.getOne(id).get();
        return new ResponseEntity(per, HttpStatus.OK);
    } 
    
    
    @PostMapping("/editar/{id}")
    public ResponseEntity<?> update(@RequestBody Persona per) {
            persoServ.editPersona(per);
            return new ResponseEntity(new Mensaje("¡Persona modificada!"), HttpStatus.OK);
        }
    }
