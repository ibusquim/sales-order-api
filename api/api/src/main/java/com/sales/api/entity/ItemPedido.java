package com.sales.api.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ItemPedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    // Relacionamento: Cada item pertence a um Pedido específico
    @ManyToOne
    @JoinColumn(name = "PedidoId", nullable = false)
    private Pedido pedido;

    // Relacionamento: Cada item representa um Produto específico
    @ManyToOne
    @JoinColumn(name = "ProdutoId", nullable = false)
    private Produto produto;

    @Column(name = "Quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "PrecoUnitario", nullable = false, precision = 18, scale = 2)
    private BigDecimal precoUnitario;

    public ItemPedido() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Pedido getPedido() { return pedido; }
    public void setPedido(Pedido pedido) { this.pedido = pedido; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public BigDecimal getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(BigDecimal precoUnitario) { this.precoUnitario = precoUnitario; }
}