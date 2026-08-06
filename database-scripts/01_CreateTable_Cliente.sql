CREATE TABLE Cliente (
                         Id INT IDENTITY(1,1) PRIMARY KEY,
                         Nome NVARCHAR(100) NOT NULL,
                         Documento NVARCHAR(14) NOT NULL UNIQUE,
                         Email NVARCHAR(100) NOT NULL UNIQUE,
                         DataCadastro DATETIME DEFAULT GETDATE(),
                         Ativo BIT DEFAULT 1
);