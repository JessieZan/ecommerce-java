package com.com.jessiezan.ecommerce.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
@Table(name = "pedido")

public class Pedido {
	@Id
	@Column(name = "id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
													
	private Integer id;
	
	@Column(name = "data", length = 50, columnDefinition = "DATE")
	private LocalDate data;
	
	@Column(name = "valor_bruto")
	private Double valorBruto;
	
	@Column(name = "desconto")
	private Double desconto;
	
	@Column(name = "valor_total")
	private Double valorTotal;
	
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	@JsonIgnoreProperties("listaPedidos")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("pedido")
	private List<ItemPedido> itens;
	


	@Override
	public String toString() {
		return "Pedido [id=" + id + ", data=" + data + ", valorBruto=" + valorBruto + ", desconto=" + desconto
				+ ", valorTotal=" + valorTotal + ", cliente=" + cliente+ "\nItens:"+itens;
				
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public LocalDate getData() {
		return data;
	}



	public void setData(LocalDate data) {
		this.data = data;
	}



	public Double getValorBruto() {
		return valorBruto;
	}



	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}



	public Double getDesconto() {
		return desconto;
	}



	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}



	public Double getValorTotal() {
		return valorTotal;
	}



	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public List<ItemPedido> getItens() {
		return itens;
	}



	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}


	
	
	
	
}
