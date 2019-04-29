package com.wedding.models;

public class Venue {
	private int venueId;
	private String venueName;
	private int price;
	private String location;
	private String image;
	
	
	
	
	@Override
	public String toString() {
		return "Venue [venueId=" + venueId + ", venueName=" + venueName
				+ ", price=" + price + ", location=" + location + ", image="
				+ image + "]";
	}
	public int getVenueId() {
		return venueId;
	}
	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
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
