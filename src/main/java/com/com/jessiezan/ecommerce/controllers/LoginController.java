package com.com.jessiezan.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.com.jessiezan.ecommerce.dto.UsuarioLoginDTO;
import com.com.jessiezan.ecommerce.model.Usuario;
import com.com.jessiezan.ecommerce.security.Token;
import com.com.jessiezan.ecommerce.security.TokenUtil;
import com.com.jessiezan.ecommerce.services.IUsuarioService;


@RestController
public class LoginController {
	
	@Autowired
	private IUsuarioService service;
	
	@PostMapping("/login")
	public ResponseEntity<?> postLogin(@RequestBody UsuarioLoginDTO dadosLogin){
		Token t = service.createTokenDeUsuarioLogado(dadosLogin);
		if(t != null) {
			return ResponseEntity.ok(t);
		};
		
		return ResponseEntity.status(400).body("Dados inválidos!");
		
	}
	
	
	
}
