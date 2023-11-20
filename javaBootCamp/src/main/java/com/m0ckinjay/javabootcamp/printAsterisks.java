/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp;

/**
 *
 * @author mo
 */
public class printAsterisks {
    public static void main(String[] args) {
        int[] x = new int[]{1,2,3,2,3,0,5,6,4,3};
        
        for (int i = 0; i < x.length; i++) {
            System.out.printf("%1d: %1d", i, x[i]);
            for(int z = 0; z < x[i]; z++){
                System.out.printf("%s","*");
            }
            System.out.println("");
            
        }
    }
    
}
