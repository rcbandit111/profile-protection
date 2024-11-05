package com.profile.protection.admin.repository;

import com.profile.protection.admin.domain.Keys;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface KeysRepository extends CrudRepository<Keys, UUID> {

    Optional<Keys> findByCipherText(String cipherText);
}
