/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import com.google.gson.Gson;

/**
 *
 * @author mthuan
 */
public class Room {
    int id;
    int id_owner;
    String name;
    boolean group_chat;
    boolean is_join;
    boolean is_block;

    public Room(int id, int id_owner, String name, boolean group_chat) {
        this.id = id;
        this.id_owner = id_owner;
        this.name = name;
        this.group_chat = group_chat;
    }

    public boolean isIs_join() {
        return is_join;
    }

    public void setIs_join(boolean is_join) {
        this.is_join = is_join;
    }

    public boolean isIs_block() {
        return is_block;
    }

    public void setIs_block(boolean is_block) {
        this.is_block = is_block;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_owner() {
        return id_owner;
    }

    public void setId_owner(int id_owner) {
        this.id_owner = id_owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGroup_chat() {
        return group_chat;
    }

    public void setGroup_chat(boolean group_chat) {
        this.group_chat = group_chat;
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", id_owner=" + id_owner + ", name=" + name + ", group_chat=" + group_chat + ", is_join=" + is_join + ", is_block=" + is_block + '}';
    }

    public String toJSON() {
        return new Gson().toJson(this);
    }

    
}
