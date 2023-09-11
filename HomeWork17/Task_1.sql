/*Создание таблицы*/
CREATE TABLE CoffeHouse
(
    CoffeHouseId SMALLINT GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 1 MINVALUE 1 NOT NULL, --Первыичный ключ
    Name VARCHAR(100) NOT NULL,
    CONSTRAINT PK_CoffeHouse_CoffeHouseId PRIMARY KEY (CoffeHouseId),
    CONSTRAINT CK_CoffeHouse_Name CHECK (Name<>''),
    CONSTRAINT UQ_CoffeHouse_Name UNIQUE(Name)
);

/*Добавление тестового кафе*/
INSERT INTO CoffeHouse (Name)
VALUES ('Кофейня Панама');

/*Добавляю столбец в таблицу Employee*/
ALTER TABLE Employee
ADD (CoffeHouseId SMALLINT);

/*Считаю, что все сотрудники работают в одной кафейне*/
UPDATE Employee SET coffehouseid=1; 

/*Модифицирую столбец CoffeHouseId таблицы Employee*/
ALTER TABLE Employee
MODIFY CoffeHouseId SMALLINT NOT NULL;

/*Создаю связь между таблицами Employee и CoffeHouse*/
ALTER TABLE Employee
ADD CONSTRAINT FK_Employee_CoffeHouseId FOREIGN KEY (CoffeHouseId) REFERENCES CoffeHouse(CoffeHouseId) ON DELETE CASCADE;

/*Добавляю столбец в таблицу GroupProduct*/
ALTER TABLE GroupProduct
ADD (CoffeHouseId SMALLINT);

/*Считаю, что все группы товара из одной кофейни*/
UPDATE GroupProduct SET coffehouseid=1;

/*Модифицирую столбец CoffeHouseId таблицы GroupProduct*/
ALTER TABLE GroupProduct
MODIFY CoffeHouseId SMALLINT NOT NULL;

/*Создаю связь между таблицами GroupProduct и CoffeHouse*/
ALTER TABLE GroupProduct
ADD CONSTRAINT FK_GroupProduct_CoffeHouseId FOREIGN KEY (CoffeHouseId) REFERENCES CoffeHouse(CoffeHouseId) ON DELETE CASCADE;

/*Добавляю столбец в таблицу Orders*/
ALTER TABLE Orders
ADD (CoffeHouseId SMALLINT);

/*Считаю, что все заказы из одной кафейни*/
UPDATE Orders SET coffehouseid=1;

/*Модифицирую столбец CoffeHouseId таблицы Orders*/
ALTER TABLE Orders
MODIFY CoffeHouseId SMALLINT NOT NULL;

/*Создаю связь между таблицами Orders и CoffeHouse*/
ALTER TABLE Orders
ADD CONSTRAINT FK_Orders_CoffeHouseId FOREIGN KEY (CoffeHouseId) REFERENCES CoffeHouse(CoffeHouseId) ON DELETE CASCADE;

/*Удаляю временно PRIMATY KEY из таблицы Schedule*/
ALTER TABLE Schedule
DROP CONSTRAINT PK_Schedule_ScheduleDate;

/*Добавляю столбец в таблицу Schedule*/
ALTER TABLE Schedule
ADD (CoffeHouseId SMALLINT);

/*Считаю, что все рассписания из одной кафейни*/
UPDATE Schedule SET coffehouseid=1;

/*Модифицирую столбец CoffeHouseId таблицы Schedule*/
ALTER TABLE Schedule
MODIFY CoffeHouseId SMALLINT NOT NULL;

/*Создаю составной первичный ключ*/
ALTER TABLE Schedule
ADD CONSTRAINT PK_Schedule_ScheduleDate_CoffeHouseId PRIMARY KEY (ScheduleDate, CoffeHouseId);

/*Создаю связь между таблицами Schedule и CoffeHouse*/
ALTER TABLE Schedule
ADD CONSTRAINT FK_Schedule_CoffeHouseId FOREIGN KEY (CoffeHouseId) REFERENCES CoffeHouse(CoffeHouseId) ON DELETE CASCADE;