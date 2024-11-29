package com.web.dto;

import java.util.Date;

public class CommentResponseDTO {

	private String hoTenNguoiComment;
	private String anhNguoiComment;
	private Date thoiGian;
	private String noiDung;

	public CommentResponseDTO() {
	}

	public CommentResponseDTO(String hoTenNguoiComment, String anhNguoiComment, Date thoiGian, String noiDung) {
		this.hoTenNguoiComment = hoTenNguoiComment;
		this.anhNguoiComment = anhNguoiComment;
		this.thoiGian = thoiGian;
		this.noiDung = noiDung;
	}

	public String getHoTenNguoiComment() {
		return hoTenNguoiComment;
	}

	public void setHoTenNguoiComment(String hoTenNguoiComment) {
		this.hoTenNguoiComment = hoTenNguoiComment;
	}

	public String getAnhNguoiComment() {
		return anhNguoiComment;
	}

	public void setAnhNguoiComment(String anhNguoiComment) {
		this.anhNguoiComment = anhNguoiComment;
	}

	public Date getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
}
