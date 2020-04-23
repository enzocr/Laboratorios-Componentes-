package com.cenfotec.examen.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Product {
	@Id
	private String id;
	private String product_name;
	private String quality_grade;
	private int total_amount;
	private int cant_boxes;
	private Date entry_date;
	private String id_storage;

	@Transient
	private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	public String getCreatedAsShort() {
		return format.format(entry_date);
	}

	public Product(String product_name, String quality_grade, int total_amount, int cant_boxes, String id_storage)
			throws ParseException {
		this.product_name = product_name;
		this.quality_grade = quality_grade;
		this.total_amount = total_amount;
		this.cant_boxes = cant_boxes;
		this.id_storage = id_storage;
		this.entry_date = new Date();
	}

	public Product() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getQuality_grade() {
		return quality_grade;
	}

	public void setQuality_grade(String quality_grade) {
		this.quality_grade = quality_grade;
	}

	public int getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}

	public int getCant_boxes() {
		return cant_boxes;
	}

	public void setCant_boxes(int cant_boxes) {
		this.cant_boxes = cant_boxes;
	}

	public Date getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}

	public SimpleDateFormat getFormat() {
		return format;
	}

	public void setFormat(SimpleDateFormat format) {
		this.format = format;
	}

	public String getId_storage() {
		return id_storage;
	}

	public void setId_storage(String id_storage) {
		this.id_storage = id_storage;
	}

}