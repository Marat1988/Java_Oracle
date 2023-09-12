/*Показать информацию обо всех кофейнях;*/
SELECT *
FROM CoffeHouse;

/*Показать напитки, которые есть во всех кофейнях;*/
SELECT cf.name  AS НазваниеКофейни, gp.name AS ГруппаТовара, p.productId, p.nameRus AS Русское_название, p.nameEng AS Английское_название, NVL(p.price, tp.price) AS Цена_товара
FROM CoffeHouse cf
INNER JOIN GroupProduct gp ON cf.coffehouseid=gp.coffehouseid
INNER JOIN subgroupproduct sgp ON gp.groupid=sgp.groupid
INNER JOIN typeProduct tp ON sgp.subgroupid=tp.subgroupid
INNER JOIN Product p ON tp.typeid=p.typeid
WHERE gp.name LIKE '%Напитки%'
ORDER BY 1,4

/*Показать десерты, которые есть во всех кофейнях;*/
SELECT cf.name  AS НазваниеКофейни, gp.name AS ГруппаТовара, p.productId, p.nameRus AS Русское_название, p.nameEng AS Английское_название, NVL(p.price, tp.price) AS Цена_товара
FROM CoffeHouse cf
INNER JOIN GroupProduct gp ON cf.coffehouseid=gp.coffehouseid
INNER JOIN subgroupproduct sgp ON gp.groupid=sgp.groupid
INNER JOIN typeProduct tp ON sgp.subgroupid=tp.subgroupid
INNER JOIN Product p ON tp.typeid=p.typeid
WHERE gp.name LIKE '%Десерты%'
ORDER BY 1,4

/*Показать информацию о баристах во всех кафейнях*/
SELECT cf.name AS Название_Кофейни, ep.*
FROM CoffeHouse cf
INNER JOIN Employee ep ON cf.coffehouseid=ep.coffehouseid
INNER JOIN EmployeePost eps ON ep.employeeid=eps.employeeid
INNER JOIN Post p ON eps.PostId=p.PostId
WHERE p.name='Бариста'

/*Показать информацию о официантах во всех кафейнях*/
SELECT cf.name AS Название_Кофейни, ep.*
FROM CoffeHouse cf
INNER JOIN Employee ep ON cf.coffehouseid=ep.coffehouseid
INNER JOIN EmployeePost eps ON ep.employeeid=eps.employeeid
INNER JOIN Post p ON eps.PostId=p.PostId
WHERE p.name='Официант'