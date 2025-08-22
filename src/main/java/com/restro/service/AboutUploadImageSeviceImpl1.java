package com.restro.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.restro.dao.AboutUploadImageDaoImpl1;

public class AboutUploadImageSeviceImpl1 implements AboutUploadImageService {
     private String result;
	
	@Override
	public String uploadimageservice(InputStream Is) {
		try {
			AboutUploadImageDaoImpl1 aboutUploadImageDaoImpl1 = new AboutUploadImageDaoImpl1();
			result=aboutUploadImageDaoImpl1.insertimageservice(Is);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result="SOMETHING WENT WRONG : SERVICE";
		}
		return result;
	}

	@Override
	public List<Integer> readimageservice() {
		System.out.println("ENTER IN SERVICE RAED IMAGEID");
		List<Integer> imageids=new ArrayList<>();
		try {
		AboutUploadImageDaoImpl1 aboutUploadImageDaoImpl1=new AboutUploadImageDaoImpl1();
		imageids=aboutUploadImageDaoImpl1.readImageidDao();
		}
		catch(Exception e)
		{
			System.out.println("Error in readImageIdService");
			e.printStackTrace();
		}
		System.out.println("EXIST IN SERVICE RAED IMAGEID");
		return imageids;
  }

	@Override
	public byte[] readImage(int id) {
		System.out.println("ENTER IN SERVICE RAED IMAGE");
		byte[] img=null;
		try {
			AboutUploadImageDaoImpl1 aboutUploadImageDaoImpl1=new AboutUploadImageDaoImpl1();
			img=aboutUploadImageDaoImpl1.readImageDao(id);
		}
		catch(Exception e)
		{
		System.out.println("error image in : service");
			e.printStackTrace();
		}
		System.out.println("EXIST IN SERVICE RAED IMAGE");
		return img;
	}
	

	
}
