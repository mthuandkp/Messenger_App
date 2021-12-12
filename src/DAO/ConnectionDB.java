/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author mthuan
 */
public class ConnectionDB {

    private static String URL = "jdbc:mysql://localhost:3306/chatdb?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf-8";
    private static String USER = "root";
    private static String PASS = "123456";

    private Connection conn = null;

    
    
    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    

    public ConnectionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối đến server");
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            System.out.println("Không thể đóng kết nối : " + e);
        }
    }
}
