package com.example.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apirest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
