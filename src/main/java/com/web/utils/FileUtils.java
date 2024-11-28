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
		// Lấy thư mục làm việc hiện tại
		String currentDir = System.getProperty("user.dir");

		// Đường dẫn tới thư mục static/uploads trong thư mục resources
		String uploadPath = currentDir + File.separator + "src" + File.separator + "main" + File.separator + "resources"
				+ File.separator + "static" + File.separator + "uploads";

		// Tạo thư mục nếu nó không tồn tại
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs(); // Sử dụng mkdirs() để tạo các thư mục cha nếu cần thiết
		}

		// Generate a random filename for the file
		String fileName = UUID.randomUUID().toString() + ".jpg";

		// Full path of the destination file
		String filePath = uploadPath + File.separator + fileName;
		FileCopyUtils.copy(multipartFile.getBytes(), new File(filePath));
		return "uploads/" + fileName;
	}

	public static boolean deleteFile(String fileName) {
		// Lấy thư mục làm việc hiện tại
		String currentDir = System.getProperty("user.dir");

		// Đường dẫn tới thư mục static/uploads trong thư mục resources
		String uploadPath = currentDir + File.separator + "src" + File.separator + "main" + File.separator + "resources"
				+ File.separator + "static" + File.separator + "uploads";

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
