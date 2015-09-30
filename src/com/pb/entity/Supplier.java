package com.pb.entity;

public class Supplier {
	private int sup_id;
	private String supplierName;
	private String contactman;
	private String phone;
	private String address;

	public Supplier() {
		this.sup_id = 0;
		this.supplierName = "";
		this.contactman = "";
		this.phone = "";
		this.address = "";

	}

	public Supplier(int id, String name, String man, String phone, String ad) {
		this.sup_id = id;
		this.supplierName = name;
		this.contactman = man;
		this.phone = phone;
		this.address = ad;
	}

	public int getsup_id() {
		return sup_id;
	}

	public void setsup_id(int sup_id) {
		this.sup_id = sup_id;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getContactman() {
		return contactman;
	}

	public void setContactman(String contactman) {
		this.contactman = contactman;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
