/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mthuan
 */
public class Right_Message_Sticker extends javax.swing.JPanel {

    String name;
    String content;
    String time;
    String view;
    String status;

    /**
     * Creates new form Left_Message
     */
    public Right_Message_Sticker(String name, String content, String time, String view, String status) {
        this.name = name;
        this.content = content;
        this.time = time;
        this.view = view;
        this.status = status;
        initComponents();
        initDisplay();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
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
        sticker = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        name_user.setFont(new java.awt.Font("Arimo", 0, 18)); // NOI18N
        name_user.setText("jLabel1");

        status_mess.setFont(new java.awt.Font("Arimo", 0, 18)); // NOI18N
        status_mess.setText("jLabel1");

        time_mess.setFont(new java.awt.Font("Arimo", 0, 18)); // NOI18N
        time_mess.setText("jLabel1");

        view_mess.setFont(new java.awt.Font("Arimo", 0, 18)); // NOI18N
        view_mess.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(status_mess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(time_mess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(view_mess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 95, Short.MAX_VALUE)
                .addComponent(sticker, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(name_user, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(name_user)
                .addGap(18, 18, 18)
                .addComponent(sticker, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(226, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel name_user;
    private javax.swing.JLabel status_mess;
    private javax.swing.JLabel sticker;
    private javax.swing.JLabel time_mess;
    private javax.swing.JLabel view_mess;
    // End of variables declaration//GEN-END:variables

    private void initDisplay() {
        view = view.compareTo("")==0 ? "Chưa ai xem":(view+" đã xem");
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
        sticker.setSize(200, 180);
       ImageIcon imageIcon = new ImageIcon(new ImageIcon("./src/img/Sticker/" + content)
                .getImage()
                .getScaledInstance(sticker.getWidth(), sticker.getHeight(), Image.SCALE_DEFAULT));
       
       sticker.setIcon(imageIcon);
    }
    
    private List<String> splitWord(String s,int number){
        List<String> listStr = new ArrayList<>();
        int i = 0;
        while(s.length() > number){
            if(i < s.length() && (i >= number) && s.charAt(i) == ' '){
                listStr.add(s.substring(0,i));
                s = s.substring(i);
                i = 0;
            }
            else{
                i++;
            }
        }
        listStr.add(s);
        return listStr;
    }
    
    @Override
    public String toString(){
        return name_user.getText() + status_mess.getText() + time_mess.getText() + view_mess.getText() + content;
    }
}
