package com.example.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apirest.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
