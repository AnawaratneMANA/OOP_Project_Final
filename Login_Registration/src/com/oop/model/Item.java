package oop.model;

public class Item {
	
	private int partID;
	private String partName;
	private String manufactName;
	private String bodyStyle;
	private int modelNumber;
	private double unitPrice;
	private int year;
	private String description;
	private int quantityInStock;
	
	
	//overloading constructor
	public Item(int partID, String partName, String manufactName, String bodyStyle, int modelNumber, double unitPrice,
			int year, int quantityInStock, String description) {
		super();
		this.partID = partID;
		this.partName = partName;
		this.manufactName = manufactName;
		this.bodyStyle = bodyStyle;
		this.modelNumber = modelNumber;
		this.unitPrice = unitPrice;
		this.year = year;
		this.quantityInStock = quantityInStock;
		this.description = description;
		
	}


	//getters and setters
	public Item() {
		
	}


	public int getPartID() {
		return partID;
	}



	public void setPartID(int partID) {
		this.partID = partID;
	}



	public String getPartName() {
		return partName;
	}



	public void setPartName(String partName) {
		this.partName = partName;
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



	public double getUnitPrice() {
		return unitPrice;
	}



	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getQuantityInStock() {
		return quantityInStock;
	}



	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	
	
	
	
	
}
