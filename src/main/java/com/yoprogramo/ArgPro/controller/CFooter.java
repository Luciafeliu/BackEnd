package com.yoprogramo.ArgPro.controller;

import com.yoprogramo.ArgPro.entity.Footer;
import com.yoprogramo.ArgPro.service.SFooter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("footer")
@CrossOrigin(origins = {"https://luciafeliuportfolio.web.app/","http://localhost:4200/"})
public class CFooter {
    
    @Autowired
    SFooter footerServ;
    
    @GetMapping("/lista")
    @ResponseBody
    public List <Footer> verFooters(){
    return footerServ.verFooters();
    }
   
  @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String editarFooterr (@RequestBody Footer footr){
        footerServ.editarFooter(footr);
        return "El footer se ha actualizado correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String eliminarFooter(@PathVariable int id){
        footerServ.borrarFooter(id);
        return "El footer ha sido eliminado correctamente";
    }
    
    
    
}
