SET SERVEROUTPUT ON; /*Устанавливаем для вывода данных через курсор */

/*Показать самый популярный напиток во всей сети кофеен*/
CREATE OR REPLACE PROCEDURE getPopularDrink(drink OUT SYS_REFCURSOR)
AS
BEGIN
  -- Объявляем курсор
  DECLARE
    drink_cursor SYS_REFCURSOR;
  BEGIN
    -- Открываем курсор
    OPEN drink_cursor FOR
    SELECT p.namerus AS НазваниеТовара
    FROM LineOrder lo
    INNER JOIN Orders o ON lo.orderid=o.orderid
    INNER JOIN product p ON lo.productid=p.productid
    INNER JOIN TypeProduct tp ON p.typeid=tp.typeid
    INNER JOIN subgroupproduct sgp ON tp.subgroupid=sgp.subgroupid
    INNER JOIN groupproduct gp ON sgp.groupid=gp.groupid
    WHERE gp.name='Напитки'
    GROUP BY p.namerus
    ORDER BY SUM(lo.Amount) DESC
    FETCH NEXT 1 ROWS ONLY;
    -- Устанавливаем выходной параметр
    drink := drink_cursor;
  END;
END;
/*Выводим данные*/
DECLARE
  drink_cursor SYS_REFCURSOR;
  НазваниеТовара VARCHAR(50);
BEGIN
  getPopularDrink(drink_cursor);
  LOOP
    FETCH drink_cursor INTO НазваниеТовара;
    EXIT WHEN drink_cursor%NOTFOUND;
    -- Обрабатываем данные
    DBMS_OUTPUT.PUT_LINE(НазваниеТовара);
  END LOOP;
  CLOSE drink_cursor;
END;
/*--------------------------------------------------------------------*/

/*Показать самый популярный десерт во всей сети кофеен*/
CREATE OR REPLACE PROCEDURE getPopularDessert(dessert OUT SYS_REFCURSOR)
AS
BEGIN
  -- Объявляем курсор
  DECLARE
    dessert_cursor SYS_REFCURSOR;
  BEGIN
    -- Открываем курсор
    OPEN dessert_cursor FOR
    SELECT p.namerus AS НазваниеТовара
    FROM LineOrder lo
    INNER JOIN Orders o ON lo.orderid=o.orderid
    INNER JOIN product p ON lo.productid=p.productid
    INNER JOIN TypeProduct tp ON p.typeid=tp.typeid
    INNER JOIN subgroupproduct sgp ON tp.subgroupid=sgp.subgroupid
    INNER JOIN groupproduct gp ON sgp.groupid=gp.groupid
    WHERE gp.name='Десерты'
    GROUP BY p.namerus
    ORDER BY SUM(lo.Amount) DESC
    FETCH NEXT 1 ROWS ONLY;
    -- Устанавливаем выходной параметр
    dessert := dessert_cursor;
  END;
END;
/*Выводим данные*/
DECLARE
  dessert_cursor SYS_REFCURSOR;
  НазваниеТовара VARCHAR(50);
BEGIN
  getPopularDessert(dessert_cursor);
  LOOP
    FETCH dessert_cursor INTO НазваниеТовара;
    EXIT WHEN dessert_cursor%NOTFOUND;
    -- Обрабатываем данные
    DBMS_OUTPUT.PUT_LINE(НазваниеТовара);
  END LOOP;
  CLOSE dessert_cursor;
END;
/*--------------------------------------------------------------------*/

/*Показать ТОП-3 напитков во всей сети кофеен;*/
CREATE OR REPLACE PROCEDURE getTop3Drink(drink OUT SYS_REFCURSOR)
AS
BEGIN
  -- Объявляем курсор
  DECLARE
    drink_cursor SYS_REFCURSOR;
  BEGIN
    -- Открываем курсор
    OPEN drink_cursor FOR
    SELECT p.namerus AS НазваниеТовара
    FROM LineOrder lo
    INNER JOIN Orders o ON lo.orderid=o.orderid
    INNER JOIN product p ON lo.productid=p.productid
    INNER JOIN TypeProduct tp ON p.typeid=tp.typeid
    INNER JOIN subgroupproduct sgp ON tp.subgroupid=sgp.subgroupid
    INNER JOIN groupproduct gp ON sgp.groupid=gp.groupid
    WHERE gp.name='Напитки'
    GROUP BY p.namerus
    ORDER BY SUM(lo.Amount) DESC
    FETCH NEXT 3 ROWS ONLY;
    -- Устанавливаем выходной параметр
    drink := drink_cursor;
  END;
END;
/*Выводим данные*/
DECLARE
  drink_cursor SYS_REFCURSOR;
  НазваниеТовара VARCHAR(50);
BEGIN
  getTop3Drink(drink_cursor);
  LOOP
    FETCH drink_cursor INTO НазваниеТовара;
    EXIT WHEN drink_cursor%NOTFOUND;
    -- Обрабатываем данные
    DBMS_OUTPUT.PUT_LINE(НазваниеТовара);
  END LOOP;
  CLOSE drink_cursor;
END;
/*--------------------------------------------------------------------*/

