DROP TABLE IF EXISTS User;

CREATE TABLE User (
      username VARCHAR(250)  PRIMARY KEY,
      first_name VARCHAR(250) NOT NULL,
      last_name VARCHAR(250) NOT NULL,
      password VARCHAR (250) NOT NULL
);

INSERT INTO User (username, first_name, last_name, password) VALUES
('DAliko','Aliko', 'Dangote', '937e8d5fbb48bd4949536cd65b8d35c426b80d2f830c5c308e2cdec422ae2244'),
('micro1','Bill', 'Gates', '937e8d5fbb48bd4949536cd65b8d35c426b80d2f830c5c308e2cdec422ae2244'),
('Fal420','Folrunsho', 'Alakija','937e8d5fbb48bd4949536cd65b8d35c426b80d2f830c5c308e2cdec422ae2244');