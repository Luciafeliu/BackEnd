package com.yoprogramo.ArgPro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Habilidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int procentaje;

    
    
    public Habilidad() {
    }
    
    public Habilidad(String nombre, int procentaje) {
        this.nombre = nombre;
        this.procentaje = procentaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getProcentaje() {
        return procentaje;
    }

    public void setProcentaje(int procentaje) {
        this.procentaje = procentaje;
    }
    
}
