USE [master]
GO
/****** Object:  Database [Rent_A_Car]    Script Date: 23/06/2016 18:49:54 ******/
CREATE DATABASE [Rent_A_Car]
GO
USE [Rent_A_Car]
GO
/****** Object:  User [s1tpo]    Script Date: 23/06/2016 08:49:34 p.m. ******/
CREATE USER [s1tpo] FOR LOGIN [s1tpo] WITH DEFAULT_SCHEMA=[dbo]
GO
exec sp_addrolemember 'db_datareader', s1tpo
exec sp_addrolemember 'db_datawriter', s1tpo
Go
GRANT EXECUTE TO s1tpo
GO

