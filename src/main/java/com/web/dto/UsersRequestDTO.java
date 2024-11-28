package com.web.dto;

import org.springframework.web.multipart.MultipartFile;

public class UsersRequestDTO {

	private String email;
	private String hoTen;
	private String matKhau;
	private String anh;
	private MultipartFile file;

	public UsersRequestDTO() {
	}

	public UsersRequestDTO(String email, String hoTen, String matKhau, String anh, MultipartFile file) {
		this.email = email;
		this.hoTen = hoTen;
		this.matKhau = matKhau;
		this.anh = anh;
		this.file = file;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
