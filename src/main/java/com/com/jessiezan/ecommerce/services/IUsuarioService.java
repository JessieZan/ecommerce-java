package com.com.jessiezan.ecommerce.services;

import com.com.jessiezan.ecommerce.dto.UsuarioLoginDTO;
import com.com.jessiezan.ecommerce.model.Usuario;
import com.com.jessiezan.ecommerce.security.Token;

public interface IUsuarioService {
	public Token createTokenDeUsuarioLogado(UsuarioLoginDTO dadosLogin);
	public Usuario createNovoUsuario(Usuario novoUsuario);
	public Usuario editaUsuario(Usuario novoEditado, Integer id);
}
