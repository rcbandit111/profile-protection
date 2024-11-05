package com.profile.protection.admin.service;

import com.profile.protection.admin.resource.DecryptValueRequest;
import com.profile.protection.admin.resource.EncryptValueRequest;

public interface KeysService {

    String encryptValueRequest(EncryptValueRequest encryptValueRequest);

    String decryptValueRequest(DecryptValueRequest decryptValueRequest);
}
