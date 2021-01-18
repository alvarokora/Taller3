/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Logica.ListHealthCentre;

/**
 *
 * @author defGrupo()
 */
public class City {
    
    private String Name;
    private ListHealthCentre listHealthCentre;

    public City(String Name) {
        this.Name = Name;
        listHealthCentre = new ListHealthCentre();
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public ListHealthCentre getListHealthCentre() {
        return listHealthCentre;
    }

    public void setListhealthCentre(ListHealthCentre listHealthCentre) {
        this.listHealthCentre = listHealthCentre;
    }
    
}