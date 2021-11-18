/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.MessageDAO;
import DAO.ViewMessageDAO;
import DTO.Message;
import DTO.User;
import DTO.View_Message;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author mthuan
 */
public class MessageBUS {
    MessageDAO messDAO = new MessageDAO();
    UserBUS userbus = new UserBUS();
    ViewMessageDAO vmdao = new ViewMessageDAO();

    public String getUserAndMessage() {
        List<User> listUser = userbus.getAllUser();
        List<Message> listMess = messDAO.getAllMessage();
        List<View_Message> listViewMessage = vmdao.getAllViewMess();
        
        HashMap<String,String> returnValue = new HashMap<>();
        returnValue.put("result", "SUCCESS");
        returnValue.put("data_viewmessage", new Gson().toJson(listViewMessage));
        returnValue.put("data_mesage", new Gson().toJson(listMess));
        returnValue.put("data_user", new Gson().toJson(listUser));
        
        
        
        return new Gson().toJson(returnValue);
    }
    
    public static void main(String[] args) {
        MessageBUS m = new MessageBUS();
        
        System.out.println(m.getUserAndMessage());
    }
}
