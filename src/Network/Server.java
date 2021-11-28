/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import BUS.ClassBUS;
import DTO.ConvertData;
import DTO.Hyrid_Encryption;
import DTO.Room;
import DTO.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mthuan
 */
public class Server {

    ServerSocket serversocket = null;
    PrivateKey privateKey = null;
    PublicKey publicKey = null;

    String PUBLIC_KEY_STRING = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCbPndbAp25koChNaXO9XfZHLBEVKWedG5c2Inio657AePBaYzYISc2ucXwHDzn+xJsFbthGzyt+CYsnVdrtwpVB3Pv7TpWnj2W2l0yG5vrOjsUERVBaC+6Mk1+RNXRimqxCJDtJTtXeB9/bZGXBe4WcPXUhwIB563JPyAGTyeVnwIDAQAB";
    String PRIVATE_KEY_STRING = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAJs+d1sCnbmSgKE1pc71d9kcsERUpZ50blzYieKjrnsB48FpjNghJza5xfAcPOf7EmwVu2EbPK34JiydV2u3ClUHc+/tOlaePZbaXTIbm+s6OxQRFUFoL7oyTX5E1dGKarEIkO0lO1d4H39tkZcF7hZw9dSHAgHnrck/IAZPJ5WfAgMBAAECgYEAkySI8m0vW+W9H49+wgOtfc6QT6O/esm2lS/0uSkVRqfK3NaTVYNO7LL2JphNLj+t/V43xVmQkQAkBqN3abQLCIR961M4eaBwpLAOQtJKALH+fnsiUCCWwbioO3PTfyOpH3injfLvE4NhyoQeazx+AKSkZyro2CG5U/LBsJJWXzECQQDQ6bYILy2WUuqWKwIbGSwDZPdc4T724PFECzdZki1O1gw6PPhdoasUOt0OZrT0rqJ71YF0MdAeykHMYn2PEWtHAkEAvjwOEIgqtFpe6nGNZDiZ+5i/sV5bxW5o/YQWwf106nxR0CQlqfwevrIJvMDUUKs7QTAeMT+pcWnK7eW3DoB+6QJBAICGeA3a8IHd6yKNvRLszo4cDK6giLsbsnK5L8k0TBmHSCiAIBCCiJy+hgb5GvS5h48F0Emq5645ondaVIKzJbsCQQCx4LXF/4zu1xGpZkQvUj2pZEraLsDg+zxw0PH2smiAWX6mgSY2q+iTpyYzuJrOU040xil1I3Hs+l8l04Y3qS8BAkBIHOR887VNtejYOVcwrUHpcKcccVPAKxsoxBBziOxD0alGHtvop7CU1VVfcnQtZ7Dd1sSj4MNgguW92s0/rXNg";

