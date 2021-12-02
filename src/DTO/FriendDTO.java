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
public class FriendDTO {

    int id_user_01;
    int id_user_02;

    public FriendDTO(int id_user_01, int id_user_02) {
        this.id_user_01 = id_user_01;
        this.id_user_02 = id_user_02;
    }

    public int getId_user_01() {
        return id_user_01;
    }

    public void setId_user_01(int id_user_01) {
        this.id_user_01 = id_user_01;
    }

    public int getId_user_02() {
        return id_user_02;
    }

    public void setId_user_02(int id_user_02) {
        this.id_user_02 = id_user_02;
    }

    @Override
    public String toString() {
        return "FriendDTO{" + "id_user_01=" + id_user_01 + ", id_user_02=" + id_user_02 + '}';
    }
}
