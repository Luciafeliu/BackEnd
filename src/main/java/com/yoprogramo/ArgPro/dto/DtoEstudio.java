package com.yoprogramo.ArgPro.dto;

public class DtoEstudio {
    private String titulo;
    private String institucion;
    private String estado;
    private int inicio;
    private int fin;
    private String descripcion;

    public DtoEstudio() {
    }

    public DtoEstudio(String titulo, String institucion, String estado, int inicio, int fin, String descripcion) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.estado = estado;
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    

}

