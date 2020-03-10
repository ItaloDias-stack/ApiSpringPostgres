package com.example.apirest.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.models.Cliente;
import com.example.apirest.models.Produto;
import com.example.apirest.repository.ClienteRepository;

@RestController
@RequestMapping(value = "/cliente")
public class Clientes {

	@Autowired
	ClienteRepository clienteRepository;
	
	@RequestMapping(value = "/getClientes")
	public List<Cliente> getClientes() {
		return clienteRepository.findAll();
	}
	
	@GetMapping(value = "/getCliente/{id}")
	public Cliente getProduto(@PathVariable(value = "id") long id) {
		Cliente cliente = clienteRepository.findById(id);
		return cliente;
	}
	
	public boolean verificaCliente(String cpf) {
		Cliente cliente = clienteRepository.findClienteCPF(cpf);
		if(cliente==null) {
			return true;
		}else {
			return false;
		}
	}
	
	@PostMapping(value="/saveCliente")
	public Map<String, String> saveCliente(@RequestBody Cliente c){
		HashMap<String, String> response = new HashMap<String, String>();
		if(verificaCliente(c.getCpf())) {
			clienteRepository.save(c);
			response.put("message", "true");
			return response;
		}else {
			response.put("message", "false");
			return response;
		}
	}
	
	@GetMapping(value = "/deleteCliente/{id}")
	public Map<String,String> deleteCliente(@PathVariable(value="id") long id){
		HashMap<String,String> response = new HashMap<String, String>();
		Cliente cliente = clienteRepository.findById(id);
		clienteRepository.delete(cliente);
		response.put("message:", "true");
		return response;
	}
	
	@PutMapping(value = "/updateCliente/{id}")
	public Map<String, String> updateCliente(@PathVariable(value = "id")long id,@RequestBody Cliente c){
		HashMap<String, String> response = new HashMap<String, String>();
		if(verificaCliente(c.getCpf())) {
			Cliente cliente = clienteRepository.findById(id);
			cliente.setCpf(c.getCpf());
			cliente.setNome(c.getNome());
			clienteRepository.save(cliente);
			response.put("message", "true");
			return response;
		}else {
			response.put("message", "false");
			return response;
		}
	}
}
