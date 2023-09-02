/*Этап 1. Создание таблиц*/
CREATE TABLE GroupProduct --Группы товаров (напитки, десерты)
(
    GroupId SMALLINT GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 1 MINVALUE 1 NOT NULL, --Первичный ключ
    Name VARCHAR2(50 CHAR) NOT NULL, --Название группы
    CONSTRAINT PK_GroupProduct_GroupId PRIMARY KEY(GroupId),
    CONSTRAINT CK_GroupProduct_Name CHECK (Name<>''),
    CONSTRAINT UQ_GroupProduct_Name UNIQUE (Name)
);

CREATE TABLE SubGroupProduct --Подгруппы товаров (кофе, торты)
(
    SubGroupId INT GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 1 MINVALUE 1 NOT NULL, --Первичный ключ
    Name VARCHAR2(100 CHAR) NOT NULL, --Название подгруппы
    GroupId SMALLINT NOT NULL, --Связь с таблицой Группы товаров
    CONSTRAINT PK_SubGroupProduct_SubGroupId PRIMARY KEY(SubGroupId),
    CONSTRAINT CK_SubGroupProduct_Name CHECK (Name<>''),
    CONSTRAINT UQ_SubGroupProduct_Name UNIQUE (Name)
);

CREATE TABLE TypeProduct --виды продуктов (Кофейные напитки на основе эспрессо, Холодные кофейные напитки, бисквитные торты)
(
    TypeId INT GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 1 MINVALUE 1 NOT NULL, --Первичный ключ
    NameRus VARCHAR2(100 CHAR) NOT NULL, ----Русское название типы продукта
    NameEng VARCHAR2(100 CHAR) NOT NULL, ----Английское название типы продукта
    SubGroupId SMALLINT NOT NULL, --Связь с таблицой подгруппой товаров
    Price NUMBER(8,2) NOT NULL, --Цена по-умолчанию на всю категорию продуктов
    CONSTRAINT PK_TypeProduct_TypeId PRIMARY KEY (TypeId),
    CONSTRAINT CK_TypeProduct_NameRus CHECK(NameRus<>''),
    CONSTRAINT UQ_TypeProduct_NameRus UNIQUE (NameRus),
    CONSTRAINT UQ_TypeProduct_NameEng UNIQUE (NameEng),
    CONSTRAINT CK_TypeProduct_Price CHECK (Price>0) 
);

CREATE TABLE Product --Таблица продуктов (Американо, торт "Наполеон" и т.д.)
(
    ProductId INT GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 1 MINVALUE 1 NOT NULL, --Первичный ключ
    NameRus VARCHAR2(100 CHAR) NOT NULL, --Русское название продукта
    NameEng VARCHAR2(100 CHAR) NOT NULL, --Английское название продукта
    Price NUMBER(8,2), --Витринная цена на товар
    TypeId SMALLINT NOT NULL, --Связь с таблицой виды продуктов
    CONSTRAINT PK_Product_ProductId PRIMARY KEY (ProductId),
    CONSTRAINT CK_Product_NameRus CHECK (NameRus<>''),
    CONSTRAINT CK_Product_NameEng CHECK (NameEng<>''),
    CONSTRAINT UQ_Product_NameRus UNIQUE (NameRus),
    CONSTRAINT UQ_Product_NameEng UNIQUE (NameEng),
    CONSTRAINT CK_Product_Price CHECK (Price>0) 
);

CREATE TABLE Post --Таблица должностей
(
    PostId INT GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 1 MINVALUE 1 NOT NULL, --Первичный ключ
    Name VARCHAR2(50 CHAR) NOT NULL, --Название должности
    CONSTRAINT PK_Post_PostId PRIMARY KEY (PostId),
    CONSTRAINT CK_Post_Name CHECK (Name<>''),
    CONSTRAINT UQ_Post_Name UNIQUE (Name)
);

CREATE TABLE Employee --Таблица сортудников
(
    EmployeeId INT GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 1 MINVALUE 1 NOT NULL,
    FirstName VARCHAR2(10 CHAR) NOT NULL, --Имя
    LastName VARCHAR2(15 CHAR) NOT NULL, --Фамилия
    MiddleName VARCHAR2(15 CHAR), --Отчество
    BirthDay DATE, --День рождения,
    dateEmployment DATE NOT NULL, --Дата приема на работу
    dateDismissal DATE, --Дата увольнения
    CONSTRAINT PK_Employee_EmployeeId PRIMARY KEY (EmployeeId),
    CONSTRAINT CK_Employee_FirstName CHECK (FirstName<>''),
    CONSTRAINT CK_Employee_LastName CHECK (LastName<>''),
    CONSTRAINT CK_Employee_MiddleName CHECK (MiddleName<>''),
    CONSTRAINT CK_Employee_dateEquals CHECK (dateEmployment<dateDismissal) 
);

