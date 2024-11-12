package com.profile.protection.admin.controller;

import com.profile.protection.admin.resource.DecryptValueRequest;
import com.profile.protection.admin.resource.DecryptValueResponse;
import com.profile.protection.admin.resource.EncryptValueRequest;
import com.profile.protection.admin.resource.EncryptValueResponse;
import com.profile.protection.admin.service.KeysService;
import com.profile.protection.admin.service.KeysServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/profile-protection", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private KeysService keysService;

    @Autowired
    public UserController(KeysService keysService, KeysServiceRegistry keysServiceRegistry) {
        this.keysService = keysService;
        this.keysServiceRegistry = keysServiceRegistry;
    }
//
//    @RequestMapping(method = {RequestMethod.GET}, path = {"encrypt"})
//    public ResponseEntity<EncryptValueResponse> encrypt(@RequestBody EncryptValueRequest encryptValueRequest)
//    {
//        String encryptValue = keysService.encryptValueRequest(encryptValueRequest);
//
//        EncryptValueResponse response = new EncryptValueResponse();
//        response.setCipherText(encryptValue);
//
//        // return EncryptValueResponse - this should return an encrypted hash
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @RequestMapping(method = {RequestMethod.GET}, path = {"decrypt"})
//    public ResponseEntity<DecryptValueResponse> retrieve(@RequestBody DecryptValueRequest decryptValueRequest)
//    {
//        keysService.decryptValueRequest(decryptValueRequest);
//        // TODO
//        // return DecryptValueResponse - this should return an plainText
//        return new ResponseEntity<>(new DecryptValueResponse(), HttpStatus.OK);
//    }

    private final KeysServiceRegistry keysServiceRegistry;

    @PostMapping("/{dataClassName}/encrypt")
    public String encrypt(@PathVariable String dataClassName, @RequestBody String plaintext) {
        KeysService encryptionService = keysServiceRegistry.provide(dataClassName);
        return encryptionService.encrypt(plaintext);
    }
}
