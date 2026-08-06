CREATE TABLE Produto (
                         Id INT IDENTITY(1,1) PRIMARY KEY,
                         Nome NVARCHAR(150) NOT NULL,
                         Descricao NVARCHAR(500),
                         Preco DECIMAL(18,2) NOT NULL,
                         Estoque INT NOT NULL DEFAULT 0,
                         Ativo BIT DEFAULT 1
);