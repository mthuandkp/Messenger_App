/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Func;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author mthuan
 */
public class Hyrid_Encryption {

    /*================================ AES ========================================*/
    public static SecretKeySpec setKey(String myKey) {
        MessageDigest sha = null;
        try {
            byte[] key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            return new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encryptAES(String strToEncrypt, String secret) {
        try {
            SecretKeySpec secretKey = setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decryptAES(String strToDecrypt, String secret) {
        try {
            SecretKeySpec secretKey = setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    /*================================ RSA ========================================*/
    public static PublicKey getPublicKeyRSA(String prikey) {
        try {
            X509EncodedKeySpec keySpecPublic = new X509EncodedKeySpec(decode(prikey));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            return keyFactory.generatePublic(keySpecPublic);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static PrivateKey getPrivateKeyRSA(String prikey) {
        try {
            PKCS8EncodedKeySpec keySpecPrivate = new PKCS8EncodedKeySpec(decode(prikey));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            return keyFactory.generatePrivate(keySpecPrivate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encryptRSA(String message, PublicKey pKey) throws Exception {
        byte[] messageToBytes = message.getBytes();
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, pKey);
        byte[] encryptedBytes = cipher.doFinal(messageToBytes);
        return encode(encryptedBytes);
    }

    public static String decryptRSA(String encryptedMessage, PrivateKey priKey) throws Exception {
        byte[] encryptedBytes = decode(encryptedMessage);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        byte[] decryptedMessage = cipher.doFinal(encryptedBytes);
        return new String(decryptedMessage, "UTF8");
    }

    private static String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    private static byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }

    /*============================ MD5 ====================================*/
    public static String convertToMd5(String str) {
        try {
            MessageDigest msd = MessageDigest.getInstance("MD5");
            byte[] srcText = str.getBytes("UTF-8");
            byte[] result = msd.digest(srcText);
            
            BigInteger bigInt = new BigInteger(1, result);
            return bigInt.toString(16);
        } catch (Exception ex) {
            Logger.getLogger(Hyrid_Encryption.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
