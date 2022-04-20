package com.com.jessiezan.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.com.jessiezan.ecommerce.dto.ClienteDTO;
import com.com.jessiezan.ecommerce.model.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Integer>{

	@Query("    SELECT "
			+ "new com.com.jessiezan.ecommerce.dto.ClienteDTO("
			+ "  cliente.id,"
			+ "  cliente.nome,"
			+ "  cliente.cpf,"
			+ "  cliente.email,"
			+ "  cliente.telefone) "
			+ "FROM Cliente as cliente")
	public List<ClienteDTO> recuperarTodos();
	
	@Query(" SELECT "
			+ " new com.com.jessiezan.ecommerce.dto.ClienteDTO("
			+ "  cliente.id,"
			+ "  cliente.nome,"
			+ "  cliente.cpf,"
			+ "  cliente.email,"
			+ "  cliente.telefone)"
			+ "FROM Cliente as cliente WHERE cliente.id = :id")
	public ClienteDTO recuperarPeloId(@Param("id") Integer id);

}
