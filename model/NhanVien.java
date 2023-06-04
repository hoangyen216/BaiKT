package com.hoangyen.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "nhanvien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maNV;

    @Column
    private String tenNV;

    @Column
    private String phai;

    @Column
    private String noiSinh;

    @ManyToOne
    @JoinColumn(name = "maphong")
    private PhongBan phongBan;
    
    @Column
    private long luong;

	public long getMaNV() {
		return maNV;
	}

	public void setMaNV(long maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getPhai() {
		return phai;
	}

	public void setPhai(String phai) {
		this.phai = phai;
	}

	public String getNoiSinh() {
		return noiSinh;
	}

	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public long getLuong() {
		return luong;
	}

	public void setLuong(long luong) {
		this.luong = luong;
	}
    
}
