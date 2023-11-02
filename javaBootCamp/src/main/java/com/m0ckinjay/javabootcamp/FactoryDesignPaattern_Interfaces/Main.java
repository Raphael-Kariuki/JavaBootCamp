/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp.FactoryDesignPaattern_Interfaces;

/**
 *
 * @author mo
 */

interface Computer{
    String getRAM();
    String getHDD();
    String getCPU();
    String printSpecs();
    
    default String printSpecsString(){
        return "RAM = "+this.getRAM()+", HDD = "+this.getHDD()+" ,CPU = " +this.getCPU();
    }
}

class PC implements Computer{
    private String ram;
    private String hdd;
    private String cpu;

    public PC(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public String getCPU() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    @Override
    public String getRAM() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    @Override
    public String getHDD() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    @Override
    public String printSpecs() {
        return "PC RAM = "+this.getRAM()+", HDD = "+this.getHDD()+" ,CPU = " +this.getCPU();
    }
    
    
}
class Server implements Computer{
    private String ram;
    private String hdd;
    private String cpu;

    public Server(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public String getCPU() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    @Override
    public String getRAM() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    @Override
    public String getHDD() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }
      @Override
    public String printSpecs() {
        return "Server RAM = "+this.getRAM()+", HDD = "+this.getHDD()+" ,CPU = " +this.getCPU();
    }
    
}

interface ProductFactory{
    Computer createProduct(String type,String ram, String hdd, String cpu);
}
class Factory implements ProductFactory{

    @Override
    public Computer createProduct(String type,String ram, String hdd, String cpu) {
        if ("PC".equalsIgnoreCase(type)) {
            return new PC(ram,hdd,cpu);
        } else if("Server".equalsIgnoreCase(type)) {
            return new Server(ram, hdd, cpu);
            
        }else return null;
    }

  

    

}
public class Main {
    public static void main(String[] args) {
        Computer computer1 = new Factory().createProduct("pc","4gb", "500gb", "2.4Ghz");
        Computer computer2 = new Factory().createProduct("server","64gb", "5000gb", "3.4Ghz");
        System.out.println("Factory PC Config " + computer1.printSpecsString());
        System.out.println("Factory Server Config " + computer2.printSpecs());
    }
    
}
