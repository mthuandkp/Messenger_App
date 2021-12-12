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
public class Message_11DTO {
    int id;
    int id_sender;
    int id_received;
    String time;
    String content;
    boolean isURL;
    boolean isOwner;
    String viewer;
    String nameUser;

    public Message_11DTO(int id, int id_sender, int id_received, String time, String content, boolean isURL) {
        this.id = id;
        this.id_sender = id_sender;
        this.id_received = id_received;
        this.time = time;
        this.content = content;
        this.isURL = isURL;
    }

    public Message_11DTO(int id_sender, int id_received, String time, String content, boolean isURL) {
        this.id_sender = id_sender;
        this.id_received = id_received;
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

    public int getId_sender() {
        return id_sender;
    }

    public void setId_sender(int id_sender) {
        this.id_sender = id_sender;
    }

    public int getId_received() {
        return id_received;
    }

    public void setId_received(int id_received) {
        this.id_received = id_received;
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
        return "Message_11DTO{" + "id=" + id + ", id_sender=" + id_sender + ", id_received=" + id_received + ", time=" + time + ", content=" + content + ", isURL=" + isURL + '}';
    }
    
    
}
