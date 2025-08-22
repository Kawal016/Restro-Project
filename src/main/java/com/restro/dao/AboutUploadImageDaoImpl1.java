package com.restro.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AboutUploadImageDaoImpl1 implements AboutUploadImageDao {
     private String result;
	
	@Override
	public String insertimageservice(InputStream Is) {
		Connection con=null;
		try {
			 con=Conection.getConnection();
			 String query="INSERT INTO image (image) VALUES(?)";
			 PreparedStatement pst=con.prepareStatement(query);
			 pst.setBlob(1,Is);
			 int i= pst.executeUpdate();
			 if(i==1)
			 {
				 result="IMAGE UPLOAD SUCCESSFULY";
			 }
			 else
			 {
				 result="SOMETHING WENT WRONG";
			 }
		}
		catch(Exception e)
		{
			result="SOMETHING WENT WRONG:DAO ";
			e.printStackTrace();
		}
		finally {
			try {
				if(Is!=null)
				{
					Is.close();
				}
				con.close();
			}
			catch(Exception e)
			{
			e.printStackTrace();
			
			}
		}
		return result;
	}

	@Override
	public List<Integer> readImageidDao() {
		System.out.println("ENTER IN DAO RAED IMAGEID");
		Connection con=null;
		List<Integer> imageids=new ArrayList<>();
		try {
			 con=Conection.getConnection();
			 String query="SELECT id FROM image ";
			 PreparedStatement pst=con.prepareStatement(query);
			
			 ResultSet rs=pst.executeQuery();
			 while(rs.next())
			 {
				imageids.add(rs.getInt("id"));
			 }
		}
		catch(Exception e)
		{
			System.out.println("Error in readImageId:Dao");	
			e.printStackTrace();
			imageids=null;	
		}
		System.out.println("EXIST IN DAO RAED IMAGEID");
		return imageids;
	}

	@Override
	public byte[] readImageDao(int id) {
		System.out.println("ENTER IN DAO RAED IMAGE");
		Connection con=null;
		byte[] img=null;
		try {
			con=Conection.getConnection();
			String query="SELECT image FROM image where id=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
			 img=rs.getBytes("image");
			}
		
		}
		catch(Exception e)
		{
			System.out.println("error in image : dao");
			e.printStackTrace();
		}
		System.out.println("EXIST IN DAO RAED IMAGE");
		return img;
	}

}
