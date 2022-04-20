package com.com.jessiezan.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.com.jessiezan.ecommerce.dao.PedidoDAO;
import com.com.jessiezan.ecommerce.model.ItemPedido;
import com.com.jessiezan.ecommerce.model.Pedido;


@Component
@Qualifier("dia-a-dia")
public class PedidoServiceImpl implements IPedidoService{
	
	@Autowired
	private PedidoDAO dao;

	@Override
	public Pedido adicionarPedido(Pedido novo) {
		System.out.println(novo);
     for(ItemPedido item: novo.getItens()) {
			item.setPedido(novo);
		}
		
		Pedido resultado = dao.save(novo);
		return resultado;
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
