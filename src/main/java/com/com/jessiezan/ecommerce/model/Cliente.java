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
@Table(name = "cliente")
public class Cliente {
	

		@Id 
		@Column(name = "id") 
		@GeneratedValue(strategy = GenerationType.IDENTITY) 
		private Integer id;

		@Column(name = "nome", length = 100, nullable = false)
		private String nome;

		@Column(name = "cpf", length = 11, nullable = false, unique = true)
		private Integer cpf;
		
		@Column(name = "email", length = 50, nullable = false, unique = true)
		private String email;
		
		@Column(name = "telefone", nullable = false)
		private Integer telefone;
		
		@Column(name = "logradouro", length = 50, nullable = false)
		private String logradouro;
		
		@Column(name = "num_res")
		private Integer num_res;
		
		@Column(name = "compl", length = 30)
		private String compl;
		
		@Column(name = "bairro", length = 30)
		private String bairro;
		
		@Column(name = "cidade", length = 30)
		private String cidade;
		
		@Column(name = "estado", length = 2)
		private String estado;
		
		@Column(name = "cep",length = 8)
		private String cep;
		
		@OneToMany(mappedBy = "cliente")
		@JsonIgnoreProperties("cliente")
		private List<Pedido> listaPedidos;
		
		public Cliente() {
		}


		public Cliente(String nome, Integer cpf, String email, Integer telefone, String logradouro, Integer num_res,
				String compl, String bairro, String cidade, String estado, String cep, List<Pedido> listaPedidos) {
			super();
			this.nome = nome;
			this.cpf = cpf;
			this.email = email;
			this.telefone = telefone;
			this.logradouro = logradouro;
			this.num_res = num_res;
			this.compl = compl;
			this.bairro = bairro;
			this.cidade = cidade;
			this.estado = estado;
			this.cep = cep;
			this.listaPedidos = listaPedidos;
		}



		public Integer getID() {
			return id;
		}


		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Integer getCpf() {
			return cpf;
		}

		public void setCpf(Integer cpf) {
			this.cpf = cpf;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Integer getTelefone() {
			return telefone;
		}

		public void setTelefone(Integer telefone) {
			this.telefone = telefone;
		}

		public String getLogradouro() {
			return logradouro;
		}

		public void setLogradouro(String logradouro) {
			this.logradouro = logradouro;
		}

		public Integer getNum_res() {
			return num_res;
		}

		public void setNum_res(Integer num_res) {
			this.num_res = num_res;
		}

		public String getComplemento() {
			return compl;
		}

		public void setComplemento(String compl) {
			this.compl = compl;
		}

		public String getBairro() {
			return bairro;
		}

		public void setBairro(String bairro) {
			this.bairro = bairro;
		}

		public String getCidade() {
			return cidade;
		}

		public void setCidade(String cidade) {
			this.cidade = cidade;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public String getCep() {
			return cep;
		}

		public void setCep(String cep) {
			this.cep = cep;
		}



		public List<Pedido> getListaPedidos() {
			return listaPedidos;
		}



		public void setListaPedidos(List<Pedido> listaPedidos) {
			this.listaPedidos = listaPedidos;
		}
		
		
		
		
	
}
