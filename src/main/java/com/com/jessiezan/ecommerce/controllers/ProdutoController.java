package com.com.jessiezan.ecommerce.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.com.jessiezan.ecommerce.dao.ProdutoDAO;
import com.com.jessiezan.ecommerce.dto.ClienteDTO;
import com.com.jessiezan.ecommerce.model.Pedido;
import com.com.jessiezan.ecommerce.model.Produto;
import com.com.jessiezan.ecommerce.services.IClienteService;
import com.com.jessiezan.ecommerce.services.IPedidoService;
import com.com.jessiezan.ecommerce.services.IProdutoService;
import com.com.jessiezan.ecommerce.services.ProdutoServiceImpl;



@RestController
public class ProdutoController {
	

	@Autowired
	private ProdutoServiceImpl service;
	
	@GetMapping("/produtos")
	public ResponseEntity<List<Produto>> recuperarTodos(){
		return ResponseEntity.ok(service.recuperarTodos());
	}


	@GetMapping("/produtos/{id}")
	public ResponseEntity<Produto> recuperarPeloId(@PathVariable Integer id) {
		Produto res = service.recuperarPeloId(id);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}
	
//	@Autowired
//	private ProdutoDAO dao;
//	
//	@GetMapping("/produtos")
//	public List<Produto> recuperarTodos(){
//		
//		return (List<Produto>)dao.recuperarTudaoComUmaUnicaQuery();
//	}
//
//	
//	@GetMapping("/produtos/{id}")
//	public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id) {
//		Produto res = dao.findById(id).orElse(null);
//		
//		if(res != null) {
//			return ResponseEntity.ok(res);
//		}
//		return ResponseEntity.status(404).build();
//	}
	
	
	//generics
	/*
	@GetMapping("/produtos/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		Produto res = dao.findById(id).orElse(null);
		
		if(res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.status(404).body("Produto nao encontrado");
	}
	*/
	
	
//	@GetMapping("/produtos/busca")
//	public ResponseEntity<List<Produto>> buscarPorPalavraChave(@RequestParam(name="chave") String chave) {
//		
//		List<Produto> res = dao.findByNomeContainingOrDescricaoContaining(chave, chave);
//		 
//		
//		if(res.size() != 0) {
//			return ResponseEntity.ok(res);
//		}
//		return ResponseEntity.noContent().build();
//	}
	
	
	
//	@GetMapping("/produtos/departamento/{id}")
//	public ResponseEntity<List<Produto>> recuperarProdutosPorDepartamento(@PahtVariable Integer id) {
//		
//		Departamento d = new Departametoi();//	
//		d.setID(id);
//		
//		if(d.size() != 0) {
//			return dao.fidByDepto(d);
//		}
//		return ResponseEntity.noContent().build();
//	}
}

