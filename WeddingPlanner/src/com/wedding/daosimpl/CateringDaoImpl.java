package com.wedding.daosimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wedding.daos.CateringDao;
import com.wedding.models.Catering;
import com.wedding.utility.ConnectionProvider;

public class CateringDaoImpl implements CateringDao {

	@Override
	public boolean addCaterer(Catering catering) {
		// TODO Auto-generated method stub
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("insert into CateringTab values( caterseq.nextval,?,?,?,?)");
			ps.setString(1, catering.getCatererName());
			ps.setInt(2,catering.getPrice());
			ps.setString(3, catering.getLocation());
			ps.setString(4, catering.getImage());
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
	public boolean deleteCaterer(int catererId) {
		// TODO Auto-generated method stub
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("delete from CateringTab where catererId=?");
			ps.setInt(1,catererId);
			int i=ps.executeUpdate();
			if(i!=0)return true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean updateCaterer(Catering cateringObj) {
		// TODO Auto-generated method stub
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("update CateringTab set catererName=? ,price=?, location=?, image=?  where catererId=?");
			ps.setString(1,cateringObj.getCatererName());
			ps.setInt(2, cateringObj.getPrice());
			ps.setString(3, cateringObj.getLocation());
			ps.setString(4, cateringObj.getImage());
			ps.setInt(5,cateringObj.getCatererId());
			int i=ps.executeUpdate();
			if(i!=0)return true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		return false;
	}

	@Override
	public Catering getCatererById(int catererId) {
		// TODO Auto-generated method stub
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from CateringTab where catererId=?");
			ps.setInt(1, catererId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int price=rs.getInt(3);
				String loc=rs.getString(4);
				String img=rs.getString(5);
			

				Catering cObj=new Catering();
				cObj.setCatererId(id);
				cObj.setCatererName(name);
				cObj.setPrice(price);
				cObj.setLocation(loc);
				cObj.setImage(img);
				
				return cObj;
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		return null;
	}

	@Override
	public List<Catering> getAllCaterings() {
		// TODO Auto-generated method stub
		List<Catering> caterings=new ArrayList<>();
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from CateringTab");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int price=rs.getInt(3);
				String loc=rs.getString(4);
				String img=rs.getString(5);
				
				Catering cObj=new Catering();
				cObj.setCatererId(id);
				cObj.setCatererName(name);
				cObj.setPrice(price);
				cObj.setLocation(loc);
				cObj.setImage(img);
				
				caterings.add(cObj);

			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		System.out.println(caterings);
		return caterings;
	}

}
