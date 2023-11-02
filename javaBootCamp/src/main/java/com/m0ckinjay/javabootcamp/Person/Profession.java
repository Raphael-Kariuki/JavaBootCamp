/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.m0ckinjay.javabootcamp.Person;

/**
 *
 * @author mo
 */
public enum Profession {
    Developer(0,"Dev"), Network_Engineer(1,"NetAdmin"), System_Administrator(2,"Sysadmin"),Doctor(3,"Doc");
    
    private final int index;
    private final String slangString;

    private Profession(int index, String slangString) {
        this.index = index;
        this.slangString = slangString;
    }

    public int getIndex() {
        return index;
    }

    public String getSlangString() {
        return slangString;
    }
}
