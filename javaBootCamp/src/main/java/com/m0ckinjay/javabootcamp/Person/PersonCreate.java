/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp.Person;

/**
 *
 * @author mo
 */
public class PersonCreate {
    public static Person createPerson(Integer age, Integer height,  String MedicalSchool, String Specialization){
        return new Doctor(age,height,MedicalSchool,Specialization);
            }
    
    public static void main(String[] args) {
        Person doctorPerson =  PersonCreate.createPerson(23,167,"KMTC","Paeds");
        Person doctorPerson2 =  PersonCreate.createPerson(23,167,"MMTC","Paeds");
        System.out.println(doctorPerson.describePerson());
        System.out.println(doctorPerson2.describePerson());
        System.out.println(doctorPerson2.getLIFESPAN());
    }
    
}
