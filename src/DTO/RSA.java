/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 *
 * @author mthuan
 */
public class RSA {
    PublicKey publickey = null;
    PrivateKey privateKey = null;

    public RSA(PublicKey p,PrivateKey pri) {
        this.publickey = p;
        this.privateKey = pri;
    }

    
    public PublicKey getPublickey() {
        return publickey;
    }

    public void setPublickey(PublicKey publickey) {
        this.publickey = publickey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

       
    
}
