package com.codeway.guessinggame.db;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DataBaseConnection {

  Connection connection;
  public Statement statement;

  public DataBaseConnection() {

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
  
      String url = "jdbc:mysql://localhost:3308/numberguessinggame";
      String username = "root";
      String password = "root";
  
      connection = DriverManager.getConnection(url, username, password);
      statement = connection.createStatement();
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println(e);
    }
  }
}
