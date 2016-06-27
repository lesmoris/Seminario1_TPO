USE [master]
GO
/****** Object:  Database [Rent_A_Car]    Script Date: 23/06/2016 18:49:54 ******/
CREATE DATABASE [Rent_A_Car]
GO

/****** Object:  Login [s1tpo]    Script Date: 27/06/2016 08:51:49 a.m. ******/
CREATE LOGIN [s1tpo] WITH PASSWORD=N's1tpo12', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO

USE [Rent_A_Car]
GO
/****** Object:  User [s1tpo]    Script Date: 23/06/2016 08:49:34 p.m. ******/
CREATE USER [s1tpo] FOR LOGIN [s1tpo] WITH DEFAULT_SCHEMA=[dbo]
GO


/****** Object:  Table [dbo].[ALQUILER]    Script Date: 27/06/2016 08:53:20 a.m. ******/
CREATE TABLE [dbo].[ALQUILER](
	[idalquiler] [int] NOT NULL,
	[fechainicio] [date] NULL,
	[fechafin] [date] NULL,
	[estado] [int] NULL,
	[importe] [float] NULL,
	[idsucursaldestino] [int] NULL,
	[punitorio] [float] NULL,
	[idPresupuesto] [int] NOT NULL,
	[fechaemision] [datetime] NOT NULL,
 CONSTRAINT [PK__ALQUILER__3AFF8BE1C2E14901] PRIMARY KEY CLUSTERED 
(
	[idalquiler] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[ALQUILER] ADD  CONSTRAINT [DF_ALQUILER_fechaemision]  DEFAULT (getdate()) FOR [fechaemision]
GO
/****** Object:  Table [dbo].[CLIENTE]    Script Date: 23/06/2016 08:42:32 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CLIENTE](
	[idcliente] [int] NOT NULL,
	[dni] [varchar](8) NULL,
	[tipodni] [varchar](10) NULL,
	[nombre] [varchar](15) NULL,
	[telefono] [varchar](15) NULL,
	[mail] [varchar](20) NULL,
	[direccion] [varchar](30) NULL,
	[estado] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idcliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[MANTENIMIENTO]    Script Date: 23/06/2016 08:42:32 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MANTENIMIENTO](
	[idmantenimiento] [int] NOT NULL,
	[fechaInicio] [date] NULL,
	[idvehiculo] [int] NULL,
	[fechaFin] [date] NULL,
	[problema] [varchar](50) NULL,
	[solucion] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[idmantenimiento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[MOVIMIENTO]    Script Date: 23/06/2016 08:42:32 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MOVIMIENTO](
	[idmovimiento] [int] NOT NULL,
	[fechaInicio] [date] NULL,
	[fechaFin] [date] NULL,
	[idvehiculo] [int] NULL,
	[idsucursalOrigen] [int] NULL,
	[idsucursalDestino] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idmovimiento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PRESUPUESTO]    Script Date: 23/06/2016 08:42:32 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PRESUPUESTO](
	[fecha] [date] NULL,
	[fechaInicio] [date] NULL,
	[fechaFin] [date] NULL,
	[importe] [float] NULL,
	[idcliente] [int] NULL,
	[idsucursalorigen] [int] NULL,
	[idsucursaldestino] [int] NULL,
	[idvehiculo] [int] NULL,
	[idpresupuesto] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idpresupuesto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SUCURSAL]    Script Date: 23/06/2016 08:42:32 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SUCURSAL](
	[idsucursal] [int] NOT NULL,
	[nombre] [varchar](10) NULL,
	[direccion] [varchar](25) NULL,
	[telefono] [varchar](12) NULL,
	[mail] [varchar](15) NULL,
PRIMARY KEY CLUSTERED 
(
	[idsucursal] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[VEHICULO]    Script Date: 23/06/2016 08:42:32 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[VEHICULO](
	[idvehiculo] [int] NOT NULL,
	[dominio] [varchar](7) NULL,
	[marca] [varchar](15) NULL,
	[modelo] [varchar](15) NULL,
	[aireAcondicionado] [varchar](1) NULL,
	[tipoCombustible] [varchar](10) NULL,
	[precioPorDia] [float] NULL,
	[transmision] [varchar](10) NULL,
	[cantidadPuertas] [int] NULL,
	[kilometraje] [int] NULL,
	[idsucursal] [int] NULL,
	[color] [varchar](10) NULL,
	[tamaño] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[idvehiculo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[ALQUILER]  WITH CHECK ADD  CONSTRAINT [FK_ALQUILER_PRESUPUESTO] FOREIGN KEY([idPresupuesto])
REFERENCES [dbo].[PRESUPUESTO] ([idpresupuesto])
GO
ALTER TABLE [dbo].[ALQUILER] CHECK CONSTRAINT [FK_ALQUILER_PRESUPUESTO]
GO
ALTER TABLE [dbo].[ALQUILER]  WITH CHECK ADD  CONSTRAINT [fk_sucursalDestino_alquiler] FOREIGN KEY([idsucursaldestino])
REFERENCES [dbo].[SUCURSAL] ([idsucursal])
GO
ALTER TABLE [dbo].[ALQUILER] CHECK CONSTRAINT [fk_sucursalDestino_alquiler]
GO
ALTER TABLE [dbo].[MANTENIMIENTO]  WITH CHECK ADD  CONSTRAINT [fk_vehiculo_mantenimiento] FOREIGN KEY([idvehiculo])
REFERENCES [dbo].[VEHICULO] ([idvehiculo])
GO
ALTER TABLE [dbo].[MANTENIMIENTO] CHECK CONSTRAINT [fk_vehiculo_mantenimiento]
GO
ALTER TABLE [dbo].[MOVIMIENTO]  WITH CHECK ADD  CONSTRAINT [fk_sucursalDestino_mov] FOREIGN KEY([idsucursalDestino])
REFERENCES [dbo].[SUCURSAL] ([idsucursal])
GO
ALTER TABLE [dbo].[MOVIMIENTO] CHECK CONSTRAINT [fk_sucursalDestino_mov]
GO
ALTER TABLE [dbo].[MOVIMIENTO]  WITH CHECK ADD  CONSTRAINT [fk_sucursalOrigen_mov] FOREIGN KEY([idsucursalOrigen])
REFERENCES [dbo].[SUCURSAL] ([idsucursal])
GO
ALTER TABLE [dbo].[MOVIMIENTO] CHECK CONSTRAINT [fk_sucursalOrigen_mov]
GO
ALTER TABLE [dbo].[MOVIMIENTO]  WITH CHECK ADD  CONSTRAINT [fk_vehiculo_mov] FOREIGN KEY([idvehiculo])
REFERENCES [dbo].[VEHICULO] ([idvehiculo])
GO
ALTER TABLE [dbo].[MOVIMIENTO] CHECK CONSTRAINT [fk_vehiculo_mov]
GO
ALTER TABLE [dbo].[PRESUPUESTO]  WITH CHECK ADD  CONSTRAINT [fk_cliente_pres] FOREIGN KEY([idcliente])
REFERENCES [dbo].[CLIENTE] ([idcliente])
GO
ALTER TABLE [dbo].[PRESUPUESTO] CHECK CONSTRAINT [fk_cliente_pres]
GO
ALTER TABLE [dbo].[PRESUPUESTO]  WITH CHECK ADD  CONSTRAINT [fk_sucursalDestino_pres] FOREIGN KEY([idsucursaldestino])
REFERENCES [dbo].[SUCURSAL] ([idsucursal])
GO
ALTER TABLE [dbo].[PRESUPUESTO] CHECK CONSTRAINT [fk_sucursalDestino_pres]
GO
ALTER TABLE [dbo].[PRESUPUESTO]  WITH CHECK ADD  CONSTRAINT [fk_sucursalOrigen_pres] FOREIGN KEY([idsucursalorigen])
REFERENCES [dbo].[SUCURSAL] ([idsucursal])
GO
ALTER TABLE [dbo].[PRESUPUESTO] CHECK CONSTRAINT [fk_sucursalOrigen_pres]
GO
ALTER TABLE [dbo].[PRESUPUESTO]  WITH CHECK ADD  CONSTRAINT [fk_vehiculo_pres] FOREIGN KEY([idvehiculo])
REFERENCES [dbo].[VEHICULO] ([idvehiculo])
GO
ALTER TABLE [dbo].[PRESUPUESTO] CHECK CONSTRAINT [fk_vehiculo_pres]
GO
ALTER TABLE [dbo].[VEHICULO]  WITH CHECK ADD  CONSTRAINT [fk_sucursal_vehiculo] FOREIGN KEY([idsucursal])
REFERENCES [dbo].[SUCURSAL] ([idsucursal])
GO
ALTER TABLE [dbo].[VEHICULO] CHECK CONSTRAINT [fk_sucursal_vehiculo]
GO
