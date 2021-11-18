/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import BUS.MessageBUS;
import BUS.RoomBUS;
import BUS.UserBUS;
import DTO.Message;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mthuan
 */
public class Server {

    ServerSocket ss;
    int port;
    public static ArrayList<Socket> listSocket = new ArrayList<>();

    public Server(int port) {
        this.port = port;
    }

    public void execute() {
        try {
            ServerSocket ss = new ServerSocket(port);
            while (true) {
                Socket s = ss.accept();
                listSocket.add(s);
                Thread t = new Thread(new childThread(s));

                t.start();

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        Server server = new Server(8888);
        server.execute();
    }

}

class childThread extends Thread {
    Socket s;
    
    public childThread(Socket s){
        this.s = s;
    }
    @Override
    public void run() {
       
            try {
                 while (true) {
                //Socket s = new Socket("127.0.0.1",8888);
                DataInputStream input = new DataInputStream(s.getInputStream());
                DataOutputStream output = new DataOutputStream(s.getOutputStream());

                String line = input.readUTF();System.out.println(line);
                HashMap<String, String> maps = new Gson().fromJson(line, new TypeToken<HashMap<String, String>>() {
                }.getType());
                String result = executeCommand(maps);
                output.writeUTF(result);
                }
            } catch (IOException ex) {
                Logger.getLogger(childThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    public String executeCommand(HashMap<String, String> maps) {
        String cmd = maps.get("command");
        String data = maps.get("data");
        Object[] obj = new Gson().fromJson(data, new TypeToken<Object[]>() {
        }.getType());

        switch (cmd) {
            case "CHECK_LOGIN": {
                UserBUS userbus = new UserBUS();
                return userbus.checkLogin(
                        String.valueOf(obj[0]),
                        String.valueOf(obj[1])
                );
            }
            case "GET_ALL_ROOM": {
                RoomBUS roomBus = new RoomBUS();
                return roomBus.getAllRoom();
            }
            case "GET_ALL_MESSAGE_USER":{
                MessageBUS messbus = new MessageBUS();
                return messbus.getUserAndMessage();
            }
                
        }
        return "";
    }
}
