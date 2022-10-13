package com.CRUDAPI.controller;

import java.awt.print.Printable;
import java.io.Console;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
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
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;

import ch.qos.logback.classic.pattern.DateConverter;
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
	System.out.println(produtos.getAlterado());
	System.out.println(produtos.getInserido());
	produtos.setAlterado(LocalDateTime.now());
	produtos.setInserido(LocalDateTime.now());
	return produtosRepository.save(produtos);
}


@SuppressWarnings("deprecation")
@CrossOrigin(origins = "*")
@GetMapping("/produtos/{id}")
public String getProduct(@PathVariable("id") Long id) throws JsonProcessingException {
	ObjectMapper mapper = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build();
	Optional<Produtos> produto ;
	produto = produtosRepository.findById(id);
	System.out.print(produto);
	String JsonRetorno= mapper.writeValueAsString(produto.get());
	System.out.print(JsonRetorno);
	return JsonRetorno;
}
@PutMapping("produtos/{id}")
@CrossOrigin(origins="*")
public void PrepupdateProduct(@Param("id")Long id,@Param("name") String name,@Param("Value") Double value,@RequestBody Produtos produto) {
	name=produto.getName();
	value=produto.getValue();
	id=produto.getId();
	LocalDateTime Alterado = LocalDateTime.now();
	System.out.print(name);
	System.out.print(value);
	System.out.print(id);
	produtosRepository.updateProduct(id, name, value,Alterado);

}




} 
