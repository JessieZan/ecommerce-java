package com.com.jessiezan.ecommerce.services;

import com.com.jessiezan.ecommerce.model.Pedido;

public interface IPedidoService {
	
	public Pedido adicionarPedido(Pedido novo);
	public boolean removerPedido(Integer id);

}
