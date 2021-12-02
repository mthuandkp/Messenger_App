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
public class JoinGroupDAO {
    ConnectionDB connect = new ConnectionDB();
    public List<JoinGroupDTO> getAllJoinGroup() {
        List<JoinGroupDTO> listJoinGroup = new ArrayList<>();
         try {
            String qry = "SELECT * FROM `Join_Group`";
            Connection conn = connect.getConnect();
            PreparedStatement prestm = conn.prepareStatement(qry);

            ResultSet rs = prestm.executeQuery();

            if (rs == null || !rs.isBeforeFirst()) {
                return null;
            }

            while (rs.next()) {
                listJoinGroup.add(new JoinGroupDTO(rs.getInt(1), rs.getInt(2)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listJoinGroup;
    }

    public boolean joinToGroup(int idUser, int idGroup) {
        try {
            String qry = "INSERT INTO `Join_Group`(`id_user`, `id_group`) VALUES (?,?)";
            Connection conn = connect.getConnect();
            PreparedStatement prestm = conn.prepareStatement(qry);
            prestm.setInt(1, idUser);
            prestm.setInt(2, idGroup);

            if(prestm.executeUpdate() != 0){
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean removeJoinGroup(int idUser, int idRoom) {
        try {
            String qry = "DELETE FROM `Join_Group` WHERE `id_user`=? AND `id_group` = ?";
            Connection conn = connect.getConnect();
            PreparedStatement prestm = conn.prepareStatement(qry);
            prestm.setInt(1, idUser);
            prestm.setInt(2, idRoom);

            if(prestm.executeUpdate() != 0){
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
}
