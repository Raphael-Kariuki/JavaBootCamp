/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.dbConnections;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mo
 */
@Entity
@Table(name = "hmisusers", catalog = "crud", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Hmisusers.findAll", query = "SELECT h FROM Hmisusers h"),
    @NamedQuery(name = "Hmisusers.findByEntryid", query = "SELECT h FROM Hmisusers h WHERE h.entryid = :entryid"),
    @NamedQuery(name = "Hmisusers.findByUsername", query = "SELECT h FROM Hmisusers h WHERE h.username = :username"),
    @NamedQuery(name = "Hmisusers.findByFirstname", query = "SELECT h FROM Hmisusers h WHERE h.firstname = :firstname"),
    @NamedQuery(name = "Hmisusers.findByLastname", query = "SELECT h FROM Hmisusers h WHERE h.lastname = :lastname"),
    @NamedQuery(name = "Hmisusers.findByEmailaddress", query = "SELECT h FROM Hmisusers h WHERE h.emailaddress = :emailaddress"),
    @NamedQuery(name = "Hmisusers.findByPassword", query = "SELECT h FROM Hmisusers h WHERE h.password = :password"),
    @NamedQuery(name = "Hmisusers.findByRegistrationdatetime", query = "SELECT h FROM Hmisusers h WHERE h.registrationdatetime = :registrationdatetime")})
public class Hmisusers implements Serializable {

    //TODO - check purpose of this serialVersionUID
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
        return "com.m0ckinjay.dbConnections.Hmisusers[ entryid=" + entryid + " ]";
    }
    
}
