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
public class User {
    int id;
    String email;
    String password;
    String name;
    String sex;
    String birthday;
    boolean status;
    boolean isActive;
    boolean isFriend;

    public User(int id, String email, String password, String name, String sex, String birthday, boolean status, boolean isActive) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.status = status;
        this.isActive = isActive;
    }
    
    public User(String email, String password, String name, String sex, String birthday, boolean status, boolean isActive) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.status = status;
        this.isActive = isActive;
    }
    
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public User(String email, String password, String name, String sex, String birthday) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    public User(int id, String email, String password, String name, String sex, String birthday, boolean status, boolean isActive, boolean isFriend) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.status = status;
        this.isActive = isActive;
        this.isFriend = isFriend;
    }

    public User() {
       
    }

    public boolean isIsFriend() {
        return isFriend;
    }

    public void setIsFriend(boolean isFriend) {
        this.isFriend = isFriend;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday + ", status=" + status + ", isActive=" + isActive + '}';
    }    

    public String toJSON() {
        return new Gson().toJson(this);
    }
}
