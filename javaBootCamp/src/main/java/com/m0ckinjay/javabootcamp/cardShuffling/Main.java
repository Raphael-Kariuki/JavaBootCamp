/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp.cardShuffling;

import java.security.SecureRandom;

/**
 *
 * @author mo
 */
public class Main {
    static void shuffle(DeckOfCards deckOfCards){
        
        //get array of cards
        var cardsToShuffle = deckOfCards.deckOfCards;
        
        SecureRandom secureRandom = new SecureRandom();
        
        for (int i = 0; i < cardsToShuffle.length - 1; i++) {
            
            //get a random number of card to shutffle among the 52(0-51)
            int randomCard = secureRandom.nextInt(51);

            //shuffle - switch places
            Card temp = cardsToShuffle[randomCard];
            cardsToShuffle[randomCard] = cardsToShuffle[i + 1];
            cardsToShuffle[i + 1] = temp;
        }
    
    }
    public static void main(String[] args) {
        
        DeckOfCards deckOfCards = new DeckOfCards();
        shuffle(deckOfCards);

        for (Card card : deckOfCards.deckOfCards) {
            System.out.println("" + card.getCard());
        }
        
       
        
       
      
    }
    
}
