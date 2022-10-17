package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Login;
import com.example.demo.Service.LoginService;

@RestController
@RequestMapping("login")
@CrossOrigin
public class LoginController {
	@Autowired
	LoginService loginservice;
    
	@PostMapping(value="signIn",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String signIn(@RequestBody Login login)
	{
		return loginservice.signIn(login);
	}
	@PostMapping(value="signUp",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String signUp(@RequestBody Login login)
	{
		return loginservice.signUp(login);
	}
}
