--CREATE db
CREATE DATABASE gregs_list;

--CONNECT
\c gregs_list postgres localhost 5432

--кодировка
\! chcp 1251

--MySQL only
USE gregs_list;

--DESC
\d my_contacts;

--DELETE
DROP TABLE my_contacts;

DELETE FROM my_contacts
WHERE id=1;

--удаление по дубликату поля.

DELETE FROM items i1
WHERE EXISTS
(SELECT FROM items i2
WHERE i1.name = i2.name AND
i1.id > i2.id);

INSERT INTO items (name) VALUES
('ИВАН'),
('ИВАН'),
('РОМАН'),
('РОМАН'),
('СЕРГЕЙ'),
('СЕРГЕЙ');

--Show data in table
SELECT * FROM my_contacts;

SELECT drink_name, main, second
FROM easy_drinks
WHERE main='содовая';

SELECT drink_name
FROM easy_drinks
WHERE amount2=7;

SELECT drink_name
FROM easy_drinks
WHERE main='содовая'
AND amount1=1.5;

SELECT drink_name
FROM easy_drinks
WHERE 
drink_name>='Г'
AND
drink_name<'Д';

SELECT drink_name
FROM easy_drinks
WHERE main='вишневый сок'
OR second='вишневый сок';

--прямая выборка с NULL значением
SELECT drink_name
FROM drink_info
WHERE 
calories IS NULL;  

--непрямая выборка со значением NULL
SELECT calories
FROM drink_info
WHERE drink_name='Дыхание дракона'; -- в примере поле callories NULL

--Поиск % - любое кол-во симоволо перед окончанием им
-- _ - один имвол перед им
SELECT first_name
FROM my_contacts
WHERE first_name LIKE '%им';

SELECT first_name
FROM my_contacts
WHERE first_name LIKE '_им';

--ПОиск в диапазоне можно применять и к символам
SELECT drink_name
FROM drink_info
WHERE
calories >= 30
AND
callories <= 60;

SELECT drink_name
FROM drink_info
WHERE
callories BETWEEN 30 AND 60;

--IN   NOT IN  - Выборка или обратная выборка что бы не строить конструкции OR
SELECT drink_name
FROM easy_drinks
WHERE main IN ('содовая','вишневый сок');

SELECT drink_name
FROM easy_drinks
WHERE main NOT IN ('содовая','вишневый сок');

--SELECT по порядку и в обратном опрядке
SELECT title, category
FROM movie_table
WHERE
category = 'семейное'
ORDER BY title; --алфавитный порядок

select * from chars_order
ORDER by test_char DESC; --Обратный порядок DESCENDING

--Суммирование и группировка
SELECT first_name, SUM(sales)
FROM cookie_sales
GROUP BY first_name
ORDER BY SUM (sales) DESC;

SELECT first_name, SUM(sales)
FROM cookie_sales
GROUP BY first_name
ORDER BY SUM (sales) DESC
LIMIT 2; --Лимит на количество вывода записей удовлетворяющим условиям
-- LIMIT 0, 4  - вывод с позиции 0  4 результата.

--Среднее значение и группировка
SELECT first_name, AVG(sales)
FROM cookie_sales
GROUP BY first_name;

--Min и Max
SELECT first_name, MAX(sales)
FROM cookie_sales
GROUP BY first_name;

SELECT first_name, MIN(sales)
FROM cookie_sales
GROUP BY first_name;

-- Счетчик полей
SELECT first_name, COUNT(sale_date)
FROM cookie_sales
GROUP BY first_name;

--Distinc выводит не дубликаты
SELECT DISTINCT sale_date
FROM cookie_sales
ORDER BY sale_date;

SELECT COUNT (DISTINCT sale_date)
FROM cookie_sales;



--UPDATE
UPDATE drink_info
SET
color='золотистый'
WHERE color ='желтый';

UPDATE drink_info
SET
cost=3.5
WHERE cost =2.5;

UPDATE drink_info
SET cost = cost + 1;
WHERE 
drink_name='Голубая лагуна'
OR
drink_name='Вот тебе на'
OR
drink_name='Лаймовый фриз';

