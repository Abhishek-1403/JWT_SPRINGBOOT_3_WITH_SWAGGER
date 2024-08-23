package com.hrms.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.requestDTO.SampleDataRequestDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/home")
public class HomeController {

	@GetMapping("/lock-url")
//	@SecurityRequirement(name = "bearerAuth")
	public String lockUrl() {
		return "Accessible after authorization";
	}
	@GetMapping("/unlock-url")
	public String unlockUrl() {
		return "Accessible without authorization";
	}
	
	@PostMapping("/save-something")
	public SampleDataRequestDTO saveSomething(@RequestBody SampleDataRequestDTO request) {
		request.setMessage("succesfully recieved request..");
		return request;
	}
}
