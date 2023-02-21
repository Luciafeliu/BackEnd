package com.yoprogramo.ArgPro.repository;

import com.yoprogramo.ArgPro.entity.Footer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RFooter extends JpaRepository <Footer, Integer>{
    
}
