/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp.cardShuffling;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mo
 */
public class DeckOfCards {
    String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
                        "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        
    String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
    
    
    /*arrayList to hold the face:suit pair that will be used by the constructor 
    to initialize the deck of cards object*/
    List<String[]> cardFaceSuit = new ArrayList<>();
    
    
    //create the array list
    private List<String[]> getPairStrings(){
        for (String face : faces) {
            for (String suit : suits) {
                String[] pairs = new String[]{face, suit};
                cardFaceSuit.add(pairs);
            }
        }
        return cardFaceSuit;
    }
    
    //initialize the required number of cards
    private final static int NUMBER_OF_CARDS = 52;
    
    //an array to hold the 52 cards
    Card[] deckOfCards = new Card[NUMBER_OF_CARDS];
    
    //constructor creates a deckOfCards object that stores the cards in array
    public DeckOfCards() {
        for (int i = 0; i < NUMBER_OF_CARDS; i++) {
            String face = (getPairStrings().get(i))[0];
            String suit = (getPairStrings().get(i))[1];
            deckOfCards[i] = new Card(face, suit);
            
        }
    }
    
    
    
}
