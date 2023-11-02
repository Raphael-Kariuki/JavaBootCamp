/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp.Person;

/**
 *
 * @author mo
 */
public abstract class Person {
    private static final int LIFESPAN = 100;
    private Integer age;
    private Integer height;
    private Gender gender;
    private Profession profession;

    public Person(Integer age, Integer height) {
        this.age = age;
        this.height = height;
     
    }
    
    

    public int getLIFESPAN(){
        return LIFESPAN;
    };
    public abstract Integer getAge() ;

    public abstract Integer getHeight();

    public abstract String describePerson();
    
}


