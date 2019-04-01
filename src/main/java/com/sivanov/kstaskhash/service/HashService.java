package com.sivanov.kstaskhash.service;

import com.sivanov.kstaskhash.dto.GettingHashByPhoneRequest;
import com.sivanov.kstaskhash.dto.GettingPhoneByHashRequest;
import com.sivanov.kstaskhash.dto.ResponseData;

import java.security.NoSuchAlgorithmException;

public interface HashService {

    ResponseData getHashByPhone(GettingHashByPhoneRequest request) throws NoSuchAlgorithmException;
    ResponseData getPhoneByHash(GettingPhoneByHashRequest request);
}
