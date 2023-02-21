package com.yoprogramo.ArgPro.repository;

import com.yoprogramo.ArgPro.entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyecto extends JpaRepository <Proyecto, Integer> {
    Optional<Proyecto> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
