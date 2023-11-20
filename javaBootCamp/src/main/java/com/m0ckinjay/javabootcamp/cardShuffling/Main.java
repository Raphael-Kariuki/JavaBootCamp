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
    
    public static SecureRandom secureRandom = new SecureRandom();
    protected static  int NUMBER_OF_CARDS = 52;

    static void shuffle(DeckOfCards deckOfCards){
        
        //get array of cards
        var cardsToShuffle = deckOfCards.deckOfCards;
        
        
        for (int i = 0; i < cardsToShuffle.length - 1; i++) {
            
            //get a random number of card to shutffle among the 52(0-51)
            int randomCard = secureRandom.nextInt(51);

            //shuffle - switch places
            Card temp = cardsToShuffle[randomCard];
            cardsToShuffle[randomCard] = cardsToShuffle[i + 1];
            cardsToShuffle[i + 1] = temp;
        }
    
    }
    static Card dealCard(DeckOfCards deckOfCards){
        //decrement the number of cards everytime method is called
        //to simulate decrease of cards on deck on dealing
        --NUMBER_OF_CARDS;
        
        //initialize to allow return
        Card card = null;
        
        //ensure that deck of cards still has cards before dealing
        if (NUMBER_OF_CARDS > 0) {
        //return a random card
            card = deckOfCards.deckOfCards[secureRandom.nextInt(51)];
        }else{
            System.out.println("Out of cards");
        }
        return card;
        
    }
    public static void main(String[] args) {
        
        DeckOfCards deckOfCards = new DeckOfCards();
        
        //shuffle the deck
        shuffle(deckOfCards);
        
        
        //deal 10 cards
        for (int i = 0; i < 10; i++) {
            System.out.println(""+ dealCard(deckOfCards).getCard());

        }
        

       
        
       
      
    }
    
}
