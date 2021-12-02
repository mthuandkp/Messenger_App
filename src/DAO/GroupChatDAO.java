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
public class GroupChatDAO {
    ConnectionDB connect = new ConnectionDB();
    public List<GroupChatDTO> getAllGroup() {
        List<GroupChatDTO> listGroup = new ArrayList<>();
         try {
            String qry = "SELECT * FROM `Group_Chat`";
            Connection conn = connect.getConnect();
            PreparedStatement prestm = conn.prepareStatement(qry);

            ResultSet rs = prestm.executeQuery();

            if (rs == null || !rs.isBeforeFirst()) {
                return null;
            }

            while (rs.next()) {
                listGroup.add(new GroupChatDTO(rs.getInt(1),rs.getInt(2), rs.getString(3)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listGroup;
    }
}
