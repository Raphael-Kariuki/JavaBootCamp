/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.linkedin.learning.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author mo
 */
public class SalutationRequest implements Serializable{

    private String salutation;

  
    private static final Long serialVersionUID = -345739573904573L;
    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    @Override
    public String toString() {
        return "SalutationRequest{" + "salutation=" + salutation + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.salutation);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SalutationRequest other = (SalutationRequest) obj;
        return Objects.equals(this.salutation, other.salutation);
    }
    
    

}
