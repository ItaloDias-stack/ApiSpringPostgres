package com.example.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.models.Produto;
import com.example.apirest.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/produto")
public class Produtos {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@RequestMapping(value = "/getProdutos")
	public List<Produto> getProdutos(){
		return produtoRepository.findAll();
	}
	
}
