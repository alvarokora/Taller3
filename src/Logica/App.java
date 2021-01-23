/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.*;
import java.util.*;

/**
 *
 * @author defGrupo()
 */
public class App {
    
    public static boolean readCities(SystemHealthCentre System){
        try{
            File arch = new File("cities.txt");
            Scanner s = new Scanner(arch);
            while(s.hasNextLine()){
                String line = s.nextLine();
                Scanner s1 = new Scanner(line);
                s1.useDelimiter(",");
                String name = s1.next();
                String hospital = s1.next();
                String[] lista = line.split(",");
                String[] clinic = new String[lista.length-2];
                for(int i=0;i<clinic.length;i++){
                    clinic[i]=s.next();
                }
                System.addCity(name, hospital, clinic);
            }
            s.close();
            return true;
        }catch(FileNotFoundException ex){
            return false;
        }
    }
    
    public static boolean readPersons(SystemHealthCentre System){
        try{
            File arch = new File("persons.txt");
            Scanner s = new Scanner(arch);
            while(s.hasNextLine()){
                String line = s.nextLine();
                Scanner s1 = new Scanner(line);
                s1.useDelimiter(",");
                String name = s1.next();
                String surname = s1.next();
                String ID = s1.next();
                String city = s1.next();
                String affiliation = s1.next();
                String entry = s1.next();
                String exit = s1.next();
            }
            s.close();
            return true;
        }catch(FileNotFoundException ex){
            return false;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SystemHealthCentre System = new SystemHealthCentreImpl();
    }
    
}