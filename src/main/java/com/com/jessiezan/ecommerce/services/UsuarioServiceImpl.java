package com.com.jessiezan.ecommerce.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.com.jessiezan.ecommerce.dao.UsuarioDAO;
import com.com.jessiezan.ecommerce.dto.UsuarioLoginDTO;
import com.com.jessiezan.ecommerce.model.Usuario;
import com.com.jessiezan.ecommerce.security.EcommerceCrypto;
import com.com.jessiezan.ecommerce.security.Token;
import com.com.jessiezan.ecommerce.security.TokenUtil;

@Component
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private UsuarioDAO dao;
	
	@Override
	public Token createTokenDeUsuarioLogado(UsuarioLoginDTO dadosLogin) {
		Usuario u = dao.findByUsernameOrEmail(dadosLogin.getUsername(), dadosLogin.getEmail());
		try {
			System.out.println("Debug senha dados= " + EcommerceCrypto.encrypt(dadosLogin.getSenha()));
			System.out.println("Debug senha usuario= " + u.getSenha());
		
		if(u != null) {
			String senhaLogin = EcommerceCrypto.encrypt(dadosLogin.getSenha());
			String senhaBanco = u.getSenha();
			
			if(senhaLogin.equals(senhaBanco)) {
				Token t = new Token(TokenUtil.createToken(u));
				
				return t;
			}
		}
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		return null;
	}

	@Override
	public Usuario createNovoUsuario(Usuario novoUsuario) {
		
		try {
			if(novoUsuario.getSenha() != null) {
				novoUsuario.setSenha(EcommerceCrypto.encrypt(novoUsuario.getSenha()));
				return dao.save(novoUsuario);
			}
		
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		return null;
	}

	@Override
	public Usuario editaUsuario(Usuario novoEditado, Integer id) {
		Usuario u =  dao.findById(id).orElse(null);
		
		try {
			if(novoEditado.getSenha() != null) {
				
				u.setSenha(EcommerceCrypto.encrypt(novoEditado.getSenha()));
				
				if(novoEditado.getUsername() != null) {
					u.setUsername(novoEditado.getUsername());
				}
				
				if(novoEditado.getEmail() != null) {
					u.setEmail(novoEditado.getEmail());
				}
				
				if(novoEditado.getNomeCompleto() != null) {
					u.setNomeCompleto(novoEditado.getNomeCompleto());
				}
				
				
				
				return dao.save(u);
			}
		
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		return null;
	}
	
	
}
