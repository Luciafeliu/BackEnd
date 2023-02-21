package com.yoprogramo.ArgPro.security.repository;

import com.yoprogramo.ArgPro.security.entity.Rol;
import com.yoprogramo.ArgPro.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
