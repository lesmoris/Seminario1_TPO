USE [Rent_A_Car]
GO
/*
-- Por si es necesario borrar algun contenido de tabla

delete from MOVIMIENTO
delete from MANTENIMIENTO
delete from VEHICULO
delete from SUCURSAL
delete from CLIENTE
*/
USE [Rent_A_Car]
GO
SET IDENTITY_INSERT [dbo].[CLIENTE] ON 

GO
INSERT [dbo].[CLIENTE] ([idcliente], [dni], [tipodni], [nombre], [telefono], [mail], [direccion], [estado]) VALUES (1, N'28749650', N'DNI', N'Leonardo', N'1234567', N'leo@leo.com', N'Siempreviva 1234', N'ACTIVO')
GO
INSERT [dbo].[CLIENTE] ([idcliente], [dni], [tipodni], [nombre], [telefono], [mail], [direccion], [estado]) VALUES (2, N'43241234', N'DNI', N'Pablo', N'12354345', N'pablo@pablo.com', N'123asd', N'ACTIVO')
GO
INSERT [dbo].[CLIENTE] ([idcliente], [dni], [tipodni], [nombre], [telefono], [mail], [direccion], [estado]) VALUES (3, N'14432424', N'DNI', N'Hugo', N'5433214', N'hugo@hugo.com', N'tfsf123', N'ACTIVO')
GO
INSERT [dbo].[CLIENTE] ([idcliente], [dni], [tipodni], [nombre], [telefono], [mail], [direccion], [estado]) VALUES (4, N'53244324', N'DNI', N'Camila', N'44324324', N'cami@cami.com', N'fdsgregre123', N'ACTIVO')
GO
INSERT [dbo].[CLIENTE] ([idcliente], [dni], [tipodni], [nombre], [telefono], [mail], [direccion], [estado]) VALUES (5, N'454342141', N'CUIL', N'Paty SA', N'12312321', N'paty@qf.com', N'dsafsf12321', N'ACTIVO')
GO
SET IDENTITY_INSERT [dbo].[CLIENTE] OFF
GO
SET IDENTITY_INSERT [dbo].[SUCURSAL] ON 

GO
INSERT [dbo].[SUCURSAL] ([idsucursal], [nombre], [direccion], [telefono], [mail]) VALUES (1, N'SucMDQ', N'asd123', N'123125435', N'sucmdq@rac.com')
GO
INSERT [dbo].[SUCURSAL] ([idsucursal], [nombre], [direccion], [telefono], [mail]) VALUES (2, N'SucLP', N'asd543', N'123543543', N'suclp@rac.com.ar')
GO
INSERT [dbo].[SUCURSAL] ([idsucursal], [nombre], [direccion], [telefono], [mail]) VALUES (3, N'SucCABA', N'fsdf123', N'645523432', N'succaba@rac.com.ar')
GO
SET IDENTITY_INSERT [dbo].[SUCURSAL] OFF
GO
SET IDENTITY_INSERT [dbo].[VEHICULO] ON 

GO
INSERT [dbo].[VEHICULO] ([idvehiculo], [dominio], [marca], [modelo], [aireAcondicionado], [tipoCombustible], [precioPorDia], [transmision], [cantidadPuertas], [kilometraje], [idsucursal], [color], [tamaño], [estado]) VALUES (1, N'AMD123', N'Fiat', N'Palio', N'S', N'GNC', 900, N'MANUAL', 4, 21000, 1, N'Rojo', N'MEDIANO', N'DISPONIBLE')
GO
INSERT [dbo].[VEHICULO] ([idvehiculo], [dominio], [marca], [modelo], [aireAcondicionado], [tipoCombustible], [precioPorDia], [transmision], [cantidadPuertas], [kilometraje], [idsucursal], [color], [tamaño], [estado]) VALUES (2, N'VBH567', N'Ford', N'Ka', N'N', N'NAFTA', 700, N'MANUAL', 3, 70000, 2, N'Gris', N'CHICO', N'DISPONIBLE')
GO
INSERT [dbo].[VEHICULO] ([idvehiculo], [dominio], [marca], [modelo], [aireAcondicionado], [tipoCombustible], [precioPorDia], [transmision], [cantidadPuertas], [kilometraje], [idsucursal], [color], [tamaño], [estado]) VALUES (3, N'QWE456', N'Peugeot', N'206', N'N', N'NAFTA', 800, N'MANUAL', 3, 30000, 3, N'Blanco', N'MEDIANO', N'DISPONIBLE')
GO
INSERT [dbo].[VEHICULO] ([idvehiculo], [dominio], [marca], [modelo], [aireAcondicionado], [tipoCombustible], [precioPorDia], [transmision], [cantidadPuertas], [kilometraje], [idsucursal], [color], [tamaño], [estado]) VALUES (4, N'JKL890', N'Renault', N'Clio', N'N', N'GASOIL', 500, N'AUTOMATICO', 1, 30000, 1, N'Bordo', N'MEDIANO', N'DISPONIBLE')
GO
INSERT [dbo].[VEHICULO] ([idvehiculo], [dominio], [marca], [modelo], [aireAcondicionado], [tipoCombustible], [precioPorDia], [transmision], [cantidadPuertas], [kilometraje], [idsucursal], [color], [tamaño], [estado]) VALUES (5, N'CGL567', N'Ford', N'F100', N'N', N'GASOIL', 1500, N'MANUAL', 2, 100000, 3, N'Gris', N'GRANDE', N'DISPONIBLE')
GO
SET IDENTITY_INSERT [dbo].[VEHICULO] OFF
GO
SET IDENTITY_INSERT [dbo].[PRESUPUESTO] ON 

GO
INSERT [dbo].[PRESUPUESTO] ([idpresupuesto], [fechaemision], [fechaInicio], [fechaFin], [importe], [idcliente], [idsucursalorigen], [idsucursaldestino], [idvehiculo], [fechaVencimiento]) VALUES (1, CAST(N'2016-07-01' AS Date), CAST(N'2016-07-10' AS Date), CAST(N'2016-07-20' AS Date), 5000, 1, 1, 2, 1, CAST(N'2016-08-01' AS Date))
GO
INSERT [dbo].[PRESUPUESTO] ([idpresupuesto], [fechaemision], [fechaInicio], [fechaFin], [importe], [idcliente], [idsucursalorigen], [idsucursaldestino], [idvehiculo], [fechaVencimiento]) VALUES (2, CAST(N'2016-07-02' AS Date), CAST(N'2016-08-01' AS Date), CAST(N'2016-08-10' AS Date), 9000, 2, 2, 3, 4, CAST(N'2016-08-02' AS Date))
GO
SET IDENTITY_INSERT [dbo].[PRESUPUESTO] OFF
GO
SET IDENTITY_INSERT [dbo].[ALQUILER] ON 

GO
INSERT [dbo].[ALQUILER] ([idPresupuesto], [idalquiler], [fechainicio], [fechafin], [importe], [idsucursaldestino], [punitorio], [fechaemision]) VALUES (1, 1, CAST(N'2016-07-10' AS Date), CAST(N'2016-07-20' AS Date), 5000, 2, 0, CAST(N'2016-07-01 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[ALQUILER] ([idPresupuesto], [idalquiler], [fechainicio], [fechafin], [importe], [idsucursaldestino], [punitorio], [fechaemision]) VALUES (2, 2, CAST(N'2016-08-01' AS Date), CAST(N'2016-08-20' AS Date), 9000, 3, 1000, CAST(N'2016-07-02 00:00:00.000' AS DateTime))
GO
SET IDENTITY_INSERT [dbo].[ALQUILER] OFF
GO
