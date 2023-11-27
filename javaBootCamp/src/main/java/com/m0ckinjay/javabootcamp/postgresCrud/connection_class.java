/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.javabootcamp.postgresCrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mo
 */
public class connection_class {
    public static void main(String[] args) {
        Connection conn = connect_to_db("crud", "mo", "mo..");
        createTable(conn, "Users");
        //insertToDB(conn,"John","Doe","john@doe.com");
        selectFrmDB(conn);
        updateDb(conn);
        selectFrmDB(conn);
        deleteFrmDB(conn);
        
        
    }
    public static Connection connect_to_db(String dbname, String user, String password){
        Connection con_obj = null;
        String jdbcUrl = "jdbc:postgresql://localhost:5432/";
        
        try {
            con_obj = DriverManager.getConnection(jdbcUrl+dbname, user, password);
            if (con_obj!=null) {
                System.out.println("Connection successful");
            }else{
                System.out.println("Connection failes");
            }
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        }
        return con_obj;
    }
    public static void createTable(Connection conn_obj, String tableName){
        Statement stmnt;
        String query = "create table if not exists "+tableName+"(entry_id serial PRIMARY KEY,"
                    + "first_name varchar(20),"
                    + "last_name varchar(20),"
                    + "email_address varchar )";
        try {
            stmnt = conn_obj.createStatement();
            stmnt.executeQuery(query);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.out.println("" + e);
        }
    }
    public static int insertToDB(Connection conn_obj, String fNameString,String sNamString, String emailString){
        String insertQuery = "insert into users(first_name, last_name, email_address) values (?,?,?)";
         var execUpdate = 0;
        try (PreparedStatement preparedStatement = conn_obj.prepareStatement(insertQuery)){
            preparedStatement.setString(1, fNameString);
            preparedStatement.setString(2, sNamString);
            preparedStatement.setString(3, emailString);
            
           execUpdate = preparedStatement.executeUpdate();
            System.out.println("Insert success");
        } catch (Exception e) {
            System.out.println("" + e);
        }
        return execUpdate;
    }
    public static void selectFrmDB(Connection conn_obj){
        String selectQuery = "SELECT * FROM \"public\".users LIMIT 100";
        Statement statement;
        ResultSet resultSet;
        try {
            statement = conn_obj.createStatement();
            resultSet = statement.executeQuery(selectQuery);
            
            System.out.printf("%20s%20s%20s%n","FirstName", "SecondName", "Email address");
            while (resultSet.next()) {
                System.out.printf("%20s%20s%20s%n", resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getString("email_address"));
            }
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }
    public static void updateDb(Connection conn_obj){
        String updateQuery = "update \"public\".users set first_name = ? where entry_id = ?";
        try(PreparedStatement preStmnt = conn_obj.prepareStatement(updateQuery)) {
            preStmnt.setString(1, "Johny");
            preStmnt.setInt(2, 8);
            
            var execUpdate = preStmnt.executeUpdate();
            System.out.println("Update success");
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }
    public static void deleteFrmDB(Connection conn_obj){
        String deleteQuery = "delete from \"public\".users where entry_id = ?";
        try (PreparedStatement preStmnt = conn_obj.prepareStatement(deleteQuery)){
            preStmnt.setInt(1, 1);
            
            var execUpdate = preStmnt.executeUpdate();
            System.out.println("Delete success");
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }
    
    
}
