package com.yoprogramo.ArgPro.service;

import com.yoprogramo.ArgPro.entity.Experiencia;
import com.yoprogramo.ArgPro.repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class SExperiencia {
    
    @Autowired
    public RExperiencia expRepo;
    
    
    public List<Experiencia> list(){
    return expRepo.findAll();
    }
    
    public Optional<Experiencia> getOne(int id) {
    return expRepo.findById(id);
    }
    
    public Optional<Experiencia> getByNombre(String titulo) {
    return expRepo.findByTitulo(titulo);
    }
    
    public void crearExperiencia(Experiencia exp){
    expRepo.save(exp);
    }
   
    public void editEducacion(Experiencia exp) {
        expRepo.save(exp);
   }
    
    public void delete (int id){
    expRepo.deleteById(id);
    }

   public void save (Experiencia exp){
   expRepo.save(exp);
   }
   
   public boolean existsById(int id){
    return expRepo.existsById(id);
   }
    
}
