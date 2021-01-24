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
        HealthCentre hospital = new Hospital(Hospital,"",0,0,0);
        c.getListHealthCentre().addHealthCentre(hospital);
        for (String Clinic1 : Clinic) {
            HealthCentre clinic = new Clinic(0,Clinic1,"",0,0,0);
            c.getListHealthCentre().addHealthCentre(clinic);
        }
        return listCity.add(c);
    }

    /**
     * add the 'Hospital' data and sort in his respective array
     * @param Name
     * @param Adress
     * @param Assessment
     * @param Capacity
     * @param Area
     * @return
     */
    @Override
    public boolean addHospital(String Name, String Adress, double Assessment, int Capacity, double Area) {
        HealthCentre hospital = new Hospital(Name,Adress,Assessment,Capacity,Area);
        listHealthCentre.addHealthCentre(hospital);
        return true;
    }

    /**
     * add the 'Clinic' data and sort in his respective array
     * @param Name
     * @param Adress
     * @param Assessment
     * @param Capacity
     * @param Area
     * @return
     */
    @Override
    public boolean addClinic(String Name, String Adress, double Assessment, int Capacity, double Area, int Quantity) {
        HealthCentre clinic = new Clinic(Quantity,Name,Adress,Assessment,Capacity,Area);
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
            healthCentre = new Clinic(0,HealthCentre,"",0,0,0);
        if(partes[0].equalsIgnoreCase("Hospital"))
            healthCentre = new Hospital(HealthCentre,"",0,0,0);
        People person = new People(Name,Surname,ID,city,Affiliation,healthCentre,Entry,Exit);
        return listPeople.add(person);
    }

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
    public String loginNewPatient(String Name, String Surname, String ID, String City, boolean Affiliation, String HealthCentre, Date Entry, Date Exit, double waitTime) {
        City city = new City(City);
        String[] partes = HealthCentre.split(" ");
        HealthCentre healthCentre = null;
        if(partes[0].equalsIgnoreCase("Clínica"))
            healthCentre = new Clinic(0,HealthCentre,"",0,0,0);
        if(partes[0].equalsIgnoreCase("Hospital"))
            healthCentre = new Hospital(HealthCentre,"",0,0,0);
        People person = new People(Name,Surname,ID,city,Affiliation,healthCentre,Entry,Exit);
        listPeople.add(person);
        double cost = 0;
        if(listHealthCentre.searchHealthCentre(HealthCentre) instanceof Hospital){
            double days = (double) Entry.getTime() - Exit.getTime();
            if(Affiliation){
                cost = (7000*listHealthCentre.searchHealthCentre(HealthCentre).getAssassment()*days)/waitTime; 
            }else{
                cost = (2000*listHealthCentre.searchHealthCentre(HealthCentre).getAssassment()*days)/waitTime;
            }
        }else if(listHealthCentre.searchHealthCentre(HealthCentre) instanceof Clinic){
            double days = (double) Entry.getTime() - Exit.getTime();
            if(Affiliation){
                Clinic c = (Clinic) listHealthCentre.searchHealthCentre(HealthCentre);
                cost = (10000*listHealthCentre.searchHealthCentre(HealthCentre).getAssassment()*days)/c.getQuantity();
            }else{
                Clinic c = (Clinic) listHealthCentre.searchHealthCentre(HealthCentre);
                cost = (5000*listHealthCentre.searchHealthCentre(HealthCentre).getAssassment()*days)/c.getQuantity();
            }
        }
        return "The cost of the control is: "+cost;
    }
    
    /**
     * ask for a date range and return each patient attended in that range of time
     * @param Entry
     * @param Exit
     * @return
     */
    @Override
    public String centerInformation(Date Entry, Date Exit) {
        String r = "";
        int contClinic = 1;
        int contHospital = 1;
        for(int j=0;j<listHealthCentre.size();j++){
            if(listHealthCentre.getHealthCentreI(j) instanceof Hospital){
                r+="Hospital "+contHospital+"\n";
                int cont = 0;
                for(int i=0;i<listPeople.size();i++){
                    if(listPeople.get(i).getHealthCentre() instanceof Hospital){
                        if((listPeople.get(i).getEntry().before(Exit) && listPeople.get(i).getEntry().after(Entry)) && (listPeople.get(i).getExit().after(Entry) && listPeople.get(i).getExit().before(Exit))){
                            cont++;
                        }
                    }
                }
                r+="Patients treated in this range: "+cont+"\n";
                contHospital++;
            }else if(listHealthCentre.getHealthCentreI(j) instanceof Clinic){
                r+="Clinic "+contClinic+"\n";
                int cont = 0;
                for(int i=0;i<listPeople.size();i++){
                    if(listPeople.get(i).getHealthCentre() instanceof Clinic){
                        if((listPeople.get(i).getEntry().before(Exit) && listPeople.get(i).getEntry().after(Entry)) && (listPeople.get(i).getExit().after(Entry) && listPeople.get(i).getExit().before(Exit))){
                            cont++;
                        }
                    }
                }
                r+="Patients treated in this range: "+cont+"\n";
                contClinic++;
            }
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
