package com.example.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.apirest.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	Cliente findById(long id);
	
	@Query(value = "select * from cliente where cpf = ?1", nativeQuery = true)
	Cliente findClienteCPF(String cpf);
}
