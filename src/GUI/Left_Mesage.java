/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Message;

/**
 *
 * @author mthuan
 */
public class Left_Mesage extends javax.swing.JPanel {
    Message mess;
    /**
     * Creates new form Left_Mesage
     */
    public Left_Mesage(Message m,String viewUser) {
        this.mess = m;
        initComponents();
        
        user_name.setText(mess.getUsername());
        content.setText(mess.getBody());
        time_sent.setText(mess.getTime());
        if(viewUser.compareTo("") == 0){
            status_view.setText("Đã gửi");
        }
        else{
            status_view.setText(viewUser + " đã xem");
        }
    }
    
    public String getContent(){
        return user_name.getText() + content.getText()+status_view.getText();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        user_name = new javax.swing.JLabel();
        status_view = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        content = new javax.swing.JTextArea();
        time_sent = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(560, 100));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user_name.setFont(new java.awt.Font("Arimo", 0, 18)); // NOI18N
        user_name.setText("jLabel1");
        jPanel1.add(user_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 390, -1));

        status_view.setFont(new java.awt.Font("Arimo", 0, 18)); // NOI18N
        status_view.setText("jLabel1");
        jPanel1.add(status_view, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 400, -1));

        content.setColumns(20);
        content.setFont(new java.awt.Font("Arimo", 0, 18)); // NOI18N
        content.setRows(5);
        jScrollPane1.setViewportView(content);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 390, 90));

        time_sent.setFont(new java.awt.Font("Arimo", 0, 18)); // NOI18N
        time_sent.setText("jLabel1");
        jPanel1.add(time_sent, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 400, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 200));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea content;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel status_view;
    private javax.swing.JLabel time_sent;
    private javax.swing.JLabel user_name;
    // End of variables declaration//GEN-END:variables
}
