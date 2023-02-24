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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("persona")
@CrossOrigin(origins = "http://localhost:4200")
public class CPersona {
    
    @Autowired
    SPersona persoServ;
    
    @GetMapping("/lista")
    @ResponseBody
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = persoServ.list();
    return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/ver/{id}")
    @ResponseBody
    public ResponseEntity<Persona> getById(@PathVariable("id")int id){
        if (!persoServ.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.BAD_REQUEST);
        }
        Persona per = persoServ.getOne(id).get();
        return new ResponseEntity(per, HttpStatus.OK);
    } 
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody DtoPersona dtopersona){
        if(!persoServ.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        if(!persoServ.existsByNombre(dtopersona.getNombre()) && persoServ.getByNombre(dtopersona.getNombre()).get().getId() != id){ 
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
            Persona persona = persoServ.getOne(id).get();
            
            persona.setNombre(dtopersona.getNombre());
            persona.setApellido(dtopersona.getApellido());
            persona.setDescripcion(dtopersona.getDescripcion());
            persona.setOcupacion(dtopersona.getOcupacion());
            persona.setImagen(dtopersona.getImagen());
            
            persoServ.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona modificada"), HttpStatus.OK);
    }
    
}
