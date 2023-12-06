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
    
    public PersonModel insertPerson(PersonModel person){
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
        return person;
}
    public String registerSystemUser(Systemusers newUser){
        /*
        INSERT INTO systemusers (username, firstname, lastname, emailaddress, password, log_ts) 
	VALUES (?,?,?,?,?, DEFAULT)

        */
        String insertSQLString = " INSERT INTO systemusers (username, firstname, lastname, emailaddress, password, log_ts) \n" +
"	VALUES (?,?,?,?,?, DEFAULT)";
        PreparedStatement registerUserPreparedStatement = null;
        String status = null;
        try {
            registerUserPreparedStatement = conn.prepareStatement(insertSQLString);
            registerUserPreparedStatement.setString(1, newUser.getUsername());
            registerUserPreparedStatement.setString(2, newUser.getFirstname());
            registerUserPreparedStatement.setString(3, newUser.getLastname());
            registerUserPreparedStatement.setString(4, newUser.getEmailaddress());
            registerUserPreparedStatement.setString(5, newUser.getPassword());
            status = "" + registerUserPreparedStatement.executeUpdate();
            
            
    }catch(SQLException e){
            status = e.getMessage();
    }
        return status;
}
    public List<PersonModel> getallPerson() throws SQLException{
        List<PersonModel> dataFromDb = new ArrayList<>();
        
        String selectQuery = "select entryid,* from person";
        PreparedStatement selectPreparedStatement = null;
        ResultSet rs = null;
        
        try {
            selectPreparedStatement = conn.prepareStatement(selectQuery);
            rs = selectPreparedStatement.executeQuery();
            while (rs.next()) {
                PersonModel person = new PersonModel();
                person.setEntryid(rs.getInt("entryid"));
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
    public PersonModel getPersonById(int id) throws SQLException{
        
        String selectQuery = "select * from person where entryid = ?";
        
        PreparedStatement selectPreparedStatement = null;
        ResultSet rs = null;
        PersonModel person = new PersonModel();

        
        try {
            selectPreparedStatement = conn.prepareStatement(selectQuery);
            selectPreparedStatement.setInt(1, id);

            rs = selectPreparedStatement.executeQuery();

            while (rs.next()) {
                person.setFirstname(rs.getString("firstname"));
                person.setLastname(rs.getString("lastname"));
                person.setAge(rs.getInt("age"));
                person.setHeight(rs.getDouble("height"));
            }

        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        }
       return person;
    }
    public int deletePersonById(int id){
        String deleteQuery = "delete from person where entryid = ?";
        
        PreparedStatement deletePreparedStatement = null;
        Integer deleteStatus = null;
        
        try {
            deletePreparedStatement = conn.prepareStatement(deleteQuery);
            deletePreparedStatement.setInt(1, id);
            /*
            *ResultSet 	executeQuery() - Executes the SQL query in this PreparedStatement object and returns the ResultSet object generated by the query.
            *int executeUpdate() - Executes the SQL statement in this PreparedStatement object, 
                which must be an SQL Data Manipulation Language (DML) statement, such as INSERT, UPDATE or DELETE; 
                or an SQL statement that returns nothing, such as a DDL statement.
            */
            deleteStatus = deletePreparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        }
        return deleteStatus;
    }
    
    public String updatePersonById(PersonModel newPerson, int id){
        String updateQuery = "update public.person set firstname = ?, lastname = ?, age = ?, height = ? where entryid = ?";
        PreparedStatement updatePreparedStatement = null;
        Integer updateStatus = null;
        String errorMessage = null;
        
        try {
            updatePreparedStatement = conn.prepareStatement(updateQuery);
            updatePreparedStatement.setString(1, newPerson.getFirstname());
            updatePreparedStatement.setString(2, newPerson.getLastname());
            updatePreparedStatement.setInt(3, newPerson.getAge());
            updatePreparedStatement.setDouble(4, newPerson.getHeight());
            updatePreparedStatement.setInt(5, id);
            
            updateStatus = updatePreparedStatement.executeUpdate();
        } catch (SQLException e) {
            updateStatus = 404;
            System.out.println("" + e.getMessage());
            errorMessage = e.getMessage();
        }
        return errorMessage;
    }
    //why special, method that executes an update should be a PUT, I use POST because forms support 2 methods GET and POST. It works
    public int specialUpdatePersonById(PersonModel newPerson, int id){
        String updateQuery = "update public.person set firstname = ?, lastname = ?, age = ?, height = ? where entryid = ?";
        PreparedStatement updatePreparedStatement = null;
        Integer updateStatus = null;
        String errorMessage = null;
        
        try {
            updatePreparedStatement = conn.prepareStatement(updateQuery);
            updatePreparedStatement.setString(1, newPerson.getFirstname());
            updatePreparedStatement.setString(2, newPerson.getLastname());
            updatePreparedStatement.setInt(3, newPerson.getAge());
            updatePreparedStatement.setDouble(4, newPerson.getHeight());
            updatePreparedStatement.setInt(5, id);
            
            updateStatus = updatePreparedStatement.executeUpdate();
        } catch (SQLException e) {
            updateStatus = 404;
            System.out.println("" + e.getMessage());
            errorMessage = e.getMessage();
        }
        return updateStatus;
    }
    public String patchPersonById(PersonModel newPerson, int id){
        String updateQuery = "update public.person set firstname = ? where entryid = ?";
        PreparedStatement updatePreparedStatement = null;
        Integer updateStatus = null;
        String errorMessage = null;
        
        try {
            updatePreparedStatement = conn.prepareStatement(updateQuery);
            updatePreparedStatement.setString(1, newPerson.getFirstname());
            updatePreparedStatement.setInt(2, id);
            
            updateStatus = updatePreparedStatement.executeUpdate();
        } catch (SQLException e) {
            updateStatus = 404;
            System.out.println("" + e.getMessage());
            errorMessage = e.getMessage();
        }
        return errorMessage;
    }
    
    public Systemusers checkLogin(String username, String password){
        Systemusers loginUser = null;
        
        String loginCheckSelectQuery = "select * from public.systemusers where username = ? and password = ?";
        PreparedStatement preparedLoginCheckPreparedStatement = null;
        ResultSet rs  = null;
        String error = "No such user found";
        try {
            preparedLoginCheckPreparedStatement = conn.prepareStatement(loginCheckSelectQuery);
            preparedLoginCheckPreparedStatement.setString(1, username);
            preparedLoginCheckPreparedStatement.setString(2, password);
            
            rs = preparedLoginCheckPreparedStatement.executeQuery();
            
            if (rs.next()) {
                
                loginUser.setUsername(rs.getString("firstname"));
                loginUser.setEmailaddress(rs.getString("emailaddress"));
            }else{
                System.out.println("" + error);
            }
            
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        }
        return loginUser;
    }

     
}