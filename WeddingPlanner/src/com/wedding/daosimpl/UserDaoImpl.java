 package com.wedding.daosimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import com.wedding.daos.UserDao;
import com.wedding.models.User;
import com.wedding.utility.ConnectionProvider;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean registerUser(User userObj) {
		try {
		Connection conn=ConnectionProvider.getConnection();
		PreparedStatement ps=conn.prepareStatement("insert into UserTab values(?,?,?,?,?,?,?,?)");
		ps.setString(1,userObj.getEmail());
		ps.setString(2,userObj.getPassword());
		ps.setString(3,userObj.getFirstName());
		ps.setString(4,userObj.getLastName());
		ps.setString(5,userObj.getGender());
		ps.setString(7,userObj.getAddress());
		ps.setString(8,userObj.getMobileNo());

		/*Converting java.util.Date into java.sql.Date*/
		Date dateOfBirth=userObj.getDateOfBirth();
		long l=dateOfBirth.getTime();
		java.sql.Date dob=new java.sql.Date(l);
		ps.setDate(6, dob);

		PreparedStatement ps1=conn.prepareStatement("insert into Login_Tab values(?,?,'user')");
		ps1.setString(1,userObj.getEmail());
	    ps1.setString(2,userObj.getPassword());
		
		int i=ps.executeUpdate();
		if(i!=0){
			ps1.executeUpdate();
			return true;
		}
		else {
			return false;
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUser(String email) {
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from UserTab where email=?");
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			if(rs.next());
				String fname=rs.getString(3);
				String lname=rs.getString(4);
				String em=rs.getString(1);
				Date dob=rs.getDate(6);
				String address=rs.getString(7);
				String mob=rs.getString(8);
				String gender=rs.getString(5);
				
				User user=new User();
				user.setFirstName(fname);
				user.setLastName(lname);
				user.setEmail(em);
				user.setDateOfBirth(dob);
				user.setAddress(address);
				user.setMobileNo(mob);
				user.setGender(gender);

				return user;
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public boolean updateUser(User userObj) {
		try {
			
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement
		("Update UserTab set FristName=?,LastName=?,address=?,MobileNo=? where email=?");
			ps.setString(5,userObj.getEmail());
			//ps.setString(2,userObj.getPassword());
			ps.setString(1,userObj.getFirstName());
			ps.setString(2,userObj.getLastName());
			
			ps.setString(3,userObj.getAddress());
			ps.setString(4,userObj.getMobileNo());

			/*Converting java.util.Date into java.sql.Date*/
		/*	Date dateOfBirth=userObj.getDateOfBirth();
			long l=dateOfBirth.getTime();
			java.sql.Date dob=new java.sql.Date(l);
			ps.setDate(4, dob);*/
			
			int i=ps.executeUpdate();
			if(i!=0){
				return true;
			}
			else {
				return false;
			}	
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean changePassword(String email, String newPassword,String confirmPassword) {
		
		System.out.println(email+" "+newPassword);
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps1=conn.prepareStatement("Update Login_Tab set password=? where loginId=?");
			ps1.setString(1,newPassword);
			ps1.setString(2, email);
			int i=ps1.executeUpdate();
			if(i!=0){
				return true;
			}
			else
				return false;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return false;
	}
	
	@Override
	public User validateUser(String email, String pass) {
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from UserTab where email=? and password=?");
			ps.setString(1,email);
			ps.setString(2,pass);

			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				String em=rs.getString(1);
				String pa=rs.getString(2);
				String fname=rs.getString(3);
				String lname=rs.getString(4);
				String gen=rs.getString(5);
				Date dob=rs.getDate(6);
				String address=rs.getString(7);
				String Mob=rs.getString(8);

				User obj=new User();
				obj.setEmail(em);
				obj.setPassword(pa);
				obj.setFirstName(fname);
				obj.setLastName(lname);
				obj.setGender(gen);
				obj.setDateOfBirth(dob);
				obj.setAddress(address);
				obj.setMobileNo(Mob);

				return obj;
			}
			else {
				return null;
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}

		return null;
	}
}