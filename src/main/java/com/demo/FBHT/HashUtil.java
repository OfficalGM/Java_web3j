package com.demo.FBHT;

import org.web3j.crypto.Hash;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class HashUtil {
    public static byte[] sha3(String base) {
        try {
            byte[] hash = Hash.sha3(base.getBytes(StandardCharsets.UTF_8));
            return hash;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static byte[] sha3(byte[] a, byte[] b) {
        byte[] c = new byte[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        byte[] hash = Hash.sha3(c);
        return hash;
    }

    public static byte[] sha256(String tx) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(tx.getBytes(StandardCharsets.UTF_8));
            return hash;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
