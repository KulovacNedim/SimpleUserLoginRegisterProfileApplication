package main.java.validation;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

public class PasswordHash {

    public String getHash(String password) {

        byte[] bytes = password.getBytes();
        String algorithm = "SHA-256";
        String hashValue = null;

        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(bytes);
            byte[] digestedBytes = messageDigest.digest();
            hashValue = DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("No such algorithm Exception.");;
        }
        return hashValue;
    }

}
