/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Func;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mthuan
 */
public class fileFunc {
    public static byte[] convertFileToByte(String filestr) throws FileNotFoundException, IOException {
        
        File file = new File(filestr);
        /*FileInputStream fileInput = new FileInputStream(file.getAbsolutePath());
        
        String filename = file.getName();
        byte[] fileByte = filename.getBytes();
        byte[] fileContent = new byte[(int)file.length()];
        
        return fileContent;*/
        return Files.readAllBytes(file.toPath());
    }
    
    public static void WriteFile(String filename,byte []data){
        FileOutputStream fout = null;
        try {
           
            
            File file = new File(filename);
            fout = new FileOutputStream(file);
            
                fout.write(data);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(fileFunc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(fileFunc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fout.close();
            } catch (IOException ex) {
                Logger.getLogger(fileFunc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static List<String> readTextFile(String url){
        List<String> list = new ArrayList<>();
        try {
            FileInputStream fi = new FileInputStream(new File(url));
            Scanner sc = new Scanner(fi);
            
            while(sc.hasNext()){
                list.add(sc.nextLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        
        return list;
    }
    
    public static void writeTextFile(String url,List<String> list) {
        try {
            //Ghi file
            FileWriter file = new FileWriter(url);

            for (String item : list) {
                file.write(item + "\n");
            }
            file.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
