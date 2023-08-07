-- Insert dummy data into the User table
INSERT INTO Users (Id, Name, Email, Role)
VALUES (1, 'John Doe', 'john@example.com', 'User'),
   (2, 'Jane Smith', 'jane@example.com', 'Admin');
-- Insert dummy data into the Book table
INSERT INTO Book (Id, Book_Name)
VALUES (1, 'Book A'),
   (2, 'Book B'),
   (3, 'Book C');
-- Insert dummy data into the BookUser table (assigning books to users)
INSERT INTO Book_User (id, Book_Id, User_Id)
VALUES (1,1, 1),
   (2,2, 1),
   (3,2, 2);
-- Insert dummy data into the Counterparty table
INSERT INTO Counterparty (Id, Name)
VALUES (1, 'Counterparty A'),
   (2, 'Counterparty B');
-- Insert dummy data into the Security table
INSERT INTO Security (
      Id,
      ISIN,
      CUSIP,
      Issuer,
      Maturity_Date,
      Coupon,
      Type,
      Face_Value,
      Status
   )
VALUES (
      1,
      'ISIN001',
      'CUSIP001',
      'Issuer A',
      '2025-08-01',
      5.25,
      'Type A',
      1000,
      'Active'
   ),
   (
      2,
      'ISIN002',
      'CUSIP002',
      'Issuer B',
      '2024-12-01',
      4.75,
      'Type B',
      500,
      'Inactive'
   );
-- Insert dummy data into the Trade table
INSERT INTO Trade (
      Id,
      Book_Id,
      Counterparty_Id,
      Security_Id,
      Quantity,
      Status,
      Price,
      Buy_Sell,
      Trade_Date,
      Settlement_Date
   )
VALUES (
      1,
      1,
      1,
      1,
      100,
      'Open',
      102.50,
      'Buy',
      '2023-08-04',
      '2023-08-10'
   ),
   (
      2,
      2,
      2,
      2,
      50,
      'Pending',
      97.75,
      'Sell',
      '2023-08-04',
      '2023-08-12'
   );