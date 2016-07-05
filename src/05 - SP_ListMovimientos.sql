--exec SP_ListMovimientos 

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[SP_ListMovimientos]') and OBJECTPROPERTY(id, N'IsProcedure') = 1)
	drop procedure [dbo].SP_ListMovimientos
GO

CREATE Procedure SP_ListMovimientos
(  
	  @fechaInicioDesde		datetime	= null
	 ,@fechaInicioHasta		datetime	= null
	 ,@fechaFinDesde		datetime	= null
	 ,@fechaFinHasta		datetime	= null
	 ,@sucursalOrigen		varchar(50)	= null
	 ,@sucursalDestino		varchar(50) = null
)
AS

	declare @sql	nvarchar(max)

	select @sql	= 
	N'SELECT 
	   [idmovimiento]
      ,[fechaInicio]
      ,[fechaFin]
      ,m.[idvehiculo]
      ,[idsucursalOrigen]
      ,[idsucursalDestino]
	FROM movimiento m
	inner join vehiculo v on v.idVehiculo = m.idVehiculo
	inner join sucursal s_origen on s_origen.idsucursal = m.idsucursalOrigen 
	inner join sucursal s_destino on s_destino.idsucursal = m.idsucursalDestino 
	where 1 = 1 '

	if (@fechaInicioDesde is not null)
		select @sql	= @sql + ' and m.fechaInicio >= @fechaInicioDesde '

	if (@fechaInicioHasta is not null)
		select @sql	= @sql + ' and m.fechaInicio <= @fechaInicioHasta '
	
	if (@fechaFinDesde is not null)
		select @sql	= @sql + ' and v.fechaFin >= @fechaFinDesde '
	
	if (@fechaFinHasta is not null)
		select @sql	= @sql + ' and v.fechaFin <= @fechaFinHasta '
	
	if (@sucursalOrigen is not null)
		select @sql	= @sql + ' and s_origen.nombre = @sucursalOrigen '
	
	if (@sucursalDestino is not null)
		select @sql	= @sql + ' and s_destino.nombre = @sucursalDestino '
	
	exec sp_executesql @sql, 
						N'  @fechaInicioDesde datetime, @fechaInicioHasta datetime, @fechaFinDesde datetime, @fechaFinHasta datetime, @sucursalOrigen varchar(50), @sucursalDestino	varchar(50)',
						@fechaInicioDesde, @fechaInicioHasta, @fechaFinDesde, @fechaFinHasta, @sucursalOrigen, @sucursalDestino
	
GO