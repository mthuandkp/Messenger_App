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
public class UserDTO {
    int id;
    String email;
    String password;
    String name;
    String sex;
    String birthday;
    boolean isOnline;
    boolean isActive;
    boolean isFriend;
    boolean isBlock;
    String lastMessage;
    boolean serverBlock;

    public UserDTO(String email, String password, String name, String sex, String birthday) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    public UserDTO(int id, String email, String password, String name, String sex, String birthday, boolean isOnline, boolean isActive,boolean svBlock) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.isOnline = isOnline;
        this.isActive = isActive;
        this.serverBlock = svBlock;
    }
    
    

    public UserDTO(int id, String email, String password, String name, String sex, String birthday, boolean isOnline, boolean isActive, boolean isFriend, boolean isBlock,boolean svBlock) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.isOnline = isOnline;
        this.isActive = isActive;
        this.isFriend = isFriend;
        this.isBlock = isBlock;
        this.serverBlock = svBlock;
    }

    
    
    

    public UserDTO() {
       
    }

    public UserDTO(String email, String pass) {
        this.email = email;
        this.password = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isIsOnline() {
        return isOnline;
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isIsFriend() {
        return isFriend;
    }

    public void setIsFriend(boolean isFriend) {
        this.isFriend = isFriend;
    }

    public boolean isIsBlock() {
        return isBlock;
    }

    public void setIsBlock(boolean isBlock) {
        this.isBlock = isBlock;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public boolean isServerBlock() {
        return serverBlock;
    }

    public void setServerBlock(boolean serverBlock) {
        this.serverBlock = serverBlock;
    }
    
    
    
    

    @Override
    public String toString() {
        return "UserDTO{" + "id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday + ", isOnline=" + isOnline + ", isActive=" + isActive + ", isFriend=" + isFriend + ", isBlock=" + isBlock + '}';
    }

    public String toJSON() {
        return new Gson().toJson(this);
    }
}
