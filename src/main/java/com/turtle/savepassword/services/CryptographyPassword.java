package com.turtle.savepassword.services;



import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

@Service
public class CryptographyPassword {

    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 256;

    public static SecretKey derivekey(char[] masterPassword, byte[] salt) throws Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        PBEKeySpec spec = new PBEKeySpec(masterPassword, salt, ITERATIONS, KEY_LENGTH);
        SecretKey tmp = factory.generateSecret(spec);
        return new SecretKeySpec(tmp.getEncoded(), "AES");
    }

    public static String encrypt(String plainText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        SecureRandom random = new SecureRandom();
        byte[] iv = new byte[12];
        random.nextBytes(iv);
        GCMParameterSpec spec = new GCMParameterSpec(128, iv);
        cipher.init(Cipher.ENCRYPT_MODE, key, spec);
        byte[] encrypted = cipher.doFinal(plainText.getBytes());
        byte[] result = new byte[iv.length + encrypted.length];
        System.arraycopy(iv, 0, result, 0, iv.length);
        System.arraycopy(encrypted, 0, result, iv.length, encrypted.length);

        return Base64.getEncoder().encodeToString(result);
}
    public static String decrypt(String base64CipherText, SecretKey key) throws Exception {
        byte[] data = Base64.getDecoder().decode(base64CipherText);
        byte[] iv = new byte[12];
        byte[] cipherText = new byte[data.length - 12];

        System.arraycopy(data, 0, iv, 0, 12);
        System.arraycopy(data, 12, cipherText, 0, cipherText.length);

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(128, iv);
        cipher.init(Cipher.DECRYPT_MODE, key, spec);

        byte[] decrypted = cipher.doFinal(cipherText);
        return new String(decrypted);
    }
    public static byte[] createSalt(){
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[12];
        secureRandom.nextBytes(salt);
        return salt;

    }




}
