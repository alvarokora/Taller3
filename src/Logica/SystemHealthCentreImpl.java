/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.*;
import java.util.*;

/**
 *
 * @author Alvaro Mora
 */
public class SystemHealthCentreImpl implements SystemHealthCentre {

    private ListHealthCentre listHealthCentre;
    private List<City> listCity;
    private List<People> listPeople;
    
    public SystemHealthCentreImpl(){
        listHealthCentre = new ListHealthCentre();
        listCity = new ArrayList<>();
        listPeople = new LinkedList<>();
    }   
    
    @Override
    public boolean addCity(String Name, String Hospital, String[] Clinic) {
        City c = new City(Name);
        HealthCentre hospital = new Hospital(Hospital,"",0,0);
        c.getListHealthCentre().addHealthCentre(hospital);
        for (String Clinic1 : Clinic) {
            HealthCentre clinic = new Clinic(Clinic1, "", 0, 0);
            c.getListHealthCentre().addHealthCentre(clinic);
        }
        return listCity.add(c);
    }

    @Override
    public boolean addHospital(String Name, String Adress, int Capacity, double Area) {
        HealthCentre hospital = new Hospital(Name,Adress,Capacity,Area);
        listHealthCentre.addHealthCentre(hospital);
        return true;
    }

    @Override
    public boolean addClinic(String Name, String Adress, int Capacity, double Area) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addPerson(String Name, String Surname, String ID, String City, boolean Affiliation, String HealthCentre, Date Entry, Date Exit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean loginNewPatient(String Name, String Surname, String ID, String City, boolean Affiliation, String HealthCentre, Date Entry, Date Exit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String centerInformation(Date Entry, Date Exit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String cost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String areaInformation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String bestEvaluated() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeCity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writePerson() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeCentre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
