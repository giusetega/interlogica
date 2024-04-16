CREATE DATABASE IF NOT EXISTS bakery DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE bakery;

-- -- CAKE -----
CREATE TABLE IF NOT EXISTS cake (
  cakeid int(10) NOT NULL PRIMARY KEY,
  cakename varchar(100) DEFAULT NULL,
  slices int(4) NOT NULL
) ;


INSERT INTO cake (cakeid, cakename, slices) VALUES
(1, 'Apple Pie', 6),
(2, 'Brownie', 8),
(3, 'Chocolate Delight', 3),
(4, 'Red bean cake', 5),
(5, 'Italian', 7),
(6, 'Lemon cake', 4),
(7, 'Vanilla cake', 10),
(8, 'Strawberry cake', 5);


-- -- INGREDIENT -----
CREATE TABLE IF NOT EXISTS ingredient (
  ingredid int(10) NOT NULL PRIMARY KEY,
  iname varchar(50) DEFAULT NULL,
  price int(3) NOT NULL
);


INSERT INTO ingredient (ingredid, iname, price) VALUES
(1, 'flour', 3),
(2, 'eggs', 4),
(3, 'sugar', 2),
(4, 'milk', 5);

-- -- CONTAINS -----
CREATE TABLE IF NOT EXISTS contains (
  cakeid int(10) NOT NULL ,
  ingredid int(10) NOT NULL,
  qty int(5) NOT NULL,
  PRIMARY KEY (cakeid,ingredid)
);

INSERT INTO contains (cakeid, ingredid, qty) VALUES
(1, 1, 2),
(1, 3, 1),
(1, 4, 1),
(2, 2, 2),
(2, 3, 4),
(3, 1, 2),
(3, 4, 2),
(4, 2, 2),
(4, 3, 1);

-- ALTER TABLE contains ADD CONSTRAINT fk_ingredid FOREIGN KEY (ingredid) REFERENCES ingredient (ingredid);
-- ALTER TABLE contains ADD CONSTRAINT fk_cakeid FOREIGN KEY (cakeid) REFERENCES cake (cakeid);

ALTER TABLE contains ADD FOREIGN KEY (ingredid) REFERENCES ingredient (ingredid);
ALTER TABLE contains ADD FOREIGN KEY (cakeid) REFERENCES cake (cakeid);

-------------------------------------


CREATE DATABASE IF NOT EXISTS pasticceria;
USE pasticceria;

-- -- CAKE -----
CREATE TABLE IF NOT EXISTS cake (
  cakeid int(10) NOT NULL PRIMARY KEY,
  cakename varchar(100) DEFAULT NULL,
  slices int(4) NOT NULL
) ;


INSERT INTO cake (cakeid, cakename, slices) VALUES
(1, 'Apple Pie', 6),
(2, 'Brownie', 8),
(3, 'Chocolate Delight', 3),
(4, 'Red bean cake', 5),
(5, 'Italian', 7),
(6, 'Lemon cake', 4),
(7, 'Vanilla cake', 10),
(8, 'Strawberry cake', 5);


-- -- INGREDIENT -----
CREATE TABLE IF NOT EXISTS ingredient (
  ingredid int(10) NOT NULL PRIMARY KEY,
  iname varchar(50) DEFAULT NULL,
  price int(3) NOT NULL
);


INSERT INTO ingredient (ingredid, iname, price) VALUES
(1, 'flour', 3),
(2, 'eggs', 4),
(3, 'sugar', 2),
(4, 'milk', 5);

-- -- CONTAINS -----
CREATE TABLE IF NOT EXISTS contains (
  cakeid int(10) NOT NULL ,
  ingredid int(10) NOT NULL,
  qty int(5) NOT NULL,
  PRIMARY KEY (cakeid,ingredid)
);

INSERT INTO contains (cakeid, ingredid, qty) VALUES
(1, 1, 2),
(1, 3, 1),
(1, 4, 1),
(2, 2, 2),
(2, 3, 4),
(3, 1, 2),
(3, 4, 2),
(4, 2, 2),
(4, 3, 1);

-- ALTER TABLE contains ADD CONSTRAINT fk_ingredid FOREIGN KEY (ingredid) REFERENCES ingredient (ingredid);
-- ALTER TABLE contains ADD CONSTRAINT fk_cakeid FOREIGN KEY (cakeid) REFERENCES cake (cakeid);

ALTER TABLE contains ADD FOREIGN KEY (ingredid) REFERENCES ingredient (ingredid);
ALTER TABLE contains ADD FOREIGN KEY (cakeid) REFERENCES cake (cakeid);


