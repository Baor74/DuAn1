/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.HDCT;
import Utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HDCTDAO extends TrangChuKHDAO<HDCT, String> {

    public void insert(HDCT model) {
        String sql = "Insert Into HOADON(MAHD,MASP , SOLUONG) values (?,?,?)";
        XJdbc.update(sql,
                model.getMaHD(),
                model.getMaSP(),
                model.getSoLuong());
    }

    public void update(HDCT model) {
        String sql = "Update HOADON set MASP=?, SOLUONG=? Where MaHD= ?";
        XJdbc.update(sql,
                model.getMaSP(),
                model.getSoLuong(),
                model.getMaHD());
    }

    public void delete(String mahd) {
        String sql = "Delete From HOADONCHITIET where MAHD = ?";
        XJdbc.update(sql, mahd);
    }

    protected List<HDCT> selectBySql(String sql, Object... args) {
        List<HDCT> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    HDCT entity = new HDCT();
                    entity.setMaHD(rs.getInt("MAHD"));
                    entity.setMaSP(rs.getString("MASP"));
                    entity.setSoLuong(rs.getInt("SOLUONG"));

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

    public List<HDCT> selectAll() {
        String sql = "Select * from HOADONCHITIET";
        return this.selectBySql(sql);
    }

    public HDCT selectById(String MaKH) {
        String sql = "SELECT * FROM HOADONCHITIET WHERE MaHD=?";
        List<HDCT> list = this.selectBySql(sql, MaKH);
        return list.size() > 0 ? list.get(0) : null;
    }

}
