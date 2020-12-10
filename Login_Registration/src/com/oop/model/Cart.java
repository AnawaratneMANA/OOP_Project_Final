package com.oop.model;

//class for user added parts

public class Cart {
	private int partId;
	private float unitPrice;
	private int qty;
	private String pName;
	private String manufactName;
	private String bodyStyle;
	private int modelNumber;
	private int qtyStock;
	
	
	
	public Cart(int partId, float unitPrice, int qty, String pName, String manufactName, String bodyStyle,
			int modelNumber, int qtyStock) {
		super();
		this.partId = partId;
		this.unitPrice = unitPrice;
		this.qty = qty;
		this.pName = pName;
		this.manufactName = manufactName;
		this.bodyStyle = bodyStyle;
		this.modelNumber = modelNumber;
		this.qtyStock = qtyStock;
	}


	

	public float getUnitPrice() {
		return unitPrice;
	}




	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}




	public int getPartId() {
		return partId;
	}



	public void setPartId(int partId) {
		this.partId = partId;
	}


	public int getQty() {
		return qty;
	}



	public void setQty(int qty) {
		this.qty = qty;
	}



	public String getpName() {
		return pName;
	}



	public void setpName(String pName) {
		this.pName = pName;
	}



	public String getManufactName() {
		return manufactName;
	}



	public void setManufactName(String manufactName) {
		this.manufactName = manufactName;
	}



	public String getBodyStyle() {
		return bodyStyle;
	}



	public void setBodyStyle(String bodyStyle) {
		this.bodyStyle = bodyStyle;
	}



	public int getModelNumber() {
		return modelNumber;
	}



	public void setModelNumber(int modelNumber) {
		this.modelNumber = modelNumber;
	}



	public int getQtyStock() {
		return qtyStock;
	}



	public void setQtyStock(int qtyStock) {
		this.qtyStock = qtyStock;
	}

	
	
	
	
	
	
	
	
	
	
	
}





