USE [master]
GO
/****** Object:  Database [Rent_A_Car]    Script Date: 23/06/2016 18:49:54 ******/
CREATE DATABASE [Rent_A_Car]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Rent_A_Car', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\Rent_A_Car.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Rent_A_Car_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\Rent_A_Car_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Rent_A_Car] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Rent_A_Car].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Rent_A_Car] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Rent_A_Car] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Rent_A_Car] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Rent_A_Car] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Rent_A_Car] SET ARITHABORT OFF 
GO
ALTER DATABASE [Rent_A_Car] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Rent_A_Car] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [Rent_A_Car] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Rent_A_Car] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Rent_A_Car] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Rent_A_Car] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Rent_A_Car] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Rent_A_Car] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Rent_A_Car] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Rent_A_Car] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Rent_A_Car] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Rent_A_Car] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Rent_A_Car] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Rent_A_Car] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Rent_A_Car] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Rent_A_Car] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Rent_A_Car] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Rent_A_Car] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Rent_A_Car] SET RECOVERY FULL 
GO
ALTER DATABASE [Rent_A_Car] SET  MULTI_USER 
GO
ALTER DATABASE [Rent_A_Car] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Rent_A_Car] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Rent_A_Car] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Rent_A_Car] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [Rent_A_Car]
GO
/****** Object:  Table [dbo].[ALQUILER]    Script Date: 23/06/2016 18:49:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ALQUILER](
	[idalquiler] [int] NOT NULL,
	[fechainicio] [date] NULL,
	[fechafin] [date] NULL,
	[estado] [int] NULL,
	[importe] [float] NULL,
	[idsucursaldestino] [int] NULL,
	[punitorio] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[idalquiler] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CLIENTE]    Script Date: 23/06/2016 18:49:54 ******/
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
/****** Object:  Table [dbo].[MANTENIMIENTO]    Script Date: 23/06/2016 18:49:54 ******/
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
/****** Object:  Table [dbo].[MOVIMIENTO]    Script Date: 23/06/2016 18:49:54 ******/
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
/****** Object:  Table [dbo].[PRESUPUESTO]    Script Date: 23/06/2016 18:49:54 ******/
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
/****** Object:  Table [dbo].[SUCURSAL]    Script Date: 23/06/2016 18:49:54 ******/
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
/****** Object:  Table [dbo].[VEHICULO]    Script Date: 23/06/2016 18:49:54 ******/
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
USE [master]
GO
ALTER DATABASE [Rent_A_Car] SET  READ_WRITE 
GO
