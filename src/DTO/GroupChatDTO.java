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
public class GroupChatDTO {
    int id_group;
    int id_owner;
    String name;
    boolean isJoin;
    boolean isBlock;
    String nearlyMessage;

    public GroupChatDTO(int id_group, int id_owner, String name, boolean isJoin, boolean isBlock) {
        this.id_group = id_group;
        this.id_owner = id_owner;
        this.name = name;
        this.isJoin = isJoin;
        this.isBlock = isBlock;
    }
    public GroupChatDTO(int id_group, int id_owner, String name) {
        this.id_group = id_group;
        this.id_owner = id_owner;
        this.name = name;
    }

    public GroupChatDTO(int id_group, int id_owner, String name, boolean isJoin, boolean isBlock, String nearlyMessage) {
        this.id_group = id_group;
        this.id_owner = id_owner;
        this.name = name;
        this.isJoin = isJoin;
        this.isBlock = isBlock;
        this.nearlyMessage = nearlyMessage;
    }
    
    
    

    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
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

    public boolean isIsJoin() {
        return isJoin;
    }

    public void setIsJoin(boolean isJoin) {
        this.isJoin = isJoin;
    }

    public boolean isIsBlock() {
        return isBlock;
    }

    public void setIsBlock(boolean isBlock) {
        this.isBlock = isBlock;
    }

    public String getNearlyMessage() {
        return nearlyMessage;
    }

    public void setNearlyMessage(String nearlyMessage) {
        this.nearlyMessage = nearlyMessage;
    }
    
    
    @Override
    public String toString() {
        return "GroupChatDTO{" + "id_group=" + id_group + ", id_owner=" + id_owner + ", name=" + name + ", isJoin=" + isJoin + ", isBlock=" + isBlock + '}';
    }
}
