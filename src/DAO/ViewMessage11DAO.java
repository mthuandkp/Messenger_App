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
public class ViewMessage11DAO {

    public List<ViewMessageDTO> getAllViewMessage(Connection conn) {
        List<ViewMessageDTO> listView = new ArrayList<>();
        try {
            String qry = "SELECT * FROM `View_Message_11`";

            PreparedStatement prestm = conn.prepareStatement(qry);
            ResultSet rs = prestm.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    listView.add(new ViewMessageDTO(rs.getInt(1), rs.getInt(2)));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listView;
    }

    public void addViewMessage(int userId, int idmess, Connection conn) {
        try {
            String qry = "INSERT INTO `View_Message_11`(`id_user`, `id_mess`) VALUES (?,?)";

            PreparedStatement prestm = conn.prepareStatement(qry);
            prestm.setInt(1, userId);
            prestm.setInt(2, idmess);

            prestm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
