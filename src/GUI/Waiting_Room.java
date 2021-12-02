/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.GroupChatDTO;
import DTO.UserDTO;
import Func.Hyrid_Encryption;
import Network.Config;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author mthuan
 */
public class Waiting_Room extends javax.swing.JFrame {

    UserDTO user;
    Socket socket;
    String PUBLIC_KEY_SERVER = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCbPndbAp25koChNaXO9XfZHLBEVKWedG5c2Inio657AePBaYzYISc2ucXwHDzn+xJsFbthGzyt+CYsnVdrtwpVB3Pv7TpWnj2W2l0yG5vrOjsUERVBaC+6Mk1+RNXRimqxCJDtJTtXeB9/bZGXBe4WcPXUhwIB563JPyAGTyeVnwIDAQAB";
    String randomKey;
    PublicKey pKeyServer;

    /**
     * Creates new form Chat_Room
     */
    public Waiting_Room() {
        this.user = new UserDTO(1, "pnmthuan@gmail.com", "123", "Phạm Nguyễn Minh Thuận", randomKey, randomKey, true, true, true);
        //this.user = new UserDTO(2, "pnmthuan@gmail.com", "123", "Do nhi Khang", randomKey, randomKey, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        initComponents();
        initSocket();
        name_user.setText(user.getName() + "(" + user.getEmail() + ")");
    }

    public Waiting_Room(UserDTO user) {
        this.user = user;
        initComponents();
        initSocket();
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        name_user.setText(user.getName() + "(" + user.getEmail() + ")");
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list_room = new javax.swing.JScrollPane();
        list_user = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        name_user = new javax.swing.JLabel();
        time_system = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arimo", 0, 18)); // NOI18N
        jLabel1.setText("Danh sách chat nhóm");

        jLabel2.setFont(new java.awt.Font("Arimo", 0, 18)); // NOI18N
        jLabel2.setText("Danh sách người dùng");

        jPanel1.setBackground(new java.awt.Color(193, 193, 193));

        jButton1.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        jButton1.setText("Xem phòng chat nhóm bị khóa");

        jButton2.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        jButton2.setText("Xem người dùng bị chặn");

        jButton3.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        jButton3.setText("Xem friend list");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(0, 287, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(0, 52, Short.MAX_VALUE))
        );

