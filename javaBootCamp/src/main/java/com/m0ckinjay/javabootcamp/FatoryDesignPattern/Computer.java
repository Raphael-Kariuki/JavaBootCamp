/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp.FatoryDesignPattern;

/**
 *
 * @author mo
 */
public abstract class Computer {
    public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();
    
    
    @Override
    public String toString(){
        return "RAM = "+this.getRAM()+", HDD = "+this.getHDD()+" ,CPU = " +this.getCPU();
    }

}
