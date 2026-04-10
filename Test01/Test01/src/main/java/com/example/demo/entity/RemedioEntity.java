package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "remedio")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RemedioEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String nombreCientifico;
	
	@NonNull
	private String marca;
	
	@NonNull
	private Double gramos;
	private int anio;
	private char tipo;
	public boolean controlado;
}
