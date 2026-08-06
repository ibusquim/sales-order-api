package com.sales.api.service;

import com.sales.api.entity.Pedido;
import com.sales.api.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPorId(Integer id) {
        return pedidoRepository.findById(id);
    }

    public Pedido salvar(Pedido pedido) {
        // A lógica de soma dos itens e baixa de estoque entrará aqui nas próximas etapas
        return pedidoRepository.save(pedido);
    }
}