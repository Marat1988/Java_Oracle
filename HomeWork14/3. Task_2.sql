/*Сначала добавим расписание на ближайший вторник*/
INSERT INTO Schedule (ScheduleDate, TimeBegin, TimeEnd)
SELECT NEXT_DAY(CURRENT_DATE, 'Вторник') AS ScheduleDate,  '0 8:00:00' AS TimeBegin,  '0 18:10:00' AS TimeEnd
FROM Dual;

/*Изменить расписание работы на ближайший вторник*/
UPDATE Schedule SET TimeBegin='0 9:00:00',
                    TimeEnd='0 17:00:00'
WHERE to_date(ScheduleDate,'dd.mm.yy')=to_date(NEXT_DAY(CURRENT_DATE, 'Вторник'),'dd.mm.yy');

/*Изменить название уже существующего вида кофе*/
UPDATE TypeProduct SET NameRus='Кофейные напитки с молочной примесью'
WHERE NameRus='Кофейные напитки с молоком';

/*Изменить  информацию в существующем заказе*/
UPDATE LineOrder SET Quantity=5 WHERE OrderId=1 AND ProductId=3;

/*Изменит название уже существующего дисерта.*/
/*Торт «Ленинградский» входит в десерты. Поэтому меняю его название*/
UPDATE Product SET NameRus='Торт "Балтийский"', NameEng='cake "Baltic"'
WHERE NameRus='Торт «Ленинградский»';