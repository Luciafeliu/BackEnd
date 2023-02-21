package com.yoprogramo.ArgPro.repository;

import com.yoprogramo.ArgPro.entity.Banner;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RBanner extends JpaRepository<Banner, Integer>{
    public Optional<Banner> findByImagen(String imagen);
    public boolean existsByImagen(String imagen);
}
