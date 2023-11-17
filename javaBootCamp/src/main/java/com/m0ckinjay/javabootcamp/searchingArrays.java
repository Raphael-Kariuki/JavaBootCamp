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

class Pen{
    protected int price;
    protected String color;

    public Pen(int price, String color) {
        this.price = price;
        this.color = color;
    }
}
public class searchingArrays {
    public static void main(String[] args) {
        var numbers = new Integer[]{1,45,242,4664,4,768};
        
        //binarySearch works with ordered/sorted arrays
        Arrays.sort(numbers);
        int index = Arrays.binarySearch(numbers, 4);
        System.out.println("Number 4 at index: " + index);
        
        
        var characters = new char[]{'h','e','l','l','o'};
      
        Arrays.sort(characters);
        int index3 = Arrays.binarySearch(characters, 'e');
        System.out.println("Character \'e\' at pos: " + index3);
        
        Pen pen = new Pen(10, "Black");
        Pen pen1 = new Pen(25, "Blue");
        Pen pen2 = new Pen(20, "Red");
        
        Pen[] pensArray = new Pen[]{pen, pen1, pen2};
        
        //first sort. Though not necessary coz we not using binarySearch
//        Arrays.sort(pensArray, Comparator.comparing(singlePen -> singlePen.price));
        
        for (Pen pen_ : pensArray) {
            switch (pen_.color) {
                case "Black" -> System.out.println("Price of a Black pen is " + pen_.price);
                case "Red" -> System.out.println("Price of a Red pen is " + pen_.price);
                case "Blue" -> System.out.println("Price of a Blue pen is " + pen_.price);
                default -> throw new AssertionError();
            }
        }
        
        
        
    }
    
}
