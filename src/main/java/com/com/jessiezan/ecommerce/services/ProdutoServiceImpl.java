package com.com.jessiezan.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.com.jessiezan.ecommerce.dao.ProdutoDAO;
import com.com.jessiezan.ecommerce.model.Produto;

@Component
public class ProdutoServiceImpl implements IProdutoService{
	
	@Autowired
	private ProdutoDAO dao;

	@Override
	public List<Produto> recuperarTodos() {
		return (List<Produto>)dao.findAll();
	}

	@Override
	public Produto recuperarPeloId(Integer id) {
		return dao.findById(id).orElse(null);
	}

}
