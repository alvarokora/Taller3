/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Date;

/**
 *
 * @author defGrupo()
 */
public interface SystemHealthCentre {
    
    public boolean addCity(String Name, String Hospital, String[] Clinic);
    public boolean addHospital(String Name, String Adress,double Assessment, int Capacity, double Area);
    public boolean addClinic(String Name, String Adress,double Assessment, int Capacity, double Area, int Quantity);
    public boolean addPerson(String Name, String Surname, String ID, String City, boolean Affiliation, String HealthCentre, Date Entry, Date Exit);
    public String loginNewPatient(String Name, String Surname, String ID, String City, boolean Affiliation, String HealthCentre, Date Entry, Date Exit, double waitTime);
    public String centerInformation(Date Entry, Date Exit);
    public String cost();
    public String areaInformation();
    public String bestEvaluated();
    public void writeCity();
    public void writePerson();
    public void writeCentre();
    
}