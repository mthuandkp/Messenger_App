/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Message;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mthuan
 */
public class MessageDAO {
    ConnectionDB connect = new ConnectionDB();
    public List<Message> getAllMessage() {
        List<Message> listUser = new ArrayList<>();
        if(connect == null){
            return listUser;
        }
        
        Connection conn = connect.getConnect();
        String qry = "SELECT * FROM `Message`";
        try {
            PreparedStatement prestm = conn.prepareStatement(qry);
            ResultSet rs = prestm.executeQuery();
            listUser = convertResultSetToList(rs);
        } catch (SQLException ex) {
            Logger.getLogger(BlockDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUser;   
    }
    
    public List<Message> convertResultSetToList(ResultSet rs) {
        List<Message> listMessage = new ArrayList<>();
        try {
            if(rs != null){
                while(rs.next()){
                    listMessage.add(new Message(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getBoolean(4),rs.getString(5),rs.getString(6),rs.getBoolean(7)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMessage;
    }

    /*public String addNewMess(Message mess) {
        Connection conn = connect.getConnect();
        String qry = "INSERT INTO `Message`(`id_user`, `id_room`, `is_url`, `body`, `time`, `Status`) VALUES (?,?,?,?,?,?);";
        try {
            PreparedStatement prestm = conn.prepareStatement(qry);
            
            prestm.setInt(1, mess.getId_user());
            prestm.setInt(2, mess.getId_room());
            prestm.setBoolean(3, mess.isIs_url());
            prestm.setString(4, mess.getBody());
            prestm.setString(5,mess.getTime().toString());
            prestm.setBoolean(6, true);
            
            prestm.execute();
                
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(BlockDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        HashMap<String,String> maps = new HashMap<>();
        maps.put("command", "");
        
        return new Gson().toJson(maps);
    }*/

    public void addNewMessage(int idRoom, int idUser, String chatcontent) {
        String time = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
        Connection conn = connect.getConnect();
        String qry = "INSERT INTO `Message`(`id_user`, `id_room`, `is_url`, `body`, `time`, `Status`) VALUES (?,?,?,?,?,?);";
        try {
            PreparedStatement prestm = conn.prepareStatement(qry);
            prestm.setInt(1, idUser);
            prestm.setInt(2, idRoom);
            prestm.setBoolean(3, false);
            prestm.setString(4, chatcontent);
            prestm.setString(5, time);
            prestm.setBoolean(6, true);
            prestm.execute();            
        } catch (SQLException ex) {
            Logger.getLogger(BlockDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public List<Message> getAllMessageByIdRoom(int idRoom) {
        List<Message> listMess = new ArrayList<>();
        if(connect == null){
            return listMess;
        }
        
        Connection conn = connect.getConnect();
        String qry = "SELECT * FROM `Message` WHERE `id_room` = ?";
        try {
            PreparedStatement prestm = conn.prepareStatement(qry);
            prestm.setInt(1, idRoom);
            ResultSet rs = prestm.executeQuery();
            listMess = convertResultSetToList(rs);
        } catch (SQLException ex) {
            Logger.getLogger(BlockDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMess;   
    }
}
