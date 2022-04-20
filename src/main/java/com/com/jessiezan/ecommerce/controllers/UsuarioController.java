package com.com.jessiezan.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.com.jessiezan.ecommerce.model.Usuario;
import com.com.jessiezan.ecommerce.services.IUsuarioService;


@RestController
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;
	
	@PostMapping("/usuarios")
	public ResponseEntity<?> cadastrarUsuario(@RequestBody Usuario novoUsuario){
		Usuario u = service.createNovoUsuario(novoUsuario);
		if(u != null) {
			return ResponseEntity.ok(u);
		};
		
		return ResponseEntity.status(400).body("Não foi possivel completar a operação.");
		
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<?> editaUsuario(@RequestBody Usuario novoEditado, @PathVariable Integer id){
		Usuario u = service.editaUsuario(novoEditado, id);
		if(u != null) {
			return ResponseEntity.ok(u);
		};
		
		return ResponseEntity.status(400).body("Não foi possivel completar a operação.");
		
	}
	
	
	
}