/*Показать ТОП-3 десертов во всей сети кофеен;;*/
CREATE OR REPLACE PROCEDURE getTop3Dessert(dessert OUT SYS_REFCURSOR)
AS
BEGIN
  -- Объявляем курсор
  DECLARE
    dessert_cursor SYS_REFCURSOR;
  BEGIN
    -- Открываем курсор
    OPEN dessert_cursor FOR
    SELECT p.namerus AS НазваниеТовара
    FROM LineOrder lo
    INNER JOIN Orders o ON lo.orderid=o.orderid
    INNER JOIN product p ON lo.productid=p.productid
    INNER JOIN TypeProduct tp ON p.typeid=tp.typeid
    INNER JOIN subgroupproduct sgp ON tp.subgroupid=sgp.subgroupid
    INNER JOIN groupproduct gp ON sgp.groupid=gp.groupid
    WHERE gp.name='Десерты'
    GROUP BY p.namerus
    ORDER BY SUM(lo.Amount) DESC
    FETCH NEXT 3 ROWS ONLY;
    -- Устанавливаем выходной параметр
    dessert := dessert_cursor;
  END;
END;
/*Выводим данные*/
DECLARE
  dessert_cursor SYS_REFCURSOR;
  НазваниеТовара VARCHAR(50);
BEGIN
  getTop3Dessert(dessert_cursor);
  LOOP
    FETCH dessert_cursor INTO НазваниеТовара;
    EXIT WHEN dessert_cursor%NOTFOUND;
    -- Обрабатываем данные
    DBMS_OUTPUT.PUT_LINE(НазваниеТовара);
  END LOOP;
  CLOSE dessert_cursor;
END;
/*--------------------------------------------------------------------*/

/*Показать бариста, который работал во всех точках сети;*/
CREATE OR REPLACE PROCEDURE getBaristaWorkedCoffeeHouse(cursors OUT SYS_REFCURSOR)
AS
BEGIN
  -- Объявляем курсор
  DECLARE
    barista_cursor SYS_REFCURSOR;
  BEGIN
      -- Открываем курсор
   OPEN barista_cursor FOR
   SELECT e.lastname || ' ' || e.firstname || ' ' || e.middleName AS ФИО
   FROM
   (SELECT e.employeeid, e.coffehouseid
    FROM Employee e
    INNER JOIN EmployeePost ep ON e.employeeid=ep.employeeid
    INNER JOIN Post p ON ep.postid=p.postid
    WHERE p.name='Бариста'
    UNION ALL
    SELECT e.employeeid, e.odlcoffehouseid AS coffehouseid
    FROM employee_archivework e
    INNER JOIN EmployeePost ep ON e.employeeid=ep.employeeid
    INNER JOIN Post p ON ep.postid=p.postid
    WHERE p.name='Бариста') info
   INNER JOIN Employee e ON info.employeeId=e.employeeid
   GROUP BY info.employeeId, e.lastname || ' ' || e.firstname || ' ' || e.middleName
   HAVING COUNT(DISTINCT info.coffehouseid)>=(SELECT COUNT(CoffeHouseId) FROM coffeHouse);
   -- Устанавливаем выходной параметр
    cursors:= barista_cursor;
  END;
 END;

 /*Выводим данные*/
DECLARE
  barista_cursor SYS_REFCURSOR;
  ФИО VARCHAR(50);
BEGIN
  getBaristaWorkedCoffeeHouse(barista_cursor);
  LOOP
    FETCH barista_cursor INTO ФИО;
    EXIT WHEN barista_cursor%NOTFOUND;
    -- Обрабатываем данные
    DBMS_OUTPUT.PUT_LINE(ФИО);
  END LOOP;
  CLOSE barista_cursor;
END;
/*--------------------------------------------------------------------*/

/*Реализуйте механизм "черного списка". В "черный список" могут быть помещены сотрудники сети, которых необходимо уволить и и в коем случае не брать на работу в любую точку сети*/

/*1. Модифицируем таблицу Employee. Добавляю столбец*/
ALTER TABLE Employee
ADD (BlackList CHAR(1)  DEFAULT('N') CHECK (BlackList IN ('N','Y')) NOT NULL);

/*2. Создаю хранимую процедуру,  с помощью которой можно будет ставить работника в черный список*/
CREATE OR REPLACE PROCEDURE setBlackListEmployee(findEmployeeId SMALLINT, setBlackList CHAR)
AS
BEGIN
 UPDATE Employee SET BlackList=setBlackList WHERE employeeId=findEmployeeId;
END;

/*3. Модифицирую ранее созданный триггер*/
/*Создаем триггер*/
CREATE OR REPLACE TRIGGER EmployeeCoffeHouseUpdate
BEFORE UPDATE ON Employee
FOR EACH ROW
BEGIN
IF( updating( 'CoffeHouseId' ) and :old.BlackList='N')
  THEN
    INSERT INTO Employee_ArchiveWork(EmployeeId, OdlCoffeHouseId, DateCreate)
    VALUES (:old.EmployeeId, :old.CoffeHouseId, TO_DATE(CURRENT_DATE, 'dd.mm.yyyy'));
  ELSE IF( updating( 'CoffeHouseId' ) and :old.BlackList='Y') 
       THEN
         DBMS_OUTPUT.PUT_LINE('Сотрудник в черном списке');
         raise_application_error(-20000, 'Сотрудник в черном списке'); 
       END IF;
  END IF;
END;
