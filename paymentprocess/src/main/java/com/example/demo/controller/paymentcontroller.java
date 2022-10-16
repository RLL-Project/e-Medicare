package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PaymentEntity;
import com.example.demo.service.paymentservice;

@RestController
@RequestMapping("payment")
@CrossOrigin
public class paymentcontroller {
	@Autowired
	paymentservice paymentservice;
	
    
	@PostMapping(value = "paymentprocess",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String payment(@RequestBody PaymentEntity paymententity)
	{
		return paymentservice.paymentProcess(paymententity);
	}
//	@PostMapping(value="signUp",consumes=MediaType.APPLICATION_JSON_VALUE)
//	public String signUp(@RequestBody Login login)
//	{
//		return loginservice.signUp(login);
//	}
}
