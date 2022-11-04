DROP INDEX IF EXISTS IDX_CANAL_001 ON canals;
DROP TABLE IF EXISTS messages;
DROP TABLE IF EXISTS canals;

CREATE TABLE canals (
   idcanal INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(200) NOT NULL,
   dateCreate DATE NOT NULL,
   isRoot INT DEFAULT 0
);

CREATE UNIQUE INDEX IDX_CANAL_001  ON canals(name);

CREATE TABLE messages (
   idmessage INT PRIMARY KEY AUTO_INCREMENT,
   message_body VARCHAR(500) NOT NULL,
   author VARCHAR(200) NOT NULL,
   dateCreate DATE NOT NULL,
   dateUpdate DATE NOT NULL,
   idcanal INT NOT NULL,
   CONSTRAINT fk_canals_message_01 FOREIGN KEY (idcanal) REFERENCES canals(idcanal)
);