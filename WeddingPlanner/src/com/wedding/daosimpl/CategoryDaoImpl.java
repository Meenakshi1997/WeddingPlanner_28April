package com.wedding.daosimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wedding.daos.CategoryDao;
import com.wedding.models.Category;
import com.wedding.utility.ConnectionProvider;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public boolean addCategory(Category categoryObj) {
		// TODO Auto-generated method stub
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement
					("insert into CategoryTab values(catseq.nextval,?,?)");
			ps.setString(1,categoryObj.getCategoryName());
			ps.setString(2,categoryObj.getCategoryDesc());
			int i=ps.executeUpdate();
			
			if(i!=0)
				return true;
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return false;
		}

	@Override
	public boolean deleteCategory(int catId) {
		// TODO Auto-generated method stub
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("delete from CategoryTab where catid=?");
			ps.setInt(1,catId);
			int i=ps.executeUpdate();
			if(i!=0)return true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return false;
		}

	@Override
	public boolean updateCategory(Category categoryObj) {
		// TODO Auto-generated method stub
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("update categorytab set catname=? , catdesc=? where catId=?");
			ps.setString(1,categoryObj.getCategoryName());
			ps.setString(2,categoryObj.getCategoryDesc());
			ps.setInt(3,categoryObj.getCategoryId());
			int i=ps.executeUpdate();
			if(i!=0)return true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public Category getCategoryById(int catId) {
		// TODO Auto-generated method stub
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from CategoryTab where catId=?");
			ps.setInt(1,catId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String desc=rs.getString(3);

				Category cObj=new Category();
				cObj.setCategoryId(id);
				cObj.setCategoryName(name);
				cObj.setCategoryDesc(desc);
				return cObj;
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public List<Category> getAllCategories() {
		List<Category> categories=new ArrayList<>();
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from CategoryTab");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String desc=rs.getString(3);
				
				Category cObj=new Category();
				cObj.setCategoryId(id);
				cObj.setCategoryName(name);
				cObj.setCategoryDesc(desc);
				
				categories.add(cObj);

			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return categories;
		
	}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
}