    public Server() {
        try {
            serversocket = new ServerSocket(Config.PORT);
            //Tao public key
            publicKey = Hyrid_Encryption.getPublicKeyRSA(PUBLIC_KEY_STRING);
            //Tao private key
            privateKey = Hyrid_Encryption.getPrivateKeyRSA(PRIVATE_KEY_STRING);
            Run();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

    public void Run() {
        System.out.println("Server is running..");
        Socket socket = null;
        while (true) {
            try {
                socket = serversocket.accept();
                Thread serverExecute = new Thread(new Server_Excecute(socket, publicKey, privateKey));
                serverExecute.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Server();
    }

}

class Server_Excecute implements Runnable {

    Socket socket = null;
    PrivateKey privateKey = null;
    PublicKey publicKey = null;
    ClassBUS bus = new ClassBUS();

    public Server_Excecute(Socket s, PublicKey pKey, PrivateKey priKey) {
        this.socket = s;
        this.publicKey = pKey;
        this.privateKey = priKey;
    }

    @Override
    public void run() {
        BufferedReader input = null;
        BufferedWriter output = null;
        String readData = null;
        String result = null;
        try {

            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true) {
                //Create input and output 

                //Read data from client
                readData = input.readLine();
                if (readData == null) {
                    return;
                }

                HashMap<String, String> readClient = new Gson().fromJson(readData, new TypeToken<HashMap<String, String>>() {
                }.getType());
                
                String encryptKey = readClient.get("key");
                String valueData = readClient.get("value");
                //Giai ma key ma hoa
                String clientKey = Hyrid_Encryption.decryptRSA(encryptKey, privateKey);
                //Giai ma du lieu dua tren key da giai ma
                valueData = Hyrid_Encryption.decryptAES(valueData, clientKey);System.out.println(valueData);

                //Execute command
                result = executeCommand(valueData, clientKey);
                if (result == null) {
                    continue;
                }
                //Send result to Client
                output.write(result);
                output.newLine();
                output.flush();

                Thread.sleep(500);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(Server_Excecute.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                input.close();
                output.close();
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(Server_Excecute.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String executeCommand(String readData, String clientKey) {
        // Split data from input
        HashMap<String, String> maps = ConvertData.Convert_JSON_To_HashMap_StringString(readData);
        

        String command = maps.get("command");
        String data = maps.get("data");

        switch (command) {
            case "REGISTER_ACCOUNT": {
                return registerNewAccount(data, clientKey);
            }
            case "RESEND_OTP": {
                return sendOTP(data, clientKey);
            }
            case "ACTIVE_ACCOUNT": {
                return activeAccount(data, clientKey);
            }
            case "LOGIN_ACCOUNT": {
                return loginAccount(data, clientKey);
            }
            case "LOAD_ALL_ROOM": {
                return loadAllRoom(data, clientKey);
            }
            case "ACCOUNT_OFFLINE": {
                return accountOffline(data, clientKey);
            }
            case "BLOCK_ROOM": {
                return Block_room(data, clientKey);
            }
            case "UNBLOCK_ROOM": {
                return UnBlock_room(data, clientKey);
            }
            case "JOIN_ROOM": {
                return joinRoom(data, clientKey);
            }
            case "LOAD_ALL_MESSAGE": {
                return loadAllMessage(data, clientKey);
            }
            case "CHECK_REGISTER_ACCOUNT":{
                return checkregisteraccount(data,clientKey);
            }
            case "ADD_NEW_MESSAGE":{
                return addNewMessage(data,clientKey);
            }
            case "VIEW_ALL_MESSAGE":{
                return viewAllMessage(data,clientKey);
            }
        }

        return "";
    }

    private String registerNewAccount(String data, String clientKey) {
        User user = new Gson().fromJson(data, new TypeToken<User>() {
        }.getType());
        String result = bus.addNewAccount(user);

        //KHOI TAO DU LIEU TRA VE
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("command", "REGISTER_ACCOUNT");
        dataMap.put("result", result);

        //Chuyen thanh json
        String returnValue = new Gson().toJson(dataMap);
        //Ma hoa du lieu
        return Hyrid_Encryption.encryptAES(returnValue, clientKey);
    }

    private String sendOTP(String data, String clientKey) {
        Random rd = new Random();
        int code = rd.nextInt(99999) + 1111;
        String email = data;
        User u = bus.getUserByEmail(email);
        String title = "Kích hoạt tài khoản";
        String html = "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><title>OTP</title></head><body><div class=\"container\" ><div class=\"alert-box\" style=\"width: 50%;height: 50%;display: block;margin: auto;border: 1px solid gray;\"><div class=\"header\" style=\"background-color: #0052cc;\"><p style=\"text-align: center;padding: 20px 0;bottom: 0%;font-size: 35px;color: white;\">XÁC MINH TÀI KHOẢN</p></div><div class=\"content\" style=\"text-align: center;\"><p style=\"font-size: 20px;\">Xin chào," + u.getName() + "</p><p style=\"font-size: 20px;\">Hãy sử dụng mã xác minh bên dưới để có thể hoàn thành đăng ký tài khoản của bạn: </p><p style=\"font-size: 50px;font-weight: bold;color: red;border: 2px solid gray;width: 50%;margin:auto\">" + String.valueOf(code) + "</p><p style=\"font-size: 20px;\">Mã xác nhận chỉ tồn tại trong 10 phút</p><p style=\"font-size: 15px;\">©ChatApp.</p></div></div></div></body></html>";

        new Thread(new SendEmail(email, title, html)).start();

        HashMap<String, String> maps = new HashMap<>();
        maps.put("command", "RESEND_OTP");
        maps.put("code", String.valueOf(code));

        String returnData = new Gson().toJson(maps);
        return Hyrid_Encryption.encryptAES(returnData, clientKey);
    }

    private String activeAccount(String data, String clientKey) {
        String email = data;
        String result = bus.activeAccout(email);

        //KHOI TAO DU LIEU TRA VE
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("command", "ACTIVE_ACCOUNT");
        dataMap.put("result", result);

        //Chuyen thanh json
        String returnValue = new Gson().toJson(dataMap);
        //Ma hoa du lieu
        return Hyrid_Encryption.encryptAES(returnValue, clientKey);
    }

    private String loginAccount(String data, String clientKey) {
        String[] str = new Gson().fromJson(data, new TypeToken<String[]>() {
        }.getType());
        String result = bus.checkLogin(str[0], str[1]);

        //KHOI TAO DU LIEU TRA VE
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("command", "LOGIN_ACCOUNT");
        dataMap.put("result", result);
        dataMap.put("user", new Gson().toJson(bus.getUserByEmail(str[0])));

        //Chuyen thanh json
        String returnValue = new Gson().toJson(dataMap);
        //Ma hoa du lieu
        return Hyrid_Encryption.encryptAES(returnValue, clientKey);
    }

    private String loadAllRoom(String data, String clientKey) {
        User user = new Gson().fromJson(data, new TypeToken<User>() {
        }.getType());
        List<Room> room = bus.getAllRoom_Rblock_R11JoinByIdUser(user.getId());
        String strData = new Gson().toJson(room);
        //KHOI TAO DU LIEU TRA VE
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("command", "LOAD_ALL_ROOM");
        dataMap.put("data", strData);

        //Chuyen thanh json
        String returnValue = new Gson().toJson(dataMap);
        //Ma hoa du lieu
        return Hyrid_Encryption.encryptAES(returnValue, clientKey);
    }

    private String accountOffline(String data, String clientKey) {
        User user = new Gson().fromJson(data, new TypeToken<User>() {
        }.getType());

        bus.accountOffline(user.getEmail(), false);
        //KHOI TAO DU LIEU TRA VE
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("command", "ACCOUNT_OFFLINE");

        //Chuyen thanh json
        String returnValue = new Gson().toJson(dataMap);
        //Ma hoa du lieu
        return Hyrid_Encryption.encryptAES(returnValue, clientKey);
    }

    private String Block_room(String data, String clientKey) {
        String[] str = new Gson().fromJson(data, new TypeToken<String[]>() {
        }.getType());
        String result = bus.blockUserById(str[0], str[1]);

        //KHOI TAO DU LIEU TRA VE
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("command", "BLOCK_ROOM");
        dataMap.put("result", result);

        //Chuyen thanh json
        String returnValue = new Gson().toJson(dataMap);
        //Ma hoa du lieu
        return Hyrid_Encryption.encryptAES(returnValue, clientKey);

    }

    private String UnBlock_room(String data, String clientKey) {
        String[] str = new Gson().fromJson(data, new TypeToken<String[]>() {
        }.getType());
        String result = bus.unblockUserById(str[0], str[1]);

        //KHOI TAO DU LIEU TRA VE
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("command", "UNBLOCK_ROOM");
        dataMap.put("result", result);

        //Chuyen thanh json
        String returnValue = new Gson().toJson(dataMap);
        //Ma hoa du lieu
        return Hyrid_Encryption.encryptAES(returnValue, clientKey);

    }

    private String joinRoom(String data, String clientKey) {
        String[] str = new Gson().fromJson(data, new TypeToken<String[]>() {
        }.getType());
        String result = bus.joinRoom(str[0], str[1]);

        //KHOI TAO DU LIEU TRA VE
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("command", "JOIN_ROOM");
        dataMap.put("result", result);

        //Chuyen thanh json
        String returnValue = new Gson().toJson(dataMap);
        //Ma hoa du lieu
        return Hyrid_Encryption.encryptAES(returnValue, clientKey);
    }

    private String loadAllMessage(String data, String clientKey) {
        Room room = new Gson().fromJson(data, new TypeToken<Room>() {
        }.getType());
        String result = bus.loadAllMessByIdRoom(room);
        //KHOI TAO DU LIEU TRA VE
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("command", "LOAD_ALL_MESSAGE");
        dataMap.put("data", result);
        dataMap.put("data_view",bus.getAllViewMess());

        //Chuyen thanh json
        String returnValue = new Gson().toJson(dataMap);
        //Ma hoa du lieu
        return Hyrid_Encryption.encryptAES(returnValue, clientKey);
    }

    private String checkregisteraccount(String data, String clientKey) {
        User user = new Gson().fromJson(data, new TypeToken<User>() {
        }.getType());
        String result = bus.checkNewAccount(user);

        //KHOI TAO DU LIEU TRA VE
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("command", "CHECK_REGISTER_ACCOUNT");
        dataMap.put("result", result);

        //Chuyen thanh json
        String returnValue = new Gson().toJson(dataMap);
        //Ma hoa du lieu
        return Hyrid_Encryption.encryptAES(returnValue, clientKey);
    }

    private String addNewMessage(String data, String clientKey) {
        String []str = new Gson().fromJson(data, new TypeToken<String[]>(){}.getType());
        int idRoom = Integer.valueOf(str[0]);
        int idUser = Integer.valueOf(str[1]);
        String chatcontent = str[2];
        
        bus.addNewMessage(idRoom,idUser,chatcontent);
        
        //KHOI TAO DU LIEU TRA VE
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("command", "ADD_NEW_MESSAGE");
        //Chuyen thanh json
        String returnValue = new Gson().toJson(dataMap);
        //Ma hoa du lieu
        return Hyrid_Encryption.encryptAES(returnValue, clientKey);
    }

    private String viewAllMessage(String data, String clientKey) {
        String []str = new Gson().fromJson(data, new TypeToken<String[]>(){}.getType());
        int idRoom = Integer.valueOf(str[0]);
        int idUser = Integer.valueOf(str[1]);
        
        
        bus.ViewAllMessage(idRoom,idUser);
        
        //KHOI TAO DU LIEU TRA VE
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("command", "ADD_NEW_MESSAGE");
        //Chuyen thanh json
        String returnValue = new Gson().toJson(dataMap);
        //Ma hoa du lieu
        return Hyrid_Encryption.encryptAES(returnValue, clientKey);
    }
}
