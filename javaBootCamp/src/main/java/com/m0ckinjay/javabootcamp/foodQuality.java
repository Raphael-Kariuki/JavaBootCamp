/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp;

/**
 *
 * @author mo
 */
public class foodQuality {
    public static void main(String[] args) {
        int[] foodQualityVotes = new int[]{1,2,2,1,3,4,2,3,4,5,3,2};
        int[] frequency = new int[6];
        
        for (int foodQualityVote : foodQualityVotes) {
            ++frequency[foodQualityVote];
        }

        for (int i = 1; i < frequency.length;i++) {
            System.out.printf("%2d: %2d%n", i, frequency[i]);
        }
                }
    
}
