package com.cenfotec.examen.domain;

import org.springframework.data.annotation.Id;

public class Storage {

	@Id
	private String id_storage;
	private String storage_name;

	public Storage() {

	}

	public Storage(String storage_name) {
		this.storage_name = storage_name;
	}

	public String getId_storage() {
		return id_storage;
	}

	public void setId_storage(String id_storage) {
		this.id_storage = id_storage;
	}

	public String getStorage_name() {
		return storage_name;
	}

	public void setStorage_name(String storage_name) {
		this.storage_name = storage_name;
	}

}
