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
 * @author defGrupo()
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
    
    /**
     * add the 'City' data and sort in his respective array
     * @param Name
     * @param Hospital
     * @param Clinic
     * @return
     */
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

    /**
     * add the 'Hospital' data and sort in his respective array
     * @param Name
     * @param Adress
     * @param Capacity
     * @param Area
     * @return
     */
    @Override
    public boolean addHospital(String Name, String Adress, int Capacity, double Area) {
        HealthCentre hospital = new Hospital(Name,Adress,Capacity,Area);
        listHealthCentre.addHealthCentre(hospital);
        return true;
    }

    /**
     * add the 'Clinic' data and sort in his respective array
     * @param Name
     * @param Adress
     * @param Capacity
     * @param Area
     * @return
     */
    @Override
    public boolean addClinic(String Name, String Adress, int Capacity, double Area) {
        HealthCentre clinic = new Clinic(Name,Adress,Capacity,Area);
        listHealthCentre.addHealthCentre(clinic);
        return true;
    }

    /**
     * add the 'Person' data and sort in his respective array
     * @param Name
     * @param Surname
     * @param ID
     * @param City
     * @param Affiliation
     * @param HealthCentre
     * @param Entry
     * @param Exit
     * @return
     */
    @Override
    public boolean addPerson(String Name, String Surname, String ID, String City, boolean Affiliation, String HealthCentre, Date Entry, Date Exit) {
        City city = new City(City);
        String[] partes = HealthCentre.split(" ");
        HealthCentre healthCentre = null;
        if(partes[0].equalsIgnoreCase("Clínica"))
            healthCentre = new Clinic(HealthCentre,"",0,0);
        if(partes[0].equalsIgnoreCase("Hospital"))
            healthCentre = new Hospital(HealthCentre,"",0,0);
        People person = new People(Name,Surname,ID,city,Affiliation,healthCentre,Entry,Exit);
        return listPeople.add(person);
    }

    //Falta Hacer Esta Funcion

    /**
     * login with 'person' data and return amount to be paid
     * @param Name
     * @param Surname
     * @param ID
     * @param City
     * @param Affiliation
     * @param HealthCentre
     * @param Entry
     * @param Exit
     * @return
     */
    
    @Override
    public boolean loginNewPatient(String Name, String Surname, String ID, String City, boolean Affiliation, String HealthCentre, Date Entry, Date Exit) {
        City city = new City(City);
        String[] partes = HealthCentre.split(" ");
        HealthCentre healthCentre = null;
        if(partes[0].equalsIgnoreCase("Clínica"))
            healthCentre = new Clinic(HealthCentre,"",0,0);
        if(partes[0].equalsIgnoreCase("Hospital"))
            healthCentre = new Hospital(HealthCentre,"",0,0);
        People person = new People(Name,Surname,ID,city,Affiliation,healthCentre,Entry,Exit);
        return listPeople.add(person);
    }

    //Falta este tambien
    
    /**
     * ask for a date range and return each patient attended in that range of time
     * @param Entry
     * @param Exit
     * @return
     */
    @Override
    public String centerInformation(Date Entry, Date Exit) {
        String r = "";
        for(int j=0;j<listHealthCentre.size();j++){
            
        }
        for(int i=0;i<listPeople.size();i++){
            
        }
        return r;
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
