/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mthuan
 */
public class Test {
     static List<String> splitWord(String s,int number){
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
}
