/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author soaic
 */
public class TaiKhoan {
    private String username;
    private String pass;
    private String chucVu;

    public TaiKhoan() {
    }

    public TaiKhoan(String username, String pass, String chucVu) {
        this.username = username;
        this.pass = pass;
        this.chucVu = chucVu;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

   

    

    
    
    
    
}
