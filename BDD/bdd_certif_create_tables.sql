DROP INDEX IF EXISTS IDX_CANAL_001 ON canals;

ALTER TABLE messages DROP FOREIGN KEY IF EXISTS fk_messages_canals;
ALTER TABLE messages DROP FOREIGN KEY IF EXISTS fk_users_roles;
ALTER TABLE messages DROP FOREIGN KEY IF EXISTS fk_users_canals_users;
ALTER TABLE messages DROP FOREIGN KEY IF EXISTS fk_users_canals_users;


DROP TABLE IF EXISTS messages;
DROP TABLE IF EXISTS canals;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS users_canals;
DROP TABLE IF EXISTS roles;

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
   CONSTRAINT fk_messages_canals FOREIGN KEY (idcanal) REFERENCES canals(idcanal)
);

CREATE TABLE users (
   iduser INT PRIMARY KEY AUTO_INCREMENT,
   email VARCHAR(100) NOT NULL,
   password VARCHAR(100) NOT NULL,
   username DATE NOT NULL,
   idrole DATE NOT NULL,
   idcanal INT NOT NULL,
   CONSTRAINT fk_users_roles FOREIGN KEY (idrole) REFERENCES canals(idrole)
);

CREATE TABLE users_canals (
   idusers_canals INT PRIMARY KEY AUTO_INCREMENT,
   iduser INT NOT NULL,
   idcanal INT NOT NULL,
   CONSTRAINT fk_users_canals_users FOREIGN KEY (iduser) REFERENCES canals(iduser),
   CONSTRAINT fk_users_canals_users FOREIGN KEY (idcanal) REFERENCES canals(idcanal)
);

CREATE TABLE roles (
   idrole INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(200) NOT NULL
);