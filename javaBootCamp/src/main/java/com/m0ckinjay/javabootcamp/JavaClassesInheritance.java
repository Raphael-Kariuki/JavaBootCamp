/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp;

/**
 *
 * @author mo
 */

abstract class Human{

    public Human(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Human(String name, Integer age, Integer height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
    private String name;
    private Integer age;
    private Integer height;
    public static final int LIFESPAN = 100;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return the height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * @return the LIFESPAN
     */
    public static int getLIFESPAN() {
        return LIFESPAN;
    }
    abstract void printTTL();
  
}

class Musician extends Human{
    String genre;
    String Studio;
    public Musician(String name, Integer age, Integer height, String genre, String Studio) {
        super(name, age, height);
        this.genre = genre;
        this.Studio = Studio;
        
    }
    public Musician(String name, Integer age, Integer height) {
        super(name, age, height);
       
        
    }

    @Override
    void printTTL(){
        System.out.println("Lifespan " + getLIFESPAN());

    }
    
}

class Teacher extends Human{
    String institution;
    String Grade;
    private final static int LIFESPAN = 99;
    
    public Teacher(String name, Integer age, Integer height) {
        super(name, age, height);
    }
    @Override
    void printTTL(){
        System.out.println("I have " + (super.LIFESPAN - getAge()) + " to teach");
        System.out.println("I have " + (LIFESPAN - getAge()) + " to teach");
    }
    
    }
public class JavaClassesInheritance {
    public static void main(String[] args) {
        Musician musician = new Musician("Mojay", 26, 167);
        musician.printTTL();
        Teacher teacher = new Teacher("Mojay", 25, 168);
        teacher.printTTL();
    }
    
}
