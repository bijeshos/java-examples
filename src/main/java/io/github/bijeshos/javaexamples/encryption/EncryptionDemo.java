package io.github.bijeshos.javaexamples.encryption;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class EncryptionDemo {
    private static final String HASH_ALGORITHM = "SHA-256";
    private static final String SECURE_RANDOMN_ALGORITHM = "SHA1PRNG";
    private static final String KEY_STRETCH_ALGORITHM = "PBKDF2WithHmacSHA1";
    private static final int ITERATIONS = 1000;
    private static final int KEY_LENGTH = 192;

    public static void main(String[] args) {
        EncryptionDemo encryptionTest = new EncryptionDemo();
        String passStr = "password123";
        try {
            byte[] saltBytes = encryptionTest.getSalt();
            byte[] hashedPasswordBytes = encryptionTest.getHashedPassword(passStr.getBytes("UTF-8"), saltBytes);
            System.out.println(encryptionTest.getHexVlue(hashedPasswordBytes));
            byte[] hashedPasswordBytes2 = encryptionTest.getEncryptedPassword(passStr.toCharArray(), saltBytes);
            System.out.println(encryptionTest.getHexVlue(hashedPasswordBytes2));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    private byte[] getHashedPassword(byte[] passwordBytes, byte[] saltBytes) throws NoSuchAlgorithmException {
        MessageDigest msgDigest = MessageDigest.getInstance(HASH_ALGORITHM);
        msgDigest.reset();
        // add salt
        msgDigest.update(saltBytes);
        byte[] hashBytes = msgDigest.digest(passwordBytes);
        // repeat salt ITERATIONS+1 times
        for (int i = 0; i < ITERATIONS; i++) {
            hashBytes = msgDigest.digest(hashBytes);
        }
        return hashBytes;
    }

    private byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstance(SECURE_RANDOMN_ALGORITHM);
        byte[] salt = new byte[8];
        random.nextBytes(salt);
        return salt;
    }

    private String getHexVlue(byte[] hashedPassword) {
        //This byte[] has bytes in decimal format.
        //Convert it into hexadecimal format
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hashedPassword.length; i++) {
            sb.append(Integer.toString((hashedPassword[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    private byte[] getEncryptedPassword(char[] passwordChars, byte[] saltBytes)
            throws InvalidKeySpecException, NoSuchAlgorithmException {
        KeySpec spec = new PBEKeySpec(passwordChars, saltBytes, ITERATIONS, KEY_LENGTH);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(KEY_STRETCH_ALGORITHM);
        return factory.generateSecret(spec).getEncoded();
    }
}
