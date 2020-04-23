package com.cenfotec.examen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.examen.domain.Storage;
import com.cenfotec.examen.repository.StorageRepository;

@Service
public class StorageServiceImpl implements StorageService {
	@Autowired
	StorageRepository storageRepo;

	@Override
	public void saveStorage(Storage storage) {
		storageRepo.save(storage);

	}

	@Override
	public List<Storage> findAllStorage() {
		return storageRepo.findAll();

	}

}
