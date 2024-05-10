/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class SanPham {
    private String maSP;
private String tenSP;
private String mau;
private String hangSX;
private double giaBan;
private double giaGoc;
private int soLuong;
private Date ngayNhap;
private String hinh;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, String mau, String hangSX, double giaBan, double giaGoc, int soLuong, Date ngayNhap, String hinh) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.mau = mau;
        this.hangSX = hangSX;
        this.giaBan = giaBan;
        this.giaGoc = giaGoc;
        this.soLuong = soLuong;
        this.ngayNhap = ngayNhap;
        this.hinh = hinh;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getHangSX() {
        return hangSX;
    }

    public void setHangSX(String hangSX) {
        this.hangSX = hangSX;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getGiaGoc() {
        return giaGoc;
    }

    public void setGiaGoc(double giaGoc) {
        this.giaGoc = giaGoc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }



}
