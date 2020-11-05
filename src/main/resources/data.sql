INSERT INTO ADMIN (ID, MAIL, NAME, PASSWORD)
VALUES
(1, 'admin@gmail.com', 'Admin', 'admin123');

INSERT INTO DONOR (ID, MAIL, NAME, PASSWORD, NICKNAME)
VALUES
(2, 'cris.esroj@gmail.com', 'Cristian', 'cris123', 'Cris'),
(3, 'jony_wilde05@hotmail.com', 'Jonathan', 'jony213', 'Jony');

INSERT INTO LOCATION (ID, NAME, POPULATION, PROVINCE, STATE)
VALUES
(4, 'Avellaneda', 15675, 'Buenos Aires', true),
(5, 'Gerli', 26911, 'Buenos Aires', true),
(6, 'Sarandi', 67756, 'Buenos Aires', true),
(7, 'Villa Dominico', 29249, 'Buenos Aires', true),
(8, 'Wilde', 76174, 'Buenos Aires', true),
(9, 'Don Bosco', 19213, 'Buenos Aires', true),
(10, 'Bernal', 87647, 'Buenos Aires', true),
(11, 'Quilmes', 12946, 'Buenos Aires', true),
(12, 'Solano', 24647, 'Buenos Aires', true),
(13, 'Berazategui', 69024, 'Buenos Aires', true),
(14, 'Varela', 83698, 'Buenos Aires', true),
(15, 'Dock Sud', 29362, 'Buenos Aires', true),
(16, 'Banfield', 16409, 'Buenos Aires', true),
(17, 'Lanus', 44146, 'Buenos Aires', true),
(18, 'Lomas de Zamora', 11198, 'Buenos Aires', true),
(19, 'Adrogue', 21400, 'Buenos Aires', true),
(20, 'Alejando Korn', 78720, 'Buenos Aires', true),
(21, 'Bosques', 9297, 'Buenos Aires', true),
(22, 'Cañuelas', 5462, 'Buenos Aires', true),
(23, 'El Pato', 38807, 'Buenos Aires', true),
(24, 'Ezpeleta', 17137, 'Buenos Aires', true),
(25, 'Temperley', 94602, 'Buenos Aires', true),
(26, 'Turdera', 17817, 'Buenos Aires', true);

INSERT INTO PROJECT (ID, ACTIVE, CANT_DONATIONS, COLLECTION, END_DATE, FACTOR, INITIAL_DATE, MIN_PERCENTAGE, NAME, PERCENTAGE, LOCATION_ID)
VALUES
(27, true, 0, 0, '2021-08-28', 59300, '2020-11-05', 72, 'Avellaneda con Internet', 0, 4),
(28, true, 0, 0, '2023-02-19', 21634, '2020-11-05', 95, 'Gerli con Internet', 0, 5),
(29, true, 0, 0, '2024-01-15', 99755, '2020-11-05', 53, 'Sarandi con Internet', 0, 6),
(30, true, 0, 0, '2023-02-05', 23508, '2020-11-05', 87, 'Villa Dominico con Internet', 0, 7),
(31, true, 0, 0, '2021-12-13', 25734, '2020-11-05', 88, 'Wilde con Internet', 0, 8),
(32, true, 0, 0, '2021-09-30', 40478, '2020-11-05', 99, 'Don Bosco con Internet', 0, 9),
(33, true, 0, 0, '2022-11-25', 11171, '2020-11-05', 85, 'Bernal con Internet', 0, 10),
(34, true, 0, 0, '2021-05-25', 70772, '2020-11-05', 63, 'Quilmes con Internet', 0, 11),
(35, true, 0, 0, '2024-09-19', 63939, '2020-11-05', 65, 'Solano con Internet', 0, 12),
(36, true, 0, 0, '2023-04-16', 55428, '2020-11-05', 55, 'Berazategui con Internet', 0, 13),
(37, true, 0, 0, '2021-07-11', 54850, '2020-11-05', 76, 'Varela con Internet', 0, 14),
(38, true, 0, 0, '2021-10-26', 95504, '2020-11-05', 96, 'Dock Sud con Internet', 0, 15),
(39, true, 0, 0, '2024-03-05', 47529, '2020-11-05', 91, 'Banfield con Internet', 0, 16),
(40, true, 0, 0, '2021-09-07', 54433, '2020-11-05', 99, 'Lanus con Internet', 0, 17),
(41, true, 0, 0, '2024-03-06', 62903, '2020-11-05', 75, 'Lomas de Zamora con Internet', 0, 18),
(42, true, 0, 0, '2021-09-22', 95962, '2020-11-05', 83, 'Adrogue con Internet', 0, 19),
(43, true, 0, 0, '2021-07-25', 82407, '2020-11-05', 86, 'Alejando Korn con Internet', 0, 20),
(44, true, 0, 0, '2024-09-03', 33211, '2020-11-05', 94, 'Bosques con Internet', 0, 21),
(45, true, 0, 0, '2022-01-22', 91876, '2020-11-05', 90, 'Cañuelas con Internet', 0, 22),
(46, true, 0, 0, '2022-10-03', 24124, '2020-11-05', 75, 'El Pato con Internet', 0, 23),
(47, true, 0, 0, '2024-03-27', 2053, '2020-11-05', 65, 'Ezpeleta con Internet', 0, 24),
(48, true, 0, 0, '2021-02-16', 55968, '2020-11-05', 97, 'Temperley con Internet', 0, 25),
(49, true, 0, 0, '2024-06-05', 24343, '2020-11-05', 65, 'Turdera con Internet', 0, 26);