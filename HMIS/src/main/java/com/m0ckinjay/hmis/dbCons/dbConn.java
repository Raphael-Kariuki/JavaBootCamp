/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.hmis.dbCons;

import com.m0ckinjay.hmis.Hmisusers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author mo
 */
public class dbConn {
    public static void main(String[] args) throws ParseException {
        Connection conn = connectToDb("crud", "mo", "mo..");
//        int execUpdate = insertToDb(conn, "mojay", "mockinjay",
//                "mohanaa", "mo@hana.com", "34r3t4t5", getCurrentTimestamp());
         Hmisusers hmisusers = new Hmisusers();
         hmisusers.setUsername("mohanna");
         hmisusers.setFirstname("moh");
         hmisusers.setLastname("anna");
         hmisusers.setEmailaddress("mo@han.na");
         hmisusers.setPassword("mohan4646na");
//         SimpleDateFormat formatter5=new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
//         Date date5=formatter5.parse(getCurrentTimestamp());
//         hmisusers.setRegistrationdatetime(date5);
        int x = insertToDb(conn, hmisusers, getCurrentTimestamp());
        System.out.println("" + x);

    }
    
    public static Connection connectToDb(String dbName, String dbUser, String dbUserPass){
        Connection connObj = null;
        final String jdbcUrl = "jdbc:postgresql://localhost:5432/";
        
        try {
            connObj = DriverManager.getConnection(jdbcUrl+dbName, dbUser, dbUserPass);
            if (connObj != null) {
                System.out.println("Connection successful");
                        }
            else{
                System.out.println("Connection successful");
            }
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        }
        return connObj;
    }
    
    public static void createTable(Connection connObj){
        Statement stmnt;
        String query = "create table if not exists hmisUsers(entryId serial PRIMARY KEy, \n" +
        "userName varchar(50) NOT NULL,\n" +
        "firstName varchar(50) NOT NULL,\n" +
        "lastName varchar(50) NOT NULL,\n" +
        "emailAddress varchar(50) NOT NULL,\n" +
        "password varchar(50) NOT NULL,\n" +
        "registrationDateTime timestamp with time zone not null default current_timestamp)";
        try {
            stmnt = connObj.createStatement();
            stmnt.executeQuery(query);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        }
    }
    public static String getCurrentTimestamp(){
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
//        long currentTimestamp = zonedDateTime.toInstant().toEpochMilli();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = localDateTime.format(formatter);
        return formattedDateTime;
    }
    
    public static int insertToDb(Connection connObj, String userName,
            String firstName,
            String lastName,
            String emailAddress,
            String password,
            String currentTimestamp
    ){
        String insertQueryString = "insert into hmisUsers"
                + "(userName, firstName,"
                + "lastName, emailAddress,"
                + "password, registrationDateTime)"
                + " values  (?,?,?,?,?,CAST(? as timestamp))";
        var execUpdate = 0;
        
        try (PreparedStatement preparedStatement = connObj.prepareStatement(insertQueryString)){
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, emailAddress);
            preparedStatement.setString(5, password);
            preparedStatement.setString(6, currentTimestamp);
            
            execUpdate = preparedStatement.executeUpdate();
            System.out.println("Insert success");
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        }
        return execUpdate;
    }
     public static int insertToDb(Connection connObj, Hmisusers hmisusers, String currentTimestamp){
        String insertQueryString = "insert into hmisUsers"
                + "(userName, firstName,"
                + "lastName, emailAddress,"
                + "password, registrationDateTime)"
                + " values  (?,?,?,?,?,CAST(? as timestamp))";
        var execUpdate = 0;
        
        try (PreparedStatement preparedStatement = connObj.prepareStatement(insertQueryString)){
            preparedStatement.setString(1, hmisusers.getUsername());
            preparedStatement.setString(2, hmisusers.getFirstname());
            preparedStatement.setString(3, hmisusers.getLastname());
            preparedStatement.setString(4, hmisusers.getEmailaddress());
            preparedStatement.setString(5, hmisusers.getPassword());
            preparedStatement.setString(6, currentTimestamp);
            
            execUpdate = preparedStatement.executeUpdate();
            System.out.println("Insert success");
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        }
        return execUpdate;
    }
}
