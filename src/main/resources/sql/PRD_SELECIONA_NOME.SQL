CREATE PROCEDURE SelectPerson @name nvarchar(30)
AS
SELECT * FROM person WHERE name like @name
GO