CREATE TABLE `administrador` (
  `externo` bit(1) DEFAULT NULL,
  `idUsuario` bigint(20) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  CONSTRAINT `FKge9cmhbes1fii5xiau5ow6mgu` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `calle` (
  `idCalle` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idCalle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `cliente` (
  `idCliente` bigint(20) NOT NULL AUTO_INCREMENT,
  `cuit` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `direccion` bigint(20) DEFAULT NULL,
  `empleado` bigint(20) DEFAULT NULL,
  `situacion` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  KEY `FK4y91deom8ewsh6g1c8jc5tvbt` (`direccion`),
  KEY `FKs0yrif0t1cg01mmcxdeejvyjh` (`empleado`),
  KEY `FK573qgk8tx8rg6qd43xtfp0myu` (`situacion`),
  CONSTRAINT `FK4y91deom8ewsh6g1c8jc5tvbt` FOREIGN KEY (`direccion`) REFERENCES `direccion` (`idDireccion`),
  CONSTRAINT `FK573qgk8tx8rg6qd43xtfp0myu` FOREIGN KEY (`situacion`) REFERENCES `situacionafip` (`idSituacion`),
  CONSTRAINT `FKs0yrif0t1cg01mmcxdeejvyjh` FOREIGN KEY (`empleado`) REFERENCES `empleado` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `detalleventa` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) DEFAULT NULL,
  `producto` bigint(20) DEFAULT NULL,
  `venta` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK6f2rut2vh2euale9xbddf4c2t` (`producto`),
  KEY `FKkoddytyqumv0hsllpqxuxkhxg` (`venta`),
  CONSTRAINT `FK6f2rut2vh2euale9xbddf4c2t` FOREIGN KEY (`producto`) REFERENCES `producto` (`idProducto`),
  CONSTRAINT `FKkoddytyqumv0hsllpqxuxkhxg` FOREIGN KEY (`venta`) REFERENCES `venta` (`idVenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `direccion` (
  `idDireccion` bigint(20) NOT NULL AUTO_INCREMENT,
  `altura` int(11) DEFAULT NULL,
  `cp` varchar(255) DEFAULT NULL,
  `dpto` int(11) DEFAULT NULL,
  `entreCalle1` varchar(255) DEFAULT NULL,
  `entreCalle2` varchar(255) DEFAULT NULL,
  `piso` int(11) DEFAULT NULL,
  `calle` bigint(20) DEFAULT NULL,
  `localidad` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idDireccion`),
  KEY `FK1medhm9co5ip23cfhfyap2573` (`calle`),
  KEY `FK335nxcx6r0q63ll4wl3hxu9kj` (`localidad`),
  CONSTRAINT `FK1medhm9co5ip23cfhfyap2573` FOREIGN KEY (`calle`) REFERENCES `calle` (`idCalle`),
  CONSTRAINT `FK335nxcx6r0q63ll4wl3hxu9kj` FOREIGN KEY (`localidad`) REFERENCES `localidad` (`idLocalidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `empleado` (
  `legajo` int(11) DEFAULT NULL,
  `idUsuario` bigint(20) NOT NULL,
  `idAdm` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `FKnu07pnn885fq6c9kncie56otx` (`idAdm`),
  CONSTRAINT `FKd08jp17tmpf94fs7wwe3ix9xe` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `FKnu07pnn885fq6c9kncie56otx` FOREIGN KEY (`idAdm`) REFERENCES `administrador` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `factura` (
  `idFactura` bigint(20) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) DEFAULT NULL,
  `importe` float DEFAULT NULL,
  `tipo` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idFactura`),
  KEY `FK8xkr22lqx54g86ke511vpbkq9` (`tipo`),
  CONSTRAINT `FK8xkr22lqx54g86ke511vpbkq9` FOREIGN KEY (`tipo`) REFERENCES `tipofactura` (`idTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `localidad` (
  `idLocalidad` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `partido` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idLocalidad`),
  KEY `FK2wqd6bjo5o0tslvp3ot635c63` (`partido`),
  CONSTRAINT `FK2wqd6bjo5o0tslvp3ot635c63` FOREIGN KEY (`partido`) REFERENCES `partido` (`idPartido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `pais` (
  `idPais` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `partido` (
  `idPartido` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `provincia` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idPartido`),
  KEY `FK2ji8bro6blddw1q010eytatbk` (`provincia`),
  CONSTRAINT `FK2ji8bro6blddw1q010eytatbk` FOREIGN KEY (`provincia`) REFERENCES `provincia` (`idProvincia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `producto` (
  `idProducto` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `precio_unitario` float DEFAULT NULL,
  `administrador` bigint(20) DEFAULT NULL,
  `stock` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `FK8isub6v9vyfnvwc48jtdv8qxv` (`administrador`),
  KEY `FKglwvhs7oc6g9vrynyc4pdsyd6` (`stock`),
  CONSTRAINT `FK8isub6v9vyfnvwc48jtdv8qxv` FOREIGN KEY (`administrador`) REFERENCES `administrador` (`idUsuario`),
  CONSTRAINT `FKglwvhs7oc6g9vrynyc4pdsyd6` FOREIGN KEY (`stock`) REFERENCES `stock` (`idStock`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `provincia` (
  `idProvincia` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `pais` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idProvincia`),
  KEY `FKhoe7ga52cdy3xh06ernylq8yr` (`pais`),
  CONSTRAINT `FKhoe7ga52cdy3xh06ernylq8yr` FOREIGN KEY (`pais`) REFERENCES `pais` (`idPais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `situacionafip` (
  `idSituacion` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idSituacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `stock` (
  `idStock` bigint(20) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`idStock`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `tipofactura` (
  `idTipo` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `usuario` (
  `idUsuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `administrador` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `venta` (
  `idVenta` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `importe` float DEFAULT NULL,
  `cliente` bigint(20) DEFAULT NULL,
  `empleado` bigint(20) DEFAULT NULL,
  `factura` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idVenta`),
  KEY `FK5l4u9x4sk9nakpc16yoicgcxn` (`cliente`),
  KEY `FKcesp6qhjtkjn12ulr2ifa0ic8` (`empleado`),
  KEY `FKk0f6sjiyeaphj1apl6vyudvt2` (`factura`),
  CONSTRAINT `FK5l4u9x4sk9nakpc16yoicgcxn` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `FKcesp6qhjtkjn12ulr2ifa0ic8` FOREIGN KEY (`empleado`) REFERENCES `empleado` (`idUsuario`),
  CONSTRAINT `FKk0f6sjiyeaphj1apl6vyudvt2` FOREIGN KEY (`factura`) REFERENCES `factura` (`idFactura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
