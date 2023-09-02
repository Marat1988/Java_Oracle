/*Показать все заказы конкретного десетра*/
/*'Торт "Балтийский" - это десерт. Поэтому ищу все заказы, где он присутствует*/
SELECT lp.orderid AS Номер_заказа, lp.PriceClient AS Цена_Клиента, Quantity AS Количество, Amount AS Сумма
FROM LineOrder lp
INNER JOIN Product pr ON lp.productId=pr.productId
WHERE NameRus='Торт "Балтийский"';

/*Показать расписание работы на конкретный день*/
SELECT *
FROM Schedule
WHERE to_date(ScheduleDate,'dd.mm.yy')='04.09.23';

/*Показать все заказы конкретного официанта*/
/*e.employeeid=2 - это официант.*/
SELECT ors.orderid AS Номер_заказа, ors.dateorder AS Дата_заказа, c.fullname AS ФИО_Клиента, e.firstname AS Имя_официанта
FROM Orders ors
INNER JOIN Employee e ON ors.employeeid=e.employeeid
INNER JOIN Customer c ON ors.customerid=c.customerid
WHERE e.employeeid=2;

/*Показать все заказы конкретного клиента*/
SELECT ors.orderid AS Номер_заказа, ors.dateorder AS Дата_заказа, c.fullname AS ФИО_Клиента, e.firstname AS Имя_официанта
FROM Orders ors
INNER JOIN Employee e ON ors.employeeid=e.employeeid
INNER JOIN Customer c ON ors.customerid=c.customerid
WHERE c.customerid=1;
