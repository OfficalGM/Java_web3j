package com.demo.FBHT;

import org.web3j.crypto.Hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


public class HashUtil {
    public static byte[] sha256(String base) {
        try {
//            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = Hash.sha3(base.getBytes("UTF-8"));
//            StringBuffer hexString = new StringBuffer();
//            for (int i = 0; i < hash.length; i++) {
//                String hex = Integer.toHexString(0xff & hash[i]);
//                if (hex.length() == 1) {
//                    hexString.append('0');
//                }
//                hexString.append(hex);
//            }
            return hash;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static byte[] sha256(byte[] a,byte[]b){
        byte[] c = new byte[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);

//            MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = Hash.sha3(c);
        return hash;
    }

    public static BigInteger sha256_BigInteger(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            return new BigInteger(hash);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