--Перенос из одного неатомарного столбца в атомарные (один, два, три, четыре)
UPDATE my_contacts
SET interest1 = SUBSTRING_INDEX(interests, ',', 1); 

UPDATE my_contacts
SET interests = SUBSTR(interests, LENGTH(interst1)+2 ); --удаляет длину +запятую и пробел

--В одну команду(один, два, три, четыре)
UPDATE my_contacts SET
interest1 = SUBSTRING_INDEX(interests, ',', 1),
interests = SUBSTR(interests, LENGTH(interst1)+2 ),
interest2 = SUBSTRING_INDEX(interests, ',', 1),
interests = SUBSTR(interests, LENGTH(interst2)+2 ),
interest3 = SUBSTRING_INDEX(interests, ',', 1),
interests = SUBSTR(interests, LENGTH(interst3)+2 ),
interest4 = interests,
DROP COLUMN interests;

--ПСЕВДОНИМЫ
SELECT profession AS mcprof
FROM my_contacts AS mc
GROUP BY mc_prof,
ORDER BY mc_prof;
--equals - AS можно опустить
SELECT profession mcprof
FROM my_contacts  mc
GROUP BY mc_prof,
ORDER BY mc_prof;

--КРОСС СОЕДИНЕНИЕ
SELECT boys.boy, toys.toys
FROM boys
CROSS JOIN
toys;

--Внутреннее эевивалентное соединение
SELECT boys.boy, toys.toys
FROM boys
INNER JOIN
toys
ON boys.toy_id = toys.toy_id;


--Внтуреннее неэквивалентное соединение
SELECT boys.boy, toys.toys
FROM boys
INNER JOIN
toys
ON boys.toy_id <> toys.toy_id
ORDER BY boys.boy;

--Внутреннее естественное соединение
SELECT boys.boy, toys.toys
FROM boys
NATURAL JOIN
toys;

SELECT mc.first_name, mc.second_name, mc.phone
FROM my_contacts mc
NATURAL JOIN
job_desire jd
WHERE jd.title = 'Веб разработчик' 
AND jd.salary_high < 105000;

--Левое внешнее соединение и правое
SELECT g.girl, t.toy
FROM girls g
LEFT OUTER JOIN toys t
ON g.toy_id = t.toy_id;

SELECT g.girl, t.toy
FROM toys t
LEFT OUTER JOIN girls g
ON g.toy_id = t.toy_id;

SELECT g.girl, t.toy
FROM toys t
RIGHT OUTER JOIN girls g
ON g.toy_id = t.toy_id;

--Самосоединение одной таблицы - одна под двумя разными псевдонимами
SELECT c1.name, c2.name AS boss
FROM clown_info AS c1
INNER JOIN clown_info AS c2
ON c1.boss_id = c2.id;

--Union союзы  (--UNION ALL возвращает все союзы, не только уникальные)
SELECT title FROM job_current
UNION
SELECT title FROM job_desire
UNION
SELECT title FROM job_listings
ORDER BY title;

--Создание таблицы на основе союза CREATE TABLE AS
CREATE TABLE my_union AS
SELECT title FROM job_current
UNION
SELECT title FROM job_desire
UNION
SELECT title FROM job_listings;

CREATE TABLE contact_union AS
SELECT contact_id FROM job_current
UNION SELECT salary FROM job_listings;

--Пересечение и иключение  INTERSECT и EXCEPT
SELECT title FROM job_current
INTERSECT
SELECT title FROM job_desired;

SELECT title FROM job_сurrent
EXCEPT
SELECT title FROM job_desired;

--Ограничения CHECK
ALTER TABLE my_contacts
ADD CONSTRAINT CHECK gender IN ('М', 'Ж') ;  --так же задаются при создании таблицы



--Представления
CREATE VIEW tech_writer_jobs AS
SELECT title, salary, description, zip
FROM job_listings
WHERE title = 'Технический писатель';

SELECT * FROM tech_writer_jobs; --Вызов представления

--ЗАПРОС С ПОДЗАПРОСОМ. подзапрос используется как входящий параметр в запросе.
SELECT mc.first_name, mc.second_name, mc.phone, jc.title
FROM my_contacts AS mc
NATURAL JOIN
job_current AS jc
WHERE jc.title IN (SELECT title FROM job_listings);


