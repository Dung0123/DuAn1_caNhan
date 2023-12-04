/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ledun
 */
public class ThongKe {

    private String ma;
    private String ten;
    private int soLuong;
    private double giaBan;
    private double tongTien;
    private int trangThai;

    public ThongKe() {
    }

    public ThongKe(String ma, String ten, int soLuong, double giaBan, double tongTien, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "ThongKe{" + "ma=" + ma + ", ten=" + ten + ", soLuong=" + soLuong + ", giaBan=" + giaBan + ", tongTien=" + tongTien + ", trangThai=" + trangThai + '}';
    }
    
    

}