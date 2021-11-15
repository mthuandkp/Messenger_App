/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
     ConnectionDB connect = null;
     public UserDAO(){
         connect = new ConnectionDB();
     }
     
     public List<User> convertResultSetToList(ResultSet rs) {
        List<User> listUser = new ArrayList<>();
        try {
            if(rs != null){
                while(rs.next()){
                    listUser.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listUser;
    }

    public List<User> getAllList() {
        List<User> listUser = new ArrayList<>();
        if(connect == null){
            return listUser;
        }
        
        Connection conn = connect.getConnect();
        String qry = "SELECT * FROM `User`";
        try {
            PreparedStatement prestm = conn.prepareStatement(qry);
            ResultSet rs = prestm.executeQuery();
            listUser = convertResultSetToList(rs);
        } catch (SQLException ex) {
            Logger.getLogger(BlockDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUser;
    }

    public User getByUsername(String user) {
        if(connect == null){
            return null;
        }
        Connection conn = connect.getConnect();
        String qry = "SELECT * FROM `User` WHERE `email`=?";
        try {
            PreparedStatement prestm = conn.prepareStatement(qry);
            prestm.setString(1, user);
            ResultSet rs = prestm.executeQuery();
            List<User> lists = convertResultSetToList(rs);
            if(lists.isEmpty()){
                return null;
            }
            return lists.get(0);
           
        } catch (SQLException ex) {
            Logger.getLogger(BlockDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println(new UserDAO().getByUsername("pnmthuan@gmail.com"));
    }
}
