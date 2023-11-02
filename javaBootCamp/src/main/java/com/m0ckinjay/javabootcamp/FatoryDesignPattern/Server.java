/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp.FatoryDesignPattern;

/**
 *
 * @author mo
 */
public class Server extends Computer {
    String RAM;
    String CPU;
    String HDD;

    public Server(String RAM, String CPU, String HDD) {
        this.RAM = RAM;
        this.CPU = CPU;
        this.HDD = HDD;
    }
    
    @Override
    public String getRAM() {
        return RAM;
    }

    @Override
    public String getHDD() {
        return HDD;
    }

    @Override
    public String getCPU() {
        return CPU;
    }
    
}
