/*Сначала добавим тестовый заказ*/
INSERT INTO ORDERS (DateOrder, CustomerId, EmployeeId)
SELECT CURRENT_DATE AS DateOrder, 2 AS CustomerId, 1 AS EmployeeId
FROM dual;

/*Добавление информации о новом заказе кофе*/
INSERT INTO LineOrder (OrderId, PriceProduct, PriceClient, ProductId, Quantity)
SELECT 1 AS OrderId, NVL(p.price, tp.price) AS PriceProduct, NVL(p.price, tp.price) AS PriceClient, p.productid, 4 AS Quantity
FROM SubGroupProduct sb
INNER JOIN typeproduct tp ON sb.subgroupid=tp.subgroupid
INNER JOIN Product p ON tp.typeid=p.typeid
WHERE sb.name='Кофеи'
ORDER BY NVL(p.price, tp.price) DESC
FETCH FIRST 1 ROWS ONLY;

/*Добавление информации о новом заказе десерта*/
INSERT INTO LineOrder (OrderId, PriceProduct, PriceClient, ProductId, Quantity)
SELECT 1 AS OrderId, NVL(p.price, tp.price) AS PriceProduct, NVL(p.price, tp.price) AS PriceClient, p.productid, 4 AS Quantity
FROM GroupProduct gp
INNER JOIN SubGroupProduct sb ON gp.groupid=sb.groupid
INNER JOIN typeproduct tp ON sb.subgroupid=tp.subgroupid
INNER JOIN Product p ON tp.typeid=p.typeid
WHERE gp.name='Десерты'
ORDER BY NVL(p.price, tp.price) DESC
FETCH FIRST 1 ROWS ONLY;

/*Добавление информации о графике работы в ближайший понедельник*/
INSERT INTO Schedule (ScheduleDate, TimeBegin, TimeEnd)
SELECT NEXT_DAY(CURRENT_DATE, 'Понедельник') AS ScheduleDate,  '0 8:00:00' AS TimeBegin,  '0 18:10:00' AS TimeEnd
FROM Dual;

/*Добавление информации о новом виде кофе*/
INSERT INTO TypeProduct (NameRus, NameEng, SubGroupId, Price)
VALUES ('Холодные кофейные напитки', 'Cold coffee drinks', 1, 49.56);