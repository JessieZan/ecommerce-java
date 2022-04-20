package com.com.jessiezan.ecommerce.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.com.jessiezan.ecommerce.dao.DepartamentoDAO;
import com.com.jessiezan.ecommerce.model.Departamento;



@RestController
public class DepartamentoController {
	
	@Autowired
	private DepartamentoDAO dao;
	
	@GetMapping("/departamentos")
	public List<Departamento> recuperarTodos(){
		return (List<Departamento>)dao.findAll();
	}


	@GetMapping("/departamentos/{id}")
	public Optional<Departamento> recuperarDepartamento(@PathVariable("id") Integer id) {
		return dao.findById(id);
	}
	
	@PostMapping("/departamentos")
	public Departamento incluirNovo(@RequestBody Departamento novo) {
		return dao.save(novo);
	}
	
	@PutMapping("/departamentos")
	public Departamento alterarDepartamento(@RequestBody Departamento atual) {
		return dao.save(atual);
	}
}

