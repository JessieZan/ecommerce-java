package com.com.jessiezan.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import com.com.jessiezan.ecommerce.model.Departamento;

public interface DepartamentoDAO extends CrudRepository<Departamento, Integer>{

	//	aqui virão as minhas consultas customizadas

}
