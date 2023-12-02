/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;

/**
 *
 * @author mo
 */
public class Multi_valuedHashMap {
    public static void main(String[] args) {
        MultiValuedMap<Integer, String> map = new HashSetValuedHashMap<>();
        map.put(1, "name");
        map.put(2, "Time");
        map.put(3, "Date");
        
        System.out.println("" + map.keys());
        System.out.println("" + map.values());
        System.out.println("" + map.get(1));
    }
}
