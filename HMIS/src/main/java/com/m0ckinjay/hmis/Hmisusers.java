/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.hmis;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author mo
 */
@Entity
@Table(name = "hmisusers")
@NamedQueries({
    @NamedQuery(name = "Hmisusers.findAll", query = "SELECT h FROM Hmisusers h")})
public class Hmisusers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "entryid")
    private Integer entryid;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "emailaddress")
    private String emailaddress;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "registrationdatetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationdatetime;

    public Hmisusers() {
    }

    public Hmisusers(Integer entryid) {
        this.entryid = entryid;
    }

    public Hmisusers(Integer entryid, String username, String firstname,
            String lastname, String emailaddress, String password,
            Date registrationdatetime) {
        this.entryid = entryid;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailaddress = emailaddress;
        this.password = password;
        this.registrationdatetime = registrationdatetime;
    }

    public Integer getEntryid() {
        return entryid;
    }

    public void setEntryid(Integer entryid) {
        this.entryid = entryid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationdatetime() {
        return registrationdatetime;
    }

    public void setRegistrationdatetime(Date registrationdatetime) {
        this.registrationdatetime = registrationdatetime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entryid != null ? entryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hmisusers)) {
            return false;
        }
        Hmisusers other = (Hmisusers) object;
        if ((this.entryid == null && other.entryid != null) || (this.entryid != null && !this.entryid.equals(other.entryid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.m0ckinjay.hmis.Hmisusers[ entryid=" + entryid + " ]";
    }
    
}
