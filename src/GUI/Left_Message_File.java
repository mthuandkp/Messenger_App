/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Func.Hyrid_Encryption;
import Func.fileFunc;
import Network.Config;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author mthuan
 */
public class Left_Message_File extends javax.swing.JPanel {

    String name;
    String content;
    String time;
    String view;
    String status;

    String PUBLIC_KEY_SERVER = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCbPndbAp25koChNaXO9XfZHLBEVKWedG5c2Inio657AePBaYzYISc2ucXwHDzn+xJsFbthGzyt+CYsnVdrtwpVB3Pv7TpWnj2W2l0yG5vrOjsUERVBaC+6Mk1+RNXRimqxCJDtJTtXeB9/bZGXBe4WcPXUhwIB563JPyAGTyeVnwIDAQAB";
    String randomKey;
    PublicKey pKeyServer;

    /**
     * Creates new form Left_Message
     */
    public Left_Message_File(String name, String content, String time, String view, String status) {
        this.name = name;
        this.content = content;
        this.time = time;
        this.view = view;
        this.status = status;
        initComponents();
        initDisplay();
        initSocket();
    }

    private void initSocket() {
        try {

            //Tao random key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256); // for example
            SecretKey secretKey = keyGen.generateKey();
            randomKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            pKeyServer = Hyrid_Encryption.getPublicKeyRSA(PUBLIC_KEY_SERVER);

        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        name_user = new javax.swing.JLabel();
        status_mess = new javax.swing.JLabel();
        time_mess = new javax.swing.JLabel();
        view_mess = new javax.swing.JLabel();
        file_name = new javax.swing.JLabel();
        downloadBtn = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setRequestFocusEnabled(false);

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        name_user.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        name_user.setForeground(new java.awt.Color(38, 139, 250));
        name_user.setText("jLabel1");

        status_mess.setFont(new java.awt.Font("Arimo", 0, 18)); // NOI18N
        status_mess.setForeground(new java.awt.Color(2, 159, 12));
        status_mess.setText("jLabel1");

        time_mess.setFont(new java.awt.Font("Arimo", 0, 18)); // NOI18N
        time_mess.setForeground(new java.awt.Color(239, 124, 2));
        time_mess.setText("jLabel1");

        view_mess.setFont(new java.awt.Font("Arimo", 0, 16)); // NOI18N
        view_mess.setForeground(new java.awt.Color(196, 174, 41));
        view_mess.setText("jLabel1");

        file_name.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N

        downloadBtn.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        downloadBtn.setText("Tải");
        downloadBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                downloadBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(status_mess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(view_mess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(time_mess, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(downloadBtn)
                            .addComponent(file_name, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name_user, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 80, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(name_user)
                .addGap(26, 26, 26)
                .addComponent(file_name, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(downloadBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(status_mess)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(time_mess)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(view_mess)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 173, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void downloadBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downloadBtnMouseClicked
        try {
            // TODO add your handling code here:
            String filename = file_name.getText();
            if (filename.compareTo("") == 0 || !filename.contains(".")) {
                JOptionPane.showMessageDialog(null, "Lỗi tải file ");
                return;
            }

            Socket socket = new Socket(Config.HOST, Config.PORT);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            HashMap<String, String> maps = new HashMap<>();

            //Khoi tao data          
            maps.put("command", "DOWNLOAD_FILE_MESAGE");
            maps.put("data", filename);
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

            //Doc ket qua tu server
            String inputStr = input.readLine();

            //Giai ma du lieu
            inputStr = Hyrid_Encryption.decryptAES(inputStr, randomKey);
            //ep kieu thanh hashmap
            maps = new Gson().fromJson(inputStr, new TypeToken<HashMap<String, String>>() {
            }.getType());

            switch (maps.get("command")) {
                case "DOWNLOAD_FILE_MESAGE": {
                    String result = maps.get("result");
                    if (result != null && result.compareTo("SUCCESS") == 0) {
                        filename = maps.get("filename");
                        byte[] datafile = new Gson().fromJson(maps.get("data"), new TypeToken<byte[]>() {
                        }.getType());

                        fileFunc.WriteFile("./src/file/" + filename, datafile);

                        Desktop.getDesktop().open(new File("./src/file/" + filename));
                    }
                    JOptionPane.showMessageDialog(null, maps.get("message"));
                    break;
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }//GEN-LAST:event_downloadBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton downloadBtn;
    private javax.swing.JLabel file_name;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel name_user;
    private javax.swing.JLabel status_mess;
    private javax.swing.JLabel time_mess;
    private javax.swing.JLabel view_mess;
    // End of variables declaration//GEN-END:variables

    private void initDisplay() {
        view = view.compareTo("") == 0 ? "Chưa ai xem" : (view + " đã xem");
        name_user.setText(name);
        status_mess.setText(status);
        time_mess.setText(time);
        view_mess.setText(view);

        Container conn = new Container();
        JPanel p = new JPanel();
        List<String> listStr = splitWord(content, 70);
        for (int i = 0; i < listStr.size(); i++) {
            JLabel label = new JLabel(listStr.get(i));
            label.setHorizontalAlignment(JLabel.LEFT);
            label.setFont(new Font("Arimo", Font.PLAIN, 18));
            p.add(label);
        }

        p.setVisible(true);
        p.setLayout(new GridLayout(100, 1));
        //p.setSize(500,500);
        conn.add(p);
        conn.setLayout(new GridLayout(1, 1));
        file_name.setText(content);
    }

    private List<String> splitWord(String s, int number) {
        List<String> listStr = new ArrayList<>();
        int i = 0;
        while (s.length() > number) {
            if (i < s.length() && (i >= number) && s.charAt(i) == ' ') {
                listStr.add(s.substring(0, i));
                s = s.substring(i);
                i = 0;
            } else {
                i++;
            }
        }
        listStr.add(s);
        return listStr;
    }

    @Override
    public String toString() {
        return name_user.getText() + status_mess.getText() + time_mess.getText() + view_mess.getText() + content;
    }
}
