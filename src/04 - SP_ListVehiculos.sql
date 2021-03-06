--exec SP_ListVehiculos 'SucLP'

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[SP_ListVehiculos]') and OBJECTPROPERTY(id, N'IsProcedure') = 1)
	drop procedure [dbo].SP_ListVehiculos
GO

CREATE Procedure SP_ListVehiculos
(  
	 @nombreSucursal		varchar(50)	
	,@marca					varchar(15)	= null
	,@modelo				varchar(15)	= null
	,@aireAcondicionado		varchar(1)	= null
	,@tipoCombustible		varchar(10)	= null
	,@transmision			varchar(10)	= null
	,@cantidadPuertas		int			= 0
	,@color					varchar(10)	= null
	,@tamaño				varchar(10)	= null
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
	FROM [dbo].[VEHICULO] v
	inner join Sucursal s on s.idsucursal = v.idsucursal
	where v.[estado] = ''DISPONIBLE'' 
	and s.nombre = @nombreSucursal '

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

	exec sp_executesql @sql, 
						N' @nombreSucursal	varchar(50), @marca	varchar(15), @modelo varchar(15), @aireAcondicionado varchar(1), @tipoCombustible varchar(10), @transmision	varchar(10), @cantidadPuertas int, @color varchar(10), @tamaño varchar(10)',
						@nombreSucursal, @marca, @modelo, @aireAcondicionado, @tipoCombustible, @transmision, @cantidadPuertas, @color, @tamaño
	
GO