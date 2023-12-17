/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.restserver.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mo
 */
public class dbConnection {

    Connection conn = null;

    public dbConnection() {
        String jdbcURL = "jdbc:postgresql://localhost:5432/crud";
        String username = "mo";
        String password = "mo..";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            Logger.getAnonymousLogger().log(Level.INFO, "Cant find driver class file {0} ", new Object[]{e.getMessage()});
        }

        try {
            conn = DriverManager.getConnection(jdbcURL, username, password);
            Logger.getAnonymousLogger().log(Level.INFO, "Db conn success");
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(Level.INFO, "Error getting db conn:  {0} ", new Object[]{e.getMessage()});
        }

    }


    public  String checkLogin(String userName) {
        
        String selectQuery = "SELECT password FROM \"public\".systemusers where username = ? LIMIT 1";
        String actualPassword = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try{
            preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setString(1, userName);
            rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                if (rs.getString("password") != null) {
                    actualPassword = rs.getString("password");

                }
            }
        }catch(SQLException e){
            Logger.getAnonymousLogger().log(Level.INFO, "Error:  {0} ", new Object[]{e.getMessage()});
            actualPassword = e.getMessage();
        }
        return actualPassword;
    }

}
