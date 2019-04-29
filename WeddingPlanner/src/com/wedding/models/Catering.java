package com.wedding.models;

public class Catering {
	private int catererId;
	private String catererName;
	private int price;
	private String location;
	private String image;
	
	@Override
	public String toString() {
		return "Catering [catererId=" + catererId + ", catererName=" + catererName
				+ ", price=" + price + ", location=" + location + ", image="
				+ image + "]";
	}
	public int getCatererId() {
		return catererId;
	}
	public void setCatererId(int catererId) {
		this.catererId = catererId;
	}
	public String getCatererName() {
		return catererName;
	}
	public void setCatererName(String catererName) {
		this.catererName = catererName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	

}
