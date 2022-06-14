package com.CRUDAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;	
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.CRUDAPI.model.Produtos;
import com.CRUDAPI.repository.ProdutosRepository;
import com.fasterxml.jackson.databind.BeanProperty;

@SpringBootApplication
public class CrudApiApplication implements CommandLineRunner {
	@Autowired
	private ProdutosRepository produtosInterface;
	
	public static void main(String[] args) {
		SpringApplication.run(CrudApiApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		List<Produtos> produtos = produtosInterface.findAll();
		produtos.forEach(System.out :: println);
	}

}
