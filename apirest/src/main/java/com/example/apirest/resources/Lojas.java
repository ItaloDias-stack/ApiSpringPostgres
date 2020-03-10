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

import com.example.apirest.models.Loja;
import com.example.apirest.repository.LojaRepository;

@RestController
@RequestMapping(value = "/loja")
public class Lojas {
	@Autowired
	LojaRepository lojaRepository;
	
	@RequestMapping(value="/getLojas")
	public List<Loja> getLojas(){
		return lojaRepository.findAll();
	}
	
	@GetMapping(value="/getLoja/{id}")
	public Loja getLoja(@PathVariable(value="id")long id) {
		Loja loja = lojaRepository.findById(id);
		return loja;
	}
	
	public boolean verificaLoja(Loja loja) {
		Loja v1 = lojaRepository.findLojaByNome(loja.getNomeLoja());
		Loja v2 = lojaRepository.findLojaByEndereco(loja.getRua(), loja.getBairro(), loja.getCidade());
		if(v1 ==null && v2 == null) {
			return true;
		}else {
			return false;
		}
	}
	
	@PostMapping(value = "/saveLoja")
	public Map<String, String> saveLoja(@RequestBody Loja loja){
		HashMap<String, String> response = new HashMap<String, String>();
		if(verificaLoja(loja)) {
			lojaRepository.save(loja);
			response.put("message", "true");
			return response;
		}else {
			response.put("message", "false");
			return response;
		}
	}
	
	@GetMapping(value = "/deleteLoja/{id}")
	public Map<String, String> deleteLoja(@PathVariable(value = "id")long id){
		HashMap<String, String> response = new HashMap<String, String>();
		Loja loja = lojaRepository.findById(id);
		response.put("message", "true");
		return response;
	}
	
	@PutMapping(value = "/updateLoja/{id}")
	public Map<String, String> update(@PathVariable(value = "id")long id, @RequestBody Loja l){
		HashMap<String, String> response = new HashMap<String, String>();
		if(verificaLoja(l)) {
			Loja loja = lojaRepository.findById(id);
			loja.setBairro(l.getBairro());
			loja.setCidade(l.getCidade());
			loja.setNomeLoja(l.getNomeLoja());
			loja.setRua(l.getRua());
			loja.setUsuario(l.getUsuario());
			lojaRepository.save(loja);
			response.put("message", "true");
			return response;
		}else {
			response.put("message", "false");
			return response;
		}
	}
}
