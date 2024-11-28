package com.web.dto;

import org.springframework.web.multipart.MultipartFile;
public class BlogRequestDTO {

	private Integer ma;
	private String tieuDe;
	private String noiDung;
	private String anh;
	private String email;
	private MultipartFile file;

	public BlogRequestDTO() {
	}

	public BlogRequestDTO(Integer ma, String tieuDe, String noiDung, String anh, String email, MultipartFile file) {
		this.ma = ma;
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
		this.anh = anh;
		this.email = email;
		this.file = file;
	}

	public Integer getMa() {
		return ma;
	}

	public void setMa(Integer ma) {
		this.ma = ma;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
