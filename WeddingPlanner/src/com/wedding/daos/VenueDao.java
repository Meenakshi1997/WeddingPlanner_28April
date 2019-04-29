package com.wedding.daos;

import java.util.List;

import com.wedding.models.Venue;

public interface VenueDao {
	public boolean addVenue(Venue venue);
	public boolean deleteVenue(int venId);
	public boolean updateVenue(Venue venueObj);
	public Venue getVenueById(int venId);
	public List<Venue> getAllVenues();
}
