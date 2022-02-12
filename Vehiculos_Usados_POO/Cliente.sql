-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 01-12-2021 a las 14:56:04
-- Versión del servidor: 8.0.13-4
-- Versión de PHP: 7.2.24-0ubuntu0.18.04.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `OjobZcLXLL`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Cliente`
--

CREATE TABLE `Cliente` (
  `Identidad` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Nombre` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Genero` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Edad` int(11) DEFAULT NULL,
  `Celular` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Salario` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `Cliente`
--

INSERT INTO `Cliente` (`Identidad`, `Nombre`, `Genero`, `Edad`, `Celular`, `Salario`) VALUES
('0801-1994-00415', 'Doris Gutierrez', 'F', 27, '+504-7214-2833', 15000),
('0801-1994-00415', 'Doris Gutierrez', 'F', 27, '+504-7214-2833', 15000);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
