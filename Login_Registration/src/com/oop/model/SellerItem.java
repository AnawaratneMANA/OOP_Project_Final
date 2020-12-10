package oop.model;


public class SellerItem {

		private int id;
		private String itemname;
		private Double itemprice;
		private String itemcategory;
		private int itemquantity;
		
		//overloading constructor
		public SellerItem(int id, String itemname, Double itemprice,String itemcategory,int itemquantity) {
			
			this.id = id;
			this.itemname = itemname;
			this.itemprice = itemprice;
			this.itemcategory = itemcategory;
			this.itemquantity = itemquantity;	
		}
		
		//getters and setters
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getItemname() {
			return itemname;
		}

		public void setItemname(String itemname) {
			this.itemname = itemname;
		}

		public Double getItemprice() {
			return itemprice;
		}

		public void setItemprice(Double itemprice) {
			this.itemprice = itemprice;
		}

		public int getItemquantity() {
			return itemquantity;
		}

		public void setItemquantity(int itemquantity) {
			this.itemquantity = itemquantity;
		}

		public String getItemcategory() {
			return itemcategory;
		}

		public void setItemcategory(String itemcategory) {
			this.itemcategory = itemcategory;
		}
		
		
	}
