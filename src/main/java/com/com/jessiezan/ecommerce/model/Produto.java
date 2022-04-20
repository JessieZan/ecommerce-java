package com.com.jessiezan.ecommerce.model;

import com.com.jessiezan.ecommerce.model.Departamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome", length = 50, nullable = false)
	private String nome;

	@Column(name = "descricao", columnDefinition = "TEXT")
	private String descricao;

	@Column(name = "preco")
	private Double preco;

	@Column(name = "qtd_estoque")
	private Integer qtdEstoque;

	@Column(name = "link_foto", length = 255)
	private String linkFoto;

	@ManyToOne // esta anotação indica que há uma relação N:1 com Departamento
	@JoinColumn(name = "departamento_id") // como o nome da coluna que é FK é diferente do nome da PK de Departamento,
											// então preciso explicitar
	@JsonIgnoreProperties("listaProdutos")
	private Departamento depto;

	public Produto() {
		super();
		
	};

	public Produto(Integer id, String nome, String descricao, Integer qtdEstoque, Double preco, String link_foto,
			Integer idDepto, String nomeDepto, Integer andarDepto) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.qtdEstoque = qtdEstoque;
		this.preco = preco;
		this.linkFoto = link_foto;
		this.depto = new Departamento();
		this.depto.setID(idDepto);
		this.depto.setNome(nomeDepto);
		this.depto.setAndar(andarDepto);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public String getLinkFoto() {
		return linkFoto;
	}

	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}

	public Departamento getDepto() {
		return depto;
	}

	public void setDepto(Departamento depto) {
		this.depto = depto;
	}

}