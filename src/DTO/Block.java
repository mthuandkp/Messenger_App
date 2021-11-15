/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author mthuan
 */
public class Block {
    int id_user;
    int id_room;

    public Block(int id_user, int id_room) {
        this.id_user = id_user;
        this.id_room = id_room;
    }

    public Block() {
        
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

    @Override
    public String toString() {
        return "Block{" + "id_user=" + id_user + ", id_room=" + id_room + '}';
    }
    
    
}
