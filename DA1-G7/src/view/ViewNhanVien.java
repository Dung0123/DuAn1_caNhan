/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import DomainModels.QLCtNhanVien;
import DomainModels.QLNhanVien;
import com.sun.mail.imap.ACL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChucVu;
import model.CtNhanVien;
import model.NhanVien;
import model.SanPham;
import net.sf.jasperreports.components.table.fill.FillTable;
import repository.nhanvienrepository.NhanVienReponsitory;
import service.nhanvienservicies.NhanVienService;

/**
 *
 * @author bcuon
 */
public class ViewNhanVien extends javax.swing.JPanel {

    private DefaultComboBoxModel<ChucVu> dcbChucVu = new DefaultComboBoxModel<>();
    NhanVienService serv = new NhanVienService();

    public ViewNhanVien() {
        initComponents();
        load();
        loadct();
//        loadchuvu();
    }

    private void load() {
        DefaultTableModel model = (DefaultTableModel) this.tblNhanVien.getModel();
        model.setRowCount(0);
        for (QLNhanVien nv : this.serv.getList()) {
            String gt;
            String tt;
            if (nv.getGioiTinh() == 0) {
                gt = "Nữ";
            } else {
                gt = "Nam";
            }
            if (nv.getTrangThai() == 0) {
                tt = "Đã nghỉ";
            } else {
                tt = "Đang đi làm";
            }
            model.addRow(new Object[]{
                nv.getId(),
                nv.getMaNv(),
                nv.getTenNv(),
                nv.getSdt(),
                nv.getChucVu(),
                nv.getNgayTao(),
                nv.getNgaySua(),
                gt,
                tt
            });
        }
    }
    private void loadct() {
        DefaultTableModel model = (DefaultTableModel) this.tblNhanVienct.getModel();
        model.setRowCount(0);
        for (QLCtNhanVien nv : this.serv.getListct()) {
            model.addRow(new Object[]{
                nv.getId(), nv.getMa(), nv.getEmail(), nv.getSdt(), nv.getNgaySinh(), nv.getDiaChi(), nv.getPasss()
            });
            txtmact.setText(nv.getMa());
            txtsdtct.setText(nv.getSdt());
            txtEmailct.setText(nv.getEmail());
            txtDiaChict.setText(nv.getDiaChi());
        }
        
    }
    private void loadct1() {
        DefaultTableModel model = (DefaultTableModel) this.tblNhanVienct.getModel();
        model.setRowCount(0);
        for (QLCtNhanVien nv : this.serv.getListct()) {
            model.addRow(new Object[]{
                nv.getId(), nv.getMa(), nv.getEmail(), nv.getSdt(), nv.getNgaySinh(), nv.getDiaChi(), nv.getPasss()
            });
            txtmact.setText(nv.getMa());
            txtsdtct.setText(nv.getSdt());
            txtEmailct.setText(nv.getEmail());
            txtDiaChict.setText(nv.getDiaChi());
        }
        
    }
 
    private QLCtNhanVien getFormCT() {

        QLCtNhanVien nv = new QLCtNhanVien();

        String ma = this.txtmact.getText();
        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mã là bắt buộc. Vui lòng nhập một mã hợp lệ.");
            return null; // Stop further processing
        }
        nv.setMa(ma);

// Validate Email
        String email = this.txtEmailct.getText();
        if (email.isEmpty() || !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            JOptionPane.showMessageDialog(null, "Email không hợp lệ. Vui lòng nhập một địa chỉ email hợp lệ.");
            return null; // Stop further processing
        }
        nv.setEmail(email);

// Validate SDT
        String sdt = this.txtsdtct.getText();
        if (sdt.isEmpty() || !sdt.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ. Vui lòng nhập một số điện thoại có 10 chữ số.");
            return null; // Stop further processing
        }
        nv.setSdt(sdt);

// Validate NgaySinh (Date)
        Date ngaySinh = this.dateNgSinh.getDate();
        if (ngaySinh == null) {
            JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ. Vui lòng chọn một ngày sinh.");
            return null; // Stop further processing
        }
        if (ngaySinh == null) {
            JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ. Vui lòng chọn một ngày sinh.");
        } else {
            if (isOver18(ngaySinh)) {

                nv.setNgaySinh(ngaySinh);
              
            } else {
                JOptionPane.showMessageDialog(null, "Bạn chưa đủ 18 tuổi.");
                  return null;
            }
        }

