/*Создавим архивную таблицу удаления товаров*/
CREATE TABLE Product_ARCHIVE
(
    ProductId INT NOT NULL, --Первичный ключ
    NameRus VARCHAR(100),
    NameEng VARCHAR(100),
    Price NUMBER(8,2), 
    TypeId SMALLINT, 
    CONSTRAINT PK_ProductARCHIVE_ProductId PRIMARY KEY(ProductId)
);

/*При удалении напитка вносить информацию о нем в архивную таблицу
и
При удалении десета вносить информацию о нем в архивную таблицу
Один триггер на обе задачи
*/
CREATE OR REPLACE TRIGGER ProductAfterDeleteDrinksDesserts
BEFORE DELETE ON Product
REFERENCING OLD AS deleted
FOR EACH ROW
BEGIN
   INSERT INTO Product_ARCHIVE (ProductId, NameRus, NameEng, Price, TypeId)
   VALUES (:deleted.productId, :deleted.NameRus, :deleted.NameEng, :deleted.Price, :deleted.TypeId);
END;

/*При переводе работника из одной кофейни в другую, заносить информацию о переводе в специальную таблицу*/

/*Создаем таблицу*/
CREATE TABLE Employee_ArchiveWork --Таблица предыдущих работ сотрудников
(
    EmployeeId INT NOT NULL,
    OdlCoffeHouseId SMALLINT,
    DateCreate DATE
);


/*Создаем триггер*/
CREATE OR REPLACE TRIGGER EmployeeCoffeHouseUpdate
BEFORE UPDATE ON Employee
FOR EACH ROW
BEGIN
IF( updating( 'CoffeHouseId' ) )
  THEN
    INSERT INTO Employee_ArchiveWork(EmployeeId, OdlCoffeHouseId, DateCreate)
    VALUES (:old.EmployeeId, :old.CoffeHouseId, TO_DATE(CURRENT_DATE, 'dd.mm.yyyy'));
  END IF;
END;


