package com.project.register.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.register.entity.RegModel;
import com.project.register.repo.IRegisterRepo;


@Service
public class RegisterService {
	@Autowired
	private IRegisterRepo repo;
	
	public String saveData(RegModel data) {
		repo.save(data);
        return "Data saved successfully!";
    }
	
	public Optional<RegModel> getUserById(Long id) {
        return repo.findById(id);
    }
	public List<RegModel> getAllUsers() {
        return repo.findAll();
    }
}
