/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.UserDAO;
import DTO.User;
import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mthuan
 */
public class UserBUS {
    UserDAO userdao = new UserDAO();
    
    public String checkLogin(String username,String password){
        String result = "";
        HashMap<String,String> maps = new HashMap<>();
                
        User user = userdao.getByUsername(username);
        if(user == null){
            result = "Không tìm thấy tài khoản";
        }
        else{
            if(md5Java(password).compareTo(user.getPassword()) == 0){
                result = "SUCCESS";
                maps.put("data", new Gson().toJson(user));
            }
            else{
                result = "Sai mật khẩu";
            }
        }
       maps.put("result", result);
       return new Gson().toJson(maps);        
    }
    
    public static String md5Java(String message){
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes("UTF-8"));
           
            //converting byte array to Hexadecimal String
           StringBuilder sb = new StringBuilder(2*hash.length);
           for(byte b : hash){
               sb.append(String.format("%02x", b&0xff));
           }
          
           digest = sb.toString();
          
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return digest;
    }
}
