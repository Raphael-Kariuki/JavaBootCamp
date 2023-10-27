/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp;

/**
 *
 * @author mo
 */


enum Day{
    MONDAY(1, 'M'),
    TUESDAY(2, 'T'),
    WEDNESDAY(3, 'W'){
    @Override
    public String getComment(){
        return "Wednesday is special " + getINDEX() + " , "+ getABRV() ;
    }
    };

    private final Integer INDEX;

    public Integer getINDEX() {
        return INDEX;
    }

    public Character getABRV() {
        return ABRV;
    }
    private final Character ABRV;
    
    private Day(Integer index, Character abrv) {
        this.INDEX = index;
        this.ABRV = abrv;
        
        
    }
    public String getComment(){
        return ": " + getINDEX() + " , "+ getABRV() ;
    }
    
    
    
}

public class enumClas {
    public static void main(String[] args) {
        System.out.println("Day today is " + Day.MONDAY.getABRV() + Day.MONDAY.getComment());
        System.out.println("Day today is " + Day.WEDNESDAY.getABRV() + Day.WEDNESDAY.getComment());
    }
}
