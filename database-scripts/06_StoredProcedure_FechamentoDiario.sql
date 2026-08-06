CREATE TABLE FaturamentoDiario (
                                   Id INT IDENTITY(1,1) PRIMARY KEY,
                                   DataFechamento DATE NOT NULL UNIQUE,
                                   TotalVendas DECIMAL(18,2) NOT NULL,
                                   QuantidadePedidos INT NOT NULL,
                                   ProcessadoEm DATETIME DEFAULT GETDATE()
);
GO

CREATE PROCEDURE sp_ProcessarFaturamentoDiario
    @DataReferencia DATE
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @Total DECIMAL(18,2);
    DECLARE @Qtd INT;

SELECT
    @Total = ISNULL(SUM(Total), 0.00),
    @Qtd = COUNT(Id)
FROM Pedido
WHERE CAST(DataPedido AS DATE) = @DataReferencia
  AND Status = 'Concluido';

IF EXISTS (SELECT 1 FROM FaturamentoDiario WHERE DataFechamento = @DataReferencia)
BEGIN
UPDATE FaturamentoDiario
SET TotalVendas = @Total,
    QuantidadePedidos = @Qtd,
    ProcessadoEm = GETDATE()
WHERE DataFechamento = @DataReferencia;
END
ELSE
BEGIN
INSERT INTO FaturamentoDiario (DataFechamento, TotalVendas, QuantidadePedidos)
VALUES (@DataReferencia, @Total, @Qtd);
END
END;