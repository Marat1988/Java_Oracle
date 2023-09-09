/*Показать минимальную скидку для клиента;*/
SELECT MIN(DISCOUNT) AS МинимальнаяСкидка
FROM Customer;

/*Показать максимальную скидку для клиента;*/
SELECT MAX(DISCOUNT) AS МаксималльнаяСкидка
FROM Customer;

/*Показать клиентов с минимальной скидкой и величину скидки*/
SELECT CustomerId, FullName AS Клиент, DISCOUNT
FROM Customer
WHERE DISCOUNT=(SELECT MIN(DISCOUNT) FROM Customer);

/*Показать клиентов с максимальной скидкой и величину скидки*/
SELECT CustomerId, FullName AS Клиент, DISCOUNT
FROM Customer
WHERE DISCOUNT=(SELECT MAX(DISCOUNT) FROM Customer);

/*Показать среднюю величину скидки.*/
SELECT AVG(DISCOUNT) AS СредняяСкидка
FROM Customer;

