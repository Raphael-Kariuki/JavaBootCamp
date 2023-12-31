/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp;


/**
 *
 * @author mo
 */

enum Gender{
    MALE(1,'M'), FEMALE(2, 'F');
    
    private final Integer G_INDEX;

    private final Character G_ABRV;
    
    Gender(Integer G_INDEX, Character G_ABRV){
        this.G_INDEX =G_INDEX;
        this.G_ABRV =G_ABRV;
        
    }
  
    public Integer getG_INDEX() {
        return G_INDEX;
    }

    public Character getG_ABRV() {
        return G_ABRV;
    }
    
 
    
}

class Created{
    private final String created = "Yes";

    public String getCreated() {
        return created;
    }
    
}
interface Planet{
    String PLANET = "Earth";
}
interface Galaxy{
    String GALAXY = "Milky way";
}

abstract class Human extends Created implements Planet, Galaxy{

    
    private String name;
    private Integer age;
    private Integer height;
    public static final int LIFESPAN = 100;
    private Gender gender;
    
    
    public Human(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Human(String name, Integer age, Integer height) {
        this(name, age);
        this.height = height;
    }
  


    
    /**
    * @return the gender
    */
    public Gender getGender() {
        return gender;
    }



    /**
     * @return the name
     */
    public String getName() {
        return getName();
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.setName(name);
    }

    /**
     * @return the age
     */
    public Integer getAge() {
        return getAge();
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.setAge(age);
    }

    /**
     * @return the height
     */
    public Integer getHeight() {
        return getHeight();
    }

    /**
     * @param height the height to set
     */
    public void setHeight(Integer height) {
        this.setHeight(height);
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

class Teacher_ extends Human{
    String institution;
    String Grade;
    private final static int LIFESPAN = 99;

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public void setGrade(String Grade) {
        this.Grade = Grade;
    }

    public String getInstitution() {
        return institution;
    }

    public String getGrade() {
        return Grade;
    }

    public static int getLIFESPAN() {
        return LIFESPAN;
    }
   
    
    public Teacher_(String name, Integer age, Integer height) {
        super(name, age, height);
    }
    @Override
    void printTTL(){
        System.out.println("I have " + (Human.LIFESPAN - getAge()) + " to teach");
        System.out.println("I have " + (LIFESPAN - getAge()) + " to teach");
        System.out.println("Gender " + Gender.MALE.getG_ABRV());
    }
    
    }
public class JavaClassesInheritance {
    public static void main(String[] args) {
        Musician musician = new Musician("Mojay", 26, 167);
        musician.printTTL();
        
        Teacher_ teacher = new Teacher_("Mojay", 25, 168);
        teacher.printTTL();
        System.out.println("Created " + teacher.getCreated() + " in planet " + Planet.PLANET + " in the " + Galaxy.GALAXY + " Galaxy" );
    }
    
}
