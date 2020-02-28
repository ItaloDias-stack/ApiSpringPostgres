package com.example.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.apirest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	Produto findById(long id);
	
	@Query(value = "select * from produto where nome = ?1", nativeQuery = true)
	Produto findByNome(String nome);
	
	@Query(value = " delete from produto where id_produto = ?1", nativeQuery = true)
	Produto remove(long id);
	
	@Query(value = "update produto set nome = ?1, preco = ?2 where id_produto = ?3", nativeQuery = true)
	Produto edita(String nome,double preco,long id);
	
}
