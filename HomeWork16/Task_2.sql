/*ѕоказать самого молодого клиента;*/
SELECT  *
FROM Customer
ORDER BY BirthDAY DESC
FETCH NEXT 1 ROWS ONLY;

/*ѕоказать самого возрастного клиента;*/
SELECT  *
FROM Customer
ORDER BY BirthDAY
FETCH NEXT 1 ROWS ONLY;

/*ѕоказать клиентов, у которых день рождени¤ в этот день*/
SELECT *
FROM Customer
WHERE TO_DATE(birthday,'dd.mm.yy')=TO_DATE('13.04.88', 'dd.mm.yy');

/*ѕоказать клиентов, у которых не заполнен почтовый адрес*/
SELECT *
FROM Customer
WHERE EMAIL IS NULL







