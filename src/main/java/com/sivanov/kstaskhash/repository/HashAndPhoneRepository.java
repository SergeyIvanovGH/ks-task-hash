package com.sivanov.kstaskhash.repository;

import com.sivanov.kstaskhash.entity.HashAndPhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashAndPhoneRepository extends JpaRepository<HashAndPhoneEntity, Long> {

    HashAndPhoneEntity getOneByPhone(String phone);
    HashAndPhoneEntity getOneByHash(String hash);

}
