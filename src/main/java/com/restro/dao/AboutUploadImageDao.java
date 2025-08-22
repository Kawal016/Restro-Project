package com.restro.dao;

import java.io.InputStream;
import java.util.List;

public interface AboutUploadImageDao {

	public String insertimageservice(InputStream Is);
	public List<Integer> readImageidDao();
	public byte[] readImageDao(int id);   
}
