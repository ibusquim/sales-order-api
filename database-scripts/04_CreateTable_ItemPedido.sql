CREATE TABLE ItemPedido (
                            Id INT IDENTITY(1,1) PRIMARY KEY,
                            PedidoId INT NOT NULL,
                            ProdutoId INT NOT NULL,
                            Quantidade INT NOT NULL,
                            PrecoUnitario DECIMAL(18,2) NOT NULL,
                            CONSTRAINT FK_ItemPedido_Pedido FOREIGN KEY (PedidoId) REFERENCES Pedido(Id),
                            CONSTRAINT FK_ItemPedido_Produto FOREIGN KEY (ProdutoId) REFERENCES Produto(Id)
);