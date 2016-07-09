USE [Rent_A_Car]
GO
/****** Object:  Table [dbo].[ALQUILER]    Script Date: 07/07/2016 08:24:52 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ALQUILER](
	[idalquiler] [int] IDENTITY(1,1) NOT NULL,
	[idPresupuesto] [int] NOT NULL,
	[fechainicio] [date] NOT NULL,
	[fechafin] [date] NULL,
	[importe] [float] NULL,
	[idsucursaldestino] [int] NULL,
	[punitorio] [float] NULL,
	[fechaemision] [datetime] NOT NULL CONSTRAINT [DF_ALQUILER_fechaemision]  DEFAULT (getdate()),
 CONSTRAINT [PK__ALQUILER__3AFF8BE1C2E14901] PRIMARY KEY CLUSTERED 
(
	[idalquiler] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CLIENTE]    Script Date: 07/07/2016 08:24:52 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CLIENTE](
	[idcliente] [int] IDENTITY(1,1) NOT NULL,
	[dni] [varchar](20) NOT NULL,
	[tipodni] [varchar](10) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[telefono] [varchar](50) NOT NULL,
	[mail] [varchar](50) NOT NULL,
	[direccion] [varchar](50) NOT NULL,
	[estado] [varchar](20) NOT NULL,
 CONSTRAINT [PK__CLIENTE__7B86132F4D4DD73B] PRIMARY KEY CLUSTERED 
(
	[idcliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[MANTENIMIENTO]    Script Date: 07/07/2016 08:24:52 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MANTENIMIENTO](
	[idmantenimiento] [int] IDENTITY(1,1) NOT NULL,
	[fechaInicio] [date] NOT NULL,
	[idvehiculo] [int] NOT NULL,
	[fechaFin] [date] NULL,
	[problema] [varchar](250) NOT NULL,
	[solucion] [varchar](250) NULL,
	[idsucursal] [int] NOT NULL,
 CONSTRAINT [PK__MANTENIM__1090A6709DFF4ED9] PRIMARY KEY CLUSTERED 
(
	[idmantenimiento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[MOVIMIENTO]    Script Date: 07/07/2016 08:24:52 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MOVIMIENTO](
	[idmovimiento] [int] IDENTITY(1,1) NOT NULL,
	[fechaInicio] [date] NOT NULL,
	[fechaFin] [date] NULL,
	[idvehiculo] [int] NOT NULL,
	[idsucursalOrigen] [int] NOT NULL,
	[idsucursalDestino] [int] NOT NULL,
 CONSTRAINT [PK__MOVIMIEN__0D0F0A7C4BDF3B43] PRIMARY KEY CLUSTERED 
(
	[idmovimiento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PRESUPUESTO]    Script Date: 07/07/2016 08:24:52 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PRESUPUESTO](
	[idpresupuesto] [int] IDENTITY(1,1) NOT NULL,
	[fechaemision] [date] NOT NULL CONSTRAINT [DF_PRESUPUESTO_fechaemision]  DEFAULT (getdate()),
	[fechaInicio] [date] NOT NULL,
	[fechaFin] [date] NOT NULL,
	[importe] [float] NOT NULL,
	[idcliente] [int] NOT NULL,
	[idsucursalorigen] [int] NULL,
	[idsucursaldestino] [int] NOT NULL,
	[idvehiculo] [int] NOT NULL,
	[fechaVencimiento] [date] NOT NULL  CONSTRAINT [DF_PRESUPUESTO_fechaemision]  DEFAULT (DATEADD(dd, 30, getdate())),
 CONSTRAINT [PK__PRESUPUE__ABD6637A0AB51094] PRIMARY KEY CLUSTERED 
(
	[idpresupuesto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SUCURSAL]    Script Date: 07/07/2016 08:24:52 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SUCURSAL](
	[idsucursal] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[direccion] [varchar](50) NOT NULL,
	[telefono] [varchar](20) NOT NULL,
	[mail] [varchar](50) NOT NULL,
 CONSTRAINT [PK__SUCURSAL__0C87B3419C5B8895] PRIMARY KEY CLUSTERED 
(
	[idsucursal] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[nombre] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[VEHICULO]    Script Date: 07/07/2016 08:24:52 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[VEHICULO](
	[idvehiculo] [int] IDENTITY(1,1) NOT NULL,
	[dominio] [varchar](7) NOT NULL,
	[marca] [varchar](15) NOT NULL,
	[modelo] [varchar](15) NOT NULL,
	[aireAcondicionado] [varchar](1) NOT NULL,
	[tipoCombustible] [varchar](10) NOT NULL,
	[precioPorDia] [float] NOT NULL,
	[transmision] [varchar](10) NOT NULL,
	[cantidadPuertas] [int] NOT NULL,
	[kilometraje] [int] NOT NULL,
	[idsucursal] [int] NOT NULL,
	[color] [varchar](10) NOT NULL,
	[tamaño] [varchar](10) NOT NULL,
	[estado] [varchar](20) NOT NULL,
 CONSTRAINT [PK__VEHICULO__8E1E9617DE856741] PRIMARY KEY CLUSTERED 
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
ALTER TABLE [dbo].[MANTENIMIENTO]  WITH CHECK ADD  CONSTRAINT [FK_MANTENIMIENTO_SUCURSAL] FOREIGN KEY([idsucursal])
REFERENCES [dbo].[SUCURSAL] ([idsucursal])
GO
ALTER TABLE [dbo].[MANTENIMIENTO] CHECK CONSTRAINT [FK_MANTENIMIENTO_SUCURSAL]
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
ALTER TABLE [dbo].[SUCURSAL]  WITH CHECK ADD  CONSTRAINT [FK_SUCURSAL_SUCURSAL] FOREIGN KEY([idsucursal])
REFERENCES [dbo].[SUCURSAL] ([idsucursal])
GO
ALTER TABLE [dbo].[SUCURSAL] CHECK CONSTRAINT [FK_SUCURSAL_SUCURSAL]
GO
ALTER TABLE [dbo].[VEHICULO]  WITH CHECK ADD  CONSTRAINT [fk_sucursal_vehiculo] FOREIGN KEY([idsucursal])
REFERENCES [dbo].[SUCURSAL] ([idsucursal])
GO
ALTER TABLE [dbo].[VEHICULO] CHECK CONSTRAINT [fk_sucursal_vehiculo]
GO
ALTER TABLE [dbo].[CLIENTE]  WITH CHECK ADD CHECK  ((upper([estado])='ACTIVO' OR upper([estado])='NOACTIVO'))
GO
ALTER TABLE [dbo].[CLIENTE]  WITH CHECK ADD CHECK  (([tipodni]='DNI' OR [tipodni]='CUIL' OR [tipodni]='CUIT'))
GO
ALTER TABLE [dbo].[VEHICULO]  WITH CHECK ADD CHECK  ((upper([aireAcondicionado])='S' OR upper([aireAcondicionado])='N'))
GO
ALTER TABLE [dbo].[VEHICULO]  WITH CHECK ADD CHECK  (([cantidadPuertas]<(5)))
GO
ALTER TABLE [dbo].[VEHICULO]  WITH CHECK ADD CHECK  ((upper([estado])='DISPONIBLE' OR upper([estado])='ENMOVIMIENTO' OR upper([estado])='ENMANTENIMIENTO' OR upper([estado])='ENALQUILER'))
GO
ALTER TABLE [dbo].[VEHICULO]  WITH CHECK ADD CHECK  ((upper([tamaño])='CHICO' OR upper([tamaño])='MEDIANO' OR upper([tamaño])='GRANDE'))
GO
ALTER TABLE [dbo].[VEHICULO]  WITH CHECK ADD CHECK  ((upper([tipoCombustible])='NAFTA' OR upper([tipoCombustible])='GASOIL' OR upper([tipoCombustible])='GNC'))
GO
ALTER TABLE [dbo].[VEHICULO]  WITH CHECK ADD CHECK  ((upper([transmision])='MANUAL' OR upper([transmision])='AUTOMATICO'))
GO
