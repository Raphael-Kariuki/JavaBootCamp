/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp.cardShuffling;

/**
 *
 * @author mo
 */
public class Card {
    private String face;
    private String symbol;

    public Card(String face, String symbol) {
        this.face = face;
        this.symbol = symbol;
    }
    
    public String getCard(){
        return face + " of "+ symbol;
    }
    
}
