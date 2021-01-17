/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author defGrupo()
 */
public class City {
    
    private String Name;
    private HealthCentre healthCentre;

    public City(String Name, HealthCentre healthCentre) {
        this.Name = Name;
        this.healthCentre = healthCentre;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public HealthCentre getHealthCentre() {
        return healthCentre;
    }

    public void setHealthCentre(HealthCentre healthCentre) {
        this.healthCentre = healthCentre;
    }
    
}