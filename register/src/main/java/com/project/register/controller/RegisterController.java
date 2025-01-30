package com.project.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.project.register.entity.RegModel;
import com.project.register.service.RegisterService;


@RestController
@CrossOrigin("*")
@RequestMapping("/micro")
public class RegisterController {
	@Autowired
	private RegisterService service;

	@PostMapping("/add")
	public String micropost(@RequestBody RegModel model) {
		 System.out.println("Endpoint hit with data: " + model);
		return service.saveData(model);

	}
	
	@GetMapping("/get")
	public String get() {
		return "hi";
	}
}