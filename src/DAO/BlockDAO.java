/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Block;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mthuan
 */
public class BlockDAO {
    ConnectionDB connect = null;
    
    public BlockDAO(){
        connect = new ConnectionDB();
    }
    
    
    public List<Block> convertResultSetToList(ResultSet rs) {
        List<Block> listBlock = new ArrayList<>();
        try {
            if(rs != null){
                while(rs.next()){
                    listBlock.add(new Block(rs.getInt(1), rs.getInt(2)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBlock;
    }

    public List<Block> getAllList() {
        List<Block> listBlock = new ArrayList<>();
        if(connect == null){
            return listBlock;
        }
        
        Connection conn = connect.getConnect();
        String qry = "SELECT * FROM `Block`";
        try {
            PreparedStatement prestm = conn.prepareStatement(qry);
            ResultSet rs = prestm.executeQuery();
            listBlock = convertResultSetToList(rs);
        } catch (SQLException ex) {
            Logger.getLogger(BlockDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBlock;
    }  
    
    public List<Block> getById(int id_user){
        List<Block> listBlock = new ArrayList<>();
        if(connect == null){
            return listBlock;
        }
        
        Connection conn = connect.getConnect();
        String qry = "SELECT * FROM `Block` WHERE `id_user` = ?";
        try {
            PreparedStatement prestm = conn.prepareStatement(qry);
            prestm.setInt(1, id_user);
            ResultSet rs = prestm.executeQuery();
            listBlock = convertResultSetToList(rs);
        } catch (SQLException ex) {
            Logger.getLogger(BlockDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBlock;
    }

    public boolean addNewBlock(String idUser, String idRoom) {
        int id_user = Integer.valueOf(idUser);
        int id_room = Integer.valueOf(idRoom);
        try {
            String qry = "INSERT INTO `Block`(`id_user`, `id_room`) VALUES (?,?);";
            Connection conn = connect.getConnect();
            PreparedStatement prestm = conn.prepareStatement(qry);
            prestm.setInt(1, id_user);
            prestm.setInt(2, id_room);            
            
            return prestm.executeUpdate() > 0;
                
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean removeNewBlock(String idUser, String idRoom) {
        int id_user = Integer.valueOf(idUser);
        int id_room = Integer.valueOf(idRoom);
        try {
            String qry = "DELETE FROM `Block` WHERE `id_user`=? AND `id_room`=?";
            Connection conn = connect.getConnect();
            PreparedStatement prestm = conn.prepareStatement(qry);
            prestm.setInt(1, id_user);
            prestm.setInt(2, id_room);            
            
            return prestm.executeUpdate() > 0;
                
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean joinRoom(String idUser, String idRoom) {
        int id_user = Integer.valueOf(idUser);
        int id_room = Integer.valueOf(idRoom);
        try {
            String qry = "INSERT INTO `Join_Room`(`id_room`, `id_user`) VALUES (?,?);";
            Connection conn = connect.getConnect();
            PreparedStatement prestm = conn.prepareStatement(qry);
            prestm.setInt(2, id_user);
            prestm.setInt(1, id_room);            
            
            return prestm.executeUpdate() > 0;
                
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
