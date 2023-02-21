package com.yoprogramo.ArgPro.repository;

import com.yoprogramo.ArgPro.entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RPersona extends JpaRepository <Persona, Integer>{
    Optional<Persona> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