--ТРанзакции

START TRANSACTION;
SELECT * FROM piggy_bank;
UPDATE piggy_bank SET coin = 'Q' WHERE coin = 'P' ;
SELECT * FROM piggy_bank; -- Здесь изменения еще видны.
ROLLBACK; --Передумали.
SELECT * FROM piggy_bank; --Здесь не видны

START TRANSACTION;
SELECT * FROM piggy_bank;
UPDATE piggy_bank SET coin = 'Q' WHERE coin = 'P' ;
SELECT * FROM piggy_bank; -- Здесь изменения еще видны.
COMMIT; --Закрепление транзакции.
SELECT * FROM piggy_bank;



--CREATE table
CREATE TABLE my_contacts (
last_name VARCHAR(30),
first_name VARCHAR(20),
email VARCHAR(50),
gender CHAR(1),
birthday DATE,
profession VARCHAR(50),
location VARCHAR(50),
status VARCHAR(20),
interests VARCHAR(100),
seeking VARCHAR(100)
);

CREATE TABLE my_contacts (
last_name VARCHAR(30) NOT NULL,
first_name VARCHAR(20) NOT NULL,
email VARCHAR(50) NOT NULL,
gender CHAR(1) NOT NULL,
birthday DATE NOT NULL,
profession VARCHAR(50) NOT NULL,
location VARCHAR(50) NOT NULL,
status VARCHAR(20) NOT NULL,
interests VARCHAR(100) NOT NULL,
seeking VARCHAR(100) NOT NULL
);


CREATE TABLE my_contacts
(
	contact_id INT NOT NULL AUTO_INCREMENT,
    last_name character varying(30) default NULL,
    first_name character varying(20) default NULL,
    email character varying(50) default NULL,
    gender character(1) default NULL,
    birthday date default NULL,
    profession character varying(50) default NULL,
    location character varying(50) default NULL,
    status character varying(20) default NULL,
    interests character varying(100) default NULL,
    seeking character varying(100) default NULL
	PRIMARY KEY (contact_id)
);

CREATE SEQUENCE auto_id;

CREATE TABLE simple_contact (
	id INT NOT NULL default nextval('auto_id'),
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE simple_contact (
	id SERIAL,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	PRIMARY KEY (id)
);

--ALTER добавляет столбец
ALTER TABLE my_contacts
ADD COLUMN contact_id SERIAL NOT NULL FIRST,
ADD PRIMARY KEY (contact_id);

CREATE TABLE easy_drinks (
drink_name VARCHAR(50) NOT NULL,
main VARCHAR(50) NOT NULL,
amount1 DEC(3,2) NOT NULL,
second VARCHAR(50) NOT NULL,
amount2 DEC(3,2) NOT NULL,
directions  CHAR(255) NOT NULL
);

CREATE TABLE drink_info (
drink_name VARCHAR(50) NOT NULL,
cost DEC(4,2) NOT NULL,
carbs DEC(4,2) NOT NULL,
color VARCHAR(50) NOT NULL,
ice CHAR(1) NOT NULL,
calories  INT NOT NULL
);

CREATE TABLE doughnut_list
(
doughnut_name VARCHAR(10) NOT NULL,
doughnut_type VARCHAR(6) NOT NULL,
doughnut_cost DEC(3,2) NOT NULL DEFAULT 1.00 --устанавливает значение по умолчанию. (3,2) до 3 цифр, одна до и две после запятой.
) ;


--UPDATE
UPDATE engine
SET name = 'dark matter' WHERE id=4;

--INSERT data in rows
INSERT INTO my_contacts
(last_name, first_name, email, gender, birthday, profession, location, status, interests, seeking)
VALUES
('Anderson', 'Gillian', 'jill__anderson@breakneckpizza.com', 'F', '1980-05-09', 'Writer', 'Palo-Alto, CA', 'Single', 'kayak, terrarium', 'Friends');


INSERT INTO my_contacts
(first_name, email, profession, location)
VALUES
('Pat', 'patpost0breakneckpizza.com',
'Postman', 'Princeton, NJ ');

