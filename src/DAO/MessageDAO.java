/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
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
                    listMessage.add(new Message(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getBoolean(4),rs.getString(5),rs.getTimestamp(6).toLocalDateTime()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMessage;
    }
}
