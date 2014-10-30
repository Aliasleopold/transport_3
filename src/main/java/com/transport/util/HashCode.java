package com.transport.util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 * HashCode
 * 
 * @author Raman_Fedarenka
 * 
 */
public class HashCode {

    private static Formatter formatter;

    /**
     * Convert string to MD5
     * 
     * @param string
     *            - the converted string
     * @return code format md5
     */
    public static String encodeMD5(String string) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("md5");
            digest.reset();
            digest.update(string.getBytes());
            byte hash[] = digest.digest();
            formatter = new Formatter();
            for (int i = 0; i < hash.length; i++) {
                formatter.format("%02X", hash[i]);
            }
            return formatter.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