        String diaChi = this.txtDiaChict.getText();
        if (diaChi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Địa chỉ là bắt buộc. Vui lòng nhập một địa chỉ hợp lệ.");
            return null;
        }
        nv.setDiaChi(diaChi);
        String passs = txtPasss.getText();
        String hashpassw = hashPassword(passs);
        nv.setPasss(hashpassw);

        return nv;
    }
     public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean isOver18(Date birthDate) {
        // Chuyển đổi Date thành LocalDate
        LocalDate localBirthDate = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Lấy ngày hiện tại
        LocalDate currentDate = LocalDate.now();

        // Tính toán khoảng thời gian giữa ngày sinh và ngày hiện tại
        Period period = Period.between(localBirthDate, currentDate);

        // Kiểm tra xem tuổi có lớn hơn hoặc bằng 18 không
        return period.getYears() >= 18;
    }

    private void ClearForm() {

        txtMa.setText("");
        txtTencb.setText("");
    }

//    private void loadchuvu() {
//        List<ChucVu> listCv = this.serv.getChuCvu();
//        for (ChucVu o : listCv) {
//            this.cbChucVucb.addItem(o.getTen());
//        }
//    }
    private QLNhanVien getFormnhanviencbsua() {
        QLNhanVien nv = new QLNhanVien();

        String tenNv = txtTencb.getText();
        if (tenNv.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên nhân viên là bắt buộc. Vui lòng nhập một tên hợp lệ.");
            return null; // Stop further processing
        }
        nv.setTenNv(tenNv);

// Validate MaNv
        String maNv = txtMa.getText();
        if (maNv.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mã nhân viên là bắt buộc. Vui lòng nhập một mã hợp lệ.");
            return null; // Stop further processing
        }
        nv.setMaNv(maNv);

// Validate Sdt
        String sdt = txtSdtcb.getText();
        if (sdt.isEmpty() || !sdt.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ. Vui lòng nhập một số điện thoại có 10 chữ số.");
            return null; // Stop further processing
        }
        nv.setSdt(sdt);

// Validate NgayTao (Date)
        Date ngayDb = new Date();
        nv.setNgayTao(ngayDb);

// Validate ChucVu
        int indexvitri = cbChucVucb.getSelectedIndex();
        nv.setChucVu(indexvitri == 0 ? "1" : "2");

// Validate GioiTinh
        int gioiTinh = rdoNam.isSelected() ? 1 : 0;
        nv.setGioiTinh(gioiTinh);

// Validate TrangThai
        int indextt;
        if (ckbtt.isSelected()) {
            indextt = 1;
        } else {
            indextt = 0;
        }

        nv.setTrangThai(indextt);
        return nv;
    }

    private QLNhanVien getFormnhanviencb() {
        QLNhanVien nv = new QLNhanVien();

        String tenNv = txtTencb.getText();
        if (tenNv.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên nhân viên là bắt buộc. Vui lòng nhập một tên hợp lệ.");
            return null; // Stop further processing
        }
        nv.setTenNv(tenNv);

// Validate MaNv
        String maNv = txtMa.getText();
        if (maNv.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mã nhân viên là bắt buộc. Vui lòng nhập một mã hợp lệ.");
            return null; // Stop further processing
        }
        nv.setMaNv(maNv);

// Validate Sdt
        String sdt = txtSdtcb.getText();
        if (sdt.isEmpty() || !sdt.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ. Vui lòng nhập một số điện thoại có 10 chữ số.");
            return null; // Stop further processing
        }
        nv.setSdt(sdt);

// Validate NgayTao (Date)
        Date ngayDb = new Date();
        nv.setNgayTao(ngayDb);

// Validate ChucVu
        int indexvitri = cbChucVucb.getSelectedIndex();
        nv.setChucVu(indexvitri == 0 ? "1" : "2");

// Validate GioiTinh
        int gioiTinh = rdoNam.isSelected() ? 0 : 1;
        nv.setGioiTinh(gioiTinh);

// Validate TrangThai
        nv.setTrangThai(0);
        return nv;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tabbedPaneCustom1 = new app.view.swing.TabbedPaneCustom();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        scrollPaneWin111 = new custome_ui.swing.ScrollPaneWin11();
        tblNhanVien = new rojeru_san.complementos.RSTableMetro();
        txtSdtcb = new textfield.TextField2();
        txtTencb = new textfield.TextField2();
        txtMa = new textfield.TextField2();
        cbChucVucb = new app.view.swing.ComboBoxSuggestion();
        btnSua = new app.view.swing.ButtonGradient();
        btnXoaCb = new app.view.swing.ButtonGradient();
        btnloadlai = new app.view.swing.ButtonGradient();
        btnThemcb1 = new app.view.swing.ButtonGradient();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        ckbtt = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        scrollPaneWin112 = new custome_ui.swing.ScrollPaneWin11();
        tblNhanVienct = new rojeru_san.complementos.RSTableMetro();
        txtmact = new textfield.TextField2();
        jLabel6 = new javax.swing.JLabel();
        txtEmailct = new textfield.TextField2();
        jLabel7 = new javax.swing.JLabel();
        txtDiaChict = new textfield.TextField2();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtsdtct = new textfield.TextField2();
        dateNgSinh = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        btnLoadag = new app.view.swing.ButtonGradient();
        btnSuact = new app.view.swing.ButtonGradient();
        txtPasss = new textfield.TextField2();
        jLabel18 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(38, 28, 73));

        jPanel2.setBackground(new java.awt.Color(38, 28, 73));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));

        tabbedPaneCustom1.setBackground(new java.awt.Color(38, 28, 73));
        tabbedPaneCustom1.setForeground(new java.awt.Color(255, 255, 255));
        tabbedPaneCustom1.setSelectedColor(new java.awt.Color(51, 0, 102));
        tabbedPaneCustom1.setUnselectedColor(new java.awt.Color(38, 32, 78));

        jPanel5.setBackground(new java.awt.Color(38, 28, 73));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Chức Vụ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã NV");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tên NV");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Số Điện thoại");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Giới Tính");

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Nhân Viên", "Tên Nhân Viên", "SĐT", "Chức Vụ", "Ngày Bắt Đầu Làm Việc", "Ngày Sửa", "Giới Tính", "Trạng Thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien.setColorBackgoundHead(new java.awt.Color(102, 102, 102));
        tblNhanVien.setColorBordeFilas(new java.awt.Color(153, 153, 153));
        tblNhanVien.setColorBordeHead(new java.awt.Color(153, 153, 153));
        tblNhanVien.setColorFilasBackgound1(new java.awt.Color(204, 204, 204));
        tblNhanVien.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tblNhanVien.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tblNhanVien.setColorSelBackgound(new java.awt.Color(38, 28, 73));
        tblNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblNhanVien.setFuenteFilas(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblNhanVien.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblNhanVien.setFuenteHead(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblNhanVien.setRowHeight(40);
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        scrollPaneWin111.setViewportView(tblNhanVien);

        txtSdtcb.setForeground(new java.awt.Color(0, 0, 0));
        txtSdtcb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTencb.setForeground(new java.awt.Color(0, 0, 0));
        txtTencb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMa.setForeground(new java.awt.Color(0, 0, 0));
        txtMa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbChucVucb.setBackground(new java.awt.Color(204, 204, 204));
        cbChucVucb.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cbChucVucb.setForeground(new java.awt.Color(255, 255, 255));
        cbChucVucb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Quản lí nhân viên", "Nhân Viên" }));
        cbChucVucb.setSelectedIndex(1);
        cbChucVucb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnSua.setForeground(new java.awt.Color(0, 0, 0));
        btnSua.setText("Sửa");
        btnSua.setColor1(new java.awt.Color(255, 255, 255));
        btnSua.setColor2(new java.awt.Color(102, 102, 102));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoaCb.setForeground(new java.awt.Color(0, 0, 0));
        btnXoaCb.setText("Xóa");
        btnXoaCb.setColor1(new java.awt.Color(255, 255, 255));
        btnXoaCb.setColor2(new java.awt.Color(102, 102, 102));
        btnXoaCb.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoaCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCbActionPerformed(evt);
            }
        });

        btnloadlai.setForeground(new java.awt.Color(0, 0, 0));
        btnloadlai.setText("load lại");
        btnloadlai.setColor1(new java.awt.Color(255, 255, 255));
        btnloadlai.setColor2(new java.awt.Color(102, 102, 102));
        btnloadlai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnloadlai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloadlaiActionPerformed(evt);
            }
        });

        btnThemcb1.setForeground(new java.awt.Color(0, 0, 0));
        btnThemcb1.setText("Thêm");
        btnThemcb1.setColor1(new java.awt.Color(255, 255, 255));
        btnThemcb1.setColor2(new java.awt.Color(102, 102, 102));
        btnThemcb1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemcb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemcb1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNam);
        rdoNam.setForeground(new java.awt.Color(255, 255, 255));
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setForeground(new java.awt.Color(255, 255, 255));
        rdoNu.setText("Nữ");

        ckbtt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ckbtt.setForeground(new java.awt.Color(255, 255, 255));
        ckbtt.setText("Trạng Thái");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTencb, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ckbtt))
                            .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(27, 27, 27)
                                .addComponent(cbChucVucb, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(146, 146, 146))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(29, 29, 29)
                        .addComponent(txtSdtcb, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 465, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(173, 173, 173))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnThemcb1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnXoaCb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnloadlai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(335, 335, 335))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 1288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSua, btnThemcb1, btnXoaCb, btnloadlai});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(11, 11, 11)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnXoaCb, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnloadlai, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThemcb1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbChucVucb, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtTencb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtSdtcb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel8)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoNam)
                            .addComponent(ckbtt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoNu)))
                .addGap(18, 18, 18)
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSua, btnThemcb1, btnXoaCb, btnloadlai});

        tabbedPaneCustom1.addTab("Thông tin Cơ Bản", jPanel5);

        jPanel4.setBackground(new java.awt.Color(38, 28, 73));

        tblNhanVienct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã Nhân Viên", "Email", "SĐT", "Ngày Sinh", "Địa Chỉ", "mật khẩu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVienct.setColorBackgoundHead(new java.awt.Color(102, 102, 102));
        tblNhanVienct.setColorBordeFilas(new java.awt.Color(153, 153, 153));
        tblNhanVienct.setColorBordeHead(new java.awt.Color(153, 153, 153));
        tblNhanVienct.setColorFilasBackgound1(new java.awt.Color(204, 204, 204));
        tblNhanVienct.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tblNhanVienct.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tblNhanVienct.setColorSelBackgound(new java.awt.Color(38, 28, 73));
        tblNhanVienct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblNhanVienct.setFuenteFilas(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblNhanVienct.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblNhanVienct.setFuenteHead(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblNhanVienct.setRowHeight(40);
        tblNhanVienct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienctMouseClicked(evt);
            }
        });
        scrollPaneWin112.setViewportView(tblNhanVienct);

        txtmact.setForeground(new java.awt.Color(0, 0, 0));
        txtmact.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mã NV");

        txtEmailct.setForeground(new java.awt.Color(0, 0, 0));
        txtEmailct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email");

        txtDiaChict.setForeground(new java.awt.Color(0, 0, 0));
        txtDiaChict.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Địa Chỉ");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("SĐT");

        txtsdtct.setForeground(new java.awt.Color(0, 0, 0));
        txtsdtct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Ngày Sinh");

        btnLoadag.setForeground(new java.awt.Color(0, 0, 0));
        btnLoadag.setText("Load lại");
        btnLoadag.setColor1(new java.awt.Color(255, 255, 255));
        btnLoadag.setColor2(new java.awt.Color(102, 102, 102));
        btnLoadag.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLoadag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadagActionPerformed(evt);
            }
        });

        btnSuact.setForeground(new java.awt.Color(0, 0, 0));
        btnSuact.setText("Sửa");
        btnSuact.setColor1(new java.awt.Color(255, 255, 255));
        btnSuact.setColor2(new java.awt.Color(102, 102, 102));
        btnSuact.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuactActionPerformed(evt);
            }
        });

        txtPasss.setForeground(new java.awt.Color(0, 0, 0));
        txtPasss.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Mật Khẩu");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmact, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmailct, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateNgSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChict, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSuact, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPasss, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsdtct, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(btnLoadag, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPaneWin112, javax.swing.GroupLayout.PREFERRED_SIZE, 1263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLoadag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSuact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtmact, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmailct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtDiaChict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18)
                                .addComponent(txtPasss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dateNgSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtsdtct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(scrollPaneWin112, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        tabbedPaneCustom1.addTab("Thông Tin Chi Tiết", jPanel4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1320, 1320, 1320)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 1480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(2128, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 927, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(76, 76, 76)
                .addComponent(jLabel12)
                .addContainerGap(1159, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1570, 990));
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadagActionPerformed
        load();
        loadct();
//        loadchuvu();
    }//GEN-LAST:event_btnLoadagActionPerformed

    private void btnSuactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuactActionPerformed
        this.serv.setNhanvien1(this.getFormCT());
        load();
        
        loadct();
//        loadchuvu();
    }//GEN-LAST:event_btnSuactActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        this.serv.setNhanvien(this.getFormnhanviencbsua());
        load();
        loadct();
