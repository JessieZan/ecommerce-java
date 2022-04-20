package com.com.jessiezan.ecommerce.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "departamento")

public class Departamento {

	@Id // mostra que o atributo é uma PK
	@Column(name = "id") // mapeio o atributo "numero" para a especificação da coluna "numero" na tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Indico que o valor é gerado e gerenciado pelo BD ( e o //
														// identity torna isso indepentende da implementação)
	private Integer id;

	@Column(name = "nome", length = 50, nullable = false, columnDefinition = "TEXT")
	private String nome;

	@Column(name = "andar")
	private Integer andar;

	@OneToMany(mappedBy = "depto")
	@JsonIgnoreProperties("depto")
	private List<Produto> listaProdutos;

	public Departamento() {
	}

	public Integer getID() {
		return id;
	}

	public void setID(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAndar() {
		return andar;
	}

	public void setAndar(Integer andar) {
		this.andar = andar;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

}
