package com.profile.protection.admin.service;

import com.profile.protection.admin.resource.DecryptValueRequest;
import com.profile.protection.admin.resource.EncryptValueRequest;
import org.springframework.stereotype.Service;

@Service
public class DefaultKeysService implements KeysService {

    private final ProfileProtectionProperties.DataClass             dataClass;
    private final ProfileProtectionProperties.DataClass.Version     actualVersion;

    public DefaultKeysService(ProfileProtectionProperties.DataClass dataClass) {
        this.dataClass = dataClass;
        this.actualVersion = dataClass.getActualVersion();
    }

    public String forDataType() {
        return this.dataClass.getName();
    }

    @Override
    public String encryptValueRequest(EncryptValueRequest encryptValueRequest) {
        // todo
        // write your code here using your properties

        return "";
    }

    @Override
    public String decryptValueRequest(DecryptValueRequest decryptValueRequest) {
        // todo
        // write your code here using your properties
        return "";
    }
}