CREATE TABLE EmployeePost --Таблица сотрудников и должностей
(
    EmployeeId INT NOT NULL, --Для связи с таблицой сотрудников
    PostId INT NOT NULL, --Для связи с таблицой должностей
    CONSTRAINT PK_EmployeePost_EmployeeId_PostId PRIMARY KEY (EmployeeId, PostId)
);

CREATE TABLE Customer --Клиенты
(
    CustomerId INT GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 1 MINVALUE 1 NOT NULL, --Первичный ключ
    FullName VARCHAR2(70 CHAR) NOT NULL, --Полное ФИО
    BirthDay DATE, --День рождения,
    Telephone VARCHAR2(15 CHAR), --Номер телефона
    Email VARCHAR2(20 CHAR), --Контактный email
    Discount NUMBER(4,2) DEFAULT 0 NOT NULL, --Скидка
    CONSTRAINT PK_Customer_CustomerId PRIMARY KEY (CustomerId),
    CONSTRAINT CK_Customer_Discount CHECK (Discount>=0)
);

CREATE TABLE Orders --Заказы
(
    OrderId INT GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 1 MINVALUE 1 NOT NULL, --Первичный ключ
    DateOrder DATE NOT NULL, --Дата заказа
    CustomerId INT NOT NULL, --Для связи с таблицой клиентов
    EmployeeId INT NOT NULL, --Для связи с таблицой сотрудников
    CONSTRAINT PK_Orders_OrderId PRIMARY KEY (OrderId)
);

CREATE TABLE LineOrder --Строка заказа
(
    LineOrderId INT GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 1 MINVALUE 1 NOT NULL, --Первичный ключ,
    OrderId INT NOT NULL, --Для связи с таблицой заказов 
    PriceProduct NUMBER(8,2) NOT NULL, --Цена по прайсу в момент добавления
    PriceClient NUMBER(8,2) NOT NULL, --Цена клиента в заказе
    ProductId INT NOT NULL, --Для связи с таблицой продуктов
    Quantity SMALLINT NOT NULL, --Количество товара
    Amount NUMBER(8,2) GENERATED ALWAYS AS (ROUND(PRICECLIENT*QUANTITY,2)) VIRTUAL, --Вычисляемое после. Сумма
    CONSTRAINT PK_LineOrder_LineOrderId PRIMARY KEY (LineOrderId),
    CONSTRAINT CK_LineOrder_Amount CHECK (Amount>0),
    CONSTRAINT CK_LineOrder_PriceClient CHECK (PriceClient>0),
    CONSTRAINT CK_LineOrder_PriceProduct CHECK (PriceProduct>0)
);

CREATE TABLE Schedule --Таблица расписания работы кофе
(
    ScheduleDate DATE NOT NULL, --Дата. Первичный ключ
    TimeBegin INTERVAL DAY (0) TO SECOND (0) NOT NULL, --Время начала работы
    TimeEnd INTERVAL DAY (0) TO SECOND (0) NOT NULL, --Время окончания рабо
    CONSTRAINT PK_Schedule_ScheduleDate PRIMARY KEY (ScheduleDate),
    CONSTRAINT CK_Schedule CHECK (TimeBegin<TimeEnd)
);

/*Этап 2. Создание связей между таблицами*/
ALTER TABLE SubGroupProduct
ADD CONSTRAINT FK_SubGroupProduct_GroupId FOREIGN KEY (GroupId) REFERENCES GroupProduct (GroupId);

ALTER TABLE TypeProduct
ADD CONSTRAINT FK_TypeProduct_SubGroupId FOREIGN KEY (SubGroupId) REFERENCES  SubGroupProduct(SubGroupId);

ALTER TABLE Product
ADD CONSTRAINT FK_Product_TypeId FOREIGN KEY (TypeId) REFERENCES TypeProduct(TypeId);

ALTER TABLE EmployeePost
ADD CONSTRAINT FK_EmployeePost_EmployeeId FOREIGN KEY (EmployeeId) REFERENCES Employee (EmployeeId);

ALTER TABLE EmployeePost
ADD CONSTRAINT FK_EmployeePost_PostId FOREIGN KEY (PostId) REFERENCES Post (PostId);

