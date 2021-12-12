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
public class MessageGroupDTO {
    int id;
    int id_user;
    int id_group;
    String time;
    String content;
    boolean isURL;
    boolean isOwner;
    String viewer;
    String nameUser;

    public MessageGroupDTO(int id, int id_user, int id_group, String time, String content, boolean isURL) {
        this.id = id;
        this.id_user = id_user;
        this.id_group = id_group;
        this.time = time;
        this.content = content;
        this.isURL = isURL;
    }
    
    public MessageGroupDTO(int id_user, int id_group, String time, String content, boolean isURL) {
        
        this.id_user = id_user;
        this.id_group = id_group;
        this.time = time;
        this.content = content;
        this.isURL = isURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isIsURL() {
        return isURL;
    }

    public void setIsURL(boolean isURL) {
        this.isURL = isURL;
    }

    public boolean isIsOwner() {
        return isOwner;
    }

    public void setIsOwner(boolean isOwner) {
        this.isOwner = isOwner;
    }

    public String getViewer() {
        return viewer;
    }

    public void setViewer(String viewer) {
        this.viewer = viewer;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
    
    
    

    @Override
    public String toString() {
        return "MessageGroupDTO{" + "id=" + id + ", id_user=" + id_user + ", id_group=" + id_group + ", time=" + time + ", content=" + content + ", isURL=" + isURL + '}';
    }
}
