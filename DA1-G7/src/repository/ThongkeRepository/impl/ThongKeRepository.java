/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.ThongkeRepository.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import model.HoaDon;
import model.ThongKe;
import model.ThongkeBanHang;
import repository.ThongkeRepository.IThongRepository;
import util.Xhelp;

/**
 *
 * @author ledun
 */
public class ThongKeRepository implements IThongRepository {

    final String selectAllSanPhamBanchay = """
                                           SELECT 
                                               sp.ma AS 'Mã Sản Phẩm',
                                               sp.ten AS 'Tên Sản Phẩm',
                                               spct.soLuong AS 'Số Lượng Tồn Kho',
                                               spct.trangthai AS 'Trạng Thái'
                                           FROM 
                                               SanPham sp
                                           JOIN 
                                               SanPhamChiTiet spct ON sp.id = spct.idSanPham
                                           ORDER BY 
                                               spct.soLuong ASC;
                                           """;
    final String selectAllSanPhamTon = """
                                       
                                       SELECT 
                                           sp.ma AS 'Mã Sản Phẩm',
                                           sp.ten AS 'Tên Sản Phẩm',
                                           spct.soLuong AS 'Số Lượng Tồn Kho',
                                           spct.trangthai AS 'Trạng Thái'
                                       FROM 
                                           SanPham sp
                                       JOIN 
                                           SanPhamChiTiet spct ON sp.id = spct.idSanPham
                                       ORDER BY 
                                           spct.soLuong DESC;
                                       """;
    final String SeleccLocBanHang = "SELECT "
            + "sp.ma AS 'Mã Sản Phẩm', "
            + "sp.ten AS 'Tên Sản Phẩm', "
            + "SUM(hdct.soLuong) AS 'Tổng Số Lượng Bán Ra', "
            + "SUM(hdct.thanhTien) AS 'Tổng Tiền' "
            + "FROM "
            + "SanPham sp "
            + "JOIN "
            + "SanPhamChiTiet spct ON sp.id = spct.idSanPham "
            + "JOIN "
            + "HoaDonChiTiet hdct ON spct.id = hdct.idSanPhamChiTiet "
            + "JOIN hoaDon ON hoaDon.id = hdct.idHoaDon "
            + "WHERE "
            + "hoaDon.ngayTao > = ? AND "
            + "hoaDon.ngayTao <  = ? "
            + "GROUP BY "
            + "sp.ma, sp.ten "
            + "ORDER BY "
            + "SUM(hdct.soLuong) DESC";

    final String selectcBanHang = """
               SELECT 
                    sp.ma AS 'Mã Sản Phẩm', 
                   sp.ten AS 'Tên Sản Phẩm', 
                    SUM(hdct.soLuong) AS 'Tổng Số Lượng Bán Ra',
                    SUM(hdct.thanhTien) AS 'Tổng Tiền' 
                    FROM 
                    SanPham sp 
                    JOIN 
                    SanPhamChiTiet spct ON sp.id = spct.idSanPham 
                    JOIN 
                    HoaDonChiTiet hdct ON spct.id = hdct.idSanPhamChiTiet join HoaDon on HoaDon.id = hdct.idHoaDon
                   
                   GROUP BY 
                    sp.ma, sp.ten 
                    ORDER BY
                    SUM(hdct.soLuong) DESC
                                  """;
    final String selectcBanHangbyTen = "SELECT sp.ma AS 'Mã Sản Phẩm', sp.ten AS 'Tên Sản Phẩm', "
            + "SUM(hdct.soLuong) AS 'Tổng Số Lượng Bán Ra', "
            + "SUM(hdct.thanhTien) AS 'Tổng Tiền' "
            + "FROM SanPham sp "
            + "JOIN SanPhamChiTiet spct ON sp.id = spct.idSanPham "
            + "JOIN HoaDonChiTiet hdct ON spct.id = hdct.idSanPhamChiTiet "
            + "JOIN HoaDon ON HoaDon.id = hdct.idHoaDon "
            + "WHERE sp.ten LIKE ? "
            + "GROUP BY sp.ma, sp.ten "
            + "ORDER BY SUM(hdct.soLuong) DESC";

