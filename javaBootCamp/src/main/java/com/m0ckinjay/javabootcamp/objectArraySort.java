/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author mo
 */
public class objectArraySort {
    static class Smartphone{
        private final int price;
        private final String model;

        public Smartphone(int price, String model) {
            this.price = price;
            this.model = model;
        }
        
        public String printdetails(){
            return model + " costs " + price;
        }

      
        
        
    }
    
    
    public static void main(String[] args) {
        
        //var can be used here as the initialization is of a local variable
        var numbers = new Integer[]{21,43,65,4,23,6};
        System.out.println("Before sort");
        for (Integer number : numbers) {
            System.out.println("" + number);
        }
        Arrays.sort(numbers);
        System.out.println("After sort");
        for (Integer number : numbers) {
            System.out.println("" + number);
        }        

        
        var smartphone = new Smartphone(10000, "zItel");
        var smartphone1 = new Smartphone(12000, "Techno");
        var smartphone2 = new Smartphone(13000, "Samsung");
        
        var phones = new Smartphone[]{smartphone, smartphone1, smartphone2};
        
           
        Arrays.sort(phones, Comparator.comparing(phone -> phone.price));
        
        for(Smartphone singlePhone: phones){
            System.out.println(singlePhone.printdetails());
            }
 
        
    }
}
