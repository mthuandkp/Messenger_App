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
}
