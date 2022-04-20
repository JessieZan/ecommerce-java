package com.com.jessiezan.ecommerce.dto;

import com.com.jessiezan.ecommerce.model.Cliente;

public class ClienteDTO {
	private Integer id;
	private String nome;
	private Integer cpf;
	private String email;
	private Integer telefone;
	public ClienteDTO(Integer id, String nome, Integer cpf, String email, Integer telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
	}
	
	public ClienteDTO(Cliente cli) {
		super();
		this.id = cli.getID();
		this.nome = cli.getNome();
		this.cpf = cli.getCpf();
		this.email = cli.getEmail();
		this.telefone = cli.getTelefone();
	}
	
	public Integer getNumero() {
		return id;
	}
	public void setNumero(Integer id) {
		this.id = id;
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
	
	public static ClienteDTO fromCliente(Cliente c) {
		return new ClienteDTO(c.getID(), c.getNome(), c.getCpf(), c.getEmail(), c.getTelefone());
	}	

}
