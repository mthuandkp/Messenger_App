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
public class ViewMessageGroupDAO {
    ConnectionDB connect = new ConnectionDB();
    public List<ViewMessageDTO> getAllViewMessage() {
        List<ViewMessageDTO> listView = new ArrayList<>();
         try {
            String qry = "SELECT * FROM `View_Message_Group`";
            Connection conn = connect.getConnect();
            PreparedStatement prestm = conn.prepareStatement(qry);

            ResultSet rs = prestm.executeQuery();

            if (rs == null || !rs.isBeforeFirst()) {
                return null;
            }

            while (rs.next()) {
               listView.add(new ViewMessageDTO(rs.getInt(1), rs.getInt(2)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listView;
    }

    public void viewMessage(int idUser, int id) {
        try {
            String qry = "INSERT INTO `View_Message_Group`(`id_user`, `id_mess`) VALUES (?,?)";
            Connection conn = connect.getConnect();
            PreparedStatement prestm = conn.prepareStatement(qry);
            prestm.setInt(1, idUser);
            prestm.setInt(2, id);
            
            prestm.executeUpdate();
                
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
