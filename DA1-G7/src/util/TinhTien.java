package util;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author cuongwf
 */
public class TinhTien extends Thread implements Runnable {

    private JTextField tongTien;
    private JTextField tienKhachDua;
    private JTextField tienThua;
    private JTextField tienKhachChuyenKhoan;
    private JComboBox<String> cbbHinhThucThanhToan;
    private JButton thanhToan;

    public TinhTien(JTextField tongTien, JTextField tienKhachDua, JTextField tienThua, JTextField tienKhachChuyenKhoan, JComboBox<String> cbbHinhThucThanhToan, JButton thanhToan) {
        this.tongTien = tongTien;
        this.tienKhachDua = tienKhachDua;
        this.tienThua = tienThua;
        this.tienKhachChuyenKhoan = tienKhachChuyenKhoan;
        this.cbbHinhThucThanhToan = cbbHinhThucThanhToan;
        this.thanhToan = thanhToan;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (!tongTien.getText().isEmpty()) {
                    double tongTienValue = Double.parseDouble(tongTien.getText());

                    SwingUtilities.invokeLater(() -> {
                        String hinhThucThanhToan = (String) cbbHinhThucThanhToan.getSelectedItem();

                        if ("Tiền mặt".equals(hinhThucThanhToan)) {
                            handleTienMat(tongTienValue);
                        } else if ("Chuyển khoản".equals(hinhThucThanhToan)) {
                            handleChuyenKhoan(tongTienValue);
                        } else if ("Kết hợp".equals(hinhThucThanhToan)) {
                            handleKetHop(tongTienValue);
                        }
                    });
                }
                Thread.sleep(100);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void handleTienMat(double tongTienValue) {
        try {
            if (!tienKhachDua.getText().isEmpty()) {
                double tienKhachDuaValue = Double.parseDouble(tienKhachDua.getText());
                double tienThuaValue = tienKhachDuaValue - tongTienValue;

                SwingUtilities.invokeLater(() -> {
                    tienThua.setText(String.format("%.2f", tienThuaValue));
                    tienKhachChuyenKhoan.setText("");
                    thanhToan.setEnabled(tienKhachDuaValue >= tongTienValue);
                });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void handleChuyenKhoan(double tongTienValue) {
        SwingUtilities.invokeLater(() -> {
            tienKhachDua.setText("");
            tienKhachChuyenKhoan.setText(String.format("%.2f", tongTienValue)); // Cập nhật giá trị tienKhachChuyenKhoan
            tienThua.setText("");
            thanhToan.setEnabled(true);
        });
    }

    private void handleKetHop(double tongTienValue) {
        try {
            if (!tienKhachDua.getText().isEmpty()) {
                double tienKhachDuaValue = Double.parseDouble(tienKhachDua.getText());
                double tienKhachChuyenKhoanValue = tongTienValue - tienKhachDuaValue;

                SwingUtilities.invokeLater(() -> {
                    tienKhachChuyenKhoan.setText(String.format("%.2f", tienKhachChuyenKhoanValue));
                    tienThua.setText("");
                    thanhToan.setEnabled(tienKhachDuaValue >= tongTienValue);
                });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
