/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Hyrid_Encryption;
import DTO.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mthuan
 */
public class UserDAO {

    ConnectionDB connect = new ConnectionDB();

    public boolean addNewAccount(User user) {
        try {
            String qry = "INSERT INTO `User`(`email`, `password`, `name`, `sex`, `birthday`, `online_status`, `is_active`)"
                    + " VALUES (?,?,?,?,?,?,?)";
            Connection conn = connect.getConnect();
            PreparedStatement prestm = conn.prepareStatement(qry);
            prestm.setString(1, user.getEmail());
            prestm.setString(2, Hyrid_Encryption.convertToMd5(user.getPassword()));
            prestm.setString(3, user.getName());
            prestm.setBoolean(4, (user.getSex().compareToIgnoreCase("Nam") == 0));
            prestm.setString(5, user.getBirthday());
            prestm.setBoolean(6, user.isStatus());
            prestm.setBoolean(7, user.isIsActive());
            
            return prestm.executeUpdate() > 0;
                
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public User getUserByEmail(String email) {
        try {
            String qry = "SELECT * FROM `User` WHERE `email` = ?";
            Connection conn = connect.getConnect();
            PreparedStatement prestm = conn.prepareStatement(qry);
            prestm.setString(1, email);
            ResultSet rs = prestm.executeQuery();

            if (rs == null || !rs.isBeforeFirst()) {
                return null;
            }

            while (rs.next()) {
                return new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getBoolean(5) ? "Nam" : "Nữ",
                        rs.getString(6),
                        rs.getBoolean(7),
                        rs.getBoolean(8));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public User getUserById(String id) {
        try {
            String qry = "SELECT * FROM `User` WHERE `id_user` = ?";
            Connection conn = connect.getConnect();
            PreparedStatement prestm = conn.prepareStatement(qry);
            prestm.setString(1, id);
            ResultSet rs = prestm.executeQuery();

            if (rs == null) {
                return null;
            }
            while (rs.next()) {
                return new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getBoolean(5) ? "Nam" : "Nữ",
                        rs.getString(6),
                        rs.getBoolean(7),
                        rs.getBoolean(8));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        UserDAO u = new UserDAO();

        System.out.println(u.getUserByEmail("pnmthuan@gmail.com"));
    }

    public boolean activeAccout(String email) {
        try {
            String qry = "UPDATE `User` SET `is_active`=true WHERE `email` = ?";
            Connection conn = connect.getConnect();
            PreparedStatement prestm = conn.prepareStatement(qry);
            prestm.setString(1, email);            
            
            return prestm.executeUpdate() > 0;
                
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean updateOnlineStatus(String email,boolean status) {
        try {
            String qry = "UPDATE `User` SET `online_status`=? WHERE `email` = ?";
            Connection conn = connect.getConnect();
            PreparedStatement prestm = conn.prepareStatement(qry);
            prestm.setBoolean(1, status);
            prestm.setString(2, email);            
            
            return prestm.executeUpdate() > 0;
                
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<User> getAllUser() {
        List<User> listRoom = new ArrayList<>();
         try {
            String qry = "SELECT * FROM `User`";
            Connection conn = connect.getConnect();
            PreparedStatement prestm = conn.prepareStatement(qry);

            ResultSet rs = prestm.executeQuery();

            if (rs == null || !rs.isBeforeFirst()) {
                return null;
            }

            while (rs.next()) {
                listRoom.add(new User(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getBoolean(5) ? "Nam":"Nữ", 
                        rs.getString(6), 
                        rs.getBoolean(7), 
                        rs.getBoolean(8), 
                        false));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listRoom;
    }
}
