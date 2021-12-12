/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import BUS.ClassBUS;
import DTO.UserDTO;
import GUI.Left_Message;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author mthuan
 */
public class AdminUserGUI extends javax.swing.JFrame {

    ClassBUS bus = new ClassBUS();
    JTextArea text;

    public AdminUserGUI() {
        initComponents();
        initDisplay();
        initThread();
    }
    
    public AdminUserGUI(JTextArea txt) {
        this.text = txt;
        initComponents();
        initDisplay();
        initThread();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        listBlock = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        listOffline = new javax.swing.JScrollPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        statisticPanel = new javax.swing.JPanel();
        totalUser = new javax.swing.JLabel();
        onlineUser = new javax.swing.JLabel();
        offlineUser = new javax.swing.JLabel();
        blockUser = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        list_online = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        listBlock.setBackground(new java.awt.Color(115, 115, 115));

        jLabel1.setFont(new java.awt.Font("Arimo", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(5, 182, 26));
        jLabel1.setText("List User Online");

        jLabel2.setFont(new java.awt.Font("Arimo", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 112, 0));
        jLabel2.setText("List User Offline");

        listOffline.setBackground(new java.awt.Color(115, 115, 115));

        jLabel3.setFont(new java.awt.Font("Arimo", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(6, 124, 0));
        jLabel3.setText("Statistic");

        jLabel4.setFont(new java.awt.Font("Arimo", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("List User Block");

        statisticPanel.setBackground(new java.awt.Color(1, 1, 1));

        totalUser.setFont(new java.awt.Font("Arimo", 1, 24)); // NOI18N
        totalUser.setForeground(new java.awt.Color(254, 254, 254));
        totalUser.setText("Total User : ");

        onlineUser.setFont(new java.awt.Font("Arimo", 1, 24)); // NOI18N
        onlineUser.setForeground(new java.awt.Color(0, 161, 255));
        onlineUser.setText("Online User : ");

        offlineUser.setFont(new java.awt.Font("Arimo", 1, 24)); // NOI18N
        offlineUser.setForeground(new java.awt.Color(255, 94, 0));
        offlineUser.setText("Offline User : ");

        blockUser.setFont(new java.awt.Font("Arimo", 1, 24)); // NOI18N
        blockUser.setForeground(new java.awt.Color(255, 0, 0));
        blockUser.setText("Block User : ");

        jLabel5.setFont(new java.awt.Font("Arimo", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 255, 15));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Statistics");

        javax.swing.GroupLayout statisticPanelLayout = new javax.swing.GroupLayout(statisticPanel);
        statisticPanel.setLayout(statisticPanelLayout);
        statisticPanelLayout.setHorizontalGroup(
            statisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(totalUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(onlineUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(offlineUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(blockUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
        );
        statisticPanelLayout.setVerticalGroup(
            statisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statisticPanelLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(totalUser)
                .addGap(18, 18, 18)
                .addComponent(onlineUser)
                .addGap(18, 18, 18)
                .addComponent(offlineUser)
                .addGap(18, 18, 18)
                .addComponent(blockUser)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(370, 370, 370)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(361, 361, 361)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(list_online, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                            .addComponent(listOffline))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(listBlock, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(statisticPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(list_online, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listBlock, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listOffline, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statisticPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
            java.util.logging.Logger.getLogger(AdminUserGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminUserGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminUserGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminUserGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminUserGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel blockUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane listBlock;
    private javax.swing.JScrollPane listOffline;
    private javax.swing.JScrollPane list_online;
    private javax.swing.JLabel offlineUser;
    private javax.swing.JLabel onlineUser;
    private javax.swing.JPanel statisticPanel;
    private javax.swing.JLabel totalUser;
    // End of variables declaration//GEN-END:variables

    private void initDisplay() {
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    private void initThread() {
        new Thread(new onlineUser(list_online)).start();
        new Thread(new offlineUser(listOffline)).start();
        new Thread(new blockUser(listBlock)).start();
        new Thread(new statisticUser(totalUser, onlineUser, offlineUser, blockUser)).start();
    }

    private class onlineUser implements Runnable {

        JScrollPane list;

        public onlineUser(JScrollPane listOnline) {
            this.list = listOnline;
        }

        @Override
        public void run() {
            String currentStr = "";
            while (true) {
                String str = "";
                try {
                    List<UserDTO> listOnl = bus.getAllOnlineUser();
                    Container conn = new Container();
                    for (UserDTO user : listOnl) {
                        JPanel p = new User_Item_Server(user, "Online",text);
                        p.setVisible(true);
                        conn.add(p);
                        str += p.toString();
                    }
                    
                    if(str.compareTo(currentStr) != 0){
                        conn.setLayout(new GridLayout(listOnl.size(), 1));
                        list.getViewport().setView(conn);
                        currentStr = str;
                    }
                    

                    Thread.sleep(Config.DELAY_TIME);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AdminUserGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private class offlineUser implements Runnable {
        JScrollPane list;
        
        public offlineUser(JScrollPane listOffline) {
            this.list = listOffline;
        }

        @Override
        public void run() {
            String currentStr = "";
            while (true) {
                String str = "";
                try {
                    List<UserDTO> listOff = bus.getAllOfflineUser();
                    Container conn = new Container();
                    for (UserDTO user : listOff) {
                        JPanel p = new User_Item_Server(user, "Offline",text);
                        p.setVisible(true);
                        conn.add(p);
                        str += p.toString();
                    }
                   
                    if(str.compareTo(currentStr) != 0){
                        conn.setLayout(new GridLayout(listOff.size(), 1));
                        list.getViewport().setView(conn);
                        currentStr = str;
                    }

                    Thread.sleep(Config.DELAY_TIME);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AdminUserGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private class blockUser implements Runnable {
        JScrollPane list;
        
        public blockUser(JScrollPane listBlock) {
            this.list = listBlock;
        }

        @Override
        public void run() {
            String currentStr = "";
            while (true) {
                String str = "";
                try {
                    List<UserDTO> listBLock = bus.getAllBlockUser();
                    Container conn = new Container();
                    for (UserDTO user : listBLock) {
                        JPanel p = new User_Item_Server(user, "Block",text);
                        p.setVisible(true);
                        conn.add(p);
                        str += p.toString();
                    }
                   
                    if(str.compareTo(currentStr) != 0){
                        conn.setLayout(new GridLayout(listBLock.size(), 1));
                        list.getViewport().setView(conn);
                        currentStr = str;
                    }

                    Thread.sleep(Config.DELAY_TIME);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AdminUserGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private class statisticUser implements Runnable {
        JLabel totalUser;
        JLabel onlineUser;
        JLabel offlineUser; 
        JLabel blockUser;

        public statisticUser(JLabel totalUser, JLabel onlineUser, JLabel offlineUser, JLabel blockUser) {
            this.totalUser = totalUser;
            this.onlineUser = onlineUser;
            this.offlineUser = offlineUser;
            this.blockUser = blockUser;
        }
        
        

        @Override
        public void run() {
            String currentStr = "";
            while (true) {
                String str = "";
                try {
                    int []arrStatistic = bus.statisticUserAdmin();
                    str = String.valueOf(arrStatistic[0]) + String.valueOf(arrStatistic[1]) + String.valueOf(arrStatistic[2]) + String.valueOf(arrStatistic[3]); 
                   
                    if(str.compareTo(currentStr) != 0){
                        totalUser.setText("Total User : " + String.valueOf(arrStatistic[0]));
                        onlineUser.setText("Online User : " + String.valueOf(arrStatistic[1]));
                        offlineUser.setText("Offline User : " + String.valueOf(arrStatistic[2]));
                        blockUser.setText("Block User : " + String.valueOf(arrStatistic[3]));
                        currentStr = str;
                    }

                    Thread.sleep(Config.DELAY_TIME);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AdminUserGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