//      loadchuvu();// TODO add your handling code here:
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCbActionPerformed

        int row = this.tblNhanVien.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "chọn nhân viên đẻ xóa");
            return;
        }
        String ma = tblNhanVien.getValueAt(row, 1).toString();
        this.serv.removeNhanvien(ma);
        load();
        loadct();
//        loadchuvu();// TODO add your handling code here:
    }//GEN-LAST:event_btnXoaCbActionPerformed

    private void btnloadlaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloadlaiActionPerformed
        load();
        loadct();
    }//GEN-LAST:event_btnloadlaiActionPerformed

    private void btnThemcb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemcb1ActionPerformed
        this.serv.addNhanvien(this.getFormnhanviencb());
        txtmact.setText(this.txtMa.getText());
        txtsdtct.setText(this.txtSdtcb.getText());
        this.tabbedPaneCustom1.setSelectedIndex(1);
        JOptionPane.showMessageDialog(this, " Mời bạn tiếp tục thêm thông tin -> Sửa");
        load();
        loadct1();
//        loadchuvu();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemcb1ActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        int row = this.tblNhanVien.getSelectedRow();
        this.txtMa.setText(this.tblNhanVien.getValueAt(row, 1).toString());
        this.txtTencb.setText(this.tblNhanVien.getValueAt(row, 2).toString());
        this.txtSdtcb.setText(this.tblNhanVien.getValueAt(row, 3).toString());
        String tt = (this.tblNhanVien.getValueAt(row, 8).toString());
        this.cbChucVucb.setSelectedItem(this.tblNhanVien.getValueAt(row, 4).toString());
        String gioitinh = this.tblNhanVien.getValueAt(row, 7).toString();
        if (gioitinh.equals("Nam")) {
            this.rdoNam.setSelected(true);
        } else {
            this.rdoNu.setSelected(true);
        }
        if (tt.equals("Đang làm việc ")) {
            ckbtt.setSelected(true);
        }
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void tblNhanVienctMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienctMouseClicked
        int row = this.tblNhanVienct.getSelectedRow();
        this.txtmact.setText(this.tblNhanVienct.getValueAt(row, 1).toString());
        this.txtEmailct.setText(this.tblNhanVienct.getValueAt(row, 2).toString());
        this.txtsdtct.setText(this.tblNhanVienct.getValueAt(row, 3).toString());
        this.dateNgSinh.setDate((Date) this.tblNhanVienct.getValueAt(row, 4));
        this.txtDiaChict.setText(this.tblNhanVienct.getValueAt(row, 5).toString());
        this.txtPasss.setText(this.tblNhanVienct.getValueAt(row, 6).toString());
    }//GEN-LAST:event_tblNhanVienctMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.view.swing.ButtonGradient btnLoadag;
    private app.view.swing.ButtonGradient btnSua;
    private app.view.swing.ButtonGradient btnSuact;
    private app.view.swing.ButtonGradient btnThemcb1;
    private app.view.swing.ButtonGradient btnXoaCb;
    private app.view.swing.ButtonGradient btnloadlai;
    private javax.swing.ButtonGroup buttonGroup1;
    private app.view.swing.ComboBoxSuggestion cbChucVucb;
    private javax.swing.JCheckBox ckbtt;
    private com.toedter.calendar.JDateChooser dateNgSinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private custome_ui.swing.ScrollPaneWin11 scrollPaneWin111;
    private custome_ui.swing.ScrollPaneWin11 scrollPaneWin112;
    private app.view.swing.TabbedPaneCustom tabbedPaneCustom1;
    private rojeru_san.complementos.RSTableMetro tblNhanVien;
    private rojeru_san.complementos.RSTableMetro tblNhanVienct;
    private textfield.TextField2 txtDiaChict;
    private textfield.TextField2 txtEmailct;
    private textfield.TextField2 txtMa;
    private textfield.TextField2 txtPasss;
    private textfield.TextField2 txtSdtcb;
    private textfield.TextField2 txtTencb;
    private textfield.TextField2 txtmact;
    private textfield.TextField2 txtsdtct;
    // End of variables declaration//GEN-END:variables

}
