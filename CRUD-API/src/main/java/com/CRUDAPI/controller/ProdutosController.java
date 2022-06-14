package com.CRUDAPI.controller;

import java.awt.print.Printable;
import java.io.Console;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.CRUDAPI.model.*;
import com.CRUDAPI.repository.ProdutosRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import ch.qos.logback.core.net.ObjectWriter;

@RestController
@CrossOrigin(origins = "*")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProdutosController {
	@Autowired
	private ProdutosRepository produtosRepository;
@CrossOrigin(origins = "*")	
@GetMapping("/produtos")
public List<Produtos> list(){
	return produtosRepository.findAll();
}
@CrossOrigin(origins = "*")
@PostMapping("/produtos")
public Produtos adicionar(@RequestBody Produtos produtos) {
	return produtosRepository.save(produtos);
}


@SuppressWarnings("deprecation")
@CrossOrigin(origins = "*")
@GetMapping("/produtos/{id}")
public String getProduct(@PathVariable("id") Long id) throws JsonProcessingException {
	ObjectMapper mapper = new ObjectMapper();
	Optional<Produtos> produto ;
	produto = produtosRepository.findById(id);
	String JsonRetorno= mapper.writeValueAsString(produto.get());
	System.out.print(JsonRetorno);
	return JsonRetorno;
}
@PutMapping("produtos/{id}")
@CrossOrigin(origins="*")
public void PrepupdateProduct(@Param("id")Long id,@Param("name") String name,@Param("Value") Double value,@RequestBody Produtos produto) {
	String jsonInString	= new Gson().toJson(produto);
	
	name=produto.getname();
	value=produto.getvalue();
	id=produto.getId();
	System.out.print(name);
	System.out.print(value);
	System.out.print(id);
	produtosRepository.updateProduct(id, name, value);

}




} 
