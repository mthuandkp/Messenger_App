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
public class BlockUserDTO {
    int id_user;
    int id_usr_block;

    public BlockUserDTO(int id_user, int id_usr_block) {
        this.id_user = id_user;
        this.id_usr_block = id_usr_block;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_usr_block() {
        return id_usr_block;
    }

    public void setId_usr_block(int id_usr_block) {
        this.id_usr_block = id_usr_block;
    }

    @Override
    public String toString() {
        return "BlockUserDTO{" + "id_user=" + id_user + ", id_usr_block=" + id_usr_block + '}';
    }
}
