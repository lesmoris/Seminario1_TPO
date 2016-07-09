--exec SP_ListAlquileres 

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[SP_ListAlquileres]') and OBJECTPROPERTY(id, N'IsProcedure') = 1)
	drop procedure [dbo].SP_ListAlquileres
GO

CREATE Procedure SP_ListAlquileres
(  
	  @fechaInicioDesde		datetime	= null
	 ,@fechaInicioHasta		datetime	= null
	 ,@fechaFinDesde		datetime	= null
	 ,@fechaFinHasta		datetime	= null
	
	 ,@sucursalOrigen		varchar(50)	= null
	 ,@sucursalDestino		varchar(50) = null

	 ,@tipoDoc				varchar(10)	= null
	 ,@nroDoc				varchar(20) = null

	 ,@marca				varchar(15) = null
	 ,@modelo				varchar(10) = null
	 ,@ac					varchar(1)  = null
	 ,@tipoCombustible		varchar(10) = null
	 ,@transmision			varchar(10) = null
	 ,@cantPuertas			int			= null
	 ,@color				varchar(10) = null
	 ,@tamanio				varchar(10) = null
)
AS

	declare @sql	nvarchar(max)

	select @sql	= 
	N'SELECT 
	   a.[idAlquiler]
      ,a.[fechainicio]
      ,a.[fechaFin]
      ,a.[importe]
      ,a.[punitorio]
      ,a.[fechaemision]
	  ,a.[idSucursalDestino]
	  ,p.idpresupuesto
	FROM alquiler a
	inner join presupuesto p on a.idPresupuesto = p.idPresupuesto
	inner join vehiculo v on v.idVehiculo = p.idVehiculo
	inner join cliente c on c.idCliente = p.idCliente
	inner join sucursal s_origen on s_origen.idsucursal = p.idsucursalOrigen 
	inner join sucursal s_destino on s_destino.idsucursal = a.idsucursalDestino 
	where 1 = 1 '

	if (@fechaInicioDesde is not null)
		select @sql	= @sql + ' and a.fechaInicio >= @fechaInicioDesde '

	if (@fechaInicioHasta is not null)
		select @sql	= @sql + ' and a.fechaInicio <= @fechaInicioHasta '
	
	if (@fechaFinDesde is not null)
		select @sql	= @sql + ' and v.fechaFin >= @fechaFinDesde '
	
	if (@fechaFinHasta is not null)
		select @sql	= @sql + ' and v.fechaFin <= @fechaFinHasta '
	
	if (@sucursalOrigen is not null)
		select @sql	= @sql + ' and s_origen.nombre = @sucursalOrigen '
	
	if (@sucursalDestino is not null)
		select @sql	= @sql + ' and s_destino.nombre = @sucursalDestino '

	if (@tipoDoc is not null)
		select @sql	= @sql + ' and c.tipodni = @tipoDoc '

	if (@nroDoc is not null)
		select @sql	= @sql + ' and c.dni = @nroDoc '

	if (@marca is not null)
		select @sql	= @sql + ' and v.marca = @marca '

	if (@modelo is not null)
		select @sql	= @sql + ' and v.modelo = @modelo '
	
	if (@ac is not null)
		select @sql	= @sql + ' and v.aireAcondicionado = @ac '
	
	if (@tipoCombustible is not null)
		select @sql	= @sql + ' and v.tipoCombustible = @tipoCombustible '
	
	if (@transmision is not null)
		select @sql	= @sql + ' and v.transmision = @transmision '
	
	if (@cantPuertas > 0)
		select @sql	= @sql + ' and v.cantidadPuertas = @cantidadPuertas '
	
	if (@color is not null)
		select @sql	= @sql + ' and v.color = @color '
	
	if (@tamanio is not null)
		select @sql	= @sql + ' and v.tamaño = @tamanio '
	
	exec sp_executesql @sql, 
						N'  @fechaInicioDesde datetime, @fechaInicioHasta datetime, @fechaFinDesde datetime, @fechaFinHasta datetime, @sucursalOrigen varchar(50), @sucursalDestino	varchar(50), @tipoDoc varchar(10), @nroDoc varchar(20), @marca varchar(15), @modelo varchar(15), @ac varchar(1), @tipoCombustible varchar(10), @transmision varchar(10), @cantPuertas int, @color varchar(10), @tamaño varchar(10)',
						@fechaInicioDesde, @fechaInicioHasta, @fechaFinDesde, @fechaFinHasta, @sucursalOrigen, @sucursalDestino, @tipoDoc, @nroDoc, @marca, @modelo, @ac, @tipoCombustible, @transmision, @cantPuertas, @color, @tamanio
	
GO