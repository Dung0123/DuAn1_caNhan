

/****** Object:  Table [dbo].[ChatLieu]    Script Date: 12/2/2023 6:48:29 PM ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[ChatLieu](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](7) NULL,
	[ten] [nvarchar](50) NULL,
	[ngayTao] [datetime2](7) NULL,
	[ngaySua] [datetime2](7) NULL,
	[isDelete] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

/****** Object:  Table [dbo].[ChieuDaiTay]    Script Date: 12/2/2023 6:48:29 PM ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[ChieuDaiTay](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](7) NULL,
	[ten] [nvarchar](50) NULL,
	[ngayTao] [datetime2](7) NULL,
	[ngaySua] [datetime2](7) NULL,
	[isDelete] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

/****** Object:  Table [dbo].[ChucVu]    Script Date: 12/2/2023 6:48:29 PM ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[ChucVu](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](20) NULL,
	[ten] [nvarchar](30) NULL,
	[moTa] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

/****** Object:  Table [dbo].[CoAo]    Script Date: 12/2/2023 6:48:29 PM ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[CoAo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](7) NULL,
	[ten] [nvarchar](50) NULL,
	[ngayTao] [datetime2](7) NULL,
	[ngaySua] [datetime2](7) NULL,
	[isDelete] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

/****** Object:  Table [dbo].[DanhMuc]    Script Date: 12/2/2023 6:48:29 PM ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[DanhMuc](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](7) NULL,
	[ten] [nvarchar](50) NULL,
	[ngayTao] [datetime2](7) NULL,
	[ngaySua] [datetime2](7) NULL,
	[isDelete] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

/****** Object:  Table [dbo].[HoaDon]    Script Date: 12/2/2023 6:48:29 PM ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[HoaDon](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[maHoaDon] [varchar](20) NULL,
	[idNhanVien] [int] NULL,
	[idKhachHang] [int] NULL,
	[hinhThucThanhToan] [nvarchar](20) NULL,
	[tongTien] [decimal](20, 2) NULL,
	[tongTienGiam] [decimal](20, 2) NULL,
	[ngayTao] [datetime2](7) NULL,
	[trangThai] [bit] NULL,
	[idVoucher] [int] NULL,
	[ghiChu] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 12/2/2023 6:48:29 PM ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[HoaDonChiTiet](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idSanPhamChiTiet] [int] NULL,
	[idHoaDon] [int] NULL,
	[soLuong] [int] NULL,
	[giaTien] [decimal](20, 2) NULL,
	[thanhTien] [decimal](20, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

/****** Object:  Table [dbo].[KhachHang]    Script Date: 12/2/2023 6:48:29 PM ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[KhachHang](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](20) NULL,
	[ten] [nvarchar](50) NULL,
	[sdt] [varchar](20) NULL,
	[email] [varchar](20) NULL,
	[gioiTinh] [bit] NULL,
	[ngaySinh] [date] NULL,
	[diaChi] [nvarchar](255) NULL,
	[trangThai] [int] NULL,
	[ngayTao] [datetime] NULL,
	[ngaySua] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

/****** Object:  Table [dbo].[KichCo]    Script Date: 12/2/2023 6:48:29 PM ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[KichCo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](7) NULL,
	[ten] [nvarchar](50) NULL,
	[ngayTao] [datetime2](7) NULL,
	[ngaySua] [datetime2](7) NULL,
	[isDelete] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

/****** Object:  Table [dbo].[MauSac]    Script Date: 12/2/2023 6:48:29 PM ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[MauSac](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](7) NULL,
	[ten] [nvarchar](50) NULL,
	[ngayTao] [datetime2](7) NULL,
	[ngaySua] [datetime2](7) NULL,
	[isDelete] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

/****** Object:  Table [dbo].[NhanVien]    Script Date: 12/2/2023 6:48:29 PM ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[NhanVien](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idChucVu] [int] NULL,
	[ma] [varchar](20) NULL,
	[ten] [nvarchar](50) NULL,
	[email] [varchar](50) NULL,
	[sdt] [varchar](20) NULL,
	[gioiTinh] [bit] NULL,
	[ngaySinh] [date] NULL,
	[matKhau] [varchar](256) NULL,
	[diaChi] [nvarchar](255) NULL,
	[trangThai] [int] NULL,
	[ngayTao] [datetime2](7) NULL,
	[ngaySua] [datetime2](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

/****** Object:  Table [dbo].[SanPham]    Script Date: 12/2/2023 6:48:29 PM ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[SanPham](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](7) NULL,
	[ten] [nvarchar](50) NULL,
	[isDelete] [bit] NULL,
	[idDanhMuc] [int] NULL,
	[idThuongHieu] [int] NULL,
	[ngayTao] [datetime2](7) NULL,
	[ngaySua] [datetime2](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

/****** Object:  Table [dbo].[SanPhamChiTiet]    Script Date: 12/2/2023 6:48:29 PM ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[SanPhamChiTiet](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](7) NULL,
	[maVach] [varchar](255) NULL,
	[idChatLieu] [int] NULL,
	[idChieuDaiTay] [int] NULL,
	[idKichCo] [int] NULL,
	[idMauSac] [int] NULL,
	[idSanPham] [int] NULL,
	[idCoAo] [int] NULL,
	[idXuatXu] [int] NULL,
	[soLuong] [int] NULL,
	[giaBan] [decimal](20, 2) NULL,
	[moTa] [nvarchar](255) NULL,
	[ngayTao] [datetime2](7) NULL,
	[ngaySua] [datetime2](7) NULL,
	[trangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

/****** Object:  Table [dbo].[ThuongHieu]    Script Date: 12/2/2023 6:48:29 PM ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[ThuongHieu](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](7) NULL,
	[ten] [nvarchar](50) NULL,
	[ngayTao] [datetime2](7) NULL,
	[ngaySua] [datetime2](7) NULL,
	[isDelete] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

/****** Object:  Table [dbo].[Voucher]    Script Date: 12/2/2023 6:48:29 PM ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[Voucher](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](20) NULL,
	[ten] [varchar](20) NULL,
	[IdnhanVien] [int] NULL,
	[loaiGiamGia] [bit] NULL,
	[ngayBatDau] [datetime2](7) NULL,
	[ngayKetThuc] [datetime2](7) NULL,
	[giaTriGiam] [int] NULL,
	[GiaTriDhToiThieu] [decimal](20, 2) NULL,
	[trangThai] [int] NULL,
	[soLuong] [int] NULL,
	[soLuotSd] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

/****** Object:  Table [dbo].[XuatXu]    Script Date: 12/2/2023 6:48:29 PM ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[XuatXu](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ten] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [trangThai]

ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT ((0)) FOR [trangThai]

ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT ((0)) FOR [trangThai]

ALTER TABLE [dbo].[SanPhamChiTiet] ADD  DEFAULT ((0)) FOR [trangThai]

ALTER TABLE [dbo].[Voucher] ADD  DEFAULT ((0)) FOR [trangThai]

ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon.IdkhachHang] FOREIGN KEY([idKhachHang])
REFERENCES [dbo].[KhachHang] ([id])

ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon.IdkhachHang]

ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon.IdnhanVien] FOREIGN KEY([idNhanVien])
REFERENCES [dbo].[NhanVien] ([id])

ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon.IdnhanVien]

ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon.IdVoucher] FOREIGN KEY([idVoucher])
REFERENCES [dbo].[Voucher] ([id])

ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon.IdVoucher]

ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet.idHoaDon] FOREIGN KEY([idHoaDon])
REFERENCES [dbo].[HoaDon] ([id])

ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet.idHoaDon]

ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet.idSanPhamChiTiet] FOREIGN KEY([idSanPhamChiTiet])
REFERENCES [dbo].[SanPhamChiTiet] ([id])

ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet.idSanPhamChiTiet]

ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien.IdChucVu] FOREIGN KEY([idChucVu])
REFERENCES [dbo].[ChucVu] ([id])

ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien.IdChucVu]

ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham.idDanhMuc] FOREIGN KEY([idDanhMuc])
REFERENCES [dbo].[DanhMuc] ([id])

ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham.idDanhMuc]

ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham.idThuonghieu] FOREIGN KEY([idThuongHieu])
REFERENCES [dbo].[ThuongHieu] ([id])

ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham.idThuonghieu]

ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet.idChatLieu] FOREIGN KEY([idChatLieu])
REFERENCES [dbo].[ChatLieu] ([id])

ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet.idChatLieu]

ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet.idChieuDaiTay] FOREIGN KEY([idChieuDaiTay])
REFERENCES [dbo].[ChieuDaiTay] ([id])

ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet.idChieuDaiTay]

ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet.idCoAo] FOREIGN KEY([idCoAo])
REFERENCES [dbo].[CoAo] ([id])

ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet.idCoAo]

ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet.idKichCo] FOREIGN KEY([idKichCo])
REFERENCES [dbo].[KichCo] ([id])

ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet.idKichCo]

ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet.idMauSac] FOREIGN KEY([idMauSac])
REFERENCES [dbo].[MauSac] ([id])

ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet.idMauSac]

ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet.idSanPham] FOREIGN KEY([idSanPham])
REFERENCES [dbo].[SanPham] ([id])

ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet.idSanPham]

ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet.idXuatXu] FOREIGN KEY([idXuatXu])
REFERENCES [dbo].[XuatXu] ([id])

ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet.idXuatXu]

INSERT INTO NhanVien (idChucVu, ma, ten, email, sdt, gioiTinh, ngaySinh, matKhau, diaChi, trangThai, ngayTao, ngaySua)
VALUES
    (1, 'NV001', 'Nguyễn Văn A', 'nv.a@example.com', '123456789', 1, '1990-01-01', 'password123', '123 Main St, City', 1, GETDATE(), GETDATE()),
    (2, 'NV002', 'Trần Thị B', 'ttb@example.com', '987654321', 0, '1995-05-05', 'pass456', '456 Second St, Town', 1, GETDATE(), GETDATE()),
    (1, 'NV003', 'Lê Văn C', 'lvc@example.com', '111222333', 1, '1985-12-15', 'abc123', '789 Third St, Village', 1, GETDATE(), GETDATE());
   
INSERT INTO DanhMuc (ma, ten, ngayTao, ngaySua, isDelete)
VALUES
    ('DM001', 'Áo thun', GETDATE(), GETDATE(), 0),
    ('DM002', 'Quần jean', GETDATE(), GETDATE(), 0),
    ('DM003', 'Giày sneakers', GETDATE(), GETDATE(), 0);
   
INSERT INTO ThuongHieu (ma, ten, ngayTao, ngaySua, isDelete)
VALUES
    ('TH001', 'Nike', GETDATE(), GETDATE(), 0),
    ('TH002', 'Adidas', GETDATE(), GETDATE(), 0),
    ('TH003', 'Puma', GETDATE(), GETDATE(), 0);

INSERT INTO MauSac (ma, ten, ngayTao, ngaySua, isDelete)
VALUES
    ('MS001', 'Đen', GETDATE(), GETDATE(), 0),
    ('MS002', 'Trắng', GETDATE(), GETDATE(), 0),
    ('MS003', 'Đỏ', GETDATE(), GETDATE(), 0);

INSERT INTO SanPham (ma, ten, isDelete, idDanhMuc, idThuongHieu, ngayTao, ngaySua)
VALUES
    ('SP001', 'Áo thun Nike', 0, 1, 1, GETDATE(), GETDATE()),
    ('SP002', 'Quần jean Adidas', 0, 2, 2, GETDATE(), GETDATE()),
    ('SP003', 'Giày sneakers Puma', 0, 3, 3, GETDATE(), GETDATE());
   
INSERT INTO KichCo (ma, ten, ngayTao, ngaySua, isDelete)
VALUES
    ('KC001', 'S', GETDATE(), GETDATE(), 0),
    ('KC002', 'M', GETDATE(), GETDATE(), 0),
    ('KC003', 'L', GETDATE(), GETDATE(), 0);

INSERT INTO ChatLieu (ma, ten, ngayTao, ngaySua, isDelete)
VALUES
    ('CL001', 'Cotton', GETDATE(), GETDATE(), 0),
    ('CL002', 'Jean', GETDATE(), GETDATE(), 0),
    ('CL003', 'Da', GETDATE(), GETDATE(), 0);

INSERT INTO XuatXu (ten)
VALUES
    ('Việt Nam'),
    ('Trung Quốc'),
    ('Hàn Quốc');
   
INSERT INTO CoAo (ma, ten, ngayTao, ngaySua, isDelete)
VALUES
    ('CA001', 'Áo polo', GETDATE(), GETDATE(), 0),
    ('CA002', 'Áo sơ mi', GETDATE(), GETDATE(), 0),
    ('CA003', 'Áo thun nam', GETDATE(), GETDATE(), 0);

INSERT INTO ChieuDaiTay (ma, ten, ngayTao, ngaySua, isDelete)
VALUES
    ('CDT001', 'Ngắn tay', GETDATE(), GETDATE(), 0),
    ('CDT002', 'Dài tay', GETDATE(), GETDATE(), 0),
    ('CDT003', 'Không tay', GETDATE(), GETDATE(), 0);

INSERT INTO HoaDon (maHoaDon, idNhanVien, idKhachHang, hinhThucThanhToan, tongTien, tongTienGiam, ngayTao, trangThai, idVoucher)
VALUES
    ('HD001', 1, 1, 'Thanh toán khi nhận hàng', 100.00, 10.00, GETDATE(), 1, 1),
    ('HD002', 2, 2, 'Chuyển khoản ngân hàng', 150.00, 15.00, GETDATE(), 1, 2);

INSERT INTO HoaDonChiTiet (idSanPhamChiTiet, idHoaDon, soLuong, giaTien, thanhTien)
VALUES
    (1, 1, 2, 50.00, 90.00),
    (2, 1, 1, 70.00, 70.00),
    (3, 2, 3, 40.00, 105.00);

INSERT INTO Voucher (ma, ten, IdnhanVien, loaiGiamGia, ngayBatDau, ngayKetThuc, giaTriGiam, GiaTriDhToiThieu, trangThai, soLuong, soLuotSd)
VALUES
    ('VCH001', 'Giảm 10%', 1, 1, '2023-12-10', '2024-01-10', 10, 100.00, 1, 50, 20),
    ('VCH002', 'Giảm 20%', 2, 0, '2023-12-15', '2024-02-15', 20, 150.00, 1, 30, 15),
    ('VCH003', 'Miễn phí vận chuyển', 3, 1, '2023-12-20', '2024-03-20', 0, 200.00, 1, 20, 10);

INSERT INTO SanPhamChiTiet (ma, maVach, idChatLieu, idChieuDaiTay, idKichCo, idMauSac, idSanPham, idCoAo, idXuatXu, soLuong, giaBan, moTa, ngayTao, ngaySua, trangThai)
VALUES
    ('SPCT001', 'SPCT001V', 1, 2, 1, 1, 1, 1, 2, 100, 49.99, 'Áo thun Nike màu đen', GETDATE(), GETDATE(), 1),
    ('SPCT002', 'SPCT002V', 2, 1, 2, 2, 2, 2, 1, 150, 79.99, 'Quần jean Adidas màu trắng', GETDATE(), GETDATE(), 1),
    ('SPCT003', 'SPCT003V', 3, 3, 3, 3, 3, 3, 3, 200, 99.99, 'Giày sneakers Puma màu đỏ', GETDATE(), GETDATE(), 1);




