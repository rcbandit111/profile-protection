package com.profile.protection.admin.service.impl;

import com.profile.protection.admin.repository.KeysRepository;
import com.profile.protection.admin.resource.DecryptValueRequest;
import com.profile.protection.admin.resource.EncryptValueRequest;
import com.profile.protection.admin.service.KeysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class KeysServiceImpl implements KeysService {

    private KeysRepository keysRepository;

    @Autowired
    public KeysServiceImpl(KeysRepository keysRepository) {
        this.keysRepository = keysRepository;
    }

    @Override
    public String encryptValueRequest(EncryptValueRequest encryptValueRequest)
    {
        String dataClass = encryptValueRequest.getDataClass().name();
        String plainText = encryptValueRequest.getPlainText();

        // TODO - make here a check into application.yml what values to use.

        String key = "test";

        try {
            // TODO - make a check for dataClass and choose it based on yml config
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
            IvParameterSpec iv = new IvParameterSpec(new byte[16]);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // TODO get this value from a yml config
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

            byte[] encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void decryptValueRequest(DecryptValueRequest decryptValueRequest)
    {
        String dataClass = decryptValueRequest.getDataClass().name();
        String cipherText = decryptValueRequest.getCipherText();

        // TODO

    }
}
