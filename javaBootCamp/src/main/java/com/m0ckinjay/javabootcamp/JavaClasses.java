/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp;

/**
 *
 * @author mo
 */
public class JavaClasses {
    private String name;
    private String packaged;
    private int length;
    private int age;
    private static final int LIFESPAN = 100;

    public JavaClasses(String name, String packaged, int length, int age) {
        this.name = name;
        this.packaged = packaged;
        this.length = length;
        this.age = age;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

//    /**
//     * @param name the name to set
//     */
//    public void setName(String name) {
//        this.name = name;
//    }

    /**
     * @return the packaged
     */
    public String getPackaged() {
        return packaged;
    }

//    /**
//     * @param packaged the packaged to set
//     */
//    public void setPackaged(String packaged) {
//        this.packaged = packaged;
//    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

//    /**
//     * @param length the length to set
//     */
//    public void setLength(int length) {
//        this.length = length;
//    }

    /**
     * @return the LIFESPAN
     */
    public static int getLIFESPAN() {
        return LIFESPAN;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

//    /**
//     * @param age the age to set
//     */
//    public void setAge(int age) {
//        this.age = age;
//    }
    
    public int computeTTL(Integer a, Integer b){
        this.age = a;
        this.length = b;
        
        int ttl  = LIFESPAN - (age * length);
        return ttl;
    }
    
    public int computeTTL(){
     
        
        int ttl  = LIFESPAN - age;
        return ttl;
    }


    
    
    
    
    public static void main(String[] args) {
        JavaClasses javaClasses = new JavaClasses("JavaClass", null, 1, 26);
        
//        int age = javaClasses.getAge();
//        int length = javaClasses.getLength();
//        String name = javaClasses.getName();
//        String packaged = javaClasses.getPackaged();
//
//        
//        System.out.println("Age " + age + " Length " + length);
        System.out.println(javaClasses.getName());
        System.out.println(javaClasses.getPackaged());
        System.out.println(javaClasses.getLength());
        System.out.println(javaClasses.getLIFESPAN());
        int ttl = javaClasses.computeTTL(12,23);

        int ttl2 = javaClasses.computeTTL();
        System.out.println("TTL " + ttl +" or " + ttl2);
        
    }
    
   
    
}
