package com.yoprogramo.ArgPro.service;

import com.yoprogramo.ArgPro.entity.Footer;
import com.yoprogramo.ArgPro.repository.RFooter;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SFooter {
    
    @Autowired
    public RFooter footerRepo;
    
     public List<Footer> verFooters(){
    List<Footer> listaFooters= footerRepo.findAll();
    return listaFooters;
    }

   
    public void editarFooter(Footer footr){
    footerRepo.save(footr);
    }
    
    
    
    public void borrarFooter (int id){
    footerRepo.deleteById(id);
    }

    
}
