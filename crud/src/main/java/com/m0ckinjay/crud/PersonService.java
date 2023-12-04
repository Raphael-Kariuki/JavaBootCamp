/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mo
 */
public class PersonService {
    Connection conn;
    
    public PersonService(){
        try {
            String jdbcUrl = "jdbc:postgresql://localhost:5432/";
            String dbName = "crud";
            String dbUser = "mo";
            String dbUserPass = "mo..";
            
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(String.format(jdbcUrl+dbName), dbUser, dbUserPass);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(" " + e.getMessage());
        }
    
    }
    
    public String insertPerson(PersonModel person){
        String insertSQLString = "insert into person(firstName, lastName, age, height) values (?,?,?,?)";
        String status = null;
        try {
            PreparedStatement insertPreparedStatement = conn.prepareStatement(insertSQLString);
            insertPreparedStatement.setString(1, person.getFirstname());
            insertPreparedStatement.setString(2, person.getLastname());
            insertPreparedStatement.setInt(3, person.getAge());
            insertPreparedStatement.setDouble(4, person.getHeight());
            
            status = String.valueOf(insertPreparedStatement.executeUpdate());
            
    }catch(SQLException e){
            status = e.getMessage();
    }
        return status;
}
    public List<PersonModel> getallPerson() throws SQLException{
        List<PersonModel> dataFromDb = new ArrayList<>();
        
        String selectQuery = "select * from person";
        PreparedStatement selectPreparedStatement = null;
        ResultSet rs = null;
        
        try {
            selectPreparedStatement = conn.prepareStatement(selectQuery);
            rs = selectPreparedStatement.executeQuery();
            while (rs.next()) {
                PersonModel person = new PersonModel();
                person.setFirstname(rs.getString("firstname"));
                person.setLastname(rs.getString("lastname"));
                person.setAge(rs.getInt("age"));
                person.setHeight(rs.getDouble("height"));
                dataFromDb.add(person);
            }

        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        }
       return dataFromDb;
    }
     public List<PersonModel> getPersonById(int id) throws SQLException{
        List<PersonModel> dataFromDb = new ArrayList<>();
        
        String selectQuery = "select * from person where entryid = ?";
        
        PreparedStatement selectPreparedStatement = null;
        ResultSet rs = null;
        
        try {
            selectPreparedStatement = conn.prepareStatement(selectQuery);
            selectPreparedStatement.setInt(1, id);

            rs = selectPreparedStatement.executeQuery();
            while (rs.next()) {
                PersonModel person = new PersonModel();
                person.setFirstname(rs.getString("firstname"));
                person.setLastname(rs.getString("lastname"));
                person.setAge(rs.getInt("age"));
                person.setHeight(rs.getDouble("height"));
                dataFromDb.add(person);
            }

        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        }
       return dataFromDb;
    }
}