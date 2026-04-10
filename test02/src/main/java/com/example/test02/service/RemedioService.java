package com.example.test02.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.test02.entity.RemedioEntity;
import com.example.test02.interfaces.IRemedioService;

@Service
public class RemedioService implements IRemedioService {
	
	private RestTemplate restTemplate = new RestTemplate();
	private final String url = "http://localhost:6789/api/v1/entities/remedio";
	@Override
	public List<RemedioEntity> findAll() {
		RemedioEntity[] list = restTemplate.getForObject(url, RemedioEntity[].class);
		
		return list != null ? Arrays.asList(list):Arrays.asList();
	}

	@Override
	public RemedioEntity findById(Long id) {
		RemedioEntity bus = restTemplate.getForObject(url+"/"+id, RemedioEntity.class);
		return bus;
	}

	@Override
	public RemedioEntity save(RemedioEntity remedio) {
		RemedioEntity busNuevo = restTemplate.postForObject(url, remedio, RemedioEntity.class);
		return busNuevo;
	}

	@Override
	public void update(Long id, RemedioEntity remedio) {
		restTemplate.put(url+"/"+id, remedio);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		restTemplate.delete(url+"/"+id);
		
	}

}