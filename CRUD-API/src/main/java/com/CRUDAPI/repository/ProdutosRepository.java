package com.CRUDAPI.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.CRUDAPI.model.Produtos;
@Transactional
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
	@Query("update Produtos set name = :name,value= :value, alterado = :alterado where id = :id")
	@Modifying
	void updateProduct(@Param("id")Long id,@Param("name")String name,@Param("value")Double value,@Param("alterado")LocalDateTime Alterado);
}
