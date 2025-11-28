package com.talentotech.model;

public class Household {
    private int householdId;
    private int communityId;
    private String direccion;
    private int numResidentes;
    private String nivelSocioeco;

    public Household() {}

    public Household(int householdId, int communityId, String direccion,
                     int numResidentes, String nivelSocioeco) {
        this.householdId = householdId;
        this.communityId = communityId;
        this.direccion = direccion;
        this.numResidentes = numResidentes;
        this.nivelSocioeco = nivelSocioeco;
    }

    public int getHouseholdId() { return householdId; }
    public void setHouseholdId(int householdId) { this.householdId = householdId; }

    public int getCommunityId() { return communityId; }
    public void setCommunityId(int communityId) { this.communityId = communityId; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public int getNumResidentes() { return numResidentes; }
    public void setNumResidentes(int numResidentes) { this.numResidentes = numResidentes; }

    public String getNivelSocioeco() { return nivelSocioeco; }
    public void setNivelSocioeco(String nivelSocioeco) { this.nivelSocioeco = nivelSocioeco; }

    @Override
    public String toString() {
        return "Household{id=" + householdId + ", dir='" + direccion + "'}";
    }
}