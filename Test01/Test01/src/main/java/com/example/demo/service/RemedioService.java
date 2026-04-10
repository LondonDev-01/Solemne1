package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RemedioEntity;
import com.example.demo.interfaces.IRemedioService;
import com.example.demo.repository.RemedioRepository;

@Service
public class RemedioService implements IRemedioService {
	@Autowired
	private RemedioRepository repo;
	
	@Override
	public List<RemedioEntity> findAll() {
		return (List<RemedioEntity>) repo.findAll();
	}

	@Override
	public RemedioEntity findById(Long id){
		return repo.findById(id).orElse(null);

	}

	@Override
	public RemedioEntity save(RemedioEntity remedio) {
		
		return repo.save(remedio);

	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
}
