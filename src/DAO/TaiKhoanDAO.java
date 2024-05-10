package DAO;

import Utils.XJdbc;
import Entity.TaiKhoan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAO extends TrangChuKHDAO<TaiKhoan, String> {

    public void insert(TaiKhoan model) {
        String sql = "INSERT INTO TAIKHOAN (TenTK, MatKhau, ChucVu) VALUES (?, ?, ?)";
        XJdbc.update(sql,
                model.getUsername(),
                model.getPass(),
                model.getChucVu());
    }

    public void update(TaiKhoan model) {
        String sql = "UPDATE TAIKHOAN SET MatKhau=?, Chucvu=?,  WHERE TenTK=?";
        XJdbc.update(sql,
                model.getPass(),
                model.getChucVu(),
                model.getUsername());
    }

    public void delete(String Username) {
        String sql = "DELETE FROM TAIKHOAN WHERE TenTK=?";
        XJdbc.update(sql, Username);
    }

    public List<TaiKhoan> selectAll() {
        String sql = "SELECT * FROM TaiKhoan";
        return this.selectBySql(sql);
    }

    public TaiKhoan selectById(String Username) {
        String sql = "SELECT * FROM TaiKhoan WHERE TenTK = ?";
        List<TaiKhoan> list = this.selectBySql(sql,Username);
        return list.size() > 0 ? list.get(0) : null;
    }

    protected List<TaiKhoan> selectBySql(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    TaiKhoan entity = new TaiKhoan();
                    entity.setUsername(rs.getString("TenTK"));
                    entity.setPass(rs.getString("MatKhau"));
                    entity.setChucVu(rs.getString("Chucvu"));
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
