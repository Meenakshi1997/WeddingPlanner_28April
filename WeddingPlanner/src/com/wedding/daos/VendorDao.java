package com.wedding.daos;

import java.util.List;

import com.wedding.models.Vendor;

public interface VendorDao {
	public boolean addVendor(Vendor vendor);
	public boolean deleteVendor(int venId);
	public boolean updateVendor(Vendor vendorObj);
	public Vendor getVendorById(int venId);
	public List<Vendor> getAllVendors();

}
