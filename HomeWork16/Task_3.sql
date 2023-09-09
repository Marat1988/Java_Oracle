/*Показать информацию о заказах в конкретную дату*/
SELECT orderid AS НомерЗаказа, c.fullname AS Клиент
FROM Orders o
INNER JOIN Customer c ON o.customerid=c.customerid
WHERE TO_DATE(dateorder,'dd.mm.yy')=TO_DATE('09.09.23','dd.mm.yy');

/*Показать информацию в указанном промежутке дат*/
SELECT orderid AS НомерЗаказа, c.fullname AS Клиент
FROM Orders o
INNER JOIN Customer c ON o.customerid=c.customerid
WHERE TO_DATE(dateorder,'dd.mm.yy')BETWEEN TO_DATE('01.01.23','dd.mm.yy') AND TO_DATE('09.09.23','dd.mm.yy');

/*Показать количество заказов десерта в конкретную дату*/
SELECT SUM(lo.quantity) AS КоличествоЗаказовДесерта
FROM LineOrder lo
INNER JOIN Orders o ON lo.orderid=o.orderid
INNER JOIN Product p ON lo.productid=p.productid
INNER JOIN typeproduct tp ON p.typeid=tp.typeid
INNER JOIN subgroupproduct sp ON tp.subgroupid=sp.subgroupid
INNER JOIN groupproduct gp ON sp.groupid=gp.groupid
WHERE gp.name='Десерты' AND to_date(o.dateorder,'dd.mm.yy')=to_date('09.09.23','dd.mm.yy');


/*Показать количество заказов напитков в конкретную дату*/
SELECT SUM(lo.quantity) AS КоличествоЗаказовНапитков
FROM LineOrder lo
INNER JOIN Orders o ON lo.orderid=o.orderid
INNER JOIN Product p ON lo.productid=p.productid
INNER JOIN typeproduct tp ON p.typeid=tp.typeid
INNER JOIN subgroupproduct sp ON tp.subgroupid=sp.subgroupid
INNER JOIN groupproduct gp ON sp.groupid=gp.groupid
WHERE gp.name='Напитки' AND to_date(o.dateorder,'dd.mm.yy')=to_date('09.09.23','dd.mm.yy');