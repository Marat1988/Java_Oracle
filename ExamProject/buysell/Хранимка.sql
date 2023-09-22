USE [buysell]
GO

/****** Object:  StoredProcedure [dbo].[up_ins_createOrder]    Script Date: 19.09.23 18:26:49 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO





CREATE PROCEDURE [dbo].[up_ins_createOrder](@UserId BIGINT, @Comment VARCHAR(255))
AS
DECLARE @Код BIGINT
BEGIN TRAN
INSERT INTO orders (comment, date_of_created, [user_id])
VALUES (@Comment, GETDATE(), @UserId)
SET @Код=ISNULL(SCOPE_IDENTITY()*(1-SIGN(@@ERROR)),0)
IF @Код!=0
BEGIN
 INSERT lineorder (amount, price, quantity, order_id, productline_id)
 SELECT c.price*c.quantity AS amount, c.price, c.quantity, @Код, c.product_id
 FROM recycler c
 WHERE [user_id]=@UserId
 IF @@ERROR=0 AND @@ROWCOUNT>0
 BEGIN
  DELETE FROM recycler WHERE [user_id]=@UserId
  IF @@ERROR=0 AND @@ROWCOUNT>0
  BEGIN
   COMMIT TRAN
   RETURN Sign(@Код) 
  END
  ELSE
  BEGIN
   ROLLBACK TRAN RETURN -2
  END
 END
 ELSE
 BEGIN
  ROLLBACK TRAN RETURN -2
 END
END
ELSE
BEGIN
 ROLLBACK TRAN RETURN -2
END
GO


