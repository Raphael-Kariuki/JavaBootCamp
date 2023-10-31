/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp;

/**
 *
 * @author mo
 */

enum Professionals{
    DEVELOPER(0,"Dev"),
    SYSTEM_ADMIN(1,"Sys_admin"),
    NETWORK_ENGINEER(2,"Net");
    
    
    private Integer index;
    private String slangString;

    public Integer getIndex() {
        return index;
    }

    public String getSlangString() {
        return slangString;
    }

    private Professionals(Integer index, String slangString) {
        this.index = index;
        this.slangString = slangString;
    }
    
    
}
interface  intPrinter{
    String printOut(String nom,String Functionality);
    
}

@FunctionalInterface
interface  intPrinterr{
    String printOut(String nom,String Functionality);
    
}
class personalDetails implements intPrinter{

    @Override
    public String printOut(String nom, String Functionality) {
        return nom + " is a " + Functionality;
    }
    
    

}
public class FunctionalInterfaces {
    public static void main(String[] args) {
        personalDetails pDetails = new personalDetails();
        System.out.println(pDetails.printOut("Mojay", "Java developer"));
        
        
        //Lambda expression in use
        intPrinterr printerr = ((nom, Functionality) -> nom + " is a " + Functionality);
        System.out.println(printerr.printOut("Mo", Professionals.DEVELOPER.getSlangString()));
    }
}
