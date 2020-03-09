package com.example.apirest.resources;

import java.awt.print.Printable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.models.Produto;
import com.example.apirest.models.Usuario;
import com.example.apirest.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class Usuarios {

	@Autowired
	UsuarioRepository userRepository;

	@PostMapping("/login")
	public Map<String, String> login(@RequestBody Usuario userp) {
		//System.out.println(userp.getUsername());
		HashMap<String, String> response = new HashMap<>();
		try {
			Usuario user = userRepository.findUser(userp.getUsername(), userp.getSenha());

			if (user.equals(null)) {
				response.put("mensagem", "false");
				return response;
			} else {
				response.put("mensagem", "true");
				return response;
			}
		} catch (NullPointerException e) {
			response.put("mensagem", "false");
			return response;
		}

	}

	public boolean findUserByName(String username) {
		if (userRepository.findUserByNome(username) == null) {
			return true;
		} else {
			return false;
		}
	}

	@PostMapping("/createUser")
	public Map<String, String> createUser(@RequestBody Usuario user) {
		HashMap<String, String> response = new HashMap<>();
		if (findUserByName(user.getUsername())) {
			userRepository.save(user);
			response.put("mensagem", "true");
			return response;
		} else {
			response.put("mensagem", "false");
			return response;
		}
	}

	@GetMapping("/deleteUser/{id}")
	public Map<String, String> deleteUser(@PathVariable(value = "id") long id) {
		Usuario user = userRepository.findById(id);
		userRepository.delete(user);
		HashMap<String, String> response = new HashMap<String, String>();
		response.put("mensagem", "true");
		return response;
	}

	@PutMapping("/updateUser/{id}")
	public HashMap<String, String> updateUser(@PathVariable(value = "id") long id,@RequestBody Usuario u) {
		HashMap<String, String> response = new HashMap<String, String>();
		//System.out.println(userRepository.findUserByNome(u.getUsername()));
		if (findUserByName(u.getUsername())) {
			Usuario user = userRepository.findById(id);
			user.setNome(u.getNome());
			user.setUsername(u.getUsername());
			user.setSenha(u.getSenha());
			userRepository.save(user);
			response.put("id_usuario", user.getIdUsuario() + "");
			response.put("nome", user.getNome());
			response.put("username", user.getUsername());
			response.put("senha", user.getSenha());
			return response;
		} else {
			response.put("mensagem", "false");
			return response;
		}
	}
}
