/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utils.XJdbc;
import Entity.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhachHangDAO extends TrangChuKHDAO<KhachHang, String> {

    public void insert(KhachHang model) {
        String sql = "Insert Into KHACHHANG (MAKH, TENKH ,GIOITINH, NGAYSINH, SODT, EMAIL, DIACHI)values (?,?,?,?,?,?,?) ";
        XJdbc.update(sql,
                model.getMaKH(),
                model.getHoTen(),
                model.getGioiTinh(),
                model.getNgaySinh(),
                model.getSoDT(),
                model.getEmail(),
                model.getDiaChi());

    }

    public void update(KhachHang model) {
        String sql = "Update KHACHHANG set TENKH=?,GIOITINH=?, NGAYSINH=?, SODT=?, EMAIL=?, DIACHI=? where MaKH=?";
        XJdbc.update(sql,
                model.getHoTen(),
                model.getGioiTinh(),
                model.getNgaySinh(),
                model.getSoDT(),
                model.getEmail(),
                model.getDiaChi(),
                model.getMaKH());
    }

    public void delete(String Makh) {
        String sql = "Delete from KHACHHANG where MaKH=?";
        XJdbc.update(sql, Makh);
    }

    public List<KhachHang> selectAll() {
        String sql = "Select * from KHACHHANG";
        return this.selectBySql(sql);
    }

    public KhachHang selectById(String MaKH) {
        String sql = "SELECT * FROM KHACHHANG WHERE MaKh=?";
        List<KhachHang> list = this.selectBySql(sql, MaKH);
        return list.size() > 0 ? list.get(0) : null;
    }

    protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    KhachHang entity = new KhachHang();
                    entity.setMaKH(rs.getString("MaKH"));
                    entity.setHoTen(rs.getString("TenKH"));
                    entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                    entity.setNgaySinh(rs.getDate("NgaySinh"));
                    entity.setSoDT(rs.getString("SoDT"));
                    entity.setEmail(rs.getString("Email"));
                    entity.setDiaChi(rs.getString("Diachi"));
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

}
