/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.dbConnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 *
 * @author mo
 */
public class dbConnection {

 
    public static Connection connectToDb(){
    Optional<Connection> connObj = Optional.ofNullable(null);
    String jdbcUrl = "jdbc:postgresql://localhost:5432/";
    String dbName = "crud";
    String dbUser = "mo";
    String dbUserPass = "mo..";
    
        try {
            connObj = Optional.of(DriverManager.getConnection(jdbcUrl+dbName, dbUser, dbUserPass));
            return  connObj.get();
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        }
        return connObj.get();
    }
    
      public static String getCurrentTimestamp(){
        LocalDateTime localDateTime = LocalDateTime.now();
//        ZoneId zoneId = ZoneId.systemDefault();
//        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
//        long currentTimestamp = zonedDateTime.toInstant().toEpochMilli();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = localDateTime.format(formatter);
        return formattedDateTime;
//        SimpleDateFormat formatter5=new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
//////////         Date date5=formatter5.parse(getCurrentTimestamp());
    }
      
      
    public static String dbUserEntry(Hmisusers user){
        String insertQueryString = "insert into hmisUsers"
                + "(userName, firstName,"
                + "lastName, emailAddress,"
                + "password, registrationDateTime)"
                + " values  (?,?,?,?,?,CAST(? as timestamp))";
        String errorString = null;
        
        try {
            Hmisusers hmisusers = new Hmisusers();
            PreparedStatement preparedStatement = connectToDb().prepareStatement(insertQueryString);
            preparedStatement.setString(1, hmisusers.getUsername());
            preparedStatement.setString(2, hmisusers.getFirstname());
            preparedStatement.setString(3, hmisusers.getLastname());
            preparedStatement.setString(4, hmisusers.getEmailaddress());
            preparedStatement.setString(5, hmisusers.getPassword());
            preparedStatement.setString(6, getCurrentTimestamp());
            errorString = "Insert successful for user " + hmisusers.getUsername();
        } catch (SQLException e) {
            errorString = e.getMessage();
        }
        return errorString;
    }
    
}
