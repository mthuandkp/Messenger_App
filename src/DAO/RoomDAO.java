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
    ConnectionDB connect = null;
     public RoomDAO(){
         connect = new ConnectionDB();
     }
     
     public List<Room> convertResultSetToList(ResultSet rs) {
        List<Room> listRoom = new ArrayList<>();
        try {
            if(rs != null){
                while(rs.next()){
                    listRoom.add(new Room(
                            rs.getInt(1), 
                            rs.getInt(2), 
                            rs.getString(3), 
                            rs.getBoolean(4)
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRoom;
    }

    public List<Room> getAllRoom() {
        List<Room> listRoom = new ArrayList<>();
        if(connect == null){
            return listRoom;
        }
        
        Connection conn = connect.getConnect();
        String qry = "SELECT * FROM `Room`";
        try {
            PreparedStatement prestm = conn.prepareStatement(qry);
            ResultSet rs = prestm.executeQuery();
            listRoom = convertResultSetToList(rs);
        } catch (SQLException ex) {
            Logger.getLogger(BlockDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRoom;
    }

    public Room getByRoomname(int id) {
        if(connect == null){
            return null;
        }
        Connection conn = connect.getConnect();
        String qry = "SELECT * FROM `Room` WHERE `id_room`=?";
        try {
            PreparedStatement prestm = conn.prepareStatement(qry);
            prestm.setInt(1, id);
            ResultSet rs = prestm.executeQuery();
            List<Room> lists = convertResultSetToList(rs);
            if(lists.isEmpty()){
                return null;
            }
            return lists.get(0);
           
        } catch (SQLException ex) {
            Logger.getLogger(BlockDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
