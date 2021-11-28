/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.time.LocalDateTime;

/**
 *
 * @author mthuan
 */
public class Message {
    int id;
    int id_user;
    int id_room;
    boolean is_url;
    String body;
    String time;
    boolean status;
    String username;

    public Message(int id, int id_user, int id_room, boolean is_url, String body, String time,boolean status) {
        this.id = id;
        this.id_user = id_user;
        this.id_room = id_room;
        this.is_url = is_url;
        this.body = body;
        this.time = time;
        this.status = status;
    }
    
    public Message(int id_user, int id_room, boolean is_url, String body, String time,boolean status) {
        this.id_user = id_user;
        this.id_room = id_room;
        this.is_url = is_url;
        this.body = body;
        this.time = time;
        this.status = status;
    }

    public Message(int id, int id_user, int id_room, boolean is_url, String body, String time, boolean status, String username) {
        this.id = id;
        this.id_user = id_user;
        this.id_room = id_room;
        this.is_url = is_url;
        this.body = body;
        this.time = time;
        this.status = status;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public boolean getType_message() {
        return is_url;
    }

    public void setType_message(boolean is_url) {
        this.is_url = is_url;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isIs_url() {
        return is_url;
    }

    public void setIs_url(boolean is_url) {
        this.is_url = is_url;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", id_user=" + id_user + ", id_room=" + id_room + ", type_message=" + is_url + ", body=" + body + ", time=" + time + '}';
    }
    
}
