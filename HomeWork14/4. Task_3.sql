/*Удалить конкретный заказ*/
DELETE  Orders
WHERE OrderId=1;

/*Удалить заказы конктерного десерта*/
/*Ищем заказы (в подзапросе), где присутствует 'Торт "Балтийский"'. И удаляем заказы*/
DELETE Orders
WHERE OrderId IN (SELECT DISTINCT lp.orderId
                  FROM LineOrder lp
                  INNER JOIN Product pr ON lp.productId=pr.productId
                  WHERE NameRus='Торт "Балтийский"');

/*Удалить расписание работы на конкретный день*/
DELETE Schedule
WHERE to_date(ScheduleDate,'dd.mm.yy')='04.09.23';

/*Удалить расписание работы на конкретный промежуток между указанными датами*/
DELETE Schedule
WHERE ScheduleDate BETWEEN to_date(NEXT_DAY(CURRENT_DATE, 'Понедельник'),'dd.mm.yy') AND to_date(NEXT_DAY(CURRENT_DATE, 'Пятница'),'dd.mm.yy');

