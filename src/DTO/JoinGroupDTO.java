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
public class JoinGroupDTO {
    int id_user;
    int id_group;

    public JoinGroupDTO(int id_user, int id_group) {
        this.id_user = id_user;
        this.id_group = id_group;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    @Override
    public String toString() {
        return "JoinGroupDTO{" + "id_user=" + id_user + ", id_group=" + id_group + '}';
    }
}
