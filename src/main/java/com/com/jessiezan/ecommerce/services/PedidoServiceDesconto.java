package com.com.jessiezan.ecommerce.services;

import com.com.jessiezan.ecommerce.dao.PedidoDAO;
import com.com.jessiezan.ecommerce.model.ItemPedido;
import com.com.jessiezan.ecommerce.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("desconto")
public class PedidoServiceDesconto implements IPedidoService {
	
	@Autowired
	private PedidoDAO dao;

	@Override
	public Pedido adicionarPedido(Pedido novo) {
		// Nova logica para criar pedidod com desconto
		
		for(ItemPedido item: novo.getItens()) {
			item.setPedido(novo);
		}
		
		if(novo.getValorBruto() >= 1000.00) {
			double desconto = novo.getValorBruto() * 0.1;	
			novo.setDesconto(desconto);
			novo.setValorTotal(novo.getValorBruto() - desconto);
		}
		Pedido p = dao.save(novo);
		return p;
	}

	@Override
	public boolean removerPedido(Integer id) {
		try {
			dao.deleteById(id);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}



}
