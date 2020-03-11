package com.example.apirest.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
	private Loja loja;
	
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Loja getIdLoja() {
		return loja;
	}

	public void setIdLoja(Loja idLoja) {
		this.loja = idLoja;
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

	
	
	
}
