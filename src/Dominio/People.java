/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.Date;

/**
 *
 * @author defGrupo()
 */
public class People {
    
    private String Name;
    private String LastName;
    private String ID;
    private City city;
    private boolean Affiliation;
    private Date Entry;
    private Date Exit;

    public People(String Name, String LastName, String ID, City city, boolean Affiliation, Date Entry, Date Exit) {
        this.Name = Name;
        this.LastName = LastName;
        this.ID = ID;
        this.city = city;
        this.Affiliation = Affiliation;
        this.Entry = Entry;
        this.Exit = Exit;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public boolean isAffiliation() {
        return Affiliation;
    }

    public void setAffiliation(boolean Affiliation) {
        this.Affiliation = Affiliation;
    }

    public Date getEntry() {
        return Entry;
    }

    public void setEntry(Date Entry) {
        this.Entry = Entry;
    }

    public Date getExit() {
        return Exit;
    }

    public void setExit(Date Exit) {
        this.Exit = Exit;
    }
    
}