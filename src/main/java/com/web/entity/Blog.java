package com.web.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.ToString;

@Entity
@ToString
@Table(name = "Blog")
public class Blog {

	private Integer ma;
	private Users users;
	private String tieuDe;
	private String noiDung;
	private Date thoiGian;
	private String anh;

	public Blog() {
	}

	public Blog(String tieuDe, String noiDung, String anh, Date thoiGian) {
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
		this.anh = anh;
		this.thoiGian = thoiGian;
	}

	public Blog(Users users, String tieuDe, String noiDung, String anh, Date thoiGian) {
		this.users = users;
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
		this.anh = anh;
		this.thoiGian = thoiGian;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "ma", unique = true, nullable = false)
	public Integer getMa() {
		return this.ma;
	}

	public void setMa(Integer ma) {
		this.ma = ma;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "email")
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "tieu_de", nullable = false)
	public String getTieuDe() {
		return this.tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	@Column(name = "noi_dung", nullable = false)
	public String getNoiDung() {
		return this.noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	@Column(name = "anh", nullable = false)
	public String getAnh() {
		return this.anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "thoi_gian", nullable = false, length = 23)
	public Date getThoiGian() {
		return this.thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}
}
