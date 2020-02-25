package com.example.apirest.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Divida {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idDivida;
	
	@OneToOne
	private Cliente cliente;
	
	@OneToOne
	private Produto produto;

	public long getIdDivida() {
		return idDivida;
	}

	public void setIdDivida(long idDivida) {
		this.idDivida = idDivida;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProdutos() {
		return produto;
	}

	public void setProdutos(Produto produtos) {
		this.produto = produtos;
	}

	
	
	
}
