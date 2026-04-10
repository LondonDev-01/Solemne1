package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.entity.RemedioEntity;

public interface IRemedioService {
	List<RemedioEntity> findAll();

	RemedioEntity findById(Long id);

	RemedioEntity save(RemedioEntity remedio);
	
	void deleteById(Long id);
}
