
-- DROP DATABASE pasticceria;
--CREATE DATABASE IF NOT EXISTS pasticceria;
--USE pasticceria;

-- -- sweets -----
--CREATE TABLE IF NOT EXISTS sweets (
--  sweets_id int(10) NOT NULL PRIMARY KEY,
--  sweets_name varchar(100) DEFAULT NULL,
--  price float(4) NOT NULL
--) ;

--
--INSERT INTO sweets (sweets_id, sweets_name, price) VALUES
--(1, 'Frolle', 6.4),
--(2, 'Cannoli siciliani', 6.7),
--(3, 'Maritozzi', 9),
--(4, 'Panna cotta', 4.3),
--(5, 'Tiramisu', 3.6),
--(6, 'Strudel di mele', 8);

--INSERT INTO sweets (sweets_id, sweets_name, price, quantity) VALUES
--(1, 'Frolle', 6.4, 24),
--(2, 'Cannoli siciliani', 6.7, 2),
--(3, 'Maritozzi', 9, 16),
--(4, 'Panna cotta', 4.3, 8),
--(5, 'Tiramisu', 3.6, 32),
--(6, 'Strudel di mele', 8, 9);

--INSERT INTO sweets (sweets_name, price, quantity) VALUES
--('Frolle', 6.4, 24),
--('Cannoli siciliani', 6.7, 2),
--('Maritozzi', 9, 16),
--('Panna cotta', 4.3, 8),
--('Tiramisu', 3.6, 32),
--('Strudel di mele', 8, 9);

INSERT INTO sweets (name, price, quantity, is_first_day, is_second_day, is_third_day, image) VALUES
('Frolle', 6.4, 24, true, false, false, 'frolle.jpg'),
('Cannoli siciliani', 6.7, 2, true, false, false, 'cannoli_siciliani.jpg'),
('Maritozzi', 9, 16, true, false, false, 'maritozzi.jpg'),
('Panna cotta', 4.3, 8, false, true, false, 'panna_cotta.jpg'),
('Tiramisu', 3.6, 32, false, true, false, 'tiramisu.jpg'),
('Strudel di mele', 8, 9, false, false, true, 'strudel_di_mele.jpg');


-- -- INGREDIENT -----
--CREATE TABLE IF NOT EXISTS ingredient (
--  ingredient_id int(10) NOT NULL PRIMARY KEY,
--  ingredient_name varchar(50) DEFAULT NULL,
--  quantity int(5) NOT NULL,
--  size varchar(10) NOT NULL
--);

INSERT INTO ingredient (ingredient_id, name, quantity, size) VALUES
(1, 'sugar', 200, 'gram'),
(2, 'flour', 500, 'gram'),
(3, 'eggs', 1, 'piece'),
(4, 'milk', 1, 'litre');

-- -- CONTAINS -----
--CREATE TABLE IF NOT EXISTS contains (
--  sweets_id int(10) NOT NULL ,
--  ingredient_id int(10) NOT NULL,
--  available_quantity int(5) NOT NULL,
--  PRIMARY KEY (sweets_id,ingredient_id),
--  KEY sweets_id (sweets_id),
--  KEY ingredient_id (ingredient_id)
--);

--INSERT INTO contains (sweets_id, ingredient_id, available_quantity) VALUES
--(1, 1, 10),
--(1, 4, 14),
--(1, 2, 32),
--(2, 1, 8),
--(2, 4, 4),
--(3, 2, 9),
--(3, 1, 14),
--(4, 3, 22),
--(4, 4, 1);

INSERT INTO CONTAINS_SWEETS_INGREDIENTS (sweets_id, ingredient_id) VALUES
(1, 1),
(1, 4),
(1, 2),
(2, 1),
(2, 4),
(3, 2),
(3, 1),
(4, 3),
(4, 4);
--
--ALTER TABLE contains ADD FOREIGN KEY (ingredient_id) REFERENCES ingredient (ingredient_id);
--ALTER TABLE contains ADD FOREIGN KEY (sweets_id) REFERENCES sweets (sweets_id);



