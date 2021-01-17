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
public class Clinic extends HealthCentre{

    public Clinic(String Name, String Adress, int Capacity, double Area) {
        super(Name, Adress, Capacity, Area);
    }

    @Override
    public double calculateCost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}