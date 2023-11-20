/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp;

import java.security.SecureRandom;

/**
 *
 * @author mo
 */
public class pollAnalysisWithException {
    public static void main(String[] args) {
        
        //to generate random values between 0 and 10
        SecureRandom secureRandom = new SecureRandom();
        
        //declare arrays to use
        int[] pollResults = new int[12];
        int[] frequency = new int[10];
        
        //add values to frequency array less the last index
        for (int i = 0; i < pollResults.length - 2; i++) {
            pollResults[i] = secureRandom.nextInt(10);
        }
        
        //add value that should throw an exception
        pollResults[pollResults.length - 1] = 14;
        

        //increment frequency array based on pollresult values catching error
        try {
            for (int i = 0; i < pollResults.length; i++) {
                ++frequency[pollResults[i]];
        }    
        } catch (Exception e) {
            System.out.println("" + e);
        }
        for (int i = 0; i < frequency.length; i++) {
            System.out.printf("%3d" , i);
        }
                        System.out.println("");

        for (int i : frequency) {
            System.out.printf("%3d" , i);
        }
                System.out.println("");

        for (int pollResult : pollResults) {
            System.out.printf("%3d" , pollResult);
        }
        
    }
    
}
