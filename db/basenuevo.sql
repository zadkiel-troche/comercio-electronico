-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.1.72-community - MySQL Community Server (GPL)
-- SO del servidor:              Win32
-- HeidiSQL Versión:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura para tabla comercios.empresas
CREATE TABLE IF NOT EXISTS `empresas` (
  `id_empresa` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_empresa`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla comercios.empresas: 2 rows
/*!40000 ALTER TABLE `empresas` DISABLE KEYS */;
INSERT INTO `empresas` (`id_empresa`, `nombre`, `direccion`, `telefono`) VALUES
	(1, 'SIN EMPRESA', '0', '0'),
	(2, 'Comercial ENC', 'AVENIDA 29 DE SEPTIEMBRE', '071123456'),
	(3, 'La sirenita SRL', 'pacu cua', '0711234567');
/*!40000 ALTER TABLE `empresas` ENABLE KEYS */;

-- Volcando estructura para tabla comercios.marcas
CREATE TABLE IF NOT EXISTS `marcas` (
  `id_marca` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_marca`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla comercios.marcas: 5 rows
/*!40000 ALTER TABLE `marcas` DISABLE KEYS */;
INSERT INTO `marcas` (`id_marca`, `nombre`) VALUES
	(1, 'Samsung'),
	(2, 'HUAWEI'),
	(3, 'LENOVO'),
	(4, 'LG');
/*!40000 ALTER TABLE `marcas` ENABLE KEYS */;

-- Volcando estructura para tabla comercios.productos
CREATE TABLE IF NOT EXISTS `productos` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `pantalla` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `ram` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `procesador` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `camara` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `precio` int(11) NOT NULL,
  `id_marca` int(11) NOT NULL,
  `id_empresa` int(11) NOT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `fk_productomarca` (`id_marca`),
  KEY `fk_productosempresa` (`id_empresa`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla comercios.productos: 3 rows
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` (`id_producto`, `nombre`, `descripcion`, `pantalla`, `ram`, `procesador`, `camara`, `precio`, `id_marca`, `id_empresa`) VALUES
	(1, 'Samsung Galaxy S23 Ultra 512GB', 'Nuestro impactante diseno simetrico regresa con una diferencia importante: el uso de materiales reciclados y ecologicos. Desde el vidrio reutilizado hasta el color del marco de metal pulido.', 'AMOLED de 6,8 pulgadas', '8 GB', 'Qualcomm Snapdragon 8 Gen 2 Adreno 740', '40 MP', 2500000, 1, 0),
	(2, 'CELULAR LG K51S HD 64GB 3GB RAM PANT. 6.5', '6.55" HD+ 20:9 Hole in Display 13MP Camara Frontal QUAD Camara 32MP/ W5MP/ D2MP/ M2MP Memoria 64GB Bateria 4,000mAh AI CAM/ Google Assistant/ Google Lens', '6.55" HD+ 20:9 Hole in Display', '64GB', '4,000mAh AI CAM/ Google Assistant/ Google Lens', '13MP', 1850000, 4, 0);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;

-- Volcando estructura para tabla comercios.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla comercios.roles: 2 rows
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id_rol`, `nombre`) VALUES
	(1, 'ADMIN'),
	(2, 'USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Volcando estructura para tabla comercios.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `pass` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `id_empresa` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `fk_usuarioempresa` (`id_empresa`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla comercios.usuarios: 2 rows
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`id_usuario`, `nombre`, `email`, `pass`, `id_empresa`) VALUES
	(1, 'admin', 'admin@gmail.com', 'admin', 1),
	(2, 'zadkiel', 'zadkiel@gmail.com', 'troche', 2),
	(4, 'juan', 'juanperez@ejemplo.com', 'juan', 3);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

-- Volcando estructura para tabla comercios.usuarios_roles
CREATE TABLE IF NOT EXISTS `usuarios_roles` (
  `id_usuario_rol` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_id` int(11) NOT NULL,
  `rol_id` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario_rol`),
  KEY `fk_usrlusuario` (`usuario_id`),
  KEY `fk_usrlrol` (`rol_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla comercios.usuarios_roles: 2 rows
/*!40000 ALTER TABLE `usuarios_roles` DISABLE KEYS */;
INSERT INTO `usuarios_roles` (`id_usuario_rol`, `usuario_id`, `rol_id`) VALUES
	(1, 1, 1);
/*!40000 ALTER TABLE `usuarios_roles` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
