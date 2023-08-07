DROP TABLE IF EXISTS Users;
-- Create the User table
CREATE TABLE Users (
    Id INT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    Role VARCHAR(50)
);

DROP TABLE IF EXISTS Book;
-- Create the Book table
CREATE TABLE Book (
    Id INT PRIMARY KEY,
    BookName VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS BookUser;
-- Create the BookUser table (Many-to-Many relationship between Book and User)
CREATE TABLE BookUser (
    BookId INT NOT NULL,
    UserId INT NOT NULL,
    PRIMARY KEY (BookId, UserId),
    FOREIGN KEY (BookId) REFERENCES Book(Id),
    FOREIGN KEY (UserId) REFERENCES Users(Id)
);

DROP TABLE IF EXISTS Counterparty;
-- Create the Counterparty table
CREATE TABLE Counterparty (
    Id INT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS Security;
-- Create the Security table
CREATE TABLE Security (
    Id INT PRIMARY KEY,
    ISIN VARCHAR(50) NOT NULL,
    CUSIP VARCHAR(50) NOT NULL,
    Issuer VARCHAR(255) NOT NULL,
    MaturityDate DATE,
    Coupon FLOAT,
    Type VARCHAR(50),
    FaceValue FLOAT,
    Status VARCHAR(50)
);

DROP TABLE IF EXISTS Trade;
-- Create the Trade table
CREATE TABLE Trade (
    Id INT PRIMARY KEY,
    BookId INT NOT NULL,
    CounterpartyId INT NOT NULL,
    SecurityId INT NOT NULL,
    Quantity INT,
    Status VARCHAR(50),
    Price FLOAT,
    Buy_Sell VARCHAR(10),
    TradeDate DATE,
    SettlementDate DATE,
    FOREIGN KEY (BookId) REFERENCES Book(Id),
    FOREIGN KEY (CounterpartyId) REFERENCES Counterparty(Id),
    FOREIGN KEY (SecurityId) REFERENCES Security(Id)
);