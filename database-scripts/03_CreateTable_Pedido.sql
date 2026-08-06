CREATE TABLE Pedido (
                        Id INT IDENTITY(1,1) PRIMARY KEY,
                        ClienteId INT NOT NULL,
                        DataPedido DATETIME DEFAULT GETDATE(),
                        Status NVARCHAR(50) NOT NULL DEFAULT 'Pendente',
                        Total DECIMAL(18,2) NOT NULL DEFAULT 0.00,
                        CONSTRAINT FK_Pedido_Cliente FOREIGN KEY (ClienteId) REFERENCES Cliente(Id)
);