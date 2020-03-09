package com.example.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.apirest.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findById(long id);
	
	@Query(value = "SELECT * FROM usuario where username = ?1 and senha = ?2", nativeQuery = true)
	Usuario findUser(String username,String senha);
	
	@Query(value = "SELECT * FROM usuario where username = ?1", nativeQuery = true)
	Usuario findUserByNome(String username);
}
