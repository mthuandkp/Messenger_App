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
public class BlockUserDAO {
    ConnectionDB connect = new ConnectionDB();
    public List<BlockUserDTO> getAllListBlock() {
        List<BlockUserDTO> listBlockUser = new ArrayList<>();
         try {
            String qry = "SELECT * FROM `Block_User`";
            Connection conn = connect.getConnect();
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
    
}
