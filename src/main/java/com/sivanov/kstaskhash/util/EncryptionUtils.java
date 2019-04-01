package com.sivanov.kstaskhash.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionUtils {

    public static String encrypt(String algorithm, String input, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);

        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] messageDigest = md.digest(input.getBytes(StandardCharsets.UTF_8));

        BigInteger no = new BigInteger(1, messageDigest);

        return no.toString(16);
    }
}
