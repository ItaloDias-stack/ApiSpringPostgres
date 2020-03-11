package com.example.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apirest.models.Divida;

public interface DividaRepository extends JpaRepository<Divida, Long>{
	Divida findById(long id);
}
