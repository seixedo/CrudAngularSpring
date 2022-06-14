package com.CRUDAPI.model;

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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public Double getvalue() {
		return value;
	}
	public void setvalue(Double value) {
		this.value = value;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, value);
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
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(value, other.value);
	}
	@Override
	public String toString() {
		return "Produtos [id=" + id + ", name=" + name + ", value=" + value + "]";
	}
	
	
}