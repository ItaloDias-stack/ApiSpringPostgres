package com.example.apirest.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.models.Produto;
import com.example.apirest.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/produto")
public class Produtos {

	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping(value = "/getProdutos")
	public List<Produto> getProdutos() {
		return produtoRepository.findAll();
	}

	@GetMapping(value = "/getProduto/{id}")
	public Produto getProduto(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
	}

	public boolean verificaProduto(Produto produto) {
		if (produtoRepository.findByNome(produto.getNome()) == null) {
			return true;
		} else {
			return false;
		}
	}

	@PostMapping("/saveProduto")
	public ResponseEntity<Produto> saveProduto(@RequestBody Produto produto) {
		if (verificaProduto(produto)) {
			produtoRepository.save(produto);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/deleteProduto/{id}")
	public ResponseEntity<Produto> deleteProduto(@PathVariable(value = "id") long id) {
		Produto produto = produtoRepository.findById(id);
		produtoRepository.delete(produto);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@PutMapping("/updateProduto/{id}")
	public ResponseEntity<Produto> updateProduto(@PathVariable(value = "id") long id,@RequestBody Produto p) {

		Produto produto = produtoRepository.findById(id);

		produto.setLoja(p.getLoja());
		produto.setNome(p.getNome());
		produto.setPreco(p.getPreco());

		Produto updatedProduto = produtoRepository.save(produto);

		return ResponseEntity.ok(updatedProduto);

	}

}
