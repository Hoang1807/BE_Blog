package com.web.dto;

public class BlogResponseDTO {

	private Integer ma;
	private String tieuDe;
	private String noiDung;
	private String anh;

	public BlogResponseDTO() {
	}

	public BlogResponseDTO(Integer ma, String tieuDe, String noiDung, String anh) {
		this.ma = ma;
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
		this.anh = anh;
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

}
