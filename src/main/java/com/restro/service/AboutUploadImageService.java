package com.restro.service;

import java.io.InputStream;
import java.util.List;

public interface AboutUploadImageService {

	public String uploadimageservice(InputStream Is);
	public List<Integer> readimageservice();
	public byte[] readImage(int id);
}
