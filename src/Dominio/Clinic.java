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

    private int quantity;

    public Clinic(int quantity, String Name, String Adress, double Assassment, int Capacity, double Area) {
        super(Name, Adress, Assassment, Capacity, Area);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}