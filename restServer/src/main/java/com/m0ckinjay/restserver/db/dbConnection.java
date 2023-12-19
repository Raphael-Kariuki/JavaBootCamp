/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.restserver.db;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public Map<String, String> checkLogin(String userName) {

        String selectQuery = "SELECT entryid, password FROM \"public\".systemusers where username = ? LIMIT 1";
        String actualPassword = null;
        Integer actualEntryId = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Map<String, String> loginUserDetails = new HashMap<>();
//        users loginUser = new users();
        try {
            preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setString(1, userName);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                if (rs.getString("password") != null) {
                    actualPassword = rs.getString("password");
//                    loginUser.setPassword(actualPassword);
                    actualEntryId = rs.getInt("entryid");
//                    loginUser.setEntryid(actualEntryId);
//                    loginUser.setUsername(userName);
                    loginUserDetails.put("username", userName);
                    loginUserDetails.put("password", actualPassword);
                    loginUserDetails.put("entryid", String.valueOf(actualEntryId));

                }
            }
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(Level.INFO, "Error:  {0} ", new Object[]{e.getMessage()});
            loginUserDetails.put("error", e.getMessage());
        }
        return loginUserDetails;
    }

    public String[] getUserNames() {
        List<String> userNamesList = new ArrayList<>();

        String selectStatement = "select username from \"public\".systemusers";
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conn.prepareStatement(selectStatement);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                userNamesList.add(rs.getString("username"));
            }
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(Level.INFO, "Error getting usernames {0}", e.getMessage());
        }

        return userNamesList.toArray(new String[0]);

    }

}
