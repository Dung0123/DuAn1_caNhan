USE [G7BanAoThun]
GO
/****** Object:  Table [dbo].[ChatLieu]    Script Date: 12/6/2023 4:17:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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
GO
/****** Object:  Table [dbo].[ChieuDaiTay]    Script Date: 12/6/2023 4:17:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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
GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 12/6/2023 4:17:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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
GO
/****** Object:  Table [dbo].[CoAo]    Script Date: 12/6/2023 4:17:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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
GO
/****** Object:  Table [dbo].[DanhMuc]    Script Date: 12/6/2023 4:17:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 12/6/2023 4:17:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 12/6/2023 4:17:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 12/6/2023 4:17:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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
GO
/****** Object:  Table [dbo].[KichCo]    Script Date: 12/6/2023 4:17:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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
GO
/****** Object:  Table [dbo].[MauSac]    Script Date: 12/6/2023 4:17:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 12/6/2023 4:17:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 12/6/2023 4:17:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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
GO
/****** Object:  Table [dbo].[SanPhamChiTiet]    Script Date: 12/6/2023 4:17:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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
GO
/****** Object:  Table [dbo].[ThuongHieu]    Script Date: 12/6/2023 4:17:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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
GO
/****** Object:  Table [dbo].[Voucher]    Script Date: 12/6/2023 4:17:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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
GO
/****** Object:  Table [dbo].[XuatXu]    Script Date: 12/6/2023 4:17:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[XuatXu](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ten] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[ChatLieu] ON 

INSERT [dbo].[ChatLieu] ([id], [ma], [ten], [ngayTao], [ngaySua], [isDelete]) VALUES (1, NULL, N'Cotton', CAST(N'2023-11-29T22:01:30.1866667' AS DateTime2), CAST(N'2023-11-29T22:01:30.1866667' AS DateTime2), 0)
INSERT [dbo].[ChatLieu] ([id], [ma], [ten], [ngayTao], [ngaySua], [isDelete]) VALUES (2, NULL, N'Kaki', CAST(N'2023-11-29T22:01:30.1866667' AS DateTime2), CAST(N'2023-11-29T22:01:30.1866667' AS DateTime2), 0)
INSERT [dbo].[ChatLieu] ([id], [ma], [ten], [ngayTao], [ngaySua], [isDelete]) VALUES (3, NULL, N'Jean', CAST(N'2023-11-29T22:01:30.1866667' AS DateTime2), CAST(N'2023-11-29T22:01:30.1866667' AS DateTime2), 0)
SET IDENTITY_INSERT [dbo].[ChatLieu] OFF
GO
SET IDENTITY_INSERT [dbo].[ChieuDaiTay] ON 

INSERT [dbo].[ChieuDaiTay] ([id], [ma], [ten], [ngayTao], [ngaySua], [isDelete]) VALUES (1, NULL, N'Tay lỡ', CAST(N'2023-11-29T22:01:30.1833333' AS DateTime2), CAST(N'2023-11-29T22:01:30.1833333' AS DateTime2), 0)
INSERT [dbo].[ChieuDaiTay] ([id], [ma], [ten], [ngayTao], [ngaySua], [isDelete]) VALUES (2, NULL, N'Tay ngắn', CAST(N'2023-11-29T22:01:30.1833333' AS DateTime2), CAST(N'2023-11-29T22:01:30.1833333' AS DateTime2), 0)
INSERT [dbo].[ChieuDaiTay] ([id], [ma], [ten], [ngayTao], [ngaySua], [isDelete]) VALUES (3, NULL, N'Tay dài', CAST(N'2023-11-29T22:01:30.1833333' AS DateTime2), CAST(N'2023-11-29T22:01:30.1833333' AS DateTime2), 0)
SET IDENTITY_INSERT [dbo].[ChieuDaiTay] OFF
GO
SET IDENTITY_INSERT [dbo].[ChucVu] ON 

INSERT [dbo].[ChucVu] ([id], [ma], [ten], [moTa]) VALUES (1, N'MA_CV_1', N'Quản Lí', N'Mô tả Chức Vụ 1')
INSERT [dbo].[ChucVu] ([id], [ma], [ten], [moTa]) VALUES (2, N'MA_CV_2', N'Nhân Viên', N'Mô tả Chức Vụ 2')
SET IDENTITY_INSERT [dbo].[ChucVu] OFF
GO
SET IDENTITY_INSERT [dbo].[CoAo] ON 

INSERT [dbo].[CoAo] ([id], [ma], [ten], [ngayTao], [ngaySua], [isDelete]) VALUES (1, NULL, N'Cổ bẻ', CAST(N'2023-11-29T22:01:30.1900000' AS DateTime2), CAST(N'2023-11-29T22:01:30.1900000' AS DateTime2), 0)
INSERT [dbo].[CoAo] ([id], [ma], [ten], [ngayTao], [ngaySua], [isDelete]) VALUES (2, NULL, N'Cổ tròng', CAST(N'2023-11-29T22:01:30.1900000' AS DateTime2), CAST(N'2023-11-29T22:01:30.1900000' AS DateTime2), 0)
INSERT [dbo].[CoAo] ([id], [ma], [ten], [ngayTao], [ngaySua], [isDelete]) VALUES (3, NULL, N'Trái tim', CAST(N'2023-11-29T22:01:30.1900000' AS DateTime2), CAST(N'2023-11-29T22:01:30.1900000' AS DateTime2), 0)
SET IDENTITY_INSERT [dbo].[CoAo] OFF
GO
SET IDENTITY_INSERT [dbo].[DanhMuc] ON 

INSERT [dbo].[DanhMuc] ([id], [ma], [ten], [ngayTao], [ngaySua], [isDelete]) VALUES (1, NULL, N'Hàn Quốc', CAST(N'2023-11-29T22:01:30.1833333' AS DateTime2), CAST(N'2023-11-29T22:01:30.1833333' AS DateTime2), 0)
INSERT [dbo].[DanhMuc] ([id], [ma], [ten], [ngayTao], [ngaySua], [isDelete]) VALUES (2, NULL, N'Công sở', CAST(N'2023-11-29T22:01:30.1833333' AS DateTime2), CAST(N'2023-11-29T22:01:30.1833333' AS DateTime2), 0)
INSERT [dbo].[DanhMuc] ([id], [ma], [ten], [ngayTao], [ngaySua], [isDelete]) VALUES (3, NULL, N'Đơn giản', CAST(N'2023-11-29T22:01:30.1833333' AS DateTime2), CAST(N'2023-11-29T22:01:30.1833333' AS DateTime2), 0)
SET IDENTITY_INSERT [dbo].[DanhMuc] OFF
GO
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([id], [maHoaDon], [idNhanVien], [idKhachHang], [hinhThucThanhToan], [tongTien], [tongTienGiam], [ngayTao], [trangThai], [idVoucher], [ghiChu]) VALUES (23, N'HD42487', 2, 13, N'TienMat', CAST(1620000.00 AS Decimal(20, 2)), NULL, CAST(N'2023-12-06T13:20:05.1798337' AS DateTime2), 1, NULL, NULL)
INSERT [dbo].[HoaDon] ([id], [maHoaDon], [idNhanVien], [idKhachHang], [hinhThucThanhToan], [tongTien], [tongTienGiam], [ngayTao], [trangThai], [idVoucher], [ghiChu]) VALUES (24, N'HD40056', 2, 13, N'TienMat', CAST(1750000.00 AS Decimal(20, 2)), NULL, CAST(N'2023-12-06T13:21:12.8258476' AS DateTime2), 1, NULL, NULL)
INSERT [dbo].[HoaDon] ([id], [maHoaDon], [idNhanVien], [idKhachHang], [hinhThucThanhToan], [tongTien], [tongTienGiam], [ngayTao], [trangThai], [idVoucher], [ghiChu]) VALUES (25, N'HD58995', 2, 13, N'TienMat', CAST(1350000.00 AS Decimal(20, 2)), NULL, CAST(N'2023-12-06T13:22:25.9873444' AS DateTime2), 1, NULL, NULL)
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
GO
SET IDENTITY_INSERT [dbo].[HoaDonChiTiet] ON 

INSERT [dbo].[HoaDonChiTiet] ([id], [idSanPhamChiTiet], [idHoaDon], [soLuong], [giaTien], [thanhTien]) VALUES (16, 5, 23, 6, CAST(270000.00 AS Decimal(20, 2)), CAST(1620000.00 AS Decimal(20, 2)))
INSERT [dbo].[HoaDonChiTiet] ([id], [idSanPhamChiTiet], [idHoaDon], [soLuong], [giaTien], [thanhTien]) VALUES (17, 1, 24, 5, CAST(350000.00 AS Decimal(20, 2)), CAST(1750000.00 AS Decimal(20, 2)))
INSERT [dbo].[HoaDonChiTiet] ([id], [idSanPhamChiTiet], [idHoaDon], [soLuong], [giaTien], [thanhTien]) VALUES (18, 5, 25, 5, CAST(270000.00 AS Decimal(20, 2)), CAST(1350000.00 AS Decimal(20, 2)))
SET IDENTITY_INSERT [dbo].[HoaDonChiTiet] OFF
GO
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([id], [ma], [ten], [sdt], [email], [gioiTinh], [ngaySinh], [diaChi], [trangThai], [ngayTao], [ngaySua]) VALUES (1, N'KH001', N'Nguyễn Văn A', N'0123456789', N'nguyenvana', 1, CAST(N'1990-01-01' AS Date), N'123 Ðu?ng ABC, Qu?n 1, TP.HCM', 1, CAST(N'2023-11-28T00:00:00.000' AS DateTime), CAST(N'2023-11-28T00:00:00.000' AS DateTime))
INSERT [dbo].[KhachHang] ([id], [ma], [ten], [sdt], [email], [gioiTinh], [ngaySinh], [diaChi], [trangThai], [ngayTao], [ngaySua]) VALUES (3, N'KH003', N'Lê Văn C', N'0123456780', N'levanc', 1, CAST(N'1988-08-08' AS Date), N'789 Ðu?ng XYZ, Qu?n 3, TP.HCM', 1, CAST(N'2023-11-28T00:00:00.000' AS DateTime), CAST(N'2023-11-28T00:00:00.000' AS DateTime))
INSERT [dbo].[KhachHang] ([id], [ma], [ten], [sdt], [email], [gioiTinh], [ngaySinh], [diaChi], [trangThai], [ngayTao], [ngaySua]) VALUES (4, N'KH004', N'Phạm Thị D', N'0909090909', N'phamthid', 0, CAST(N'1992-03-20' AS Date), N'101 Ðu?ng KLM, Qu?n 4, TP.HCM', 1, CAST(N'2023-11-28T00:00:00.000' AS DateTime), CAST(N'2023-11-28T00:00:00.000' AS DateTime))
INSERT [dbo].[KhachHang] ([id], [ma], [ten], [sdt], [email], [gioiTinh], [ngaySinh], [diaChi], [trangThai], [ngayTao], [ngaySua]) VALUES (7, N'KH007', N'Lê Thị G', N'0901234567', N'lethig', 0, CAST(N'1993-09-25' AS Date), N'404 Ðu?ng ABC, Qu?n 7, TP.HCM', 1, CAST(N'2023-11-28T00:00:00.000' AS DateTime), CAST(N'2023-11-28T00:00:00.000' AS DateTime))
INSERT [dbo].[KhachHang] ([id], [ma], [ten], [sdt], [email], [gioiTinh], [ngaySinh], [diaChi], [trangThai], [ngayTao], [ngaySua]) VALUES (8, N'KH008', N'Phan Văn H', N'0912345678', N'phanvanh', 1, CAST(N'1980-04-05' AS Date), N'505 Ðu?ng XYZ, Qu?n 8, TP.HCM', 1, CAST(N'2023-11-28T00:00:00.000' AS DateTime), CAST(N'2023-11-28T00:00:00.000' AS DateTime))
INSERT [dbo].[KhachHang] ([id], [ma], [ten], [sdt], [email], [gioiTinh], [ngaySinh], [diaChi], [trangThai], [ngayTao], [ngaySua]) VALUES (9, N'KH009', N'Nguyễn Thị I', N'0987654321', N'nguyenthii', 0, CAST(N'1998-11-11' AS Date), N'606 Ðu?ng KLM, Qu?n 9, TP.HCM', 1, CAST(N'2023-11-28T00:00:00.000' AS DateTime), CAST(N'2023-11-28T00:00:00.000' AS DateTime))
INSERT [dbo].[KhachHang] ([id], [ma], [ten], [sdt], [email], [gioiTinh], [ngaySinh], [diaChi], [trangThai], [ngayTao], [ngaySua]) VALUES (13, N'KH000', N'Khách lẻ', NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL)
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
GO
SET IDENTITY_INSERT [dbo].[KichCo] ON 

INSERT [dbo].[KichCo] ([id], [ma], [ten], [ngayTao], [ngaySua], [isDelete]) VALUES (1, NULL, N'X', CAST(N'2023-11-29T22:01:30.1866667' AS DateTime2), CAST(N'2023-11-29T22:01:30.1866667' AS DateTime2), 0)
INSERT [dbo].[KichCo] ([id], [ma], [ten], [ngayTao], [ngaySua], [isDelete]) VALUES (2, NULL, N'S', CAST(N'2023-11-29T22:01:30.1866667' AS DateTime2), CAST(N'2023-11-29T22:01:30.1866667' AS DateTime2), 0)
INSERT [dbo].[KichCo] ([id], [ma], [ten], [ngayTao], [ngaySua], [isDelete]) VALUES (3, NULL, N'M', CAST(N'2023-11-29T22:01:30.1866667' AS DateTime2), CAST(N'2023-11-29T22:01:30.1866667' AS DateTime2), 0)
SET IDENTITY_INSERT [dbo].[KichCo] OFF
GO
SET IDENTITY_INSERT [dbo].[MauSac] ON 

INSERT [dbo].[MauSac] ([id], [ma], [ten], [ngayTao], [ngaySua], [isDelete]) VALUES (1, NULL, N'Đỏ', CAST(N'2023-11-29T22:01:30.1900000' AS DateTime2), CAST(N'2023-11-29T22:01:30.1900000' AS DateTime2), 0)
INSERT [dbo].[MauSac] ([id], [ma], [ten], [ngayTao], [ngaySua], [isDelete]) VALUES (2, NULL, N'Đen', CAST(N'2023-11-29T22:01:30.1900000' AS DateTime2), CAST(N'2023-11-29T22:01:30.1900000' AS DateTime2), 0)
INSERT [dbo].[MauSac] ([id], [ma], [ten], [ngayTao], [ngaySua], [isDelete]) VALUES (3, NULL, N'Trắng', CAST(N'2023-11-29T22:01:30.1900000' AS DateTime2), CAST(N'2023-11-29T22:01:30.1900000' AS DateTime2), 0)
SET IDENTITY_INSERT [dbo].[MauSac] OFF
GO
SET IDENTITY_INSERT [dbo].[NhanVien] ON 

INSERT [dbo].[NhanVien] ([id], [idChucVu], [ma], [ten], [email], [sdt], [gioiTinh], [ngaySinh], [matKhau], [diaChi], [trangThai], [ngayTao], [ngaySua]) VALUES (2, 1, N'NV001', N'Nguy?n Van Qu?n', N'le9701259@gmail.com', N'0999999999', 0, CAST(N'2003-12-12' AS Date), N'9b21b03d9048a5e6799a5c7052283250a92ca32a7089203a0c37d113d9ee9c53', N'123 Ðu?ng ABC, Qu?n 1, TP.HCM', 0, CAST(N'2023-11-29T22:02:35.3333333' AS DateTime2), CAST(N'2023-12-06T00:53:45.5330000' AS DateTime2))
INSERT [dbo].[NhanVien] ([id], [idChucVu], [ma], [ten], [email], [sdt], [gioiTinh], [ngaySinh], [matKhau], [diaChi], [trangThai], [ngayTao], [ngaySua]) VALUES (3, 2, N'NV002', N'Tr?n Th? Bán Hàng', N'nhanvien@gmail.com', N'0876543210', 1, CAST(N'2006-12-16' AS Date), N'5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', N'456 Ðu?ng XYZ, Qu?n 2, TP.HCM', 0, CAST(N'2023-11-29T22:02:35.3333333' AS DateTime2), CAST(N'2023-12-01T05:11:58.2250000' AS DateTime2))
INSERT [dbo].[NhanVien] ([id], [idChucVu], [ma], [ten], [email], [sdt], [gioiTinh], [ngaySinh], [matKhau], [diaChi], [trangThai], [ngayTao], [ngaySua]) VALUES (6, 2, N'nvtesttt', N'tesst2', N'test@gmail.com', N'0987654321', 0, CAST(N'2023-12-22' AS Date), N'5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', N'789 Ðu?ng LMN, Qu?n 3, TP.HCM', 0, CAST(N'2023-12-01T05:28:56.6240000' AS DateTime2), NULL)
INSERT [dbo].[NhanVien] ([id], [idChucVu], [ma], [ten], [email], [sdt], [gioiTinh], [ngaySinh], [matKhau], [diaChi], [trangThai], [ngayTao], [ngaySua]) VALUES (7, 2, N'NV00001', N'Nguy?n Van Qu?n', NULL, N'0999999999', 1, NULL, NULL, NULL, 0, CAST(N'2023-12-05T21:41:40.8590000' AS DateTime2), NULL)
INSERT [dbo].[NhanVien] ([id], [idChucVu], [ma], [ten], [email], [sdt], [gioiTinh], [ngaySinh], [matKhau], [diaChi], [trangThai], [ngayTao], [ngaySua]) VALUES (8, 2, N'NV40505', N'Nguyen1', NULL, N'0999999999', 0, NULL, NULL, NULL, 0, CAST(N'2023-12-05T22:15:45.6550000' AS DateTime2), NULL)
INSERT [dbo].[NhanVien] ([id], [idChucVu], [ma], [ten], [email], [sdt], [gioiTinh], [ngaySinh], [matKhau], [diaChi], [trangThai], [ngayTao], [ngaySua]) VALUES (9, 2, N'NV77108', N'tesst5', NULL, N'0987654321', 1, NULL, NULL, NULL, 0, CAST(N'2023-12-05T22:17:19.8820000' AS DateTime2), NULL)
SET IDENTITY_INSERT [dbo].[NhanVien] OFF
GO
SET IDENTITY_INSERT [dbo].[SanPham] ON 

INSERT [dbo].[SanPham] ([id], [ma], [ten], [isDelete], [idDanhMuc], [idThuongHieu], [ngayTao], [ngaySua]) VALUES (1, N'SP001', N'Áo thun Nike', 0, 1, 1, CAST(N'2023-11-29T22:01:30.2066667' AS DateTime2), CAST(N'2023-11-29T22:01:30.2066667' AS DateTime2))
INSERT [dbo].[SanPham] ([id], [ma], [ten], [isDelete], [idDanhMuc], [idThuongHieu], [ngayTao], [ngaySua]) VALUES (2, N'SP002', N'Áo thun Hàn Quốc', 0, 2, 2, CAST(N'2023-11-29T22:01:30.2066667' AS DateTime2), CAST(N'2023-11-29T22:01:30.2066667' AS DateTime2))
INSERT [dbo].[SanPham] ([id], [ma], [ten], [isDelete], [idDanhMuc], [idThuongHieu], [ngayTao], [ngaySua]) VALUES (3, N'SP003', N'Áo thun thời trang', 0, 3, 3, CAST(N'2023-11-29T22:01:30.2066667' AS DateTime2), CAST(N'2023-11-29T22:01:30.2066667' AS DateTime2))
SET IDENTITY_INSERT [dbo].[SanPham] OFF
GO
SET IDENTITY_INSERT [dbo].[SanPhamChiTiet] ON 

INSERT [dbo].[SanPhamChiTiet] ([id], [ma], [maVach], [idChatLieu], [idChieuDaiTay], [idKichCo], [idMauSac], [idSanPham], [idCoAo], [idXuatXu], [soLuong], [giaBan], [moTa], [ngayTao], [ngaySua], [trangThai]) VALUES (1, N'SPCT443', NULL, 1, 1, 1, 1, 1, 1, 1, 495, CAST(350000.00 AS Decimal(20, 2)), N'', NULL, NULL, 0)
INSERT [dbo].[SanPhamChiTiet] ([id], [ma], [maVach], [idChatLieu], [idChieuDaiTay], [idKichCo], [idMauSac], [idSanPham], [idCoAo], [idXuatXu], [soLuong], [giaBan], [moTa], [ngayTao], [ngaySua], [trangThai]) VALUES (2, N'SPCT817', NULL, 1, 1, 2, 1, 1, 1, 1, 500, CAST(350000.00 AS Decimal(20, 2)), N'', NULL, NULL, 0)
INSERT [dbo].[SanPhamChiTiet] ([id], [ma], [maVach], [idChatLieu], [idChieuDaiTay], [idKichCo], [idMauSac], [idSanPham], [idCoAo], [idXuatXu], [soLuong], [giaBan], [moTa], [ngayTao], [ngaySua], [trangThai]) VALUES (3, N'SPCT788', NULL, 1, 1, 3, 1, 1, 1, 1, 500, CAST(350000.00 AS Decimal(20, 2)), N'', NULL, NULL, 0)
INSERT [dbo].[SanPhamChiTiet] ([id], [ma], [maVach], [idChatLieu], [idChieuDaiTay], [idKichCo], [idMauSac], [idSanPham], [idCoAo], [idXuatXu], [soLuong], [giaBan], [moTa], [ngayTao], [ngaySua], [trangThai]) VALUES (5, N'SPCT481', NULL, 2, 1, 3, 1, 2, 1, 1, 475, CAST(270000.00 AS Decimal(20, 2)), N'', NULL, NULL, 0)
INSERT [dbo].[SanPhamChiTiet] ([id], [ma], [maVach], [idChatLieu], [idChieuDaiTay], [idKichCo], [idMauSac], [idSanPham], [idCoAo], [idXuatXu], [soLuong], [giaBan], [moTa], [ngayTao], [ngaySua], [trangThai]) VALUES (7, N'SPCT706', NULL, 2, 1, 1, 1, 3, 1, 1, 500, CAST(7880000.00 AS Decimal(20, 2)), N'', NULL, NULL, 0)
INSERT [dbo].[SanPhamChiTiet] ([id], [ma], [maVach], [idChatLieu], [idChieuDaiTay], [idKichCo], [idMauSac], [idSanPham], [idCoAo], [idXuatXu], [soLuong], [giaBan], [moTa], [ngayTao], [ngaySua], [trangThai]) VALUES (8, N'SPCT738', NULL, 2, 1, 2, 1, 3, 1, 1, 500, CAST(7880000.00 AS Decimal(20, 2)), N'', NULL, NULL, 0)
SET IDENTITY_INSERT [dbo].[SanPhamChiTiet] OFF
GO
SET IDENTITY_INSERT [dbo].[ThuongHieu] ON 

INSERT [dbo].[ThuongHieu] ([id], [ma], [ten], [ngayTao], [ngaySua], [isDelete]) VALUES (1, NULL, N'Nike', CAST(N'2023-11-29T22:01:30.1866667' AS DateTime2), CAST(N'2023-11-29T22:01:30.1866667' AS DateTime2), 0)
INSERT [dbo].[ThuongHieu] ([id], [ma], [ten], [ngayTao], [ngaySua], [isDelete]) VALUES (2, NULL, N'Hanoi Riot', CAST(N'2023-11-29T22:01:30.1866667' AS DateTime2), CAST(N'2023-11-29T22:01:30.1866667' AS DateTime2), 0)
INSERT [dbo].[ThuongHieu] ([id], [ma], [ten], [ngayTao], [ngaySua], [isDelete]) VALUES (3, NULL, N'SS', CAST(N'2023-11-29T22:01:30.1866667' AS DateTime2), CAST(N'2023-11-29T22:01:30.1866667' AS DateTime2), 0)
SET IDENTITY_INSERT [dbo].[ThuongHieu] OFF
GO
SET IDENTITY_INSERT [dbo].[Voucher] ON 

INSERT [dbo].[Voucher] ([id], [ma], [ten], [IdnhanVien], [loaiGiamGia], [ngayBatDau], [ngayKetThuc], [giaTriGiam], [GiaTriDhToiThieu], [trangThai], [soLuong], [soLuotSd]) VALUES (1, N'Ma1', N'Tên1', 1, 1, CAST(N'2023-01-01T00:00:00.0000000' AS DateTime2), CAST(N'2023-02-01T00:00:00.0000000' AS DateTime2), 10, CAST(5075.00 AS Decimal(20, 2)), 1, 10, 5)
INSERT [dbo].[Voucher] ([id], [ma], [ten], [IdnhanVien], [loaiGiamGia], [ngayBatDau], [ngayKetThuc], [giaTriGiam], [GiaTriDhToiThieu], [trangThai], [soLuong], [soLuotSd]) VALUES (2, N'Ma2', N'Tên2', 2, 0, CAST(N'2022-12-01T00:00:00.0000000' AS DateTime2), CAST(N'2022-12-12T00:00:00.0000000' AS DateTime2), 567, CAST(2000.00 AS Decimal(20, 2)), 1, 20, 8)
INSERT [dbo].[Voucher] ([id], [ma], [ten], [IdnhanVien], [loaiGiamGia], [ngayBatDau], [ngayKetThuc], [giaTriGiam], [GiaTriDhToiThieu], [trangThai], [soLuong], [soLuotSd]) VALUES (3, N'Ma3', N'Tên3', 3, 1, CAST(N'2023-03-01T00:00:00.0000000' AS DateTime2), CAST(N'2023-04-01T00:00:00.0000000' AS DateTime2), 80, CAST(40.20 AS Decimal(20, 2)), 1, 15, 12)
INSERT [dbo].[Voucher] ([id], [ma], [ten], [IdnhanVien], [loaiGiamGia], [ngayBatDau], [ngayKetThuc], [giaTriGiam], [GiaTriDhToiThieu], [trangThai], [soLuong], [soLuotSd]) VALUES (4, N'test', N'tesst', NULL, 0, CAST(N'2023-12-04T00:00:00.0000000' AS DateTime2), CAST(N'2023-12-04T00:00:00.0000000' AS DateTime2), 566, CAST(2000.00 AS Decimal(20, 2)), 1, 20, NULL)
INSERT [dbo].[Voucher] ([id], [ma], [ten], [IdnhanVien], [loaiGiamGia], [ngayBatDau], [ngayKetThuc], [giaTriGiam], [GiaTriDhToiThieu], [trangThai], [soLuong], [soLuotSd]) VALUES (5, N'Matest', N'testtttttttttt', NULL, 0, CAST(N'2022-12-03T00:00:00.0000000' AS DateTime2), CAST(N'2023-12-05T00:00:00.0000000' AS DateTime2), 567, CAST(2000.00 AS Decimal(20, 2)), 1, 20, NULL)
INSERT [dbo].[Voucher] ([id], [ma], [ten], [IdnhanVien], [loaiGiamGia], [ngayBatDau], [ngayKetThuc], [giaTriGiam], [GiaTriDhToiThieu], [trangThai], [soLuong], [soLuotSd]) VALUES (6, N'Ma4', N'Tên1', NULL, 1, CAST(N'2023-12-05T00:00:00.0000000' AS DateTime2), CAST(N'2023-12-08T00:00:00.0000000' AS DateTime2), 10, CAST(5075.00 AS Decimal(20, 2)), 0, 10, NULL)
SET IDENTITY_INSERT [dbo].[Voucher] OFF
GO
SET IDENTITY_INSERT [dbo].[XuatXu] ON 

INSERT [dbo].[XuatXu] ([id], [ten]) VALUES (1, N'Việt Nam')
INSERT [dbo].[XuatXu] ([id], [ten]) VALUES (2, N'Lào')
INSERT [dbo].[XuatXu] ([id], [ten]) VALUES (3, N'Campuchia')
SET IDENTITY_INSERT [dbo].[XuatXu] OFF
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [trangThai]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT ((0)) FOR [trangThai]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT ((0)) FOR [trangThai]
GO
ALTER TABLE [dbo].[SanPhamChiTiet] ADD  DEFAULT ((0)) FOR [trangThai]
GO
ALTER TABLE [dbo].[Voucher] ADD  DEFAULT ((0)) FOR [trangThai]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon.IdkhachHang] FOREIGN KEY([idKhachHang])
REFERENCES [dbo].[KhachHang] ([id])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon.IdkhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon.IdnhanVien] FOREIGN KEY([idNhanVien])
REFERENCES [dbo].[NhanVien] ([id])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon.IdnhanVien]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon.IdVoucher] FOREIGN KEY([idVoucher])
REFERENCES [dbo].[Voucher] ([id])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon.IdVoucher]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet.idHoaDon] FOREIGN KEY([idHoaDon])
REFERENCES [dbo].[HoaDon] ([id])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet.idHoaDon]
GO
