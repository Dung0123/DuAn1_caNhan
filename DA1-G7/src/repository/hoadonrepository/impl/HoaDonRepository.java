/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.hoadonrepository.impl;

import model.HoaDon;
import java.util.ArrayList;
import java.util.List;
import model.HoaDonChiTiet;
import repository.hoadonrepository.IHoaDonRepository;
import util.Xhelp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import model.HoaDonBackup;
import model.HoaDonChiTietBackup;
import util.DBConnect;

public class HoaDonRepository implements IHoaDonRepository {

    private final Connection conn = DBConnect.getConnection();

    private LocalDateTime localDateTime;

    final String selecLocSPCT = "select  HoaDon.maHoaDon as maHoaDon, SanPham.ten as tenSp,\n"
            + "           HoaDonChiTiet.soLuong,HoaDonChiTiet.giaTien,HoaDonChiTiet.thanhTien,HoaDon.ngayTao\n"
            + "            from HoaDonChiTiet left join HoaDon \n"
            + "            on HoaDonChiTiet.idHoaDon = HoaDon.id INNER JOIN SanPhamChiTiet \n"
            + "            	ON HoaDonChiTiet.idSanPhamChiTiet = SanPhamChiTiet.id inner join Voucher \n"
            + "           on Voucher.id = HoaDon.idVoucher join SanPham on SanPham.id = SanPhamChiTiet.idSanPham where HoaDon.ngayTao BETWEEN  ? and ? ";
    final String selecLocCT = "select  HoaDon.maHoaDon as maHoaDon, SanPham.ten as tenSp,\n"
            + "           HoaDonChiTiet.soLuong,HoaDonChiTiet.giaTien,HoaDonChiTiet.thanhTien,HoaDon.ngayTao\n"
            + "            from HoaDonChiTiet left join HoaDon \n"
            + "            on HoaDonChiTiet.idHoaDon = HoaDon.id INNER JOIN SanPhamChiTiet \n"
            + "            	ON HoaDonChiTiet.idSanPhamChiTiet = SanPhamChiTiet.id inner join Voucher \n"
            + "           on Voucher.id = HoaDon.idVoucher join SanPham on SanPham.id = SanPhamChiTiet.idSanPham \n"
            + "		   where HoaDon.maHoaDon = ?";
    final String SELECT_BY_Supper = " SELECT \n"
            + "                                      HoaDon.maHoaDon as maHoaDon,\n"
            + "                                      KhachHang.ten AS tenKhachHang,\n"
            + "                                      NhanVien.ten AS tenNhanVien,\n"
            + "                                      Voucher.giaTriGiam as giaTriVoucher,\n"
            + "                                      HoaDon.tongTien as tongTienHoaDon,\n"
            + "                                  	HoaDon.tongTienGiam AS tongTienGiam,\n"
            + "                                      HoaDon.ngayTao as ngayTaoHoaDon,\n"
            + "                                      HoaDon.ghiChu as ghiChuHoaDon,\n"
            + "                                      HoaDon.trangThai as trangThaiHoaDon\n"
            + "                                  FROM \n"
            + "                                      HoaDon\n"
            + "                                  JOIN \n"
            + "                                     KhachHang ON HoaDon.idKhachHang = KhachHang.id\n"
            + "                                  JOIN \n"
            + "                                      NhanVien ON HoaDon.idNhanVien = NhanVien.id\n"
            + "                                  LEFT JOIN \n"
            + "                                      Voucher ON HoaDon.idVoucher = Voucher.id\n"
            + "                   where HoaDon.ngayTao  BETWEEN ? and ? ";
    final String SELECT_BY_ID = " SELECT \n"
            + "                                      HoaDon.maHoaDon as maHoaDon,\n"
            + "                                      KhachHang.ten AS tenKhachHang,\n"
            + "                                      NhanVien.ten AS tenNhanVien,\n"
            + "                                      Voucher.giaTriGiam as giaTriVoucher,\n"
            + "                                      HoaDon.tongTien as tongTienHoaDon,\n"
            + "                                  	HoaDon.tongTienGiam AS tongTienGiam,\n"
            + "                                      HoaDon.ngayTao as ngayTaoHoaDon,\n"
            + "                                      HoaDon.ghiChu as ghiChuHoaDon,\n"
            + "                                      HoaDon.trangThai as trangThaiHoaDon\n"
            + "                                  FROM \n"
            + "                                      HoaDon\n"
            + "                                  JOIN \n"
            + "                                     KhachHang ON HoaDon.idKhachHang = KhachHang.id\n"
            + "                                  JOIN \n"
            + "                                      NhanVien ON HoaDon.idNhanVien = NhanVien.id\n"
            + "                                  LEFT JOIN \n"
            + "                                      Voucher ON HoaDon.idVoucher = Voucher.id \n"
            + "				where HoaDon.maHoaDon = ? and HoaDon.trangThai = ?";
    final String SELECT_ALL_SQL = """
                                  SELECT 
                                      HoaDon.maHoaDon as maHoaDon,
                                      KhachHang.ten AS tenKhachHang,
                                      NhanVien.ten AS tenNhanVien,
                                      Voucher.giaTriGiam as giaTriVoucher,
                                      HoaDon.tongTien as tongTienHoaDon,
                                  	HoaDon.tongTienGiam AS tongTienGiam,
                                      HoaDon.ngayTao as ngayTaoHoaDon,
                                      HoaDon.ghiChu as ghiChuHoaDon,
                                      HoaDon.trangThai as trangThaiHoaDon
                                  FROM 
                                      HoaDon
                                  JOIN 
                                     KhachHang ON HoaDon.idKhachHang = KhachHang.id
                                  JOIN 
                                      NhanVien ON HoaDon.idNhanVien = NhanVien.id
                                  LEFT JOIN 
                                      Voucher ON HoaDon.idVoucher = Voucher.id;
                                  """;
    final String SELECT_ALL_SQLCT = """
                                    	select  HoaDon.maHoaDon as maHoaDon, SanPham.ten as tenSp,
                                               HoaDonChiTiet.soLuong,HoaDonChiTiet.giaTien,HoaDonChiTiet.thanhTien,HoaDon.ngayTao
                                                from HoaDonChiTiet left join HoaDon 
                                                on HoaDonChiTiet.idHoaDon = HoaDon.id INNER JOIN SanPhamChiTiet 
                                                	ON HoaDonChiTiet.idSanPhamChiTiet = SanPhamChiTiet.id inner join Voucher 
                                               on Voucher.id = HoaDon.idVoucher join SanPham on SanPham.id = SanPhamChiTiet.idSanPham 
                                    """;
    private List<HoaDon> listHoaDon = new ArrayList<>();
    private List<HoaDonChiTiet> listHoaDonCT = new ArrayList<>();

