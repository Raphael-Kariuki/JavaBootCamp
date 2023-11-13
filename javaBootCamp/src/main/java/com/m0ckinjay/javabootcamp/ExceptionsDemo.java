/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mo
 */

// Define the Performer interface
interface Performer {
    String getName();
    void perform();
}

// Performer implementation
class Actor implements Performer {
    private String name;

    public Actor(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void perform() {
        System.out.println(name + " is performing on stage.");
    }
}

// PerformerGenerator class
class PerformerGenerator {
    public static Performer get(String name) throws CustomExceptions{
        return new Actor(name);
    }
}

public class ExceptionsDemo {
    public static void main(String[] args) {
        // Using PerformerGenerator to create a Performer object
        
        Performer p;
        try {
            p = PerformerGenerator.get("John");
            
            // Performer's attributes and behavior
            System.out.println("Performer's name: " + p.getName());
            p.perform();
        } catch (CustomExceptions ex) {
            Logger.getLogger(ExceptionsDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

