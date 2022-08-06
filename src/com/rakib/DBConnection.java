package com.rakib;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static Connection con = null;
    public static Connection getConnection(){
         String dbUrl = "jdbc:mysql://localhost:3306/employeemanegment";
         String dbUser = "root";
         String dbPassword = "root";

         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
         }catch (Exception ex){
             ex.printStackTrace();
         }

      return con;
    }

}