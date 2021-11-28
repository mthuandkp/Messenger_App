/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Join_Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mthuan
 */
public class Join_RoomDAO {
    ConnectionDB connect = new ConnectionDB();
    
    
    public List<Join_Room> convertResultSetToList(ResultSet rs){
        List<Join_Room> listjoin_room = new ArrayList<>();
        try {
            if (rs != null) {
                while(rs.next()){
                    listjoin_room.add(new Join_Room(
                                    rs.getInt(1), 
                                    rs.getInt(2)
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listjoin_room;
    }
    
    public List<Join_Room> getAllJoin_Room(){
        List<Join_Room> list = new ArrayList<>();
        if (connect == null) {
            return null;
        }
        Connection conn = connect.getConnect();
        String qry = "SELECT * FROM `join_room`";
        try {
            PreparedStatement pstm = conn.prepareStatement(qry);
            ResultSet rs = pstm.executeQuery();
            list = convertResultSetToList(rs);
            if (list.isEmpty()) {
                return null;
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<Join_Room> getAllJoin_RoomByIdRoom(int id){
        List<Join_Room> list = new ArrayList<>();
        
        Connection conn = connect.getConnect();
        if (conn == null) {
            return null;
        }
        String qry = "SELECT * FROM `join_room` WHERE `id_room`=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(qry);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            list = convertResultSetToList(rs);
            if (list.isEmpty()) {
                return null;
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    public List<Join_Room> getAllJoin_RoomByIdUser(int id){
        List<Join_Room> list = new ArrayList<>();
        Connection conn = connect.getConnect();
        if (conn == null) {
            return null;
        }
        String qry = "SELECT * FROM `Join_Room` WHERE `id_user`=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(qry);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            list = convertResultSetToList(rs);
            if (list.isEmpty()) {
                return new ArrayList<>();
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    
    
}
