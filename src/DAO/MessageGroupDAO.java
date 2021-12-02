/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mthuan
 */
public class MessageGroupDAO {
    ConnectionDB connect = new ConnectionDB();
    public List<MessageGroupDTO> getAllMessage() {
        List<MessageGroupDTO> listMessageGroup = new ArrayList<>();
        try {
            String qry = "SELECT * FROM `Message_Group`";
            Connection conn = connect.getConnect();
            PreparedStatement prestm = conn.prepareStatement(qry);

            ResultSet rs = prestm.executeQuery();

            if (rs == null || !rs.isBeforeFirst()) {
                return null;
            }

            while (rs.next()) {
                listMessageGroup.add(new MessageGroupDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getBoolean(6)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listMessageGroup;
    }

    public void addNewMess(int idUser, int idGroup, String content) {
        String time = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
        try {
            String qry = "INSERT INTO `Message_Group`(`id_user`, `id_group`, `time`, `content`, `url`) VALUES (?,?,?,?,false)";
            Connection conn = connect.getConnect();
            PreparedStatement prestm = conn.prepareStatement(qry);
            prestm.setInt(1, idUser);
            prestm.setInt(2, idGroup);
            prestm.setString(3, time);
            prestm.setString(4, content);
            
            prestm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addNewMess(MessageGroupDTO mess) {
        try {
            String qry = "INSERT INTO `Message_Group`(`id_user`, `id_group`, `time`, `content`, `url`) VALUES (?,?,?,?,?)";
            Connection conn = connect.getConnect();
            PreparedStatement prestm = conn.prepareStatement(qry);
            prestm.setInt(1, mess.getId_user());
            prestm.setInt(2, mess.getId_group());
            prestm.setString(3, mess.getTime());
            prestm.setString(4, mess.getContent());
            prestm.setBoolean(5, mess.isIsURL());
            
            prestm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
