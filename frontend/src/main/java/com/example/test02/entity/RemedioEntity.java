package com.example.test02.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RemedioEntity {
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
