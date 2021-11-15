/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.RoomDAO;
import DAO.UserDAO;
import DTO.Room;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author mthuan
 */
public class RoomBUS {
    RoomDAO userdao = new RoomDAO();
    
    public String getAllRoom(){
        List<Room> listRoom = userdao.getAllRoom();
        HashMap<String,String> maps = new HashMap<>();
        
        maps.put("result","SUCCESS");
        maps.put("data", new Gson().toJson(listRoom));
        
        return new Gson().toJson(maps);
    }
}
