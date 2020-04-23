package com.cenfotec.examen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cenfotec.examen.domain.Storage;

public interface StorageRepository extends MongoRepository<Storage, String> {

}
