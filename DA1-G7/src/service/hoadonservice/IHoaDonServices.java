/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.hoadonservice;

import DomainModels.QLHoaDon;
import DomainModels.QLHoaDonChiTiet;
import model.HoaDon;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.HoaDonBackup;
import model.HoaDonChiTietBackup;

/**
 *
 * @author ledun
 */
public interface IHoaDonServices {

    public ArrayList<QLHoaDon> selectAll();

    public ArrayList<QLHoaDon> selectloc(String ma, int tt);

    public ArrayList<QLHoaDon> selectlocSupper(String bd, String kt);

    public ArrayList<QLHoaDonChiTiet> selectAllCT();

    public ArrayList<QLHoaDonChiTiet> selectlocCT(String ma);

    public ArrayList<QLHoaDonChiTiet> selectlocSupperCT(String bd, String kt);

    String addHoaDon(HoaDonBackup hoaDonBackup);

    String updateTrangThaiHoaDon(String ma);

    HoaDonBackup findHoaDonByMa(String ma);

    List<HoaDonBackup> getAllHoaDonDaThanhToan();

    List<HoaDonBackup> getAllHoaDonChuaThanhToan();

    List<HoaDonChiTietBackup> getAllByIdHoaDon(int idHoaDon);

    Boolean addHoaDonChiTiet(HoaDonChiTietBackup hoaDonChiTietBackup);

    void updateTongTien(int idHoaDon);

    boolean updateSoLuongForSanPhamAndGioHang(int idHoaDon, int idSanPhamChiTiet, int newSoLuong);

    boolean updateHinhThucThanhToanHoaDon(String ma, String hinhThucThanhToan);
}
