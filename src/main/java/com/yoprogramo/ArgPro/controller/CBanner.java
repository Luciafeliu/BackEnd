package com.yoprogramo.ArgPro.controller;

import com.yoprogramo.ArgPro.entity.Banner;
import com.yoprogramo.ArgPro.security.controller.Mensaje;
import com.yoprogramo.ArgPro.service.SBanner;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("banner")
@CrossOrigin(origins = "http://localhost:4200")
public class CBanner {
    @Autowired
    SBanner bannerServ;
    
    @GetMapping("/lista")
    @ResponseBody
    public List <Banner> verBanners(){
    return bannerServ.verBanners();
    }
    
    @GetMapping("/ver/{id}")
    @ResponseBody
    public Banner verBanners (@PathVariable int id){
    return bannerServ.buscarBanner(id);
    } 
   
     @GetMapping("/detail/{id}")
    public ResponseEntity<Banner> getById(@PathVariable("id") int id){
        if(!bannerServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Banner banner = bannerServ.getOne(id).get();
        return new ResponseEntity(banner, HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody Banner banner){
        bannerServ.crearBanner(banner);
        return new ResponseEntity(new Mensaje("Banner agregado"), HttpStatus.OK);
    }
    
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") int id){
        bannerServ.delete(id);
        return new ResponseEntity(new Mensaje("Banner eliminado"), HttpStatus.OK);
    }
    
   
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable ("id") int it, @RequestBody Banner banner){
        banner.setImagen(banner.getImagen());
        return new ResponseEntity(new Mensaje("Banner modificado"), HttpStatus.OK);
    }
    
    
}
