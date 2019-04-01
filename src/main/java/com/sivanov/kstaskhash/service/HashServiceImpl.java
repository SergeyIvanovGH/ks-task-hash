package com.sivanov.kstaskhash.service;

import com.sivanov.kstaskhash.config.HashProperties;
import com.sivanov.kstaskhash.dto.GettingHashByPhoneRequest;
import com.sivanov.kstaskhash.dto.GettingPhoneByHashRequest;
import com.sivanov.kstaskhash.dto.ResponseData;
import com.sivanov.kstaskhash.entity.HashAndPhoneEntity;
import com.sivanov.kstaskhash.exceptions.HashException;
import com.sivanov.kstaskhash.repository.HashAndPhoneRepository;
import com.sivanov.kstaskhash.util.EncryptionUtils;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class HashServiceImpl implements HashService {

    private final HashProperties config;
    private final HashAndPhoneRepository repository;

    public HashServiceImpl(HashProperties config, HashAndPhoneRepository repository) {
        this.config = config;
        this.repository = repository;
    }

    @Override
    public ResponseData getHashByPhone(final GettingHashByPhoneRequest request) throws NoSuchAlgorithmException {

        HashAndPhoneEntity entity = repository.getOneByPhone(request.getPhone());

        if (Objects.isNull(entity)) {
            String hash = EncryptionUtils.encrypt(config.getHashAlgorithm(), request.getPhone(), config.getHashSalt());

            entity = new HashAndPhoneEntity();
            entity.setHash(hash);
            entity.setPhone(request.getPhone());

            repository.save(entity);
        }

        return new ResponseData(entity.getPhone(), entity.getHash());
    }

    @Override
    public ResponseData getPhoneByHash(final GettingPhoneByHashRequest request) {
        HashAndPhoneEntity entity = repository.getOneByHash(request.getHash());

        if (Objects.isNull(entity)) {
            throw new HashException("Phone by hash not found in database");
        }

        return new ResponseData(entity.getPhone(), entity.getHash());
    }
}
