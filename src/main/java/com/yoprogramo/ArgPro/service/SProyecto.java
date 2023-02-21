package com.yoprogramo.ArgPro.service;

import com.yoprogramo.ArgPro.entity.Proyecto;
import com.yoprogramo.ArgPro.repository.RProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyecto {
    
    @Autowired
    public RProyecto proyectoRepo;
    
    public List<Proyecto> verProyectos(){
    List<Proyecto> listaProyectos= proyectoRepo.findAll();
    return listaProyectos;
    }
    
     public Proyecto buscarProyecto(int id) { 
        Proyecto proy = proyectoRepo.findById(id).orElse(null);
        return proy;
    }
    
    
    public void crearProyecto(Proyecto proy){
    proyectoRepo.save(proy);
    }
    
    public Optional<Proyecto> getOne(int id) {
    return proyectoRepo.findById(id);
    }
    
    public Optional<Proyecto> getByNombre(String nombre) {
    return proyectoRepo.findByNombre(nombre);
    }
    
     public void delete (int id){
    proyectoRepo.deleteById(id);
    }

   public void save (Proyecto pro){
   proyectoRepo.save(pro);
   }
   
   public boolean existsById(int id){
    return proyectoRepo.existsById(id);
   }
    
    public void borrarProyecto (int id){
    proyectoRepo.deleteById(id);
    }

   
    
}
