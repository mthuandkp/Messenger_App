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
public class FriendDAO {

    public List<FriendDTO> getAllFriend(Connection conn) {
        List<FriendDTO> listFriend = new ArrayList<>();
        try {
            String qry = "SELECT * FROM `Friend`";

            PreparedStatement prestm = conn.prepareStatement(qry);

            ResultSet rs = prestm.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    listFriend.add(new FriendDTO(rs.getInt(1), rs.getInt(1)));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listFriend;
    }

    public void addNewFriend(int idUser, int idFriend, Connection conn) {
        try {
            String qry = "INSERT INTO `friend`(`id_user_1`, `id_user_2`) VALUES (?,?)";

            PreparedStatement prestm = conn.prepareStatement(qry);
            prestm.setInt(1, idUser);
            prestm.setInt(2, idFriend);

            prestm.executeUpdate();
        } catch (Exception e) {
        }
    }
}
