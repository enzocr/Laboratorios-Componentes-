package com.cenfotec.examen.service;

import java.util.List;

import com.cenfotec.examen.domain.Storage;

public interface StorageService {

	public void saveStorage(Storage storage);

	public List<Storage> findAllStorage();

}
