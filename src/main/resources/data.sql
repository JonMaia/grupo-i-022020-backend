INSERT INTO ADMIN (ID, MAIL, NAME, PASSWORD)
VALUES
(1, 'admin@gmail.com', 'Admin', 'admin123');

INSERT INTO DONOR (ID, MAIL, NAME, PASSWORD, NICKNAME)
VALUES
(2, 'cris.esroj@gmail.com', 'Cristian', 'cris123', 'Cris'),
(3, 'jony_wilde05@hotmail.com', 'Jonathan', 'jony213', 'Jony');

INSERT INTO LOCATION (ID, NAME, POPULATION, PROVINCE, STATE)
VALUES
(4, 'Avellaneda', 1565, 'Buenos Aires', true),
(5, 'Gerli', 2691, 'Buenos Aires', true),
(6, 'Sarandi', 6775, 'Buenos Aires', true),
(7, 'Villa Dominico', 2924, 'Buenos Aires', true),
(8, 'Wilde', 7617, 'Buenos Aires', true),
(9, 'Don Bosco', 1921, 'Buenos Aires', true),
(10, 'Bernal', 8764, 'Buenos Aires', true),
(11, 'Quilmes', 1294, 'Buenos Aires', true),
(12, 'Solano', 2464, 'Buenos Aires', true),
(13, 'Berazategui', 6902, 'Buenos Aires', true),
(14, 'Varela', 8369, 'Buenos Aires', true),
(15, 'Dock Sud', 2936, 'Buenos Aires', true),
(16, 'Banfield', 1640, 'Buenos Aires', true),
(17, 'Lanus', 4414, 'Buenos Aires', true),
(18, 'Lomas de Zamora', 1119, 'Buenos Aires', true),
(19, 'Adrogue', 2140, 'Buenos Aires', true),
(20, 'Alejando Korn', 7872, 'Buenos Aires', true),
(21, 'Bosques', 9297, 'Buenos Aires', true),
(22, 'Cañuelas', 5462, 'Buenos Aires', true),
(23, 'El Pato', 3880, 'Buenos Aires', true),
(24, 'Ezpeleta', 1713, 'Buenos Aires', true),
(25, 'Temperley', 9460, 'Buenos Aires', true),
(26, 'Turdera', 1781, 'Buenos Aires', true);

INSERT INTO PROJECT (ID, ACTIVE, CANT_DONATIONS, COLLECTION, END_DATE, FACTOR, INITIAL_DATE, MIN_PERCENTAGE, NAME, PERCENTAGE, LOCATION_ID)
VALUES
(27, true, 2, 1000000, '2021-08-28', 1000, '2020-11-05', 72, 'Avellaneda con Internet', 45.933014354066984, 4),
(28, true, 0, 0, '2023-02-19', 2163, '2020-11-05', 95, 'Gerli con Internet', 0, 5),
(29, true, 0, 0, '2024-01-15', 9975, '2020-11-05', 53, 'Sarandi con Internet', 0, 6),
(30, true, 0, 0, '2023-02-05', 2308, '2020-11-05', 87, 'Villa Dominico con Internet', 0, 7),
(31, true, 0, 0, '2021-12-13', 2734, '2020-11-05', 88, 'Wilde con Internet', 0, 8),
(32, true, 0, 0, '2020-11-30', 4478, '2020-11-05', 99, 'Don Bosco con Internet', 0, 9),
(33, true, 1, 500000, '2020-11-25', 1171, '2020-11-05', 85, 'Bernal con Internet', 46.30783542195291, 10),
(34, true, 1, 100000, '2021-05-25', 7772, '2020-11-05', 63, 'Quilmes con Internet', 2.5856528280885622, 11),
(35, true, 0, 0, '2024-09-19', 6939, '2020-11-05', 65, 'Solano con Internet', 0, 12),
(36, true, 0, 0, '2023-04-16', 5428, '2020-11-05', 55, 'Berazategui con Internet', 0, 13),
(37, true, 0, 0, '2020-11-30', 5850, '2020-11-05', 76, 'Varela con Internet', 0, 14),
(38, true, 0, 0, '2020-11-26', 9504, '2020-11-05', 96, 'Dock Sud con Internet', 0, 15),
(39, true, 0, 0, '2024-03-05', 4529, '2020-11-05', 91, 'Banfield con Internet', 0, 16),
(40, true, 0, 0, '2021-09-07', 5433, '2020-11-05', 99, 'Lanus con Internet', 0, 17),
(41, true, 0, 0, '2024-03-06', 6903, '2020-11-05', 75, 'Lomas de Zamora con Internet', 0, 18),
(42, true, 0, 0, '2021-09-22', 9962, '2020-11-05', 83, 'Adrogue con Internet', 0, 19),
(43, true, 0, 0, '2020-11-25', 8407, '2020-11-05', 86, 'Alejando Korn con Internet', 0, 20),
(44, true, 0, 0, '2024-09-03', 3211, '2020-11-05', 94, 'Bosques con Internet', 0, 21),
(45, true, 0, 0, '2022-01-22', 9876, '2020-11-05', 90, 'Cañuelas con Internet', 0, 22),
(46, true, 0, 0, '2022-10-03', 2124, '2020-11-05', 75, 'El Pato con Internet', 0, 23),
(47, true, 0, 0, '2024-03-27', 253, '2020-11-05', 65, 'Ezpeleta con Internet', 0, 24),
(48, true, 0, 0, '2021-02-16', 5968, '2020-11-05', 97, 'Temperley con Internet', 0, 25),
(49, true, 0, 0, '2020-11-29', 2343, '2020-11-05', 65, 'Turdera con Internet', 0, 26);

INSERT INTO DONATION (ID, AMOUNT, COMMENT, DATE, NICKNAME, POINTS, PROJECT_ID)
VALUES
(50, 500000, 'I donate to Avellaneda con Internet', '2020-11-05', 'Cris', 500000, 27),
(51, 500000, 'I donate to Avellaneda con Internet', '2020-11-05', 'Jony', 500000, 27),
(52, 100000, 'I donate to Quilmes con Internet', '2020-11-05', 'Cris', 100000, 34),
(53, 500000, 'I donate to Bernal con Internet', '2020-11-05', 'Jony', 500000, 33);