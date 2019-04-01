package com.sivanov.kstaskhash.service;

import com.sivanov.kstaskhash.config.HashProperties;
import com.sivanov.kstaskhash.dto.GettingHashByPhoneRequest;
import com.sivanov.kstaskhash.dto.GettingPhoneByHashRequest;
import com.sivanov.kstaskhash.dto.ResponseData;
import com.sivanov.kstaskhash.entity.HashAndPhoneEntity;
import com.sivanov.kstaskhash.repository.HashAndPhoneRepository;
import com.sivanov.kstaskhash.util.EncryptionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HashServiceImplTest {

    @Mock
    private HashProperties config;
    @Mock
    private HashAndPhoneRepository repository;

    @InjectMocks
    private HashServiceImpl service;

    @Test
    public void getPhoneByHash() throws NoSuchAlgorithmException {
        when(config.getAlgorithm()).thenReturn("SHA-256");
        when(config.getSalt()).thenReturn("nosalt");
        final String phone = "0675204125";
        final String hash = EncryptionUtils.encrypt(config.getAlgorithm(), phone, config.getSalt());

        HashAndPhoneEntity entity = new HashAndPhoneEntity();
        entity.setHash(hash);
        entity.setPhone(phone);

        GettingPhoneByHashRequest request = new GettingPhoneByHashRequest();
        request.setHash(hash);

        when(repository.getOneByHash(anyString())).thenReturn(entity);

        ResponseData phoneByHash = service.getPhoneByHash(request);

        assertNotNull(phoneByHash);

        System.out.println(phoneByHash);
    }


    @Test
    public void getHashByPhone() throws NoSuchAlgorithmException {
        when(config.getAlgorithm()).thenReturn("SHA-256");
        when(config.getSalt()).thenReturn("nosalt");
        final String phone = "0675204125";
        final String hash = EncryptionUtils.encrypt(config.getAlgorithm(), phone, config.getSalt());

        HashAndPhoneEntity entity = new HashAndPhoneEntity();
        entity.setHash(hash);
        entity.setPhone(phone);

        GettingHashByPhoneRequest request = new GettingHashByPhoneRequest();
        request.setPhone(phone);

        when(repository.getOneByPhone(anyString())).thenReturn(entity);

        ResponseData phoneByHash = service.getHashByPhone(request);

        assertNotNull(phoneByHash);

        System.out.println(phoneByHash);
    }
}