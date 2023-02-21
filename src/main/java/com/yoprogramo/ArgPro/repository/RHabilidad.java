package com.yoprogramo.ArgPro.repository;

import com.yoprogramo.ArgPro.entity.Habilidad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RHabilidad extends JpaRepository <Habilidad, Integer>{
   Optional<Habilidad> findByNombre(String nombre);
   public boolean existsByNombre(String nombre);
}
