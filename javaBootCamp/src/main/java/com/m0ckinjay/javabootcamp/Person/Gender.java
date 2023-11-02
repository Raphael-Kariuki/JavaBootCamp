/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp.Person;

/**
 *
 * @author mo
 */
public enum Gender {
    MALE(0,'M'),FEMALE(1,'F');
    
    private final int index;
    private final int gChar;

    private Gender(int index, int gChar) {
        this.index = index;
        this.gChar = gChar;
    }

    public int getIndex() {
        return index;
    }

    public int getgChar() {
        return gChar;
    }
    
    
}

