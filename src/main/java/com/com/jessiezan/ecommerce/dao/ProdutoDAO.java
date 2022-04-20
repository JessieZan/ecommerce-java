package com.com.jessiezan.ecommerce.dao;

import com.com.jessiezan.ecommerce.model.Departamento;
import com.com.jessiezan.ecommerce.model.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoDAO extends CrudRepository<Produto, Integer>{

	//	aqui virão as minhas consultas customizadas
	//quero uma busca que me traga produtos por palavra chave
	
	public List<Produto> findByNomeContainingOrDescricaoContaining(String pcNome, String pcDescricao);
	public List<Produto> findByOrderByNomeAsc();
	public List<Produto> findByOrderByPrecoAsc();
	public List<Produto> findByOrderByPrecoDesc();
	public List<Produto> findByDepto(Departamento d);
	public List<Produto> findAll();;

	
	@Query("SELECT new "
	     + "com.com.jessiezan.ecommerce.model.Produto(produto.id,"
	     + "                                          produto.nome,"
	     + "                                          produto.descricao,"
	     + "                                          produto.qtdEstoque,"
	     + "                                          produto.preco,"
	     + "                                          produto.linkFoto,"
	     + "                                          departamento.id,"
	     + "                                          departamento.nome,"
	     + "                                          departamento.andar) "
	     + "FROM "
	     + "Produto as produto INNER JOIN Departamento as departamento ON "
	     + "produto.depto.id = departamento.id")
	
	//"Pedido as pedido INNER JOIN Entregador as entregador ON entregador.id = pedido.entregador.id"
	//"INNER JOIN Cliente as cliente ON cliente.id = pedido.cliente.id"
	public List<Produto> recuperarTudaoComUmaUnicaQuery();
	
	
}
