CREATE TABLE IF NOT EXISTS `song` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `artist` varchar(45) NOT NULL,
  `lyric` text NOT NULL,
  `visitcount` int(11) DEFAULT NULL,
  `gam` varchar(15) DEFAULT NULL,
  `singer` varchar(100) NOT NULL,
  `category` varchar(100) NOT NULL,
  `postdate` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;