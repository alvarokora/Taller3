/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dominio.HealthCentre;

/**
 *
 * @author defGrupo()
 */
public class ListHealthCentre {
    
    private NodeHealthCentre last;
    
    public ListHealthCentre(){
        last = null;
    }

    public NodeHealthCentre getLast() {
        return last;
    }

    public void setLast(NodeHealthCentre last) {
        this.last = last;
    }
    
    public void addHealthCentre(HealthCentre healthCentre){
        NodeHealthCentre node = new NodeHealthCentre(healthCentre);
        if(last==null){
            last=node;
            last.setLast(node);
            last.setNext(node);
        }else{
            node.setNext(node.getNext());
            node.setLast(last);
            last.getNext().setLast(node);
            last.setNext(node);
        }
    }
    
    public HealthCentre searchHealthCentre(String Name){
        if(last!=null){
            NodeHealthCentre current =  last.getNext();
            do{
                if(!current.getHealthCentre().getName().equalsIgnoreCase(Name))
                    current = current.getNext();
                else
                    break;
            }while(current!=last.getNext());
            if(current==last.getNext())
                return null;
            else
                return current.getHealthCentre();
        }else
            return null;
    }
    
    public int size(){
        int c = 0;
        NodeHealthCentre current = last;
        while(last!=null){
            last=last.getNext();
            c++;
        }
        return c;
    }
    
    public HealthCentre getHealthCentreI(int i){
        if(last!=null){
            if(i>0){
                int c = 1;
                NodeHealthCentre current = last;
                while((current.getNext()!=last)&&(c<i)){
                    c++;
                    current=current.getNext();
                }
                if(c==1){
                    if(current.getNext()==last)
                        return null;
                    else
                        return current.getLast().getHealthCentre();
                }else
                    return current.getLast().getHealthCentre();
            }
        }
        return null;
    }
    
}