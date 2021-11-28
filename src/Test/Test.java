/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Network.SendEmail;
import javax.swing.JOptionPane;

/**
 *
 * @author mthuan
 */
public class Test {
    public static void main(String[] args) {
        Test.checkEmail("--pnmthuan@gmail.com");
    }
    
    public static boolean checkEmail(String email){
        if(email.compareTo("") == 0 || !email.contains("@gmail.com")){
            JOptionPane.showMessageDialog(null, "Tên đăng nhập phải có dạng \"@gmail.com\"");
            return false;
        }
        for(int i = 0;i < email.length();i++){
                if(!Character.isDigit(email.charAt(i)) 
                        && !Character.isLetter(email.charAt(i))
                        && email.charAt(i) != '@'
                        && email.charAt(i) != '.'){
                    JOptionPane.showMessageDialog(null, "Email không hợp lệ");
                    return false;
                }
            }
        return true;
    }
}