    @Override
    public ArrayList<HoaDon> selectAll() {
        listHoaDon = new ArrayList<>();
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public ArrayList<HoaDon> selectloc(String ma, int tt) {
        listHoaDon = new ArrayList<>();
        return selectBySql(SELECT_BY_ID, ma, tt);
    }

    @Override
    public ArrayList<HoaDon> selectBySql(String sql, Object... args) {
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        try {
            ResultSet rs = Xhelp.excuteQuery(sql, args);
            while (rs.next()) {
                HoaDon sp = new HoaDon();
                sp.setId(rs.getString("maHoaDOn"));
                sp.setIdKhacHang(rs.getString("tenKhachHang"));
                sp.setIdNhanVien(rs.getString("tenNhanVien"));
                sp.setGiaTriVoucher(rs.getBigDecimal("giaTriVoucher"));
                sp.setNgayTao(rs.getDate("ngayTaoHoaDon"));
                sp.setTongTien(rs.getBigDecimal("tongTienHoaDon"));
                sp.setTongTienGiam(rs.getBigDecimal("tongTienGiam"));
                sp.setTrangthai(rs.getInt("trangThaiHoaDon"));
                listHoaDon.add(sp);
            }
        } catch (Exception e) {
        }
        return listHoaDon;
    }

    @Override
    public ArrayList<HoaDon> selectlocSupper(String bd, String kt) {
        listHoaDon = new ArrayList<>();
        return selectBySql(SELECT_BY_Supper, bd, kt);
    }

    @Override
    public ArrayList<HoaDonChiTiet> selectAllCT() {
        listHoaDonCT = new ArrayList<>();
        return selectBySqlCT(SELECT_ALL_SQLCT);
    }

    @Override
    public ArrayList<HoaDonChiTiet> selectBySqlCT(String sql, Object... args) {
        ArrayList<HoaDonChiTiet> listHoaDonCt = new ArrayList<>();
        try {
            ResultSet rs = Xhelp.excuteQuery(sql, args);
            while (rs.next()) {
                HoaDonChiTiet sp = new HoaDonChiTiet();
                sp.setIdHoaDon(rs.getString("maHoaDon"));
                sp.setTenSp(rs.getString("tenSp"));
                sp.setSoLuong(rs.getInt("soLuong"));
                sp.setGiaTien(rs.getBigDecimal("giaTien"));
                sp.setThanhTien(rs.getBigDecimal("thanhTien"));
                sp.setNgayTao(rs.getDate("ngayTao"));
                listHoaDonCt.add(sp);

            }
        } catch (Exception e) {
        }
        return listHoaDonCt;
    }

    @Override
    public ArrayList<HoaDonChiTiet> selectlocCT(String ma) {
        listHoaDonCT = new ArrayList<>();
        return selecttimkiemCT(selecLocCT, ma);
    }

    @Override
    public ArrayList<HoaDonChiTiet> selecttimkiemCT(String sql, Object... args) {
        ArrayList<HoaDonChiTiet> listHoaDonCt = new ArrayList<>();
        try {
            ResultSet rs = Xhelp.excuteQuery(sql, args);
            while (rs.next()) {
                HoaDonChiTiet sp = new HoaDonChiTiet();
                sp.setIdHoaDon(rs.getString("maHoaDon"));
                sp.setTenSp(rs.getString("tenSp"));
                sp.setSoLuong(rs.getInt("soLuong"));
                sp.setGiaTien(rs.getBigDecimal("giaTien"));
                sp.setThanhTien(rs.getBigDecimal("thanhTien"));
                sp.setNgayTao(rs.getDate("ngayTao"));
                listHoaDonCt.add(sp);
            }
        } catch (Exception e) {
        }
        return listHoaDonCt;
    }

    @Override
    public ArrayList<HoaDonChiTiet> selectlocSupperCT(String bd, String kt) {
        listHoaDonCT = new ArrayList<>();
        return selectBySqlCT(selecLocSPCT, bd, kt);
    }

    @Override
    public Boolean addHoaDon(HoaDonBackup hoaDonBackup) {
        int check = 0;
        String query = """
                       INSERT INTO HoaDon (maHoaDon, idNhanVien, idKhachHang,
                       ngayTao, trangThai)
                       VALUES(?, ?, ?, ?, 0);
                       """;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, hoaDonBackup.getMaHoaDon());
            ps.setObject(2, hoaDonBackup.getIdNhanVien());
            ps.setObject(3, hoaDonBackup.getIdKhachHang());
            ps.setObject(4, localDateTime.now());
            check = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public List<HoaDonBackup> getAllHoaDonDaThanhToan() {
        String query = """
                       SELECT hd.id, hd.maHoaDon, hd.idNhanVien,
                       nv.ten AS tenNhanVien, hd.idKhachHang, kh.ten AS tenKhachHang,
                       hd.hinhThucThanhToan, hd.tongTien, hd.tongTienGiam,
                       hd.ngayTao, hd.trangThai FROM HoaDon hd
                       JOIN NhanVien nv ON hd.idNhanVien = nv.id
                       JOIN KhachHang kh ON hd.idKhachHang = kh.id 
                       WHERE hd.trangThai = 1
                       ORDER BY hd.ngayTao DESC
                       """;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            List<HoaDonBackup> listHoaDon = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listHoaDon.add(new HoaDonBackup(rs.getInt(1),
                        rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getInt(5),
                        rs.getString(6), rs.getString(7),
                        rs.getDouble(8), rs.getDouble(9),
                        rs.getTimestamp(10).toLocalDateTime(),
                        rs.getBoolean(11)));
            }
            return listHoaDon;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<HoaDonBackup> getAllHoaDonChuaThanhToan() {
        String query = """
                       SELECT hd.id, hd.maHoaDon, hd.idNhanVien,
                       nv.ten AS tenNhanVien, hd.idKhachHang, kh.ten AS tenKhachHang,
                       hd.hinhThucThanhToan, hd.tongTien, hd.tongTienGiam,
                       hd.ngayTao, hd.trangThai FROM HoaDon hd
                       JOIN NhanVien nv ON hd.idNhanVien = nv.id
                       JOIN KhachHang kh ON hd.idKhachHang = kh.id 
                       WHERE hd.trangThai = 0
                       ORDER BY hd.ngayTao DESC
                       """;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            List<HoaDonBackup> listHoaDon = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listHoaDon.add(new HoaDonBackup(rs.getInt(1),
                        rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getInt(5),
                        rs.getString(6), rs.getString(7),
                        rs.getDouble(8), rs.getDouble(9),
                        rs.getTimestamp(10).toLocalDateTime(),
                        rs.getBoolean(11)));
            }
            return listHoaDon;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public HoaDonBackup findHoaDonByMa(String ma) {
        String query = """
                       SELECT id, maHoaDon, idNhanVien, idKhachHang,
                       hinhThucThanhToan, tongTien, tongTienGiam,
                       ngayTao, trangThai, idVoucher FROM HoaDon
                       WHERE maHoaDon = ?
                       """;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, ma);
            HoaDonBackup hoaDonBackup = new HoaDonBackup();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hoaDonBackup.setId(rs.getInt(1));
                hoaDonBackup.setMaHoaDon(rs.getString(2));
                hoaDonBackup.setIdNhanVien(rs.getInt(3));
                hoaDonBackup.setIdKhachHang(rs.getInt(4));
                hoaDonBackup.setHinhThucThanhToan(rs.getString(5));
                hoaDonBackup.setTongTien(rs.getDouble(6));
                hoaDonBackup.setTongTienGiam(rs.getDouble(7));
                hoaDonBackup.setNgayTao(rs.getTimestamp(8).toLocalDateTime());
                hoaDonBackup.setTrangThai(rs.getBoolean(9));
                hoaDonBackup.setIdVoucher(rs.getInt(10));
            }
            return hoaDonBackup;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<HoaDonChiTietBackup> getAllByIdHoaDon(int idHoaDon) {
        String query = """
                       SELECT hdct.id, hdct.idSanPhamChiTiet, spct.ma, sp.id, sp.ten,
                       hdct.idHoaDon, hdct.soLuong, hdct.giaTien,
                       (hdct.soLuong * hdct.giaTien) FROM HoaDonChiTiet hdct
                       JOIN HoaDon hd ON hdct.idHoaDon = hd.id
                       JOIN SanPhamChiTiet spct ON hdct.idSanPhamChiTiet = spct.id
                       JOIN SanPham sp ON spct.idSanPham = sp.id WHERE hd.id = ?
                       """;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idHoaDon);
            List<HoaDonChiTietBackup> listHoaDonChiTiet = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listHoaDonChiTiet.add(new HoaDonChiTietBackup(rs.getInt(1),
                        rs.getInt(2), rs.getString(3),
                        rs.getInt(4), rs.getString(5),
                        rs.getInt(6), rs.getInt(7),
                        rs.getDouble(8), rs.getDouble(9)));
            }
            return listHoaDonChiTiet;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateTrangThaiHoaDon(String ma) {
        int check = 0;
        String query = """
                       UPDATE HoaDon SET trangThai = 1 WHERE maHoaDon = ?
                       """;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public void updateTongTien(int idHoaDon) {
        String query = """
                       UPDATE HoaDon SET tongTien = (SELECT SUM(thanhTien) FROM HoaDonChiTiet hdct WHERE hdct.idHoaDon = ?) WHERE id = ?
                       """;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idHoaDon);
            ps.setObject(2, idHoaDon);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Boolean addHoaDonChiTiet(HoaDonChiTietBackup hoaDonChiTietBackup) {
        try (Connection conn = DBConnect.getConnection()) {
            String checkExistingQuery = "SELECT soLuong FROM HoaDonChiTiet WHERE idHoaDon = ? AND idSanPhamChiTiet = ?";
            try (PreparedStatement checkPs = conn.prepareStatement(checkExistingQuery)) {
                checkPs.setObject(1, hoaDonChiTietBackup.getIdHoaDon());
                checkPs.setObject(2, hoaDonChiTietBackup.getIdSanPhamChiTiet());
                ResultSet rs = checkPs.executeQuery();

                if (rs.next()) {
                    int currentSoLuong = rs.getInt("soLuong");
                    int newSoLuong = currentSoLuong + hoaDonChiTietBackup.getSoLuong();
                    return updateQuantity(hoaDonChiTietBackup.getIdHoaDon(), hoaDonChiTietBackup.getIdSanPhamChiTiet(), newSoLuong);
                } else {
                    String insertQuery = "INSERT INTO HoaDonChiTiet (idSanPhamChiTiet, idHoaDon, soLuong, giaTien, thanhTien) VALUES (?, ?, ?, ?, ?)";
                    try (PreparedStatement insertPs = conn.prepareStatement(insertQuery)) {
                        insertPs.setObject(1, hoaDonChiTietBackup.getIdSanPhamChiTiet());
                        insertPs.setObject(2, hoaDonChiTietBackup.getIdHoaDon());
                        insertPs.setObject(3, hoaDonChiTietBackup.getSoLuong());
                        insertPs.setObject(4, hoaDonChiTietBackup.getGiaTien());
                        insertPs.setObject(5, hoaDonChiTietBackup.getGiaTien() * hoaDonChiTietBackup.getSoLuong());
                        return insertPs.executeUpdate() > 0;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return false;
    }

    public boolean updateQuantity(int idHoaDon, int idSanPhamChiTiet, int newSoLuong) {
        int check = 0;
        String query = "UPDATE HoaDonChiTiet SET soLuong = ?, thanhTien = ? * giaTien WHERE idHoaDon = ? AND idSanPhamChiTiet = ?";
        try (Connection conn = DBConnect.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, newSoLuong);
            ps.setObject(2, newSoLuong);
            ps.setInt(3, idHoaDon);
            ps.setInt(4, idSanPhamChiTiet);
            check = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean updateSoLuongForSanPhamAndGioHang(int idHoaDon, int idSanPhamChiTiet, int newSoLuong) {
        try (Connection conn = DBConnect.getConnection()) {
            int currentSoLuongHoaDonChiTiet = getCurrentSoLuongHoaDonChiTiet(idHoaDon, idSanPhamChiTiet);
            int soLuongDifference = newSoLuong - currentSoLuongHoaDonChiTiet;

            boolean updateSanPhamChiTiet = updateSoLuongSanPhamChiTiet(idSanPhamChiTiet, -soLuongDifference);
            boolean updateHoaDonChiTiet = updateSoLuongHoaDonChiTiet(idHoaDon, idSanPhamChiTiet, newSoLuong);

            return updateSanPhamChiTiet && updateHoaDonChiTiet;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return false;
    }

    private int getCurrentSoLuongHoaDonChiTiet(int idHoaDon, int idSanPhamChiTiet) throws Exception {
        String query = """
                       SELECT soLuong FROM HoaDonChiTiet WHERE idHoaDon = ? AND idSanPhamChiTiet = ?
                       """;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, idHoaDon);
            ps.setInt(2, idSanPhamChiTiet);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("soLuong");
            }
            return 0;
        }
    }

    private boolean updateSoLuongSanPhamChiTiet(int idSanPhamChiTiet, int soLuongDifference) throws Exception {
        String query = """
                       UPDATE SanPhamChiTiet SET soLuong = soLuong + ? WHERE id = ?
                       """;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, soLuongDifference);
            ps.setInt(2, idSanPhamChiTiet);
            return ps.executeUpdate() > 0;
        }
    }

    private boolean updateSoLuongHoaDonChiTiet(int idHoaDon, int idSanPhamChiTiet, int newSoLuong) throws Exception {
        String query = """
                       UPDATE HoaDonChiTiet SET soLuong = ?, thanhTien = ? * giaTien WHERE idHoaDon = ? AND idSanPhamChiTiet = ?
                       """;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, newSoLuong);
            ps.setObject(2, newSoLuong);
            ps.setInt(3, idHoaDon);
            ps.setInt(4, idSanPhamChiTiet);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean updateHinhThucThanhToanHoaDon(String ma, String hinhThucThanhToan) {
        int check = 0;
        String query = """
                       UPDATE HoaDon SET hinhThucThanhToan = ? WHERE maHoaDon = ?
                       """;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, hinhThucThanhToan);
            ps.setObject(2, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
}
