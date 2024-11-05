package com.profile.protection.admin.domain;

import com.profile.protection.admin.resource.DataClassType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "keys")
public class Keys {

    @Id
    @UuidGenerator
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "cipher_text")
    private String cipherText;

    @Column(name = "data_class_type")
    private DataClassType dataClassType;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @Column(name = "modified_at")
    private OffsetDateTime modifiedAt;

}
