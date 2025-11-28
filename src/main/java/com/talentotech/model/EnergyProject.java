package com.talentotech.model;

import java.time.LocalDate;

public class EnergyProject {
    private int project_id;
    private int community_id;
    private String tipo_proyecto;
    private double capacidad_MW;
    private LocalDate fecha_lanzamiento;
    private String estado;

    // Constructor vacío
    public EnergyProject () {}

    // Constructor completo
    public EnergyProject(int project_id, int community_id, String tipo_proyecto, double capacidad_MW, String estado, LocalDate fecha_lanzamiento) {
        this.project_id = project_id;
        this.community_id = community_id;
        this.tipo_proyecto = tipo_proyecto;
        this.capacidad_MW = capacidad_MW;
        this.estado = estado;
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    // Getters y Setters
    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(int community_id) {
        this.community_id = community_id;
    }

    public String getTipo_proyecto() {
        return tipo_proyecto;
    }

    public void setTipo_proyecto(String tipo_proyecto) {
        this.tipo_proyecto = tipo_proyecto;
    }

    public double getCapacidad_MW() {
        return capacidad_MW;
    }

    public void setCapacidad_MW(double capacidad_MW) {
        this.capacidad_MW = capacidad_MW;
    }

    public LocalDate getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }

    public void setFecha_lanzamiento(LocalDate fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "EnergyProject{" +
                "project_id=" + project_id +
                ", community_id=" + community_id +
                ", tipo_proyecto='" + tipo_proyecto + '\'' +
                ", capacidad_MW=" + capacidad_MW +
                ", fecha_lanzamiento=" + fecha_lanzamiento +
                ", estado='" + estado + '\'' +
                '}';
    }
}
