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
public class HoaDon {
    private int maHD;
private String maKH;
private float tongTien;
private Date ngTT;

    public HoaDon() {
    }

    public HoaDon(int maHD, String maKH, float tongTien, Date ngTT) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.tongTien = tongTien;
        this.ngTT = ngTT;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgTT() {
        return ngTT;
    }

    public void setNgTT(Date ngTT) {
        this.ngTT = ngTT;
    }

}
