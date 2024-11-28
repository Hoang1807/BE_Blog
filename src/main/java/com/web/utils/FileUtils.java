package com.web.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtils {

	public static String writeFile(MultipartFile multipartFile) throws IOException {
	    String uploadPath = System.getProperty("app.upload.dir", "uploads");
	    
	    File uploadDir = new File(uploadPath);
	    if (!uploadDir.exists()) {
	        uploadDir.mkdirs();
	    }

	    String fileName = UUID.randomUUID().toString() + ".jpg";
	    String filePath = uploadPath + File.separator + fileName;
	    FileCopyUtils.copy(multipartFile.getBytes(), new File(filePath));
	    return fileName;
	}


	public static boolean deleteFile(String fileName) {
		// Lấy thư mục làm việc hiện tại
		String uploadPath = System.getProperty("app.upload.dir", "uploads");

		// Đường dẫn đầy đủ của file cần xóa
		String filePath = uploadPath + File.separator + fileName;

		// Kiểm tra và xóa file
		File file = new File(filePath);
		if (file.exists()) {
			return file.delete();
		}
		return false; // File không tồn tại
	}
}
