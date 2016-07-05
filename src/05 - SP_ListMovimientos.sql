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
	N'select 
		 [idVehiculo]
	    ,v.[idSucursal]
 		,[dominio]
		,[marca]
		,[modelo]
		,[aireAcondicionado]
		,[tipoCombustible]
		,[precioPorDia]
		,[transmision]
		,[cantidadPuertas]
		,[kilometraje]
		,[color]
		,[tamaño]
		,[estado]
	FROM movimientos m
	inner join vehiculo v on v.idVehiculo = m.idVehiculo
	inner join Sucursal s on s.idsucursal = v.idsucursal 
	where 1 = 1 '

	if (@marca is not null)
		select @sql	= @sql + ' and v.marca = @marca '

	if (@modelo is not null)
		select @sql	= @sql + ' and v.modelo = @modelo '
	
	if (@aireAcondicionado is not null)
		select @sql	= @sql + ' and v.aireAcondicionado = @aireAcondicionado '
	
	if (@tipoCombustible is not null)
		select @sql	= @sql + ' and v.tipoCombustible = @tipoCombustible '
	
	if (@transmision is not null)
		select @sql	= @sql + ' and v.transmision = @transmision '
	
	if (@cantidadPuertas > 0)
		select @sql	= @sql + ' and v.cantidadPuertas = @cantidadPuertas '
	
	if (@color is not null)
		select @sql	= @sql + ' and v.color = @color '
	
	if (@tamaño is not null)
		select @sql	= @sql + ' and v.tamaño = @tamaño '

	print @sql

	exec sp_executesql @sql, 
						N' @nombreSucursal	varchar(50), @marca	varchar(15), @modelo varchar(15), @aireAcondicionado varchar(1), @tipoCombustible varchar(10), @transmision	varchar(10), @cantidadPuertas int, @color varchar(10), @tamaño varchar(10)',
						@nombreSucursal, @marca, @modelo, @aireAcondicionado, @tipoCombustible, @transmision, @cantidadPuertas, @color, @tamaño
	
GO