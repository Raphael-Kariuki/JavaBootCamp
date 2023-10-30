/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp;

/**
 *
 * @author mo
 */
class Humanoid {

    private Integer age;
    private Integer height;
    private String name;

    public Humanoid(Integer age, Integer height, String name) {
        this.age = age;
        this.height = height;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

interface Doctor {

    public final static String GREETING = "Dr.";

    public String getSpecialization();

    public void setSpecialization(String specialization);

    public String getMedicalSchool();

    public void setMedicalSchool(String medicalSchool);

}

interface Teacherr {

    public String getCategory();

    public void setCategory(String category);

    public String getTrainingInstitute();

    public void setTrainingInstitute(String trainingInstitute);
    
    default String isGOKEmployed(Boolean gokFlag){
        sharedLogic();
        if (gokFlag) {
            return "Employee of the GOK";
        } else {
            return "Employee of a privatized org";
        }
    }
    
    private String sharedLogic(){
        return "Just a simple example";
    }
}

class Professor extends Humanoid implements Doctor, Teacherr {

    private String category;
    private String trainingInstitute;
    private String medicalSchool;
    private String specialization;

    public Professor(String category, String trainingInstitute, String medicalSchool, String specialization, Integer age, Integer height, String name) {
        super(age, height, name);
        this.category = category;
        this.trainingInstitute = trainingInstitute;
        this.medicalSchool = medicalSchool;
        this.specialization = specialization;
    }

    @Override
    public String getSpecialization() {
        return specialization;
    }

    @Override
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String getMedicalSchool() {
        return medicalSchool;
    }

    @Override
    public void setMedicalSchool(String medicalSchool) {
        this.medicalSchool = medicalSchool;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String getTrainingInstitute() {
        return trainingInstitute;
    }

    @Override
    public void setTrainingInstitute(String trainingInstitute) {
        this.trainingInstitute = trainingInstitute;
    }

}

public class interfacesClass {

    public static void main(String[] args) {
        Professor professor = new Professor("Secondary School", "MTTC", "KMTC", "Paediatric", 56, 167, "Mojay");
        System.out.println(Doctor.GREETING + professor.getName() + " went to Medical School to further in " + professor.getSpecialization() + " and is currently " + professor.isGOKEmployed(true));
    }
}
