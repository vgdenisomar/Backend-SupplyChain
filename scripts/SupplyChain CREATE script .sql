USE [master]
GO
/****** Object:  Database [SupplyChain]    Script Date: 17/6/2024 22:19:03 ******/
CREATE DATABASE [SupplyChain]
GO
ALTER DATABASE [SupplyChain] SET COMPATIBILITY_LEVEL = 130
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [SupplyChain].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [SupplyChain] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [SupplyChain] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [SupplyChain] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [SupplyChain] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [SupplyChain] SET ARITHABORT OFF 
GO
ALTER DATABASE [SupplyChain] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [SupplyChain] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [SupplyChain] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [SupplyChain] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [SupplyChain] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [SupplyChain] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [SupplyChain] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [SupplyChain] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [SupplyChain] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [SupplyChain] SET  DISABLE_BROKER 
GO
ALTER DATABASE [SupplyChain] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [SupplyChain] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [SupplyChain] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [SupplyChain] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [SupplyChain] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [SupplyChain] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [SupplyChain] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [SupplyChain] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [SupplyChain] SET  MULTI_USER 
GO
ALTER DATABASE [SupplyChain] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [SupplyChain] SET DB_CHAINING OFF 
GO
ALTER DATABASE [SupplyChain] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [SupplyChain] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [SupplyChain] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [SupplyChain] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [SupplyChain] SET QUERY_STORE = OFF
GO
USE [SupplyChain]
GO
/****** Object:  Table [dbo].[CompanySetting]    Script Date: 17/6/2024 22:19:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CompanySetting](
	[ID_UUID] [nvarchar](40) NOT NULL,
	[CompanyLegalName] [nvarchar](100) NOT NULL,
	[CompanyCommercialName] [nvarchar](100) NOT NULL,
	[CompanyAddress] [nvarchar](100) NULL,
	[CompanyRTN] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[Phone] [nvarchar](50) NULL,
	[UserCreated] [nvarchar](50) NOT NULL,
	[DateCreated] [datetime] NOT NULL,
	[UserLastModify] [nvarchar](50) NOT NULL,
	[DateLastModify] [datetime] NOT NULL,
	[RegistryStatus] [nchar](10) NOT NULL,
 CONSTRAINT [PK_CompanySetting] PRIMARY KEY CLUSTERED 
(
	[ID_UUID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Parameter]    Script Date: 17/6/2024 22:19:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Parameter](
	[ID_UUID] [nvarchar](40) NOT NULL,
	[ParameterType_ID_UUID] [nvarchar](40) NOT NULL,
	[ParameterDescription] [nvarchar](100) NOT NULL,
	[UserCreated] [nvarchar](50) NOT NULL,
	[DateCreated] [datetime] NOT NULL,
	[UserLastModify] [nvarchar](50) NOT NULL,
	[DateLastModify] [datetime] NOT NULL,
	[RegistryStatus] [nchar](10) NOT NULL,
 CONSTRAINT [PK_Parameter] PRIMARY KEY CLUSTERED 
(
	[ID_UUID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ParameterType]    Script Date: 17/6/2024 22:19:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ParameterType](
	[ID_UUID] [nvarchar](40) NOT NULL,
	[ParameterTypeCode] [nvarchar](5) NOT NULL,
	[ParameterTypeDescription] [nvarchar](50) NOT NULL,
	[UserCreated] [nvarchar](50) NOT NULL,
	[DateCreated] [datetime] NOT NULL,
	[UserLastModify] [nvarchar](50) NOT NULL,
	[DateLastModify] [datetime] NOT NULL,
	[RegistryStatus] [nchar](10) NOT NULL,
 CONSTRAINT [PK_ParameterType] PRIMARY KEY CLUSTERED 
(
	[ID_UUID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 17/6/2024 22:19:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[ID_UUID] [nvarchar](40) NOT NULL,
	[ProductCode] [nvarchar](50) NOT NULL,
	[ProductName] [nvarchar](100) NOT NULL,
	[UnitOM] [nvarchar](40) NOT NULL,
	[UnitPrice] [decimal](18, 4) NOT NULL,
	[ISV] [decimal](9, 0) NOT NULL,
	[UserCreated] [nvarchar](50) NOT NULL,
	[DateCreated] [datetime] NOT NULL,
	[UserLastModify] [nvarchar](50) NOT NULL,
	[DateLastModify] [datetime] NOT NULL,
	[RegistryStatus] [nchar](10) NOT NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[ID_UUID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Purchase]    Script Date: 17/6/2024 22:19:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Purchase](
	[ID_UUID] [nvarchar](40) NOT NULL,
	[PurchaseNumber] [nchar](10) NOT NULL,
	[Supplier_ID_UUID] [nvarchar](40) NOT NULL,
	[PurchaseDate] [date] NOT NULL,
	[ParameterDepartment_ID_UUID] [nvarchar](40) NOT NULL,
	[PurchaseSubject] [nvarchar](200) NOT NULL,
	[Subtotal] [decimal](18, 2) NOT NULL,
	[ExemptAmount] [decimal](18, 2) NOT NULL,
	[TaxedAmount] [decimal](18, 2) NOT NULL,
	[ISVAmount] [decimal](18, 2) NOT NULL,
	[Total] [decimal](18, 2) NOT NULL,
	[LetterValue] [nvarchar](100) NOT NULL,
	[Note] [nvarchar](100) NOT NULL,
	[ParameterPaymentMethod_ID_UUID] [nvarchar](40) NOT NULL,
	[UserCreated] [nvarchar](50) NOT NULL,
	[DateCreated] [datetime] NOT NULL,
	[UserLastModify] [nvarchar](50) NOT NULL,
	[DateLastModify] [datetime] NOT NULL,
	[RegistryStatus] [nchar](10) NOT NULL,
 CONSTRAINT [PK_Purchase] PRIMARY KEY CLUSTERED 
(
	[ID_UUID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PurchaseDetail]    Script Date: 17/6/2024 22:19:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PurchaseDetail](
	[ID_UUID] [nvarchar](40) NOT NULL,
	[Purchase_ID_UUID] [nvarchar](40) NOT NULL,
	[Item] [int] NOT NULL,
	[UnitOM] [nvarchar](40) NOT NULL,
	[Product_ID_UUID] [nvarchar](40) NOT NULL,
	[Quantity] [decimal](18, 2) NOT NULL,
	[UnitPrice] [decimal](18, 4) NOT NULL,
	[SubTotal] [decimal](18, 4) NOT NULL,
	[UserCreated] [nvarchar](50) NOT NULL,
	[DateCreated] [datetime] NOT NULL,
	[UserLastModify] [nvarchar](50) NOT NULL,
	[DateLastModify] [datetime] NOT NULL,
	[RegistryStatus] [nchar](10) NOT NULL,
 CONSTRAINT [PK_PurchaseDetail] PRIMARY KEY CLUSTERED 
(
	[ID_UUID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Supplier]    Script Date: 17/6/2024 22:19:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Supplier](
	[ID_UUID] [nvarchar](40) NOT NULL,
	[SupplierName] [nvarchar](100) NOT NULL,
	[SupplierRTN] [nchar](20) NOT NULL,
	[Address] [nvarchar](100) NOT NULL,
	[Notes] [nvarchar](100) NOT NULL,
	[UserCreated] [nvarchar](50) NOT NULL,
	[DateCreated] [datetime] NOT NULL,
	[UserLastModify] [nvarchar](50) NOT NULL,
	[DateLastModify] [datetime] NOT NULL,
	[RegistryStatus] [nchar](10) NOT NULL,
 CONSTRAINT [PK_Supplier] PRIMARY KEY CLUSTERED 
(
	[ID_UUID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[CompanySetting] ([ID_UUID], [CompanyLegalName], [CompanyCommercialName], [CompanyAddress], [CompanyRTN], [Email], [Phone], [UserCreated], [DateCreated], [UserLastModify], [DateLastModify], [RegistryStatus]) VALUES (N'8e0cdb0a-ea8f-488b-8d2c-bd2fc56a8363', N'MUNICIPALIDAD DE AMAPALA', N'MUNICIPALIDAD DE AMAPALA DEPARTAMENTO DE VALLE', N'Amapala', N'08011977123456', N'amapala@gmail.com', N'2290-0000', N'jmartinez', CAST(N'2024-06-17T21:21:37.787' AS DateTime), N'jmartinez', CAST(N'2024-06-17T21:21:37.787' AS DateTime), N'ACTIVO    ')
GO
INSERT [dbo].[Parameter] ([ID_UUID], [ParametryType_ID_UUID], [ParameterDescription], [UserCreated], [DateCreated], [UserLastModify], [DateLastModify], [RegistryStatus]) VALUES (N'24a153d3-bfc5-448a-a3e7-09e53f2911cf', N'7952d2bf-c4e7-4833-98ba-4c88a1b8eaf2', N'CHEQUE', N'JAMARTINEZ', CAST(N'2024-06-17T21:39:06.583' AS DateTime), N'JAMARTNEZ', CAST(N'2024-06-17T21:39:06.583' AS DateTime), N'ACTIVO    ')
INSERT [dbo].[Parameter] ([ID_UUID], [ParametryType_ID_UUID], [ParameterDescription], [UserCreated], [DateCreated], [UserLastModify], [DateLastModify], [RegistryStatus]) VALUES (N'd82ab4a2-3266-4d84-a800-0eaea72df2fc', N'7952d2bf-c4e7-4833-98ba-4c88a1b8eaf2', N'TRANSFERENCIA', N'JAMARTINEZ', CAST(N'2024-06-17T21:39:20.773' AS DateTime), N'JAMARTINEZ', CAST(N'2024-06-17T21:39:20.773' AS DateTime), N'ACTIVO    ')
INSERT [dbo].[Parameter] ([ID_UUID], [ParametryType_ID_UUID], [ParameterDescription], [UserCreated], [DateCreated], [UserLastModify], [DateLastModify], [RegistryStatus]) VALUES (N'd3fba145-ebb3-46ca-9c29-248fd7ee0fc0', N'02c9a87c-1a0c-4a42-8e6f-0660543ebdfa', N'ONZA', N'JAMARTINEZ', CAST(N'2024-06-17T21:35:55.380' AS DateTime), N'JAMARTINEZ', CAST(N'2024-06-17T21:35:55.380' AS DateTime), N'ACTIVO    ')
INSERT [dbo].[Parameter] ([ID_UUID], [ParametryType_ID_UUID], [ParameterDescription], [UserCreated], [DateCreated], [UserLastModify], [DateLastModify], [RegistryStatus]) VALUES (N'296d365e-8aec-44c1-b31f-2d92bc9daeea', N'02c9a87c-1a0c-4a42-8e6f-0660543ebdfa', N'CARTON', N'JAMARTINEZ', CAST(N'2024-06-17T21:34:55.190' AS DateTime), N'JAMARTINEZ', CAST(N'2024-06-17T21:34:55.190' AS DateTime), N'ACTIVO    ')
INSERT [dbo].[Parameter] ([ID_UUID], [ParametryType_ID_UUID], [ParameterDescription], [UserCreated], [DateCreated], [UserLastModify], [DateLastModify], [RegistryStatus]) VALUES (N'f34d4c77-1578-4dae-9366-52ac36c8e948', N'02c9a87c-1a0c-4a42-8e6f-0660543ebdfa', N'UNIDAD', N'JAMARTINEZ', CAST(N'2024-06-17T21:34:35.210' AS DateTime), N'JAMARTINEZ', CAST(N'2024-06-17T21:34:35.210' AS DateTime), N'ACTIVO    ')
INSERT [dbo].[Parameter] ([ID_UUID], [ParametryType_ID_UUID], [ParameterDescription], [UserCreated], [DateCreated], [UserLastModify], [DateLastModify], [RegistryStatus]) VALUES (N'8600121e-b9c0-47d2-a48d-76e89c5e1779', N'8b3101c2-01c6-4d98-a18e-0d94536efa4c', N'DEPARTAMENTO DE COMPRAS DE LA ALCALDIA MUNICIPAL DE AMAPALA', N'JAMARTINEZ', CAST(N'2024-06-17T21:37:03.863' AS DateTime), N'JAMARTINEZ', CAST(N'2024-06-17T21:37:03.863' AS DateTime), N'ACTIVO    ')
INSERT [dbo].[Parameter] ([ID_UUID], [ParametryType_ID_UUID], [ParameterDescription], [UserCreated], [DateCreated], [UserLastModify], [DateLastModify], [RegistryStatus]) VALUES (N'e839cdae-07fb-44fd-bc6b-95b99b5a7a29', N'7952d2bf-c4e7-4833-98ba-4c88a1b8eaf2', N'EFECTIVO', N'JAMARTINEZ', CAST(N'2024-06-17T21:38:52.373' AS DateTime), N'JAMARTINEZ', CAST(N'2024-06-17T21:38:52.373' AS DateTime), N'ACTIVO    ')
INSERT [dbo].[Parameter] ([ID_UUID], [ParametryType_ID_UUID], [ParameterDescription], [UserCreated], [DateCreated], [UserLastModify], [DateLastModify], [RegistryStatus]) VALUES (N'fc39b17a-4d44-44c1-a334-f835867d7d95', N'02c9a87c-1a0c-4a42-8e6f-0660543ebdfa', N'LIBRA', N'JAMARTINEZ', CAST(N'2024-06-17T21:35:22.900' AS DateTime), N'JAMARTINEZ', CAST(N'2024-06-17T21:35:22.900' AS DateTime), N'ACTIVO    ')
GO
INSERT [dbo].[ParameterType] ([ID_UUID], [ParameterTypeCode], [ParameterTypeDescription], [UserCreated], [DateCreated], [UserLastModify], [DateLastModify], [RegistryStatus]) VALUES (N'02c9a87c-1a0c-4a42-8e6f-0660543ebdfa', N'UMED', N'UNIDAD DE MEDIDA', N'JAMARTINEZ', CAST(N'2024-06-17T21:30:28.443' AS DateTime), N'JAMARTINEZ', CAST(N'2024-06-17T21:30:28.443' AS DateTime), N'ACTIVO    ')
INSERT [dbo].[ParameterType] ([ID_UUID], [ParameterTypeCode], [ParameterTypeDescription], [UserCreated], [DateCreated], [UserLastModify], [DateLastModify], [RegistryStatus]) VALUES (N'8b3101c2-01c6-4d98-a18e-0d94536efa4c', N'DEPA', N'DEPARTAMENTOS DE LA INSTITUCION', N'JAMARTINEZ', CAST(N'2024-06-17T21:29:52.977' AS DateTime), N'JAMARTINEZ', CAST(N'2024-06-17T21:29:52.977' AS DateTime), N'ACTIVO    ')
INSERT [dbo].[ParameterType] ([ID_UUID], [ParameterTypeCode], [ParameterTypeDescription], [UserCreated], [DateCreated], [UserLastModify], [DateLastModify], [RegistryStatus]) VALUES (N'7952d2bf-c4e7-4833-98ba-4c88a1b8eaf2', N'FPAG', N'FORMA DE PAGO', N'JAMARTINEZ', CAST(N'2024-06-17T21:29:11.020' AS DateTime), N'JAMARTINEZ', CAST(N'2024-06-17T21:29:11.020' AS DateTime), N'ACTIVO    ')
INSERT [dbo].[ParameterType] ([ID_UUID], [ParameterTypeCode], [ParameterTypeDescription], [UserCreated], [DateCreated], [UserLastModify], [DateLastModify], [RegistryStatus]) VALUES (N'8f4de9c3-114f-4af5-8953-6814cd13de97', N'CRGO', N'CARGO DE LA INSITUCION', N'JAMARTINEZ', CAST(N'2024-06-17T21:30:58.317' AS DateTime), N'JAMARTINEZ', CAST(N'2024-06-17T21:30:58.317' AS DateTime), N'ACTIVO    ')
INSERT [dbo].[ParameterType] ([ID_UUID], [ParameterTypeCode], [ParameterTypeDescription], [UserCreated], [DateCreated], [UserLastModify], [DateLastModify], [RegistryStatus]) VALUES (N'f4cf3030-f52b-4a44-8c05-a61a6cfac766', N'LOGO', N'LOGOS DEL SISTEMA', N'JAMARTINEZ', CAST(N'2024-06-17T21:31:23.540' AS DateTime), N'JAMARTINEZ', CAST(N'2024-06-17T21:31:23.540' AS DateTime), N'ACTIVO    ')
GO
INSERT [dbo].[Product] ([ID_UUID], [ProductCode], [ProductName], [UnitPrice], [UserCreated], [DateCreated], [UserLastModify], [DateLastModify], [RegistryStatus]) VALUES (N'8bf26020-f638-4508-b580-77d6fe449ffc', N'2', N'Huevos', CAST(160.0000 AS Decimal(18, 4)), N'jamartinez', CAST(N'2024-06-17T21:27:36.980' AS DateTime), N'jamartinez', CAST(N'2024-06-17T21:27:36.980' AS DateTime), N'ACTIVO    ')
INSERT [dbo].[Product] ([ID_UUID], [ProductCode], [ProductName], [UnitPrice], [UserCreated], [DateCreated], [UserLastModify], [DateLastModify], [RegistryStatus]) VALUES (N'76585bd4-b749-43f3-b71e-7a8735ab49f9', N'1', N'Menudos de Pollo', CAST(30.0000 AS Decimal(18, 4)), N'jamartinez', CAST(N'2024-06-17T21:26:57.200' AS DateTime), N'jamartinez', CAST(N'2024-06-17T21:26:57.200' AS DateTime), N'ACTIVO    ')
GO
INSERT [dbo].[Purchase] ([ID_UUID], [PurchaseNumber], [Supplier_ID_UUID], [PurchaseDate], [ParameterDepartment_ID_UUID], [PurchaseSubject], [Subtotal], [ExemptAmount], [TaxedAmount], [ISVAmount], [Total], [LetterValue], [Note], [ParameterPaymentMethod_ID_UUID], [UserCreated], [DateCreated], [UserLastModify], [DateLastModify], [RegistryStatus]) VALUES (N'f9567518-a0f6-4895-b8e3-941642b976d8', N'9999-2024 ', N'10c00b66-f58f-42b3-914f-a7a211c35206', CAST(N'2024-06-17' AS Date), N'8600121e-b9c0-47d2-a48d-76e89c5e1779', N'SUMINISTRO DE VIVERES', CAST(0.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(18, 2)), N'CERO', N'', N'd82ab4a2-3266-4d84-a800-0eaea72df2fc', N'JAMARTINEZ', CAST(N'2024-06-17T21:44:30.040' AS DateTime), N'JAMARTINEZ', CAST(N'2024-06-17T21:44:30.040' AS DateTime), N'ACTIVO    ')
GO
INSERT [dbo].[Supplier] ([ID_UUID], [SupplierName], [SupplierRTN], [Address], [Notes], [UserCreated], [DateCreated], [UserLastModify], [DateLastModify], [RegistryStatus]) VALUES (N'10c00b66-f58f-42b3-914f-a7a211c35206', N'ABARROTERIA EN GEERAL Y VENTA DE VERDURAS JUANITA', N'08011234123456      ', N'Valle', N'Ninguna', N'jamartinez', CAST(N'2024-06-17T21:22:39.973' AS DateTime), N'jamartinez', CAST(N'2024-06-17T21:22:39.973' AS DateTime), N'ACTIVO    ')
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_ParameterTypeCode]    Script Date: 17/6/2024 22:19:04 ******/
CREATE UNIQUE NONCLUSTERED INDEX [IX_ParameterTypeCode] ON [dbo].[ParameterType]
(
	[ParameterTypeCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[CompanySetting] ADD  CONSTRAINT [DF_CompanySetting_ID_UUID]  DEFAULT (newid()) FOR [ID_UUID]
GO
ALTER TABLE [dbo].[CompanySetting] ADD  CONSTRAINT [DF_CompanySetting_DateCreated]  DEFAULT (getdate()) FOR [DateCreated]
GO
ALTER TABLE [dbo].[CompanySetting] ADD  CONSTRAINT [DF_CompanySetting_DateLastModify]  DEFAULT (getdate()) FOR [DateLastModify]
GO
ALTER TABLE [dbo].[CompanySetting] ADD  CONSTRAINT [DF_CompanySetting_RegistryStatus]  DEFAULT ('ACTIVO') FOR [RegistryStatus]
GO
ALTER TABLE [dbo].[Parameter] ADD  CONSTRAINT [DF_Parameter_ID_UUID]  DEFAULT (newid()) FOR [ID_UUID]
GO
ALTER TABLE [dbo].[Parameter] ADD  CONSTRAINT [DF_Parameter_DateCreated]  DEFAULT (getdate()) FOR [DateCreated]
GO
ALTER TABLE [dbo].[Parameter] ADD  CONSTRAINT [DF_Parameter_DateLastModify]  DEFAULT (getdate()) FOR [DateLastModify]
GO
ALTER TABLE [dbo].[Parameter] ADD  CONSTRAINT [DF_Parameter_RegistryStatus]  DEFAULT ('ACTIVO') FOR [RegistryStatus]
GO
ALTER TABLE [dbo].[ParameterType] ADD  CONSTRAINT [DF_ParameterType_ID_UUID]  DEFAULT (newid()) FOR [ID_UUID]
GO
ALTER TABLE [dbo].[ParameterType] ADD  CONSTRAINT [DF_ParameterType_DateCreated]  DEFAULT (getdate()) FOR [DateCreated]
GO
ALTER TABLE [dbo].[ParameterType] ADD  CONSTRAINT [DF_ParameterType_DateLastModify]  DEFAULT (getdate()) FOR [DateLastModify]
GO
ALTER TABLE [dbo].[ParameterType] ADD  CONSTRAINT [DF_ParameterType_RegistryStatus]  DEFAULT ('ACTIVO') FOR [RegistryStatus]
GO
ALTER TABLE [dbo].[Product] ADD  CONSTRAINT [DF_Product_ID_UUID]  DEFAULT (newid()) FOR [ID_UUID]
GO
ALTER TABLE [dbo].[Product] ADD  CONSTRAINT [DF_Product_ProductCode]  DEFAULT ('') FOR [ProductCode]
GO
ALTER TABLE [dbo].[Product] ADD  CONSTRAINT [DF_Product_ProductName]  DEFAULT ('') FOR [ProductName]
GO
ALTER TABLE [dbo].[Product] ADD  CONSTRAINT [DF_Product_UnitPrice]  DEFAULT ((0)) FOR [UnitPrice]
GO
ALTER TABLE [dbo].[Product] ADD  CONSTRAINT [DF_Product_DateCreated]  DEFAULT (getdate()) FOR [DateCreated]
GO
ALTER TABLE [dbo].[Product] ADD  CONSTRAINT [DF_Product_DateLastModify]  DEFAULT (getdate()) FOR [DateLastModify]
GO
ALTER TABLE [dbo].[Product] ADD  CONSTRAINT [DF_Product_RegistryStatus]  DEFAULT ('ACTIVO') FOR [RegistryStatus]
GO
ALTER TABLE [dbo].[Purchase] ADD  CONSTRAINT [DF_Purchase_ID_UUID]  DEFAULT (newid()) FOR [ID_UUID]
GO
ALTER TABLE [dbo].[Purchase] ADD  CONSTRAINT [DF_Purchase_DateCreated]  DEFAULT (getdate()) FOR [DateCreated]
GO
ALTER TABLE [dbo].[Purchase] ADD  CONSTRAINT [DF_Purchase_DateLastModify]  DEFAULT (getdate()) FOR [DateLastModify]
GO
ALTER TABLE [dbo].[Purchase] ADD  CONSTRAINT [DF_Purchase_RegistryStatus]  DEFAULT ('ACTIVO') FOR [RegistryStatus]
GO
ALTER TABLE [dbo].[PurchaseDetail] ADD  CONSTRAINT [DF_PurchaseDetail_ID_UUID]  DEFAULT (newid()) FOR [ID_UUID]
GO
ALTER TABLE [dbo].[PurchaseDetail] ADD  CONSTRAINT [DF_PurchaseDetail_Quantity]  DEFAULT ((0)) FOR [Quantity]
GO
ALTER TABLE [dbo].[PurchaseDetail] ADD  CONSTRAINT [DF_PurchaseDetail_Price]  DEFAULT ((0)) FOR [UnitPrice]
GO
ALTER TABLE [dbo].[PurchaseDetail] ADD  CONSTRAINT [DF_PurchaseDetail_SubTotal]  DEFAULT ((0)) FOR [SubTotal]
GO
ALTER TABLE [dbo].[PurchaseDetail] ADD  CONSTRAINT [DF_PurchaseDetail_DateCreated]  DEFAULT (getdate()) FOR [DateCreated]
GO
ALTER TABLE [dbo].[PurchaseDetail] ADD  CONSTRAINT [DF_PurchaseDetail_DateLastModify]  DEFAULT (getdate()) FOR [DateLastModify]
GO
ALTER TABLE [dbo].[PurchaseDetail] ADD  CONSTRAINT [DF_PurchaseDetail_RegistryStatus]  DEFAULT ('ACTIVO') FOR [RegistryStatus]
GO
ALTER TABLE [dbo].[Supplier] ADD  CONSTRAINT [DF_Supplier_ID_UUID]  DEFAULT (newid()) FOR [ID_UUID]
GO
ALTER TABLE [dbo].[Supplier] ADD  CONSTRAINT [DF_Supplier_SupplierRTN]  DEFAULT ('') FOR [SupplierRTN]
GO
ALTER TABLE [dbo].[Supplier] ADD  CONSTRAINT [DF_Supplier_Address]  DEFAULT ('') FOR [Address]
GO
ALTER TABLE [dbo].[Supplier] ADD  CONSTRAINT [DF_Supplier_Notes]  DEFAULT ('') FOR [Notes]
GO
ALTER TABLE [dbo].[Supplier] ADD  CONSTRAINT [DF_Supplier_DateCreated]  DEFAULT (getdate()) FOR [DateCreated]
GO
ALTER TABLE [dbo].[Supplier] ADD  CONSTRAINT [DF_Supplier_DateLastModify]  DEFAULT (getdate()) FOR [DateLastModify]
GO
ALTER TABLE [dbo].[Supplier] ADD  CONSTRAINT [DF_Supplier_RegistryStatus]  DEFAULT ('ACTIVO') FOR [RegistryStatus]
GO
ALTER TABLE [dbo].[Parameter]  WITH CHECK ADD  CONSTRAINT [FK_Parameter_ParameterType] FOREIGN KEY([ParametryType_ID_UUID])
REFERENCES [dbo].[ParameterType] ([ID_UUID])
GO
ALTER TABLE [dbo].[Parameter] CHECK CONSTRAINT [FK_Parameter_ParameterType]
GO
ALTER TABLE [dbo].[Purchase]  WITH CHECK ADD  CONSTRAINT [FK_Purchase_Parameter] FOREIGN KEY([ParameterDepartment_ID_UUID])
REFERENCES [dbo].[Parameter] ([ID_UUID])
GO
ALTER TABLE [dbo].[Purchase] CHECK CONSTRAINT [FK_Purchase_Parameter]
GO
ALTER TABLE [dbo].[Purchase]  WITH CHECK ADD  CONSTRAINT [FK_Purchase_Parameter1] FOREIGN KEY([ParameterPaymentMethod_ID_UUID])
REFERENCES [dbo].[Parameter] ([ID_UUID])
GO
ALTER TABLE [dbo].[Purchase] CHECK CONSTRAINT [FK_Purchase_Parameter1]
GO
ALTER TABLE [dbo].[Purchase]  WITH CHECK ADD  CONSTRAINT [FK_Purchase_Supplier] FOREIGN KEY([Supplier_ID_UUID])
REFERENCES [dbo].[Supplier] ([ID_UUID])
GO
ALTER TABLE [dbo].[Purchase] CHECK CONSTRAINT [FK_Purchase_Supplier]
GO
ALTER TABLE [dbo].[PurchaseDetail]  WITH CHECK ADD  CONSTRAINT [FK_PurchaseDetail_Product] FOREIGN KEY([Product_ID_UUID])
REFERENCES [dbo].[Product] ([ID_UUID])
GO
ALTER TABLE [dbo].[PurchaseDetail] CHECK CONSTRAINT [FK_PurchaseDetail_Product]
GO
ALTER TABLE [dbo].[PurchaseDetail]  WITH CHECK ADD  CONSTRAINT [FK_PurchaseDetail_Purchase] FOREIGN KEY([Purchase_ID_UUID])
REFERENCES [dbo].[Purchase] ([ID_UUID])
GO
ALTER TABLE [dbo].[PurchaseDetail] CHECK CONSTRAINT [FK_PurchaseDetail_Purchase]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'unit of measurement' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PurchaseDetail', @level2type=N'COLUMN',@level2name=N'UnitOM'
GO
USE [master]
GO
ALTER DATABASE [SupplyChain] SET  READ_WRITE 
GO
