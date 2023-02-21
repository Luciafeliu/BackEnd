package com.yoprogramo.ArgPro.service;

import com.yoprogramo.ArgPro.entity.Habilidad;
import com.yoprogramo.ArgPro.repository.RHabilidad;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class SHabilidad {
    
    @Autowired
    public RHabilidad habilidadRepo;
    
    public List<Habilidad> verHabilidades(){
    List<Habilidad> listaHabilidad= habilidadRepo.findAll();
    return listaHabilidad;
    }
    
    public Optional<Habilidad> getOne(int id) {
    return habilidadRepo.findById(id);
    }
    
    public Optional<Habilidad> getByNombre(String nombre) {
    return habilidadRepo.findByNombre(nombre);
    }
    
     public Habilidad buscarHabilidad(int id) { 
        Habilidad habilidad = habilidadRepo.findById(id).orElse(null);
        return habilidad;
    }
    
    public void delete (int id){
    habilidadRepo.deleteById(id);
    }

   public void save (Habilidad hab){
   habilidadRepo.save(hab);
   }
   
   public boolean existsById(int id){
    return habilidadRepo.existsById(id);
   }
   
    public void crearHabilidad(Habilidad habilidad){
    habilidadRepo.save(habilidad);
    }
    
    public void borrarHabilidad (int id){
    habilidadRepo.deleteById(id);
    }

    
}
