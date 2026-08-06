package com.sales.api.service;

import com.sales.api.entity.Produto;
import com.sales.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Integer id) {
        return produtoRepository.findById(id);
    }

    public Produto salvar(Produto produto) {
        // Regra de negócio simples: garantir que não cadastre com preço negativo
        if (produto.getPreco().signum() < 0) {
            throw new IllegalArgumentException("O preço do produto não pode ser negativo.");
        }
        return produtoRepository.save(produto);
    }
}