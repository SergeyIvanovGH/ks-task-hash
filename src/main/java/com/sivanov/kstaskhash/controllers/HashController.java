package com.sivanov.kstaskhash.controllers;

import com.sivanov.kstaskhash.dto.GettingHashByPhoneRequest;
import com.sivanov.kstaskhash.dto.GettingPhoneByHashRequest;
import com.sivanov.kstaskhash.dto.ResponseData;
import com.sivanov.kstaskhash.service.HashService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(path = "/data")
@Api(tags = "REST-сервисы", produces = "application/json")
public class HashController {

    private final HashService hashService;

    public HashController(HashService hashService) {
        this.hashService = hashService;
    }


    @ApiOperation(value = "Получение hash-значения по номеру телефона",
            httpMethod = "GET", produces = "application/json", authorizations = {@Authorization(value="basicAuth")})
    @GetMapping(path = "/hash", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseData getHashByPhone(@ModelAttribute @Valid GettingHashByPhoneRequest request) throws NoSuchAlgorithmException {

        return hashService.getHashByPhone(request);
    }

    @ApiOperation(value = "Получение значение номер телефона по hash-значению",
            httpMethod = "GET", produces = "application/json", authorizations = {@Authorization(value="basicAuth")})
    @GetMapping(path = "/phone", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseData getHashByPhone(@ModelAttribute @Valid GettingPhoneByHashRequest request) {

        return hashService.getPhoneByHash(request);
    }
}
