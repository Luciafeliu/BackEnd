package com.yoprogramo.ArgPro.repository;

import com.yoprogramo.ArgPro.entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository <Experiencia, Integer>{
    public Optional<Experiencia> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
}
