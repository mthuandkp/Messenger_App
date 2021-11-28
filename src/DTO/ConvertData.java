/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;

/**
 *
 * @author mthuan
 */
public class ConvertData {
    public static String Convert_HashMap_To_Json(HashMap<String,String> maps){
        return new Gson().toJson(maps);
    }
    
    public static HashMap<String,String> Convert_JSON_To_HashMap_StringString(String json){
        return new Gson().fromJson(json, new TypeToken<HashMap<String,String>>(){}.getType());
    }
    
    public static Object[] Convert_JSON_To_ObjectArray(String json){
        return new Gson().fromJson(json, new TypeToken<HashMap<String,String>>(){}.getType());
    }
}
