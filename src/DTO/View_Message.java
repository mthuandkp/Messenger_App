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
public class View_Message {
    int id_mess;
    int id_user;

    public View_Message(int id_mess, int id_user) {
        this.id_mess = id_mess;
        this.id_user = id_user;
    }

    public int getId_mess() {
        return id_mess;
    }

    public void setId_mess(int id_mess) {
        this.id_mess = id_mess;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "View_Message{" + "id_mess=" + id_mess + ", id_user=" + id_user + '}';
    }
}
