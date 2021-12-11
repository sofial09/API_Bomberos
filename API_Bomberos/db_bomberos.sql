-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 11-12-2021 a las 01:17:59
-- Versión del servidor: 10.5.12-MariaDB
-- Versión de PHP: 7.3.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `id18023924_db_bomberos`
--
CREATE DATABASE IF NOT EXISTS `id18023924_db_bomberos` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `id18023924_db_bomberos`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contactos`
--

DROP TABLE IF EXISTS `contactos`;
CREATE TABLE `contactos` (
  `id_contacto` int(11) NOT NULL,
  `entidad` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `direccion` text COLLATE utf8_unicode_ci NOT NULL,
  `telefono` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `correo` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `contactos`
--

INSERT INTO `contactos` (`id_contacto`, `entidad`, `direccion`, `telefono`, `correo`) VALUES
(1, 'Bomberos', 'Blvr. del Ejercito Nacional, Ilopango', '2295 0310', 'No poseen');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incidentes`
--

DROP TABLE IF EXISTS `incidentes`;
CREATE TABLE `incidentes` (
  `id_incidente` int(11) NOT NULL,
  `tipo` int(11) NOT NULL,
  `descripcion` text COLLATE utf8_unicode_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `gravedad` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `fecha_hora` datetime NOT NULL,
  `personas_lesionadas` int(11) DEFAULT NULL,
  `costo_danios` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `incidentes`
--

INSERT INTO `incidentes` (`id_incidente`, `tipo`, `descripcion`, `direccion`, `gravedad`, `fecha_hora`, `personas_lesionadas`, `costo_danios`) VALUES
(1, 2, 'Lluvia', 'Jardines Soyapango', 'Poca inundación', '2021-12-08 17:31:41', 0, '0'),
(2, 1, 'Incendio', 'Mercado ExCuartel', 'Perdida Material', '2021-12-05 12:31:41', 5, '1.000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_incidentes`
--

DROP TABLE IF EXISTS `tipo_incidentes`;
CREATE TABLE `tipo_incidentes` (
  `id_tipo` int(11) NOT NULL,
  `tipo_incidente` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tipo_incidentes`
--

INSERT INTO `tipo_incidentes` (`id_tipo`, `tipo_incidente`) VALUES
(1, 'Grave'),
(2, 'Leve');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `correo` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `clave` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `telefono` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `tipo` varchar(10) COLLATE utf8_unicode_ci NOT NULL DEFAULT '2'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`, `correo`, `clave`, `telefono`, `tipo`) VALUES
(1, 'angel', 'alopez', '123456', '7777-7777', '1'),
(2, 'tamara', 'tamara@tamara.com', '1234', '8888-8888', '1'),
(3, 'alvaro', 'alvaro@alvaro.com', '1234', '9999-9999', '1'),
(4, 'Ronald', 'ronald@ronald.com', '1234', '754545555', '1'),
(5, 'Prueba503', 'prueba503@gmail.com', '123456', '754545555', '2'),
(6, 'Prueba503', 'prueba503@gmail.com', '123456', '754545555', '2'),
(7, 'Prueba503', 'prueba503@gmail.com', '123456', '754545555', '2'),
(8, 'Prueba503', 'prueba503@gmail.com', '123456', '754545555', '2'),
(9, 'Prueba503', 'prueba503@gmail.com', '123456', '754545555', '2'),
(10, 'Prueba503', 'prueba503@gmail.com', '123456', '754545555', '2'),
(11, 'prueba 503', 'misterdj26@gmail.com', '1234', '1234', '2'),
(12, 'alcides', 'alcides@alcides.com', '1234', '23232323', '2'),
(13, 'Juan', 'Juan@Juan.com', '1234', '9999-9999', '2'),
(14, 'tamara', 'tamara@gmail.com', '1234', '23232323', '2');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `contactos`
--
ALTER TABLE `contactos`
  ADD PRIMARY KEY (`id_contacto`);

--
-- Indices de la tabla `incidentes`
--
ALTER TABLE `incidentes`
  ADD PRIMARY KEY (`id_incidente`),
  ADD KEY `tipo` (`tipo`);

--
-- Indices de la tabla `tipo_incidentes`
--
ALTER TABLE `tipo_incidentes`
  ADD PRIMARY KEY (`id_tipo`),
  ADD KEY `id_tipo` (`id_tipo`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `contactos`
--
ALTER TABLE `contactos`
  MODIFY `id_contacto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `incidentes`
--
ALTER TABLE `incidentes`
  MODIFY `id_incidente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipo_incidentes`
--
ALTER TABLE `tipo_incidentes`
  MODIFY `id_tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `incidentes`
--
ALTER TABLE `incidentes`
  ADD CONSTRAINT `FK_tipo` FOREIGN KEY (`tipo`) REFERENCES `tipo_incidentes` (`id_tipo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
