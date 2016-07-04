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
INSERT [dbo].[VEHICULO] ([idvehiculo], [dominio], [marca], [modelo], [aireAcondicionado], [tipoCombustible], [precioPorDia], [transmision], [cantidadPuertas], [kilometraje], [idsucursal], [color], [tamaño], [estado]) VALUES (6, N'AMD123', N'Fiat', N'Palio', N'S', N'GNC', 900, N'MANUAL', 4, 21000, 1, N'Rojo', N'MEDIANO', N'DISPONIBLE')
GO
INSERT [dbo].[VEHICULO] ([idvehiculo], [dominio], [marca], [modelo], [aireAcondicionado], [tipoCombustible], [precioPorDia], [transmision], [cantidadPuertas], [kilometraje], [idsucursal], [color], [tamaño], [estado]) VALUES (11, N'VBH567', N'Ford', N'Ka', N'N', N'NAFTA', 700, N'MANUAL', 3, 70000, 2, N'Gris', N'CHICO', N'DISPONIBLE')
GO
SET IDENTITY_INSERT [dbo].[VEHICULO] OFF
GO
