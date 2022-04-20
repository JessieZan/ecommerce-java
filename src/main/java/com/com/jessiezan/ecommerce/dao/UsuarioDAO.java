package com.com.jessiezan.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import com.com.jessiezan.ecommerce.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
	public Usuario findByUsernameOrEmail(String username, String email);

}
