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
public class Friend {
    int id_user_1;
    int id_user_2;

    public Friend(int id_user_1, int id_user_2) {
        this.id_user_1 = id_user_1;
        this.id_user_2 = id_user_2;
    }

    public int getId_user_1() {
        return id_user_1;
    }

    public void setId_user_1(int id_user_1) {
        this.id_user_1 = id_user_1;
    }

    public int getId_user_2() {
        return id_user_2;
    }

    public void setId_user_2(int id_user_2) {
        this.id_user_2 = id_user_2;
    }

    @Override
    public String toString() {
        return "Friend{" + "id_user_1=" + id_user_1 + ", id_user_2=" + id_user_2 + '}';
    }
    
    
}
