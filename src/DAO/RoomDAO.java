/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Room;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mthuan
 */
public class RoomDAO {
    ConnectionDB connect = new ConnectionDB();
    public List<Room> getAllRoom() {
        List<Room> listRoom = new ArrayList<>();
         try {
            String qry = "SELECT * FROM `Room`";
            Connection conn = connect.getConnect();
            PreparedStatement prestm = conn.prepareStatement(qry);

            ResultSet rs = prestm.executeQuery();

            if (rs == null || !rs.isBeforeFirst()) {
                return null;
            }

            while (rs.next()) {
                listRoom.add(new Room(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBoolean(4)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listRoom;
    }
    
}
