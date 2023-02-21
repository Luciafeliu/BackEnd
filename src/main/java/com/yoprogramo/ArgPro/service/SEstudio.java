package com.yoprogramo.ArgPro.service;

import com.yoprogramo.ArgPro.entity.Estudio;
import com.yoprogramo.ArgPro.repository.REstudio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEstudio {
    
    
    @Autowired
    public REstudio estudioRepo;
    
    public List<Estudio> verEstudios(){
    List<Estudio> listaEstudios= estudioRepo.findAll();
    return listaEstudios;
    }
    
     public Estudio buscarEstudio(int id) { 
        Estudio est = estudioRepo.findById(id).orElse(null);
        return est;
    }
    
     public boolean existsById(int id){
    return estudioRepo.existsById(id);
   }
    
     public Optional<Estudio> getOne(int id) {
    return estudioRepo.findById(id);
    }
   
    public void crearEstudio(Estudio est){
    estudioRepo.save(est);
    }
    
    public void save (Estudio exp){
    estudioRepo.save(exp);
   }
    
    public void delete (int id){
    estudioRepo.deleteById(id);
    }

    
}
