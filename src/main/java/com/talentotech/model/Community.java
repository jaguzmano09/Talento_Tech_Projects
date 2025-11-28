package com.talentotech.model;

public class Community {
    private int communityId;
    private String nombre;
    private String region;
    private int poblacion;
    private int anyoInicio;
    private double metaEnergiaMW;

    // Constructor vacío
    public Community() {}

    // Constructor completo
    public Community(int communityId, String nombre, String region,
                     int poblacion, int anyoInicio, double metaEnergiaMW) {
        this.communityId = communityId;
        this.nombre = nombre;
        this.region = region;
        this.poblacion = poblacion;
        this.anyoInicio = anyoInicio;
        this.metaEnergiaMW = metaEnergiaMW;
    }

    // Getters y Setters
    public int getCommunityId() { return communityId; }
    public void setCommunityId(int communityId) { this.communityId = communityId; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public int getPoblacion() { return poblacion; }
    public void setPoblacion(int poblacion) { this.poblacion = poblacion; }

    public int getAnyoInicio() { return anyoInicio; }
    public void setAnyoInicio(int anyoInicio) { this.anyoInicio = anyoInicio; }

    public double getMetaEnergiaMW() { return metaEnergiaMW; }
    public void setMetaEnergiaMW(double metaEnergiaMW) { this.metaEnergiaMW = metaEnergiaMW; }

    @Override
    public String toString() {
        return String.format("Community{id=%d, nombre='%s', region='%s'}", communityId, nombre, region);
    }
}