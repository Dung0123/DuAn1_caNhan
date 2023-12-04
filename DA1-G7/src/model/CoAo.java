package model;

import java.time.LocalDateTime;

/**
 *
 * @author cuongwf
 */
public class CoAo {

    private int id;
    private String ma;
    private String ten;
    private LocalDateTime ngayTao;
    private LocalDateTime ngaySua;
    private boolean isDelete;

    public CoAo() {
    }

    public CoAo(int id, String ma, String ten, LocalDateTime ngayTao, LocalDateTime ngaySua, boolean isDelete) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.isDelete = isDelete;
    }

    public CoAo(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    public LocalDateTime getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(LocalDateTime ngaySua) {
        this.ngaySua = ngaySua;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return ten;
    }

}
