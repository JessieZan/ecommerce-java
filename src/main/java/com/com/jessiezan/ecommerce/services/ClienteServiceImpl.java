package com.com.jessiezan.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.com.jessiezan.ecommerce.dao.ClienteDAO;
import com.com.jessiezan.ecommerce.dto.ClienteDTO;

@Component
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private ClienteDAO dao;

	@Override
	public List<ClienteDTO> recuperarTodos() {
		return dao.recuperarTodos();
	}

	@Override
	public ClienteDTO recuperarPeloId(Integer id) {
		return dao.recuperarPeloId(id);
	}

}
