package com.com.jessiezan.ecommerce.services;

import java.util.List;

import com.com.jessiezan.ecommerce.model.Produto;

public interface IProdutoService {
	public List<Produto> recuperarTodos();
	public Produto recuperarPeloId(Integer id);
}
