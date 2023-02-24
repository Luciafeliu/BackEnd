package com.yoprogramo.ArgPro.service;
import com.yoprogramo.ArgPro.entity.Persona;
import com.yoprogramo.ArgPro.repository.RPersona;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SPersona {
    
    @Autowired
    RPersona persoRepo;
    
    
    public List<Persona> list(){
    List<Persona> listaPersonas= persoRepo.findAll();
    return listaPersonas;
    }
    
     public Persona buscarPersona(int id) { 
        Persona perso = persoRepo.findById(id).orElse(null);
        return perso;
    }
    
     public Optional<Persona> getOne(int id) {
    return persoRepo.findById(id);
    }
    
    public Optional<Persona> getByNombre(String nombre) {
    return persoRepo.findByNombre(nombre);
    }
   
     public void delete (int id){
    persoRepo.deleteById(id);
    }

   public void save (Persona perso){
   persoRepo.save(perso);
   }
   
   public boolean existsById(int id){
    return persoRepo.existsById(id);
   }
   
   public boolean existsByNombre(String nombre){
       return persoRepo.existsByNombre(nombre);
   }
    
    public void crearPersona(Persona perso){
    persoRepo.save(perso);
    }
    
     public void editPersona(Persona per) {
        persoRepo.save(per);
   }
    
    public void borrarPersona (int id){
    persoRepo.deleteById(id);
    }

   
}
