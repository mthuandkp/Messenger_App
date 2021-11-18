/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.View_Message;
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
public class ViewMessageDAO {
    ConnectionDB connect = new ConnectionDB();
    public List<View_Message> convertResultSetToList(ResultSet rs) {
        List<View_Message> listViewMess = new ArrayList<>();
        try {
            if(rs != null){
                while(rs.next()){
                    listViewMess.add(new View_Message(rs.getInt(1), rs.getInt(2)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listViewMess;
    }
    
    public List<View_Message> getAllViewMess() {
        List<View_Message> listViewMess = new ArrayList<>();
        if(connect == null){
            return listViewMess;
        }
        
        Connection conn = connect.getConnect();
        String qry = "SELECT * FROM `View_Message`";
        try {
            PreparedStatement prestm = conn.prepareStatement(qry);
            ResultSet rs = prestm.executeQuery();
            listViewMess = convertResultSetToList(rs);
        } catch (SQLException ex) {
            Logger.getLogger(BlockDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listViewMess;
    }    
}
