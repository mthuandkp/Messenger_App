/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import BUS.ClassBUS;
import DTO.UserDTO;
import Func.Hyrid_Encryption;
import Func.fileFunc;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

            new Thread(new RunServer(serversocket, privateKey, publicKey)).start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Server();
    }

    private static class RunServer implements Runnable {

        ServerSocket serversocket;
        PrivateKey privateKey;
        PublicKey publicKey;

        public RunServer(ServerSocket serversocket, PrivateKey privateKey, PublicKey publicKey) {
            this.serversocket = serversocket;
            this.privateKey = privateKey;
            this.publicKey = publicKey;
        }

        @Override
        public void run() {
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
                valueData = Hyrid_Encryption.decryptAES(valueData, clientKey);
                System.out.println(valueData);

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
        HashMap<String, String> maps = new Gson().fromJson(readData, new TypeToken<HashMap<String, String>>() {
        }.getType());

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
            case "CHECK_REGISTER_ACCOUNT": {
                return checkregisteraccount(data, clientKey);
            }
            case "GET_ALL_GROUPCHAT_AND_USER": {
                return getAllGroupChatAndUser(data, clientKey);
            }
            case "JOIN_GROUPCHAT": {
                return joinGroupChat(data, clientKey);
            }
            case "LOAD_MESSAGE_GROUPCHAT": {
                return loadMessageGroupChat(data, clientKey);
            }
            case "LEAVE_GROUP_CHAT": {
                return leaveGroupChat(data, clientKey);
            }
            case "ADD_MESSAGE_GROUPCHAT": {
                return addNewMessage(data, clientKey);
            }
            case "VIEW_ALL_MESSAGE_GROUPCHAT": {
                return viewAllMessageGroup(data, clientKey);
            }
            case "ADD_FILE_MESAGE": {
                return addNewFIleMess(data, clientKey);
            }
            case "DOWNLOAD_FILE_MESAGE": {
                return downloadFile(data, clientKey);
            }
            case "ADD_STIKER_GROUPCHAT": {
                return addNewStickerGroup(data, clientKey);
            }
            case "LOGOUT_ACCOUNT":{
                return logoutAccount(data,clientKey);
            }
        }
        return "";
    }

    private String registerNewAccount(String data, String clientKey) {
        UserDTO user = new Gson().fromJson(data, new TypeToken<UserDTO>() {
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
        UserDTO u = bus.getUserByEmail(email);
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
        //Ghi log
        List<String> logUser = fileFunc.readTextFile("./src/file/log.txt");
        logUser.add("User " + str[0] + " đăng nhập vào lúc " + DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));
        
        fileFunc.writeTextFile("./src/file/log.txt", logUser);

        //Chuyen thanh json
        String returnValue = new Gson().toJson(dataMap);
        //Ma hoa du lieu
        return Hyrid_Encryption.encryptAES(returnValue, clientKey);
    }

    private String checkregisteraccount(String data, String clientKey) {
        UserDTO user = new Gson().fromJson(data, new TypeToken<UserDTO>() {
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

    private String getAllGroupChatAndUser(String data, String clientKey) {
        int id = Integer.valueOf(data);
        String result = bus.getAllGroupChatWithoutBlock(id);
        String dataUser = bus.getAllUserWithoutBlock(id);

        //KHOI TAO DU LIEU TRA VE
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("command", "GET_ALL_GROUPCHAT_AND_USER");
        dataMap.put("data_group", result);
        dataMap.put("data_user", dataUser);

        //Chuyen thanh json
        String returnValue = new Gson().toJson(dataMap);
        //Ma hoa du lieu
        return Hyrid_Encryption.encryptAES(returnValue, clientKey);
    }

    private String joinGroupChat(String data, String clientKey) {
        int[] str = new Gson().fromJson(data, new TypeToken<int[]>() {
        }.getType());

        String result = bus.joinGroupChat(str[0], str[1]);

        //KHOI TAO DU LIEU TRA VE
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("command", "JOIN_GROUPCHAT");
        dataMap.put("result", result);

        //Chuyen thanh json
        String returnValue = new Gson().toJson(dataMap);
        //Ma hoa du lieu
        return Hyrid_Encryption.encryptAES(returnValue, clientKey);
    }

    private String loadMessageGroupChat(String data, String clientKey) {
        int[] str = new Gson().fromJson(data, new TypeToken<int[]>() {
        }.getType());

        String result = bus.getMessageGroupChat(str[0], str[1]);

        //KHOI TAO DU LIEU TRA VE
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("command", "LOAD_MESSAGE_GROUPCHAT");
        dataMap.put("data", result);

        //Chuyen thanh json
        String returnValue = new Gson().toJson(dataMap);
        //Ma hoa du lieu
        return Hyrid_Encryption.encryptAES(returnValue, clientKey);
    }

    private String leaveGroupChat(String data, String clientKey) {
        int[] str = new Gson().fromJson(data, new TypeToken<int[]>() {
        }.getType());

        String result = bus.leaveMessageGroupChat(str[0], str[1]);

        //KHOI TAO DU LIEU TRA VE
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("command", "LEAVE_GROUP_CHAT");
        dataMap.put("result", result);

        //Chuyen thanh json
        String returnValue = new Gson().toJson(dataMap);
        //Ma hoa du lieu
        return Hyrid_Encryption.encryptAES(returnValue, clientKey);

    }

    private String addNewMessage(String data, String clientKey) {
        //ADD_MESSAGE_GROUPCHAT
        String[] str = new Gson().fromJson(data, new TypeToken<String[]>() {
        }.getType());
        int idUser = Integer.valueOf(str[0]);
        int idGroup = Integer.valueOf(str[1]);
        String content = str[2];
        bus.addNewGroupMessage(idUser, idGroup, content);

        //KHOI TAO DU LIEU TRA VE
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("command", "ADD_MESSAGE_GROUPCHAT");

        //Chuyen thanh json
        String returnValue = new Gson().toJson(dataMap);
        //Ma hoa du lieu
        return Hyrid_Encryption.encryptAES(returnValue, clientKey);
    }

    private String viewAllMessageGroup(String data, String clientKey) {
        //VIEW_ALL_MESSAGE_GROUPCHAT
        int[] str = new Gson().fromJson(data, new TypeToken<int[]>() {
        }.getType());

        bus.viewAllMessageGroupChat(str[0], str[1]);

        //KHOI TAO DU LIEU TRA VE
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("command", "VIEW_ALL_MESSAGE_GROUPCHAT");

        //Chuyen thanh json
        String returnValue = new Gson().toJson(dataMap);
        //Ma hoa du lieu
        return Hyrid_Encryption.encryptAES(returnValue, clientKey);

    }

    private String addNewFIleMess(String data, String clientKey) {
        //ADD_FILE_MESAGE
        String[] str = new Gson().fromJson(data, new TypeToken<String[]>() {
        }.getType());
        int idUser = Integer.valueOf(str[0]);
        int idGroup = Integer.valueOf(str[1]);
        String filename = str[2];
        byte[] dataFile = new Gson().fromJson(str[3], new TypeToken<byte[]>() {
        }.getType());

        bus.addNewFileMess(idUser, idGroup, filename, dataFile);
        fileFunc.WriteFile("./src/file_Server/" + filename, dataFile);

        //KHOI TAO DU LIEU TRA VE
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("command", "ADD_FILE_MESAGE");

        //Chuyen thanh json
        String returnValue = new Gson().toJson(dataMap);
        //Ma hoa du lieu
        return Hyrid_Encryption.encryptAES(returnValue, clientKey);
    }

    private String downloadFile(String data, String clientKey) {
        File file = new File("./src/file_Server/" + data);
        //KHOI TAO DU LIEU TRA VE
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("command", "DOWNLOAD_FILE_MESAGE");
        if (file.length() == 0) {
            dataMap.put("result", "File không tồn tại");
        } else {
            try {
                byte[] dataFile = fileFunc.convertFileToByte("./src/file_Server/" + data);
                dataMap.put("result", "SUCCESS");
                dataMap.put("message", "Tải file thành công. File được  lưu ở './src/file/" + data + "'");
                dataMap.put("data", new Gson().toJson(dataFile));
                dataMap.put("filename", data);
            } catch (IOException ex) {
                Logger.getLogger(Server_Excecute.class.getName()).log(Level.SEVERE, null, ex);
                dataMap.put("result", "Lỗi khi tải file");
            }
        }

        //Chuyen thanh json
        String returnValue = new Gson().toJson(dataMap);
        //Ma hoa du lieu
        return Hyrid_Encryption.encryptAES(returnValue, clientKey);
    }

    private String addNewStickerGroup(String data, String clientKey) {
        //ADD_STIKER_GROUPCHAT
        String[] str = new Gson().fromJson(data, new TypeToken<String[]>() {
        }.getType());
        int idUser = Integer.valueOf(str[0]);
        int idGroup = Integer.valueOf(str[1]);
        String stickername = str[2];

        bus.addNewStickerGroupMess(idUser, idGroup, stickername);

        //KHOI TAO DU LIEU TRA VE
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("command", "ADD_STIKER_GROUPCHAT");

        //Chuyen thanh json
        String returnValue = new Gson().toJson(dataMap);
        //Ma hoa du lieu
        return Hyrid_Encryption.encryptAES(returnValue, clientKey);
    }

    private String logoutAccount(String data, String clientKey) {
        UserDTO user = new Gson().fromJson(data, new TypeToken<UserDTO>(){}.getType());
        
        bus.logOutAccount(user.getId());
        //LOGOUT_ACCOUNT
        //KHOI TAO DU LIEU TRA VE
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("command", "LOGOUT_ACCOUNT");
        
        //Ghi log
        List<String> logUser = fileFunc.readTextFile("./src/file/log.txt");
        logUser.add("User " + user.getEmail() + " đăng xuất vào lúc " + DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));
        fileFunc.writeTextFile("./src/file/log.txt", logUser);

        //Chuyen thanh json
        String returnValue = new Gson().toJson(dataMap);
        //Ma hoa du lieu
        return Hyrid_Encryption.encryptAES(returnValue, clientKey);
    }
}
