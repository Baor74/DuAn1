/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.SanPham;
import Utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SanPhamDAO extends TrangChuKHDAO<SanPham, String> {

    public void insert(SanPham model) {
        String sql = "Insert Into SANPHAM (MASP, TENSP, MAU, HANGSX, GIABAN, GIAGOC, SOLUONG, NGAYNHAP, HINH)values (?,?,?,?,?,?,?,?,?) ";
        XJdbc.update(sql,
                model.getMaSP(),
                model.getTenSP(),
                model.getMau(),
                model.getHangSX(),
                model.getGiaBan(),
                model.getGiaGoc(),
                model.getSoLuong(),
                model.getNgayNhap(),
                model.getHinh());

    }

    public void update(SanPham model) {
        String sql = "Update SANPHAM set TENSP=?, MAU=?, HANGSX=?, GIABAN=?, GIAGOC=?, SOLUONG=?, NGAYNHAP=?, HINH=? where MASP=?";
        XJdbc.update(sql,
                model.getTenSP(),
                model.getMau(),
                model.getHangSX(),
                model.getGiaBan(),
                model.getGiaGoc(),
                model.getSoLuong(),
                model.getNgayNhap(),
                model.getHinh(),
                model.getMaSP());
    }

    public void delete(String MaSP) {
        String sql = "Delete from SANPHAM where MASP=?";
        XJdbc.update(sql, MaSP);
    }

    protected List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    SanPham entity = new SanPham();
                    entity.setMaSP(rs.getString("MaSP"));
                    entity.setTenSP(rs.getString("TenSP"));
                    entity.setMau(rs.getString("Mau"));
                    entity.setHangSX(rs.getString("HangSX"));
                    entity.setGiaBan(rs.getDouble("GiaBan"));
                    entity.setHinh(rs.getString("Hinh"));
                    entity.setGiaGoc(rs.getDouble("GiaGoc"));
                    entity.setSoLuong(rs.getInt("SoLuong"));
                    entity.setNgayNhap(rs.getDate("NgayNhap"));

                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<SanPham> selectAll() {
        String sql = "Select * From SANPHAM";
        return this.selectBySql(sql);
    }

    public SanPham selectById(String MaSP) {
String sql = "SELECT * FROM SANPHAM WHERE MASP =  ?";
        List<SanPham> list = this.selectBySql(sql, MaSP);
        return list.size() > 0 ? list.get(0) : null;
    }

}
