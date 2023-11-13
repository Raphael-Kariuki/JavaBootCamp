/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp;

/**
 *
 * @author mo
 */
    class Box<T> {
        private T height, width;

    

        public T getHeight() {
            return height;
        }

        public T getWidth() {
            return width;
        }
        public void setHeight(T height) {
            this.height = height;
        }

        public void setWidth(T width) {
            this.width = width;
        }



    }
public class Generics1 {
    

    
    public static void main(String[] args) {
        Box<Integer> uno = new Box<>();
        
        uno.setHeight(3);
        int height = uno.getHeight();
        System.out.println("Height: " + height);
        
        Box<String> deux = new Box<>();
        deux.setWidth("5 cm");
        String width = deux.getWidth();
        System.out.println("Width: " + width);

        
    }
}
