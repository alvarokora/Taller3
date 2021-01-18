/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.HealthCentre;

/**
 *
 * @author Alvaro Mora
 */
public class NodeHealthCentre {
    
    private HealthCentre healthCentre;
    private NodeHealthCentre next;
    private NodeHealthCentre last;
    
    public NodeHealthCentre(HealthCentre healthCentre){
        this.healthCentre=healthCentre;
        next = null;
        last = null;
    }

    public HealthCentre getHealthCentre() {
        return healthCentre;
    }

    public void setHealthCentre(HealthCentre healthCentre) {
        this.healthCentre = healthCentre;
    }

    public NodeHealthCentre getNext() {
        return next;
    }

    public void setNext(NodeHealthCentre next) {
        this.next = next;
    }

    public NodeHealthCentre getLast() {
        return last;
    }

    public void setLast(NodeHealthCentre last) {
        this.last = last;
    }
    
}