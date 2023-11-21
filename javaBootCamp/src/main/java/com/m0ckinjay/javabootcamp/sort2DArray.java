/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author mo
 */
class twoDArray{
    
    int[][] twoDArray = new int[10][10];

    public twoDArray(){
        SecureRandom secureRandom = new SecureRandom();
        
        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray[i].length; j++) {
                twoDArray[i][j] = secureRandom.nextInt(100);
            }
        }
    }
    

}
public class sort2DArray {
    public static void main(String[] args) {
       twoDArray tDArray = new twoDArray();
       int[][] x = tDArray.twoDArray;
        System.out.printf("%s%n", "Array before sorting");
        for (int[] is : x) {
            for (int i : is)
                System.out.printf("%3d" , i);
                
            System.out.println("");

        }
        Arrays.sort(x, Comparator.comparingInt(row -> row[1]));
        
        System.out.printf("%s%n", "Array after sorting");
        for (int[] is : x) {
            for (int i : is)
                System.out.printf("%3d" , i);
                
            System.out.println("");

        }
    }
}
