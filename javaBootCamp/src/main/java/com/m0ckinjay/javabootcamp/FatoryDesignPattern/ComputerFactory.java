/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp.FatoryDesignPattern;


/**
 *
 * @author mo
 */
public class ComputerFactory {
    public static Computer getComputer(String type,String ram, String hdd, String cpu){
        if ("PC".equalsIgnoreCase(type)) {
            return new PC(ram,hdd,cpu);
        } else if("Server".equalsIgnoreCase(type)) {
            return new Server(ram, cpu, hdd);
            
        }else return null;
    
    }
}
