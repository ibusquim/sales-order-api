package com.sales.api.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    // Relacionamento ManyToOne: Muitos pedidos podem pertencer a um mesmo Cliente
    @ManyToOne
    @JoinColumn(name = "ClienteId", nullable = false)
    private Cliente cliente;

    @Column(name = "DataPedido", insertable = false, updatable = false)
    private LocalDateTime dataPedido;

    @Column(name = "Status", nullable = false, insertable = false)
    private String status;

    @Column(name = "Total", nullable = false, insertable = false)
    private BigDecimal total;

    public Pedido() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public LocalDateTime getDataPedido() { return dataPedido; }
    public void setDataPedido(LocalDateTime dataPedido) { this.dataPedido = dataPedido; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
}