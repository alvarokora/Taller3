/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.*;
import java.util.*;
import java.text.*;

/**
 *
 * @author defGrupo()
 */
public class App {
    
    public static boolean readCities(SystemHealthCentre system){
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
                system.addCity(name, hospital, clinic);
            }
            s.close();
            return true;
        }catch(FileNotFoundException ex){
            return false;
        }
    }
    
    public static Date parseFecha(String fecha){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try{
            fechaDate = formato.parse(fecha);
        }catch(ParseException ex){
        }
        return fechaDate;
    }
    
    public static boolean readPersons(SystemHealthCentre system){
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
                String healthCentre = s1.next();
                if(affiliation.equalsIgnoreCase("Isapre"))
                    system.addPerson(name, surname, ID, city, true, healthCentre, parseFecha(entry), parseFecha(exit));
                else if(affiliation.equalsIgnoreCase("Fonasa"))
                    system.addPerson(name, surname, ID, city, false, healthCentre, parseFecha(entry), parseFecha(exit));
            }
            s.close();
            return true;
        }catch(FileNotFoundException ex){
            return false;
        }
    }
    
    public static boolean readCentres(SystemHealthCentre system){
        try{
            File arch = new File("centres.txt");
            Scanner s = new Scanner(arch);
            while(s.hasNextLine()){
                String line = s.nextLine();
                Scanner s1 = new Scanner(line);
                s1.useDelimiter(",");
                String name = s1.next();
                String adress = s1.next();
                double assessment = s1.nextDouble();
                String[] lista = name.split(" ");
                if(lista[0].equalsIgnoreCase("Hospital")){
                    double area = s1.nextDouble();
                    system.addHospital(name, adress, assessment, 200, area);
                }else if(lista[0].equalsIgnoreCase("Clínica")){
                    int quantity = s1.nextInt();
                    system.addClinic(name, adress, assessment, 50, 50, quantity);
                }
            }
            s.close();
            return true;
        }catch(FileNotFoundException ex){
            return false;
        }
    }
    
    public static void menu(SystemHealthCentre system){
        System.out.println("-------");
        System.out.println("WELCOME");
        System.out.println("-------");
        Scanner s = new Scanner(System.in);
        if(readCities(system)==false || readPersons(system)==false || readCentres(system)==false){
            System.out.println("!ERROR¡ one of the files doesn't exist");
        }else{
            String option = "";
            while(!option.equalsIgnoreCase("3")){
                System.out.print("(1)Login a new patient\n(2)Administrator's menu\n(3)Close the system\nEnter option: ");
                option = s.next(); 
                while(option.equalsIgnoreCase("1")){
                    System.out.print("Enter a name: ");
                    String name = s.next();
                    System.out.print("Enter a surname: ");
                    String surname = s.next();
                    System.out.print("Enter the ID: ");
                    String ID = s.next();
                    System.out.print("City where his live: ");
                    String city = s.next();
                    System.out.print("Enter afilliation (Isapre/Fonasa): ");
                    String afilliation = s.next();
                    while(!afilliation.equalsIgnoreCase("Isapre") && !afilliation.equalsIgnoreCase("Fonasa")){
                        System.out.print("The afilliation entered is wrong, enter again: ");
                        afilliation = s.next();
                    }
                    System.out.print("Wich health centre are you going to enter? (Clinic/Hospital): ");
                    String healthCentre = s.next();
                    while(!healthCentre.equalsIgnoreCase("Clinic") && !healthCentre.equalsIgnoreCase("Hospital")){
                        System.out.print("The health centre entered is wrong, enter again: ");
                        healthCentre = s.next();
                    }
                    System.out.print("Enter the entry date (dd/MM/yyyy): ");
                    String entry = s.next();
                    System.out.print("Enter the exit date (dd/MM/yyyy): ");
                    String exit = s.next();
                    if(healthCentre.split(" ")[0].equalsIgnoreCase("Hospital")){
                        System.out.print("How long was the waiting time?: ");
                        double waitTime = s.nextDouble();
                        if(afilliation.equalsIgnoreCase("Isapre"))
                            System.out.println(system.loginNewPatient(name, surname, ID, city, true, healthCentre, parseFecha(entry), parseFecha(exit), waitTime));
                        else
                            System.out.println(system.loginNewPatient(name, surname, ID, city, false, healthCentre, parseFecha(entry), parseFecha(exit), waitTime));
                    }else{
                        if(afilliation.equalsIgnoreCase("Isapre"))
                            System.out.println(system.loginNewPatient(name, surname, ID, city, true, healthCentre, parseFecha(entry), parseFecha(exit), 0));
                        else
                            System.out.println(system.loginNewPatient(name, surname, ID, city, false, healthCentre, parseFecha(entry), parseFecha(exit), 0));
                    }
                    System.out.print("Do you want back to the last menu? (yes/no)\nEnter option: ");
                    option = s.next();
                    while(!option.equalsIgnoreCase("yes") && !option.equalsIgnoreCase("no")){
                        System.out.print("Your choise is wrong, enter again (yes/no) : ");
                        option = s.next();
                    }
                    if(option.equalsIgnoreCase("no"))
                        option="1";
                }
                while(option.equalsIgnoreCase("2")){
                    System.out.print("(1)Center Information\n(2)Costs\n(3)Areas Information\n(4)Best Evaluated\n(5)Sign off\nEnter option: ");
                    option = s.next();
                    if(option.equalsIgnoreCase("1")){
                        System.out.print("Enter the entry date (dd/MM/yyyy): ");
                        String entry = s.next();
                        System.out.print("Enter the exit date (dd/MM/yyyy): ");
                        String exit = s.next();
                        System.out.println(system.centerInformation(parseFecha(entry), parseFecha(exit)));
                    }else if(option.equalsIgnoreCase("2")){
                        
                    }else if(option.equalsIgnoreCase("3")){
                        
                    }else if(option.equalsIgnoreCase("4")){
                        
                    }
                }
            }
        }
        System.out.println("---------------------");
        System.out.println("Closing the system...");
        System.out.println("---------------------");
        System.out.println("Thank you for using the system ^^");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SystemHealthCentre System = new SystemHealthCentreImpl();
        menu(System);
    }
    
}