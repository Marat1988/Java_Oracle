SET SERVEROUTPUT ON;

/*Процедура добавления строки заказа*/
CREATE OR REPLACE PROCEDURE up_ins_Order (NewDateOrder DATE, NewCustomerId INT, NewEmployeeId INT)
AS
BEGIN
    INSERT INTO Orders (DateOrder, CustomerId, EmployeeId)
    VALUES (NewDateOrder, NewCustomerId, NewEmployeeId);
END;

/*Процедура изменения строки заказа*/
CREATE OR REPLACE PROCEDURE up_upd_Order (FindOrderId INT, NewDateOrder DATE, NewCustomerId INT, NewEmployeeId INT)
AS
BEGIN
    UPDATE Orders SET DateOrder=NewDateOrder, CustomerId=NewCustomerId, EmployeeId=NewEmployeeId
    WHERE orderid=FindOrderId;
END;

/*Процедура удаления строки заказа*/
CREATE OR REPLACE PROCEDURE up_del_Order (FindOrderId INT)
AS
BEGIN
    DELETE FROM Orders WHERE orderid=FindOrderId;
END;

/*Процедура добавления строки расписания*/
CREATE OR REPLACE PROCEDURE up_ins_Schedule (NewSheduleDate DATE, newTimeBegin INTERVAL DAY TO SECOND, newTimeEnd INTERVAL DAY TO SECOND)
AS
BEGIN
    INSERT INTO Schedule (ScheduleDate, TimeBegin, TimeEnd)
    VALUES (NewSheduleDate, newTimeBegin, newTimeEnd);
END;

/*Процедура обновления строки расписания*/
CREATE OR REPLACE PROCEDURE up_upd_Schedule (FindSheduleDate DATE, newSheduleDate DATE, newTimeBegin INTERVAL DAY TO SECOND, newTimeEnd INTERVAL DAY TO SECOND)
AS
BEGIN
    UPDATE Schedule SET ScheduleDate=newSheduleDate, TimeBegin=newTimeBegin, TimeEnd=newTimeEnd
    WHERE ScheduleDate=FindSheduleDate;
END;
--EXEC up_upd_Schedule (to_date('020923','ddmmyy'), to_date('030923','ddmmyy'), '0 8:10:00', '0 18:00:00')

/*Процедура удаления строки расписания*/
CREATE OR REPLACE PROCEDURE up_del_Schedule (FindSheduleDate DATE)
AS
BEGIN
    DELETE Schedule WHERE ScheduleDate=FindSheduleDate;
END;

/*Процедура вывода данных о заказах у сотрудника*/
CREATE OR REPLACE PROCEDURE getShowOrderEmployee(findEmployeeId IN NUMBER, employees OUT SYS_REFCURSOR)
AS
BEGIN
  -- Объявляем курсор
  DECLARE
    employees_cursor SYS_REFCURSOR;
  BEGIN
    -- Открываем курсор
    OPEN employees_cursor FOR
    SELECT ors.orderid AS Номер_заказа, ors.dateorder AS Дата_заказа, c.fullname AS ФИО_Клиента, e.firstname AS Имя_официанта
    FROM Orders ors
    INNER JOIN Employee e ON ors.employeeid=e.employeeid
    INNER JOIN Customer c ON ors.customerid=c.customerid
    WHERE e.employeeid=findEmployeeId;
    -- Устанавливаем выходной параметр
    employees := employees_cursor;
  END;
END;

/*Выводим данные*/
DECLARE
  emp_cursor SYS_REFCURSOR;
  Номер_заказа INT;
  Дата_заказа DATE;
  ФИО_Клиента VARCHAR(50);
  Имя_официанта VARCHAR(50);
BEGIN
  getShowOrderEmployee(2, emp_cursor); -- получаем все заказы сотрудника с id равное 2
  LOOP
    FETCH emp_cursor INTO Номер_заказа, Дата_заказа, ФИО_Клиента, Имя_официанта;
    EXIT WHEN emp_cursor%NOTFOUND;
    -- Обрабатываем данные
    DBMS_OUTPUT.PUT_LINE('Номер_заказа: ' || Номер_заказа || ', ' || Дата_заказа || ' ' || ФИО_Клиента || ' ' || Имя_официанта);
  END LOOP;
  CLOSE emp_cursor;
END;


