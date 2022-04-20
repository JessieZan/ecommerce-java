package com.com.jessiezan.ecommerce.controllers;

import com.com.jessiezan.ecommerce.model.Pedido;
import com.com.jessiezan.ecommerce.services.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class PedidoController {
	
	@Autowired
	@Qualifier("desconto")
	private IPedidoService service;
	
	@PostMapping("/pedidos")
	public ResponseEntity<?> inserirNovo(@RequestBody Pedido novo){
		Pedido resultado = service.adicionarPedido(novo);
		if(resultado != null) {
			return ResponseEntity.status(201).body(resultado);
		}
		return ResponseEntity.status(400).body("Dados inválidos para essa estrturura");
	}
	
	@DeleteMapping("/pedidos/{id}")
	public ResponseEntity<String> removerPedido(@PathVariable Integer id){
		if(service.removerPedido(id) ) {
			return ResponseEntity.ok("Pedido removido com sucesso");
		}
		return ResponseEntity.badRequest().body("Erro ao remover pedido");
		
	}
	
	//@GetMapping("/pedidos")
	//public List<Pedido> recuperarTodos(){
	//		return service.recuperarTodos();
	//}
//
//
//	@GetMapping("/pedidos/{id}")
//	public Pedido recuperarPedido(@PathVariable("id") Integer id) {
//		return dao.findById(id).orElse(null);
//	}
//	
//	@GetMapping("/faturamento/{ano}")
//	public List<Faturamento> recuperarFaturamento(@PathVariable("ano") int ano){
//		return dao.recuperarFaturamentoPorAno(ano);
//	}
	
	
}

