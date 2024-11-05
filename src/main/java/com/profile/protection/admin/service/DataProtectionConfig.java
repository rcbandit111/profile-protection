package com.profile.protection.admin.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "profile-protection")
public class DataProtectionConfig {

    private List<DataClass> dataClasses;

    @Getter
    @Setter
    public static class DataClass {
        private String name;
        private String activeVersionName;
        private List<Version> versions;

        @Getter
        @Setter
        public static class Version {
            private String versionName;
            private String algorithmName;
            private String encryptAlgorithmName;
            private String encryptKeyName;
            private int encryptKeyVersion;
        }
    }
}
