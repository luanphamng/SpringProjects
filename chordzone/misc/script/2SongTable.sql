CREATE TABLE `song` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `artist` varchar(45) NOT NULL,
  `lyric` varchar(5000) NOT NULL,
  `visitcount` int(11) DEFAULT NULL,
  `gam` varchar(15) DEFAULT NULL,
  `singer` varchar(200) NOT NULL,
  `category` varchar(100) NOT NULL,
  `postdate` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
SELECT * FROM testchorddb.song;