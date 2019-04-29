package com.wedding.daosimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wedding.daos.VendorDao;
import com.wedding.models.Vendor;
import com.wedding.utility.ConnectionProvider;

public class VendorDaoImpl implements VendorDao {

	@Override
	public boolean addVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("insert into VendorTab values( vendorseq.nextval,?,?,?,?)");
			ps.setString(1, vendor.getVendorName());
			ps.setInt(2,vendor.getPrice());
			ps.setString(3, vendor.getLocation());
			ps.setString(4, vendor.getImage());
			int i=ps.executeUpdate();            
			if(i!=0){
				return true;
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}

		return false;
	}

	@Override
	public boolean deleteVendor(int venId) {
		// TODO Auto-generated method stub
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("delete from VendorTab where vendorId=?");
			ps.setInt(1,venId);
			int i=ps.executeUpdate();
			if(i!=0)return true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean updateVendor(Vendor vendorObj) {
		// TODO Auto-generated method stub
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("update vendorTab set vendorName=? ,price=?, location=?, image=?  where vendorId=?");
			ps.setString(1,vendorObj.getVendorName());
			ps.setInt(2, vendorObj.getPrice());
			ps.setString(3, vendorObj.getLocation());
			ps.setString(4, vendorObj.getImage());
			ps.setInt(5,vendorObj.getVendorId());
			int i=ps.executeUpdate();
			if(i!=0)return true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public Vendor getVendorById(int venId) {
		// TODO Auto-generated method stub
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from VendorTab where vendorId=?");
			ps.setInt(1,venId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int price=rs.getInt(3);
				String loc=rs.getString(4);
				String img=rs.getString(5);
			

				Vendor vObj=new Vendor();
				vObj.setVendorId(id);
				vObj.setVendorName(name);
				vObj.setPrice(price);
				vObj.setLocation(loc);
				vObj.setImage(img);
				
				return vObj;
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}

		return null;
	}

	@Override
	public List<Vendor> getAllVendors() {
		// TODO Auto-generated method stub
		List<Vendor> vendors=new ArrayList<>();
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from VendorTab");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int price=rs.getInt(3);
				String loc=rs.getString(4);
				String img=rs.getString(5);
				
				Vendor vObj=new Vendor();
				vObj.setVendorId(id);
				vObj.setVendorName(name);
				vObj.setPrice(price);
				vObj.setLocation(loc);
				vObj.setImage(img);
				
				vendors.add(vObj);

			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		System.out.println(vendors);
		return vendors;
		
	}

}
