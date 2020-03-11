package com.example.apirest.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.models.Divida;
import com.example.apirest.repository.DividaRepository;

@RestController
@RequestMapping(value="/divida")
public class Dividas {
	@Autowired
	DividaRepository dividaRepository;
	
	@RequestMapping(value = "/getDividas")
	public List<Divida> getDividas(){
		return dividaRepository.findAll();
	}
	
	@GetMapping(value="/getDivida/{id}")
	public Divida getDivida (@PathVariable(value = "id")long id) {
		return dividaRepository.findById(id);
	}
	
	@PostMapping(value="/createDivida")
	public Map<String, String> createDivida(@RequestBody Divida d){
		HashMap<String, String> response = new HashMap<String, String>();
		dividaRepository.save(d);
		response.put("message", "true");
		return response;
	}
	
	@GetMapping(value = "/deleteDivida/{id}")
	public Map<String, String> deleteDivida(@PathVariable(value = "id") long id){
		HashMap<String, String> response = new HashMap<String, String>();
		Divida divida = dividaRepository.findById(id);
		dividaRepository.delete(divida);
		response.put("message", "true");
		return response;
	}
	
	@PutMapping(value = "/updateDivida/{id}")
	public Map<String, String> updateDivida(@PathVariable(value = "id") long id, Divida d){
		HashMap<String, String> response = new HashMap<String, String>();
		Divida divida = dividaRepository.findById(id);
		divida.setCliente(d.getCliente());
		divida.setProduto(d.getProduto());
		divida.setIdLoja(d.getIdLoja());
		response.put("message", "true");
		return response;
	}
}