ALTER TABLE Orders
ADD CONSTRAINT FK_Orders_CustomerId FOREIGN KEY (CustomerId) REFERENCES Customer (CustomerId);

ALTER TABLE Orders
ADD CONSTRAINT FK_Orders_EmployeeId FOREIGN KEY (EmployeeId) REFERENCES Employee (EmployeeId);

ALTER TABLE LineOrder
ADD CONSTRAINT FK_LineOrder_OrderId FOREIGN KEY (OrderId) REFERENCES Orders (OrderId) ON DELETE CASCADE;

ALTER TABLE LineOrder
ADD CONSTRAINT FK_LineOrder_ProductId FOREIGN KEY (ProductId) REFERENCES Product(ProductId);

/*Этап 3. Заполнение таблиц тестовыми данными*/
INSERT INTO GroupProduct (Name) VALUES ('Напитки');
INSERT INTO GroupProduct (Name) VALUES ('Десерты');

SELECT *
FROM GroupProduct;

INSERT INTO SubGroupProduct (Name, GroupId) VALUES ('Кофеи',1);
INSERT INTO SubGroupProduct (Name, GroupId) VALUES ('Торты',2);

SELECT *
FROM SubGroupProduct;

INSERT INTO TypeProduct (NameRus, NameEng, SubGroupId, Price) VALUES ('Кофейные напитки на основе эспрессо', 'Espresso-based coffee drinks', 1, 55.66);
INSERT INTO TypeProduct (NameRus, NameEng, SubGroupId, Price) VALUES ('Кофейные напитки с молоком', 'Coffee drinks with milk', 1, 35.66);
INSERT INTO TypeProduct (NameRus, NameEng, SubGroupId, Price) VALUES ('Песочные торты', 'Shortbread cakes', 2, 104.66);

SELECT *
FROM TypeProduct;

INSERT INTO Product (NameRus, NameEng, Price, TypeId) VALUES ('Американо', 'Americano', 30.56, 1);
INSERT INTO Product (NameRus, NameEng, Price, TypeId) VALUES ('Доппио', 'Doppio', 70.56, 1);
INSERT INTO Product (NameRus, NameEng, Price, TypeId) VALUES ('Капучино', 'Cappuccino', 80.56, 2);
INSERT INTO Product (NameRus, NameEng, Price, TypeId) VALUES ('Торт «Ленинградский»', 'Cake "Leningradsky"', 1000, 3);

SELECT *
FROM Product;

INSERT INTO Post (Name) VALUES ('Бариста');
INSERT INTO Post (Name) VALUES ('Официант');
INSERT INTO Post (Name) VALUES ('Кондитер');

SELECT *
FROM Post;

INSERT INTO EMPLOYEE(FirstName, LastName, MiddleName, BirthDay, DateEmployment, DateDismissal)
VALUES ('Иван', 'Иванов', 'Иванович', NULL, DATE '2012-05-04', NULL);

INSERT INTO EMPLOYEE(FirstName, LastName, MiddleName, BirthDay, DateEmployment, DateDismissal)
VALUES ('Петр', 'Петров', 'Петрович', NULL, DATE '2015-05-04', NULL);

INSERT INTO EMPLOYEE(FirstName, LastName, MiddleName, BirthDay, DateEmployment, DateDismissal)
VALUES ('Александр', 'Синицин', 'Игоревич', NULL, DATE '2023-02-09', NULL);

SELECT *
FROM EMPLOYEE;

INSERT INTO EmployeePost (EmployeeId, PostId) VALUES (1, 1);
INSERT INTO EmployeePost (EmployeeId, PostId) VALUES (2, 2);
INSERT INTO EmployeePost (EmployeeId, PostId) VALUES (3, 3);

SELECT *
FROM EmployeePost;

INSERT INTO Customer (FullName, BirthDay, Telephone, Email, DISCOUNT)
VALUES ('Орлов О.О.', NULL, NULL, 'orlov@mail.ru', 4);

INSERT INTO Customer (FullName, BirthDay, Telephone, Email, DISCOUNT)
VALUES ('Пономарев М.Б.', NULL, NULL, NULL, 1.23);

INSERT INTO Customer (FullName, BirthDay, Telephone, Email, DISCOUNT)
VALUES ('Александров А.А.', NULL, NULL, NULL, 1.7);

INSERT INTO Customer (FullName, BirthDay, Telephone, Email, DISCOUNT)
VALUES ('Александров А.А.', NULL, NULL, NULL, 5.88);

SELECT *
FROM Customer;
