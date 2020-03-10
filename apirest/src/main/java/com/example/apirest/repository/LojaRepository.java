package com.example.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.apirest.models.Loja;

public interface LojaRepository extends JpaRepository<Loja, Long>{
	Loja findById(long id);
	
	@Query(value = "select * from loja where nome_loja = ?1", nativeQuery = true)
	Loja findLojaByNome(String nome);
	
	@Query(value = "select * from loja where rua = ?1 and bairro=?2 and cidade=?3", nativeQuery = true)
	Loja findLojaByEndereco(String rua,String bairro,String cidade);
}