    @Override
    public ArrayList<ThongKe> selectAllSanPhamBanchay() {
        return selectAllSanPhamBanchay(selectAllSanPhamBanchay);
    }

    @Override
    public ArrayList<ThongKe> selectAllSanPhamTon() {
        return selectAllSanPhamBanchay(selectAllSanPhamTon);
    }

    @Override
    public ArrayList<ThongkeBanHang> selectcBanHang() {
        return selectcBanHang(selectcBanHang);
    }

    @Override
    public ArrayList<ThongkeBanHang> SeleccLocBanHang(Date bd, Date kt) {
        return selectcBanHangTK("SELECT \n"
                + "            sp.ma, \n"
                + "            sp.ten  ,\n"
                + "            SUM(hdct.soLuong)  ,\n"
                + "            SUM(hdct.thanhTien) \n"
                + "            FROM \n"
                + "            SanPham sp \n"
                + "            JOIN \n"
                + "            SanPhamChiTiet spct ON sp.id = spct.idSanPham \n"
                + "            JOIN \n"
                + "            HoaDonChiTiet hdct ON spct.id = hdct.idSanPhamChiTiet \n"
                + "            JOIN hoaDon ON hoaDon.id = hdct.idHoaDon \n"
                + "            WHERE \n"
                + "            hoaDon.ngayTao > = ? AND \n"
                + "            hoaDon.ngayTao <  = ? \n"
                + "            GROUP BY \n"
                + "            sp.ma, sp.ten \n"
                + "            ORDER BY \n"
                + "            SUM(hdct.soLuong) DESC;", bd, kt);
    }

    public ArrayList<ThongKe> selectAllSanPhamBanchay(String sql, Object... args) {
        ArrayList<ThongKe> list = new ArrayList<>();
        try {
            ResultSet rs = Xhelp.excuteQuery(sql, args);
            while (rs.next()) {
                ThongKe sp = new ThongKe();
                sp.setMa(rs.getString(1));
                sp.setTen(rs.getNString(2));
                sp.setSoLuong(rs.getInt(3));
                sp.setTrangThai(rs.getInt(4));
                list.add(sp);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<ThongkeBanHang> selectcBanHang(String sql, Object... args) {
        ArrayList<ThongkeBanHang> listbanHang = new ArrayList<>();
        try {
            ResultSet rs = Xhelp.excuteQuery(sql, args);
            while (rs.next()) {
                ThongkeBanHang sp = new ThongkeBanHang();
                sp.setMa(rs.getString(1));
                sp.setTen(rs.getNString(2));
                sp.setSoLuong(rs.getInt(3));
                sp.setTongTien(rs.getDouble(4));
                listbanHang.add(sp);
            }
        } catch (Exception e) {
        }
        return listbanHang;
    }

    public ArrayList<ThongkeBanHang> selectcBanHangTK(String sql, Object... args) {
        ArrayList<ThongkeBanHang> listbanHang = new ArrayList<>();
        try {
            ResultSet rs = Xhelp.excuteQuery(sql, args);
            while (rs.next()) {
                ThongkeBanHang sp = new ThongkeBanHang();
                sp.setMa(rs.getString(1));
                sp.setTen(rs.getNString(2));
                sp.setSoLuong(rs.getInt(3));
                sp.setTongTien(rs.getDouble(4));
                listbanHang.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(listbanHang.toString() + " lấy ra loc");
        return listbanHang;
    }

    @Override
    public ArrayList<ThongkeBanHang> selectcBanHangbyten(String ma) {
        return selectcBanHang(selectcBanHangbyTen, ma);
    }
}
