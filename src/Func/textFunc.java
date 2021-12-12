/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Func;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mthuan
 */
public class textFunc {
    
    public static List<String> splitWord(String s,int number){
        String str[] = s.split(" ");
        List<String> listStr = Arrays.asList(str);
        List<String> strResult = new ArrayList<>();
        while(listStr.size() > 0){
            String tmp = listStr.get(0);
            while(tmp.length() < number){
                
            }
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello_1");
        list.add("Hello_2");
        list.add("Hello_3");
        list.add("Hello_4");
        list.add("Hello_5");
        list.add("Hello_6");
        list.add("Hello_7");
        list.add("Hello_8");
        
        System.out.println(textFunc.getFirstElementArray(list) + "\n\n");
        for(String s : list){
            System.out.println(s);
        }
        
    }
    
    private static String getFirstElementArray(List<String> list){
        String s = list.get(0);
        List<String> tmp = new ArrayList<>();
        for(int i = 1;i < list.size();i++){
            tmp.add(list.get(i));
        }
        list = tmp;
        return s;        
    }
    
    public static String convertTextToEnglish(String s){
        char []result = s.toLowerCase().replaceAll("\\s++","").toCharArray();
        char []aVN = {'á', 'à', 'ả', 'ã', 'ạ', 'ắ', 'ằ', 'ẳ', 'ẵ', 'ặ', 'ă', 'â', 'ấ', 'ầ', 'ẩ', 'ẫ', 'ậ'};
        char []dVN = {'đ'};
        char []eVN = {'é', 'è', 'ẻ', 'ẽ', 'ẹ', 'ê', 'ế', 'ề', 'ể', 'ễ', 'ệ'};
        char []iVN = {'í', 'ì', 'ỉ', 'ĩ', 'ị'};
        char []oVN = {'ó', 'ò', 'ỏ', 'õ', 'ọ', 'ô', 'ố', 'ồ', 'ổ', 'ỗ', 'ộ', 'ơ', 'ớ', 'ờ', 'ở', 'ỡ', 'ợ'};
        char []uVN = {'ú', 'ù', 'ủ', 'ũ', 'ụ', 'ư', 'ứ', 'ừ', 'ử', 'ữ', 'ự'};
        char []yVN = {'ý', 'ỳ', 'ỷ', 'ỹ', 'ỵ'};
        String rs = "";
        
        for(int i = 0;i < result.length;i++){
            for(char a : aVN){
                if(result[i] == a){
                    result[i] = 'a';
                }
                continue;
            }
            for(char a : dVN){
                if(result[i] == a){
                    result[i] = 'd';
                }
                continue;
            }
            for(char a : eVN){
                if(result[i] == a){
                    result[i] = 'e';
                }
                continue;
            }
            for(char a : iVN){
                if(result[i] == a){
                    result[i] = 'i';
                }
                continue;
            }
            for(char a : oVN){
                if(result[i] == a){
                    result[i] = 'o';
                }
                continue;
            }
            for(char a : uVN){
                if(result[i] == a){
                    result[i] = 'u';
                }
                continue;
            }
            for(char a : yVN){
                if(result[i] == a){
                    result[i] = 'y';
                }
                continue;
            }
        }
        
        for(char a : result){
            rs += a;
        }
        return rs;
    }
}
