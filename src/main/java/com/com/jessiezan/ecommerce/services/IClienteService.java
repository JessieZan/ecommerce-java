package com.com.jessiezan.ecommerce.services;

import java.util.List;

import com.com.jessiezan.ecommerce.dto.ClienteDTO;


public interface IClienteService {
	public List<ClienteDTO> recuperarTodos();
	public ClienteDTO recuperarPeloId(Integer id);
}
