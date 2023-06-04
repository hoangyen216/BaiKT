package com.hoangyen.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;


import java.util.List;

@Entity
@Table(name = "phongban")
public class PhongBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maphong;
    @Column
    private String tenphong;
    @OneToMany(mappedBy = "phongBan", cascade = CascadeType.ALL)
    private List<NhanVien> listNhanVien;
	public long getMaphong() {
		return maphong;
	}
	public void setMaphong(long maphong) {
		this.maphong = maphong;
	}
	public String getTenphong() {
		return tenphong;
	}
	public void setTenphong(String tenphong) {
		this.tenphong = tenphong;
	}
	public List<NhanVien> getListNhanVien() {
		return listNhanVien;
	}
	public void setListNhanVien(List<NhanVien> listNhanVien) {
		this.listNhanVien = listNhanVien;
	}
    
    
}
