package com.CRUDAPI.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.id.CompositeNestedGeneratedValueGenerator.GenerationContextLocator;

@Entity
@Table(name = "Produtos")
public class Produtos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double value;
	private LocalDateTime inserido;
	private LocalDateTime alterado;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public LocalDateTime getInserido() {
		return inserido;
	}
	public void setInserido(LocalDateTime inserido) {
		this.inserido = inserido;
	}
	public LocalDateTime getAlterado() {
		return alterado;
	}
	public void setAlterado(LocalDateTime alterado) {
		this.alterado = alterado;
	}
	@Override
	public int hashCode() {
		return Objects.hash(alterado, id, inserido, name, value);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produtos other = (Produtos) obj;
		return Objects.equals(alterado, other.alterado) && Objects.equals(id, other.id)
				&& Objects.equals(inserido, other.inserido) && Objects.equals(name, other.name)
				&& Objects.equals(value, other.value);
	}
	@Override
	public String toString() {
		return "Produtos [id=" + id + ", name=" + name + ", value=" + value + ", inserido=" + inserido + ", alterado="
				+ alterado + "]";
	}
	
	
	
	

	
	
}