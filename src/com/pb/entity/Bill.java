package com.pb.entity;

public class Bill {
	private int bill_id;
	private String productName;
	private int amount;
	private float price;
	private float pay;
	private String supplierName;
	private String billtime;
	private String saleworker;

	public Bill() {
		this.bill_id = 0;
		this.productName = "";
		this.amount = 0;
		this.price = 0;
		this.pay = 0;
		this.supplierName = "";
		this.billtime = "";
		this.saleworker = "";
	}

	public Bill(int billId, String productName, int amount, float price,
			float pay, String supplierName, String billtime, String saleworker) {
		super();
		bill_id = billId;
		this.productName = productName;
		this.amount = amount;
		this.price = price;
		this.pay = pay;
		this.supplierName = supplierName;
		this.billtime = billtime;
		this.saleworker = saleworker;
	}

	public int getBill_id() {
		return bill_id;
	}

	public void setBill_id(int billId) {
		bill_id = billId;
	}

	public String getproductName() {
		return productName;
	}

	public void setproductName(String productName) {
		this.productName = productName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getPay() {
		return pay;
	}

	public void setPay(float pay) {
		this.pay = pay;
	}

	public String getsupplierName() {
		return supplierName;
	}

	public void setsupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getBilltime() {
		return billtime;
	}

	public void setBilltime(String billtime) {
		this.billtime = billtime;
	}

	public String getsaleworker() {
		return saleworker;
	}

	public void setsaleworker(String saleworker) {
		this.saleworker = saleworker;
	}

}
