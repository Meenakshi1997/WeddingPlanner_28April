package com.wedding.daosimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wedding.daos.VenueDao;
import com.wedding.models.Venue;
import com.wedding.utility.ConnectionProvider;

public class VenueDaoImpl implements VenueDao {

	@Override
	public boolean addVenue(Venue venue) {
		// TODO Auto-generated method stub
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("insert into VenueTab values( venseq.nextval,?,?,?,?)");
			ps.setString(1, venue.getVenueName());
			ps.setInt(2,venue.getPrice());
			ps.setString(3, venue.getLocation());
			ps.setString(4, venue.getImage());
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
	public List<Venue> getAllVenues() {
		List<Venue> venues=new ArrayList<>();
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from VenueTab");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int price=rs.getInt(3);
				String loc=rs.getString(4);
				String img=rs.getString(5);
				
				Venue vObj=new Venue();
				vObj.setVenueId(id);
				vObj.setVenueName(name);
				vObj.setPrice(price);
				vObj.setLocation(loc);
				vObj.setImage(img);
				
				venues.add(vObj);

			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		System.out.println(venues);
		return venues;
		
	}

	@Override
	public boolean deleteVenue(int venId) {
		// TODO Auto-generated method stub
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("delete from VenueTab where venueId=?");
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
	public boolean updateVenue(Venue venueObj) {
		// TODO Auto-generated method stub
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("update venueTab set venueName=? ,price=?, location=?, image=?  where venueId=?");
			ps.setString(1,venueObj.getVenueName());
			ps.setInt(2, venueObj.getPrice());
			ps.setString(3, venueObj.getLocation());
			ps.setString(4, venueObj.getImage());
			ps.setInt(5,venueObj.getVenueId());
			int i=ps.executeUpdate();
			if(i!=0)return true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		return false;
	}

	@Override
	public Venue getVenueById(int venId) {
		// TODO Auto-generated method stub
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from VenueTab where venueId=?");
			ps.setInt(1,venId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int price=rs.getInt(3);
				String loc=rs.getString(4);
				String img=rs.getString(5);
			

				Venue vObj=new Venue();
				vObj.setVenueId(id);
				vObj.setVenueName(name);
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
                               
}
