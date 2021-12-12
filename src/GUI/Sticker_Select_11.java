package GUI;

import DTO.UserDTO;
import Func.Hyrid_Encryption;
import Network.Config;
import com.google.gson.Gson;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Base64;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Sticker_Select_11 extends javax.swing.JFrame {

    UserDTO user;
    UserDTO userReceive;
    Socket socket;
    String PUBLIC_KEY_SERVER = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCbPndbAp25koChNaXO9XfZHLBEVKWedG5c2Inio657AePBaYzYISc2ucXwHDzn+xJsFbthGzyt+CYsnVdrtwpVB3Pv7TpWnj2W2l0yG5vrOjsUERVBaC+6Mk1+RNXRimqxCJDtJTtXeB9/bZGXBe4WcPXUhwIB563JPyAGTyeVnwIDAQAB";
    String randomKey;
    PublicKey pKeyServer;
    JScrollPane scrollChat;
    final String[] listStiker = {"sticker1.gif", "sticker2.gif", "sticker3.gif", "sticker4.gif", "sticker5.gif", "sticker6.gif", "sticker7.gif", "sticker8.gif", "sticker9.gif", "sticker10.gif","sticker11.gif","sticker12.gif","sticker13.gif","sticker14.gif","sticker15.gif","sticker16.gif","sticker17.gif","sticker18.gif"};
    
    public Sticker_Select_11() {
        initComponents();
        loadSticker();
    }

    public Sticker_Select_11(UserDTO user, UserDTO userReceive, JScrollPane scroll) {
        this.user = user;
        this.userReceive = userReceive;
        this.scrollChat = scroll;
        initComponents();
        loadSticker();
        initSocket();
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(991, 629));

        jLabel1.setFont(new java.awt.Font("Arimo", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(253, 48, 14));
        jLabel1.setText("Lựa chọn sticker:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 691, Short.MAX_VALUE))
            .addComponent(scroll)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Sticker_Select_11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sticker_Select_11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sticker_Select_11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sticker_Select_11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sticker_Select_11().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables

    private void loadSticker() {
        Container container = new Container();
        for (String s : listStiker) {
            JLabel label = new JLabel();
            label.setSize(200, 200);
            ImageIcon imageIcon = new ImageIcon(new ImageIcon("./src/img/Sticker/" + s)
                    .getImage()
                    .getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));

            label.setIcon(imageIcon);
            label.setVisible(true);

            container.add(label);
            label.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    int choose = JOptionPane.showConfirmDialog(null, "Bạn có muốn chọn stiker này ?", "", JOptionPane.YES_NO_OPTION);
                    if (choose != 0) {
                        return;
                    }

                    //Them vao chat
                    Container container = null;
                    if (scrollChat.getViewport().getView() != null) {
                        for (Component c : scrollChat.getViewport().getComponents()) {
                            if (c instanceof Container) {
                                container = (Container) c;
                                break;
                            }
                        }
                    }

                    container.add(new Right_Message_Sticker(user.getName(), s, "", "Chưa ai xem", "Đang gửi"));

                    container.setLayout(new GridLayout(container.getComponentCount(), 1));
                    scrollChat.getViewport().setView(container);

                    JScrollBar scrollBar = scrollChat.getVerticalScrollBar();
                    scrollBar.setValue(scrollBar.getMaximum());
                    new Thread(new addNewSticker11(socket, randomKey, user, userReceive, s, pKeyServer)).start();
                    dispose();
                }
            });
        }
        container.setLayout(new GridLayout(listStiker.length / 3, 3));
        scroll.getViewport().setView(container);
    }

    private void initSocket() {
        try {
            socket = new Socket(Config.HOST, Config.PORT);
            //Tao random key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256); // for example
            SecretKey secretKey = keyGen.generateKey();
            randomKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            pKeyServer = Hyrid_Encryption.getPublicKeyRSA(PUBLIC_KEY_SERVER);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối đến Server [" + ex.getMessage() + "]");
        }
    }
    private static class addNewSticker11 implements Runnable {

        Socket socket;
        String randomKey;
        UserDTO user;
        UserDTO userReceive;
        String stickerName;
        PublicKey pKeyServer;

        public addNewSticker11(Socket socket, String randomKey, UserDTO user, UserDTO userReceive, String stickerName, PublicKey pKeyServer) {
            this.socket = socket;
            this.randomKey = randomKey;
            this.user = user;
            this.userReceive = userReceive;
            this.stickerName = stickerName;
            this.pKeyServer = pKeyServer;
        }


        @Override
        public void run() {
            try {
                BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                HashMap<String, String> maps = new HashMap<>();
                String str[] = {
                    String.valueOf(user.getId()),
                    String.valueOf(userReceive.getId()),
                    stickerName
                };
                //Khoi tao data          
                maps.put("command", "ADD_STICKER_11");
                maps.put("data", new Gson().toJson(str));
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

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}
