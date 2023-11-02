/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp.FatoryDesignPattern;

/**
 *
 * @author mo
 */
public class TestFactory {
    public static void main(String[] args) {
        Computer Computer1 = ComputerFactory.getComputer("pc", "4GB", "500GB", "2.4GHz");
        Computer Computer2 = ComputerFactory.getComputer("server", "64GB", "500TB", "2.4GHz");
        
        System.out.println("PC Factory config "+Computer1);
        System.out.println("Server Factory config "+Computer2);
    }
}
