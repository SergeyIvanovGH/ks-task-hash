package com.sivanov.kstaskhash.util;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EncryptionUtilsTest {

    @Test
    public void encrypt() throws NoSuchAlgorithmException {

        String hash = EncryptionUtils.encrypt("SHA-1", "ajksdhfalsdflajksdlfjka huefqwuer1u34r1ufqjkw h", "salt");
        assertNotNull(hash);
        assertEquals("e5d5224bcd7de0b424f778a9139d0a93fafad09a", hash);

        hash = EncryptionUtils.encrypt("SHA-256", "ajksdhfalsdflajksdlfjka huefqwuer1u34r1ufqjkw h", "salt");
        assertNotNull(hash);
        assertEquals("aae96849e6ccbc0f7fe2003822f5d0fb7ed56a388cb03d8bd1e23bc3f0535ae9", hash);
    }
}