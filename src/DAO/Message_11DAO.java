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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mthuan
 */
public class Message_11DAO {
    ConnectionDB connect = new ConnectionDB();
    public List<Message_11DTO> getAllMessage() {
        List<Message_11DTO> listMessage11 = new ArrayList<>();
         try {
            String qry = "SELECT * FROM `Message_11`";
            Connection conn = connect.getConnect();
            PreparedStatement prestm = conn.prepareStatement(qry);

            ResultSet rs = prestm.executeQuery();

            if (rs == null || !rs.isBeforeFirst()) {
                return null;
            }

            while (rs.next()) {
               listMessage11.add(new Message_11DTO(rs.getInt(1), rs.getInt(2),rs.getInt(3), rs.getString(4), rs.getString(5), rs.getBoolean(6)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listMessage11;
    }
    
}
