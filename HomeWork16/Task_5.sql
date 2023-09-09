/*Показать расписание работы конкретного бариста на неделю*/
SELECT e.lastname || ' ' || e.firstname AS ФИО_сотрудника, se.scheduledate AS Дата, se.timebegin AS Время_начала,
se.timebegin AS Время_окончания
FROM ScheduleEmployee se
INNER JOIN employee e ON se.employeeid=e.employeeid
INNER JOIN EmployeePost ep ON e.employeeid=ep.employeeid
INNER JOIN Post p ON ep.postid=p.postid
WHERE p.name='Бариста'
      AND e.employeeid=1 
      AND to_DATE(se.scheduledate, 'dd.mm.yyyy')
          BETWEEN to_DATE(CURRENT_DATE, 'dd.mm.yyyy')
                  AND to_DATE(CURRENT_DATE+7, 'dd.mm.yyyy');
                  
/*Показать расписание работы всех бариста на неделю*/
SELECT e.lastname || ' ' || e.firstname AS ФИО_сотрудника, se.scheduledate AS Дата, se.timebegin AS Время_начала,
se.timebegin AS Время_окончания
FROM ScheduleEmployee se
INNER JOIN employee e ON se.employeeid=e.employeeid
INNER JOIN EmployeePost ep ON e.employeeid=ep.employeeid
INNER JOIN Post p ON ep.postid=p.postid
WHERE p.name='Бариста'
      AND to_DATE(se.scheduledate, 'dd.mm.yyyy')
          BETWEEN to_DATE(CURRENT_DATE, 'dd.mm.yyyy')
                  AND to_DATE(CURRENT_DATE+7, 'dd.mm.yyyy');

/*Показать расписание работы для всех работников кафе на неделю*/
SELECT e.lastname || ' ' || e.firstname AS ФИО_сотрудника, se.scheduledate AS Дата, se.timebegin AS Время_начала,
se.timebegin AS Время_окончания
FROM ScheduleEmployee se
INNER JOIN employee e ON se.employeeid=e.employeeid
INNER JOIN EmployeePost ep ON e.employeeid=ep.employeeid
INNER JOIN Post p ON ep.postid=p.postid
WHERE to_DATE(se.scheduledate, 'dd.mm.yyyy') BETWEEN to_DATE(CURRENT_DATE, 'dd.mm.yyyy') AND to_DATE(CURRENT_DATE+7, 'dd.mm.yyyy');

