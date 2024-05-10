/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.HoaDon;
import Entity.KhachHang;
import Utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoaDonDAO extends TrangChuKHDAO<HoaDon, String>{

    public void insert(HoaDon model) {
        String sql = "Insert Into HOADON(MAKH,TONGTIENTT,NGAYTHANHTOAN) values (?,?,?)";
        XJdbc.update(sql,
                model.getMaKH(),
                model.getTongTien(),
                model.getNgTT());
        

    }

    public void update(HoaDon model) {
        String sql = "Update HOADON set MAKH=?, TONGTIENTT=?,NGAYTHANHTOAN=? Where MaHD= ?";
        XJdbc.update(sql,
                model.getMaKH(),
                model.getTongTien(),
                model.getNgTT(),
                model.getMaHD());
    }

    public void delete(String mahd) {
        String sql = "Delete From HOADON where MAHD = ?";
        XJdbc.update(sql, mahd);
    }

    protected List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    HoaDon entity = new HoaDon();
                    entity.setMaHD(rs.getInt("MAHD"));
                    entity.setMaKH(rs.getString("MAKH"));
                    entity.setTongTien(rs.getFloat("TONGTIENTT"));
                    entity.setNgTT(rs.getDate("NGAYTHANHTOAN"));

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

    public List<HoaDon> selectAll() {
        String sql = "Select * from HOADON";
        return this.selectBySql(sql);
    }

    public HoaDon selectById(String MaKH) {
        String sql = "SELECT * FROM HOADON WHERE MaHD=?";
        List<HoaDon> list = this.selectBySql(sql, MaKH);
        return list.size() > 0 ? list.get(0) : null;
    }

}
