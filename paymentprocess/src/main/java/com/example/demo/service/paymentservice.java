package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PaymentEntity;
import com.example.demo.repository.paymentRepo;
import com.fasterxml.jackson.core.util.RequestPayload;

@Service
public class paymentservice {
	
	@Autowired
	private paymentRepo paymentrepo;

	public String paymentProcess(PaymentEntity paymententity) {
		
		paymentrepo.save(paymententity);
		return "PaymentSucessFull";
	}
	
	
}
