-- create database and use it
--CREATE DATABASE NasaPictures
--GO
--USE NasaPictures
--GO
--

------------------
------TABLES------
------------------

-- Create User table
CREATE TABLE Udata
(
	ID INT PRIMARY KEY IDENTITY,
	Uname NVARCHAR(300) UNIQUE,
	UPass NVARCHAR(300),
	Utype INT CHECK (Utype IN (0, 1))
)
GO
--

-- create Category table and fill it with default values
CREATE TABLE Category (
	ID INT PRIMARY KEY IDENTITY,
	Name NVARCHAR(40)
)
GO
INSERT INTO Category (name) VALUES
('Earth'),
('Jupiter'),
('Mars'),
('Mercury'),
('Neptune'),
('Pluto'),
('Saturn'),
('Sun'),
('Uranus'),
('Venus'),
('Asteroids & Comets'),
('Spacecraft & Telescopes'),
('The Universe');
GO
--

--create Article table
CREATE TABLE Article
(
	IDArticle INT PRIMARY KEY IDENTITY,
	Title NVARCHAR(300),
	Link NVARCHAR(300),
	Description NVARCHAR(900),
	PicturePath NVARCHAR(90),
	Category INT FOREIGN KEY REFERENCES Category(ID)
)
GO
--

------------------
----PROCEDURES----
------------------

--check user
CREATE PROCEDURE checkUser
    @Uname NVARCHAR(300),
    @Upass NVARCHAR(300),
    @Utype INT OUTPUT
AS 
BEGIN
    SET @Utype = -1;
    SELECT @Utype = Utype 
    FROM Udata 
    WHERE Uname = @Uname AND UPass = @Upass;
END
GO
--

--create user
CREATE PROCEDURE createUser
	@Uname NVARCHAR(300),
	@Upass NVARCHAR(300),
	@Utype INT
AS 
BEGIN 
	INSERT INTO Udata VALUES(@Uname, @Upass, @Utype)
END
GO
--

--create admin user
EXEC createUser @Uname = N'dbele', @Upass = N'belecasni', @Utype = N'1';
GO
--

-- create Article
CREATE PROCEDURE createArticle
	@Title NVARCHAR(300),
	@Link NVARCHAR(300),
	@Description NVARCHAR(900),
	@PicturePath NVARCHAR(90),
	@Category NVARCHAR(90),
	@IDArticle INT OUTPUT
AS 
BEGIN 
	INSERT INTO Article VALUES(@Title, @Link, @Description, @PicturePath, (select ID from Category where Name = @Category))
	SET @IDArticle = SCOPE_IDENTITY()
END
GO
--

--DELETE ALL ARTICLES
CREATE PROCEDURE deleteAllArticles
AS
BEGIN
DELETE FROM Article
END
GO
--

--UPDATE ARTICLE
CREATE PROCEDURE updateArticle
	@Title NVARCHAR(300),
	@Link NVARCHAR(300),
	@Description NVARCHAR(900),
	@PicturePath NVARCHAR(90),
	@Category NVARCHAR(90),
	@IDArticle INT
AS 
BEGIN 
	UPDATE Article SET 
		Title = @Title,
		Link = @Link,
		Description = @Description,
		PicturePath = @PicturePath,
		Category = (select ID from Category where Name = @Category)		
	WHERE 
		IDArticle = @IDArticle
END
GO
--

--DELETE ONE ARTICLE
CREATE PROCEDURE deleteArticle
	@IDArticle INT	 
AS 
BEGIN 
	DELETE  
	FROM 
			Article
	WHERE 
		IDArticle = @IDArticle
END
GO
--

--SELECT ONE ARTICLE
CREATE PROCEDURE selectArticle
	@IDArticle INT
AS 
BEGIN 
	SELECT 
		a.IDArticle, a.Title, a.Link, a.Description, a.PicturePath, c.Name as 'Category' 
	FROM Article as a inner join Category as c 
	on a.Category=c.ID
	WHERE 
		IDArticle = @IDArticle
END
GO
--

--SELECT ALL ARTICLES
CREATE PROCEDURE selectArticles
AS 
BEGIN 
	SELECT a.IDArticle, a.Title, a.Link, a.Description, a.PicturePath, c.Name as Category
	FROM Article 
	as a inner join Category as c 
	on a.Category=c.ID
END
GO
--

-- select all categories
CREATE PROCEDURE selectAllCategories
AS 
BEGIN 
	SELECT Name FROM Category
END
GO
--

-- create new category
CREATE PROCEDURE createCategory
	@Name NVARCHAR(50)
AS 
BEGIN 
	INSERT INTO Category VALUES(@Name)
END
GO
--

-- get all users
CREATE PROCEDURE getAllUsers
AS 
BEGIN 
	SELECT Uname FROM Udata where Utype != 1
END
GO
--

-- promote users
CREATE PROCEDURE promoteUsers
    @Uname NVARCHAR(50)
AS 
BEGIN 
    UPDATE Udata
    SET Utype = 1 
    WHERE Uname = @Uname
END
GO
--