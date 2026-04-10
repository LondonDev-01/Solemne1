package com.example.test02.interfaces;

import java.util.List;

import com.example.test02.entity.RemedioEntity;

public interface IRemedioService {
	List<RemedioEntity> findAll();
	RemedioEntity findById(Long id);
	RemedioEntity save(RemedioEntity remedio);
	void update(Long id, RemedioEntity remedio);
	void deleteById(Long id);
}
