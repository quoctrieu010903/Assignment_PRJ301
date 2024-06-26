USE [CarManagement]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 24/04/2024 17:27:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[AccountID] [varchar](4) NOT NULL,
	[UserName] [varchar](40) NOT NULL,
	[Password] [varchar](40) NOT NULL,
	[FullName] [varchar](40) NOT NULL,
	[RoleID] [varchar](2) NULL,
PRIMARY KEY CLUSTERED 
(
	[AccountID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 24/04/2024 17:27:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[CategoryID] [varchar](4) NOT NULL,
	[CategoryName] [varchar](40) NULL,
	[Description] [varchar](40) NULL,
PRIMARY KEY CLUSTERED 
(
	[CategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customers]    Script Date: 24/04/2024 17:27:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customers](
	[CustomerID] [varchar](5) NOT NULL,
	[Password] [varchar](40) NULL,
	[ContactName] [varchar](40) NULL,
	[Address] [varchar](11) NULL,
	[PhoneNumber] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[CustomerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order_Details]    Script Date: 24/04/2024 17:27:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order_Details](
	[OrderID] [varchar](4) NOT NULL,
	[ProductID] [varchar](4) NOT NULL,
	[UnitPrice] [float] NULL,
	[Quantity] [int] NULL,
 CONSTRAINT [pk_OrderDetails] PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC,
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 24/04/2024 17:27:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[OrderID] [varchar](4) NOT NULL,
	[CustomerID] [varchar](5) NULL,
	[OrderDate] [date] NULL,
	[RequiredDate] [date] NULL,
	[ShippedDate] [date] NULL,
	[Freight] [float] NULL,
	[ShipAddress] [varchar](40) NULL,
PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 24/04/2024 17:27:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[ProductID] [varchar](4) NOT NULL,
	[ProductName] [varchar](40) NULL,
	[CategoryID] [varchar](4) NULL,
	[QuantityPerUnit] [int] NULL,
	[UnitPrice] [float] NULL,
	[ProductImage] [varchar](300) NULL,
PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([AccountID], [UserName], [Password], [FullName], [RoleID]) VALUES (N'A000', N'Trieu', N'1', N'Quoc Trieu', N'AD')
INSERT [dbo].[Account] ([AccountID], [UserName], [Password], [FullName], [RoleID]) VALUES (N'A001', N'Quoc Trieu', N'1', N'Luong Quoc Trieu', N'US')
INSERT [dbo].[Account] ([AccountID], [UserName], [Password], [FullName], [RoleID]) VALUES (N'A002', N'Trieu', N'1', N'Luong Quoc Trieu', N'US')
GO
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (N'C001', N'Fresh Meat', NULL)
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (N'C002', N'Vegetables', NULL)
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (N'C003', N'Fruit & Nut Gifts', NULL)
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (N'C004', N'Fresh Berries', NULL)
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (N'C05', N'Ocean Foods', NULL)
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (N'C06', N'Butter & Eggs', NULL)
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (N'C07', N'Fastfood', NULL)
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (N'C08', N'Fresh Onion', NULL)
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (N'C09', N'Papayaya & Crisps', NULL)
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (N'C10', N'Oatmeal', NULL)
GO
INSERT [dbo].[Customers] ([CustomerID], [Password], [ContactName], [Address], [PhoneNumber]) VALUES (N'A001', N'1', N'Quoc Trieu', N'Dong Nai', N'0705726731')
INSERT [dbo].[Customers] ([CustomerID], [Password], [ContactName], [Address], [PhoneNumber]) VALUES (N'A002', N'1', N'Trieu', N'Dong Nai', N'0705726731')
GO
INSERT [dbo].[Order_Details] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (N'O001', N'C003', 30.399999618530273, 1)
INSERT [dbo].[Order_Details] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (N'O001', N'C004', 30, 1)
INSERT [dbo].[Order_Details] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (N'O002', N'C003', 30.399999618530273, 10)
INSERT [dbo].[Order_Details] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (N'O003', N'C003', 30.399999618530273, 2)
INSERT [dbo].[Order_Details] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (N'O004', N'C003', 30.399999618530273, 1)
INSERT [dbo].[Order_Details] ([OrderID], [ProductID], [UnitPrice], [Quantity]) VALUES (N'O005', N'C003', 30.399999618530273, 1)
GO
INSERT [dbo].[Orders] ([OrderID], [CustomerID], [OrderDate], [RequiredDate], [ShippedDate], [Freight], [ShipAddress]) VALUES (N'O001', N'A001', CAST(N'2024-04-24' AS Date), CAST(N'2024-04-27' AS Date), CAST(N'2024-04-25' AS Date), 50, N'Dong Nai')
INSERT [dbo].[Orders] ([OrderID], [CustomerID], [OrderDate], [RequiredDate], [ShippedDate], [Freight], [ShipAddress]) VALUES (N'O002', N'A001', CAST(N'2024-04-24' AS Date), CAST(N'2024-04-27' AS Date), CAST(N'2024-04-25' AS Date), 30, N'Dong Nai')
INSERT [dbo].[Orders] ([OrderID], [CustomerID], [OrderDate], [RequiredDate], [ShippedDate], [Freight], [ShipAddress]) VALUES (N'O003', N'A002', CAST(N'2024-04-24' AS Date), CAST(N'2024-04-27' AS Date), CAST(N'2024-04-25' AS Date), 50, N'Dong Nai')
INSERT [dbo].[Orders] ([OrderID], [CustomerID], [OrderDate], [RequiredDate], [ShippedDate], [Freight], [ShipAddress]) VALUES (N'O004', N'A001', CAST(N'2024-04-24' AS Date), CAST(N'2024-04-27' AS Date), CAST(N'2024-04-25' AS Date), 30, N'Dong Nai')
INSERT [dbo].[Orders] ([OrderID], [CustomerID], [OrderDate], [RequiredDate], [ShippedDate], [Freight], [ShipAddress]) VALUES (N'O005', N'A001', CAST(N'2024-04-24' AS Date), CAST(N'2024-04-27' AS Date), CAST(N'2024-04-25' AS Date), 30, N'Dong Nai')
GO
INSERT [dbo].[Products] ([ProductID], [ProductName], [CategoryID], [QuantityPerUnit], [UnitPrice], [ProductImage]) VALUES (N'C001', N'COffe', N'C10', 12, 25.5, N'https://product.hstatic.net/1000282430/product/tao-web_a16941821af245129abba58b71e35f18_master.jpg')
INSERT [dbo].[Products] ([ProductID], [ProductName], [CategoryID], [QuantityPerUnit], [UnitPrice], [ProductImage]) VALUES (N'C003', N'Apple', N'C001', 6, 30.4, N'https://product.hstatic.net/1000282430/product/du-du-do_a925cf1dca944fa5aea5fafa75c85656_master.jpg')
INSERT [dbo].[Products] ([ProductID], [ProductName], [CategoryID], [QuantityPerUnit], [UnitPrice], [ProductImage]) VALUES (N'C004', N'Crab Pool Security', N'C002', 4, 30, N'https://product.hstatic.net/1000282430/product/tam-bop_b40175b59dbe4c9f9f4693a6af640e6c_master.jpg')
INSERT [dbo].[Products] ([ProductID], [ProductName], [CategoryID], [QuantityPerUnit], [UnitPrice], [ProductImage]) VALUES (N'C005', N'Crab Pool Security', N'C002', 6, 65.3, N'https://product.hstatic.net/200000157781/product/papaya_copy_5ed9f2b13a2e4c34ae1ec932bede426d.jpg')
INSERT [dbo].[Products] ([ProductID], [ProductName], [CategoryID], [QuantityPerUnit], [UnitPrice], [ProductImage]) VALUES (N'C006', N'Crab Pool Security', N'C002', 6, 14.2, N'https://product.hstatic.net/200000157781/product/tao_gala_do_superdomex_usa__2__f278ef3d4eac46819c23ef6cd534b1e0.jpg')
INSERT [dbo].[Products] ([ProductID], [ProductName], [CategoryID], [QuantityPerUnit], [UnitPrice], [ProductImage]) VALUES (N'C011', N'Durian Fruits', N'C002', 12, 35.5, N'https://product.hstatic.net/200000325223/product/sau_rieng_new-01_63392fbb5c3d449e913faebc332ae80f_7914731456f84bd195eeb1ea2e08886f_master.png')
INSERT [dbo].[Products] ([ProductID], [ProductName], [CategoryID], [QuantityPerUnit], [UnitPrice], [ProductImage]) VALUES (N'C015', N'Durian Fruits', N'C002', 10, 35.1, N'https://product.hstatic.net/200000325223/product/sau_rieng_new-01_63392fbb5c3d449e913faebc332ae80f_7914731456f84bd195eeb1ea2e08886f_master.png')
GO
ALTER TABLE [dbo].[Order_Details]  WITH CHECK ADD  CONSTRAINT [fk_OrderID] FOREIGN KEY([OrderID])
REFERENCES [dbo].[Orders] ([OrderID])
GO
ALTER TABLE [dbo].[Order_Details] CHECK CONSTRAINT [fk_OrderID]
GO
ALTER TABLE [dbo].[Order_Details]  WITH CHECK ADD  CONSTRAINT [fk_ProductID] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Products] ([ProductID])
GO
ALTER TABLE [dbo].[Order_Details] CHECK CONSTRAINT [fk_ProductID]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([CustomerID])
REFERENCES [dbo].[Customers] ([CustomerID])
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD FOREIGN KEY([CategoryID])
REFERENCES [dbo].[Categories] ([CategoryID])
GO