        exitBtn.setBackground(new java.awt.Color(255, 0, 0));
        exitBtn.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        exitBtn.setForeground(new java.awt.Color(254, 254, 254));
        exitBtn.setText("Đăng xuất");
        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBtnMouseClicked(evt);
            }
        });

        name_user.setFont(new java.awt.Font("Arimo", 1, 24)); // NOI18N
        name_user.setForeground(new java.awt.Color(213, 42, 222));
        name_user.setText("jLabel3");

        time_system.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(list_room, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(list_user, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(336, 336, 336))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(name_user, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(time_system, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitBtn))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(exitBtn)
                        .addComponent(time_system))
                    .addComponent(name_user))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(list_room, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(list_user, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        // TODO add your handling code here:
        int choose = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (choose != 0) {
            return;
        }

        new Thread(new logoutAccount(socket, user, pKeyServer)).start();
    }//GEN-LAST:event_exitBtnMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Waiting_Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Waiting_Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Waiting_Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Waiting_Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Waiting_Room().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane list_room;
    private javax.swing.JScrollPane list_user;
    private javax.swing.JLabel name_user;
    private javax.swing.JLabel time_system;
    // End of variables declaration//GEN-END:variables

    private void initSocket() {
        try {
            socket = new Socket(Config.HOST, Config.PORT);
            //Tao random key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256); // for example
            SecretKey secretKey = keyGen.generateKey();
            randomKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            pKeyServer = Hyrid_Encryption.getPublicKeyRSA(PUBLIC_KEY_SERVER);

            new Thread(new Read_Client(socket, randomKey, list_room, list_user, user)).start();
            new Thread(new getAllChatGroupAndUser(socket, randomKey, pKeyServer)).start();
            new Thread(new loadTimeWaitingRoom(time_system)).start();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối đến Server " + ex.getMessage(), "Cảnh báo", JOptionPane.YES_NO_OPTION);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Register_2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    class loadTimeWaitingRoom implements Runnable {

        JLabel label;

        public loadTimeWaitingRoom(JLabel label) {
            this.label = label;
        }

        @Override
        public void run() {
            while (true) {
                this.label.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd:MM-yyyy")));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(loadTimeWaitingRoom.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private class logoutAccount implements Runnable {

        Socket socket;
        UserDTO user;
        PublicKey pKeyServer;

        public logoutAccount(Socket socket, UserDTO user, PublicKey pKeyServer) {
            this.socket = socket;
            this.user = user;
            this.pKeyServer = pKeyServer;
        }

        @Override
        public void run() {
            try {
                BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                while (true) {
                    HashMap<String, String> maps = new HashMap<>();
                    //Khoi tao data          
                    maps.put("command", "LOGOUT_ACCOUNT");
                    maps.put("data", user.toJSON());
                    //Ma hoa du lieu
                    String data = new Gson().toJson(maps);
                    data = Hyrid_Encryption.encryptAES(data, randomKey);
                    //Ma hoa randomkey
                    String encryptRandomKey = Hyrid_Encryption.encryptRSA(randomKey, pKeyServer);
                    //Tao du lieu gui den server                     
                    HashMap<String, String> sendServer = new HashMap<>();
                    sendServer.put("key", encryptRandomKey);
                    sendServer.put("value", data);
                    String strSend = new Gson().toJson(sendServer);

                    output.write(strSend);
                    output.newLine();
                    output.flush();
                    Thread.sleep(Config.DELAY_TIME);
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    // Doc du lieu tat ca cac phong va nguoi dung
    private class getAllChatGroupAndUser implements Runnable {

        Socket socket;
        String randomKey;
        PublicKey pKeyServer;

        public getAllChatGroupAndUser(Socket socket, String randomKey, PublicKey pKeyServer) {
            this.socket = socket;
            this.randomKey = randomKey;
            this.pKeyServer = pKeyServer;
        }

        @Override
        public void run() {
            try {
                BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                while (true) {
                    HashMap<String, String> maps = new HashMap<>();
                    //Khoi tao data          
                    maps.put("command", "GET_ALL_GROUPCHAT_AND_USER");
                    maps.put("data", String.valueOf(user.getId()));
                    //Ma hoa du lieu
                    String data = new Gson().toJson(maps);
                    data = Hyrid_Encryption.encryptAES(data, randomKey);
                    //Ma hoa randomkey
                    String encryptRandomKey = Hyrid_Encryption.encryptRSA(randomKey, pKeyServer);
                    //Tao du lieu gui den server                     
                    HashMap<String, String> sendServer = new HashMap<>();
                    sendServer.put("key", encryptRandomKey);
                    sendServer.put("value", data);
                    String strSend = new Gson().toJson(sendServer);

                    output.write(strSend);
                    output.newLine();
                    output.flush();
                    Thread.sleep(Config.DELAY_TIME);
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private class Read_Client implements Runnable {

        Socket socket;
        String randomKey;
        JScrollPane scroll;
        JScrollPane scroll_user;
        UserDTO user;

        public Read_Client(Socket s, String randomKey, JScrollPane scroll, JScrollPane scroll_u, UserDTO user) {
            this.socket = s;
            this.randomKey = randomKey;
            this.scroll = scroll;
            this.user = user;
            this.scroll_user = scroll_u;
        }

        @Override
        public void run() {
            BufferedReader bufferRead = null;
            try {
                bufferRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String currentContentGroup = "";
                String currentContentUser = "";
                while (true) {
                    String input = bufferRead.readLine();
                    if (input == null) {
                        break;
                    }
                    //Gia ma du lieu
                    input = Hyrid_Encryption.decryptAES(input, randomKey);
                    //ep kieu thanh hashmap
                    HashMap<String, String> maps = new Gson().fromJson(input, new TypeToken<HashMap<String, String>>() {
                    }.getType());

                    switch (maps.get("command")) {
                        case "GET_ALL_GROUPCHAT_AND_USER": {
                            //data_group
                            List<GroupChatDTO> listGroupChat = new Gson().fromJson(maps.get("data_group"), new TypeToken<List<GroupChatDTO>>() {
                            }.getType());
                            List<UserDTO> listUser = new Gson().fromJson(maps.get("data_user"), new TypeToken<List<UserDTO>>() {
                            }.getType());
                            String contentGroup = "";
                            String contentUser = "";

                            Container conn = new Container();
                            for (GroupChatDTO groupchat : listGroupChat) {
                                JPanel p = new Group_Item(groupchat, user);
                                p.setSize(480, 150);
                                p.setVisible(true);
                                contentGroup += ((Group_Item) p).toString();
                                conn.add(p);
                            }

                            if (contentGroup.compareTo(currentContentGroup) != 0) {
                                conn.setLayout(new GridLayout(listGroupChat.size(), 1));
                                scroll.getViewport().setView(conn);
                                currentContentGroup = contentGroup;
                            }

                            conn = new Container();
                            for (UserDTO user : listUser) {
                                JPanel p = new User_item(user);
                                p.setSize(480, 150);
                                p.setVisible(true);
                                contentUser += ((User_item) p).toString();
                                conn.add(p);
                            }

                            if (contentUser.compareTo(currentContentUser) != 0) {

                                conn.setLayout(new GridLayout(listUser.size(), 1));
                                scroll_user.getViewport().setView(conn);
                                currentContentUser = contentUser;
                            }
                            break;
                        }
                        case "LOGOUT_ACCOUNT": {
                            System.exit(0);
                        }
                    }
                }

                bufferRead.close();
                socket.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
