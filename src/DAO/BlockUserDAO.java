/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.*;
import Func.Hyrid_Encryption;
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
public class BlockUserDAO {

    public List<BlockUserDTO> getAllListBlock(Connection conn) {
        List<BlockUserDTO> listBlockUser = new ArrayList<>();
         try {
            String qry = "SELECT * FROM `Block_User`";
            
            PreparedStatement prestm = conn.prepareStatement(qry);

            ResultSet rs = prestm.executeQuery();

            if (rs == null || !rs.isBeforeFirst()) {
                return null;
            }

            while (rs.next()) {
               listBlockUser.add(new BlockUserDTO(rs.getInt(1), rs.getInt(2)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listBlockUser;
    }

    public boolean block(int idSender, int idReceive,Connection conn) {
        try {
            String qry = "INSERT INTO `Block_User`(`id_user`, `id_user_block`) VALUES (?,?);";
            
            PreparedStatement prestm = conn.prepareStatement(qry);
            prestm.setInt(1, idSender);
            prestm.setInt(2, idReceive);
            
            return prestm.executeUpdate() > 0;
                
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean unblock(int id, int idblock,Connection conn) {
        try {
            String qry = "DELETE FROM `Block_User` WHERE `id_user`=? AND `id_user_block`=?;";
            
            PreparedStatement prestm = conn.prepareStatement(qry);
            prestm.setInt(1, id);
            prestm.setInt(2, idblock);
            
            return prestm.executeUpdate() > 0;
                
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
