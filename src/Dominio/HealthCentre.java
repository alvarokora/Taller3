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
public abstract class HealthCentre {
    
    private String Name;
    private String Adress;
    private int Capacity;
    private double Area;
    private double Cost;

    public HealthCentre(String Name, String Adress, int Capacity, double Area) {
        this.Name = Name;
        this.Adress = Adress;
        this.Capacity = Capacity;
        this.Area = Area;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int Capacity) {
        this.Capacity = Capacity;
    }

    public double getArea() {
        return Area;
    }

    public void setArea(double Area) {
        this.Area = Area;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double Cost) {
        this.Cost = Cost;
    }

    public abstract double calculateCost();
    
}