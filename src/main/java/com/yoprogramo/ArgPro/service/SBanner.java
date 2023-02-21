package com.yoprogramo.ArgPro.service;

import com.yoprogramo.ArgPro.entity.Banner;
import com.yoprogramo.ArgPro.repository.RBanner;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SBanner {
    
    @Autowired
    public RBanner bannerRepo;
    
    public List<Banner> verBanners(){
    List<Banner> listaBanners= bannerRepo.findAll();
    return listaBanners;
    }
    
    public Optional<Banner> getOne(int id) {
    return bannerRepo.findById(id);
    }
    
    public Optional<Banner> getByNombre(String imagen) {
    return bannerRepo.findByImagen(imagen);
    }
    
     public Banner buscarBanner(int id) { 
        Banner banner = bannerRepo.findById(id).orElse(null);
        return banner;
    }
    
    public void crearBanner(Banner banner){
    bannerRepo.save(banner);
    }
   
    
    public void delete (int id){
    bannerRepo.deleteById(id);
    }

   public void save (Banner banner){
   bannerRepo.save(banner);
   }
   
   public boolean existsById(int id){
    return bannerRepo.existsById(id);
   }
}
