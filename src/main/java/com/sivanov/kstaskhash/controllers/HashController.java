package com.sivanov.kstaskhash.controllers;

import com.sivanov.kstaskhash.dto.GettingHashByPhoneRequest;
import com.sivanov.kstaskhash.dto.GettingPhoneByHashRequest;
import com.sivanov.kstaskhash.dto.ResponseData;
import com.sivanov.kstaskhash.service.HashService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(path = "/data")
public class HashController {

    private final HashService hashService;

    public HashController(HashService hashService) {
        this.hashService = hashService;
    }


    @GetMapping(path = "/hash", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseData getHashByPhone(@ModelAttribute @Valid GettingHashByPhoneRequest request) throws NoSuchAlgorithmException {

        return hashService.getHashByPhone(request);
    }

    @GetMapping(path = "/phone", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseData getHashByPhone(@ModelAttribute @Valid GettingPhoneByHashRequest request) {

        return hashService.getPhoneByHash(request);
    }
}
