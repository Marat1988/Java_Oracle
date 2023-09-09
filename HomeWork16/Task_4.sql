
/*Показать информацию о клиентах, которые заказывали напитки сегодня.
Кроме информации о клиенте, нужно показывать информацию о бариста, который сделал напиток*/
SELECT c.fullname AS Клиент, os.orderId AS НомерЗаказа, c.telephone AS НомерТелефона, o.priceclient AS Цена, o.quantity AS Количество, o.amount AS Сумма,
e.lastname || ' ' || e.firstname AS ФИО_Бариста
FROM lineorder o
INNER JOIN orders os ON o.orderid=os.orderid
INNER JOIN employee e ON o.employeeid=e.employeeid
INNER JOIN customer c ON os.customerid=c.customerid
INNER JOIN Product p ON o.productid=p.productid
INNER JOIN typeproduct tp ON p.typeid=tp.typeid
INNER JOIN subgroupproduct sgp ON tp.subgroupid=sgp.subgroupid
INNER JOIN groupproduct gp ON sgp.groupid=gp.groupid
WHERE to_date(os.dateorder,'dd.mm.yy')=to_date(CURRENT_DATE,'dd.mm.yy') AND gp.name='Напитки';

/*Показать среднюю сумму заказа в конкретную дату*/
SELECT AVG(amount) AS СредняяСуммаЗаказа
FROM lineorder lo
INNER JOIN Orders o ON lo.orderid=o.orderid
WHERE to_date(o.dateorder,'dd.mm.yy')=to_date('09.09.23','dd.mm.yy');

/*Показать максимальную сумму заказа в конкретную дату*/
SELECT MAX(ord.Сумма) AS МаксимальнаяСуммаЗаказа
FROM
(SELECT o.orderid, SUM(lo.amount) AS Сумма
 FROM lineorder lo
 INNER JOIN Orders o ON lo.orderid=o.orderid
 WHERE to_date(o.dateorder,'dd.mm.yy')=to_date('09.09.23','dd.mm.yy')
 GROUP BY o.orderid) ord;

/*Показать клиента, который совершил максимальную сумму заказа в конкретную дату*/
SELECT c.fullname, SUM(lo.amount) AS Сумма
FROM lineOrder lo
INNER JOIN Orders o ON lo.orderid=o.orderid
INNER JOIN Customer c ON o.customerid=c.customerid
WHERE to_date(o.dateorder,'dd.mm.yy')=to_date('09.09.23','dd.mm.yy')
GROUP BY c.fullname
ORDER BY 2 DESC
FETCH NEXT 1 ROWS ONLY

