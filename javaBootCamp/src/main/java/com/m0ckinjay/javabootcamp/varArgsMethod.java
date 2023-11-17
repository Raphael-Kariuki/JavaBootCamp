/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp;

/**
 *
 * @author mo
 */
public class varArgsMethod {
   
    public static void main(String[] args) {
        int[] nombres = new int[]{1,2,3,4,5};
        printNumbers(nombres);
    }
    /*
    varArgsMethod(Variable-length of arguments method denoted by ellipsis i.e 3 dots allows
    passing of a variable number of arguments to a method. Treated as an array)
    */
    
    //In the below example the method receives args which are then printed out.
    static void printNumbers(int... numbers){
        for(int x: numbers){
            System.out.println(x);
        }
    }
    
}
