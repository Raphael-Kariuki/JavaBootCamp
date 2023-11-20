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
    static int [] generatepollArray(){
                
        //to generate random values between 0 and 10
        SecureRandom secureRandom = new SecureRandom();
        
        //declare arrays to use
        int[] pollResults = new int[12];
        
        //add values to frequency array less the last index
        for (int i = 0; i < pollResults.length - 2; i++) {
            pollResults[i] = secureRandom.nextInt(10);
        }
        
        //add value that should throw an exception
        pollResults[pollResults.length - 1] = secureRandom.nextInt(10,20);
        
        return pollResults;
    
    }
    
    static int[] returnPollAnalysisArray(int [] x){
         //declare arrays to use
        int[] frequency = new int[10];

        //increment frequency array based on pollresult values catching error
        try {
            for (int i = 0; i < x.length; i++) {
                ++frequency[x[i]];
        }    
        } catch (Exception e) {
            System.out.println("" + e);
        }
        return frequency;
    } 
    public static void main(String[] args) {

        
       int[] pollResults = returnPollAnalysisArray(generatepollArray());
        for (int i = 0; i < pollResults.length; i++) {
            System.out.printf("%3d" , i);
        }
                        System.out.println("");

        for (int i : pollResults) {
            System.out.printf("%3d" , i);
        }
                System.out.println("");

        for (int pollResult : generatepollArray()) {
            System.out.printf("%3d" , pollResult);
        }
        
    }
    
}
