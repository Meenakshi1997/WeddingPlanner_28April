package com.wedding.daos;

import java.util.List;

import com.wedding.models.Catering;

public interface CateringDao {
	public boolean addCaterer(Catering catering);
	public boolean deleteCaterer(int catererId);
	public boolean updateCaterer(Catering cateringObj);
	public Catering getCatererById(int catererId);
	public List<Catering> getAllCaterings();
}
