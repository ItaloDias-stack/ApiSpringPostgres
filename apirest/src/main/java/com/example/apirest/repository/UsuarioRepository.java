package com.example.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apirest.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
