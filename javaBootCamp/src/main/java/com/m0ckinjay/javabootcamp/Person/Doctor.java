/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp.Person;

/**
 *
 * @author mo
 */
public class Doctor extends Person{
    private Integer age;
    private Integer height;
    private Gender gender;
    private Profession profession;
    private String MedicalSchool;
    private String Specialization;

    public Doctor(Integer age, Integer height, String MedicalSchool, String Specialization) {
        super(age, height);
     
        this.MedicalSchool = MedicalSchool;
        this.Specialization = Specialization;
    }
    
  


    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public Integer getHeight() {
        return height;
    }


    
    public String getMedicalSchool() {
        return MedicalSchool;
    }

    public String getSpecialization() {
        return Specialization;
    }

    @Override
    public String describePerson() {
        return "As a " + Profession.Doctor + " I studied at " + getMedicalSchool() + getAge() + " of age";
    }
    
    
    
}
