package com.medicare;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.medicare.user.AuthenticationStatus;
import com.medicare.user.User;
import com.medicare.user.UserRepository;
import com.medicare.user.UserService;

/**
 * @Created by Abhinav Bhardwaj
 * on 19-Oct-2022 at 3:08:18 PM
 * on @EclipseEE
 */

@RunWith(Suite.class)
@SuiteClasses({})
@SpringBootTest
class UserSignupSigninTest {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	
	@Test
	@DisplayName("SigUp with valid details")
	public void signUpTest(){
		User user = new User();
		user.setFirst_name("First");
		user.setLast_name("UserTest");
		user.setMobile_no("9876543210");
		user.setAge(25);
		user.setUsername("firstusertest@email.com");
		user.setPassword("Password@123");
		user.setGender("Male");
		
		userService.insertUser(user);
	}
	
	@Test
	@DisplayName("SigIn with valid details")
	public void signInTest(){
		String username = "firstusertest@email.com";
		String password = "Password@123";
		
		AuthenticationStatus res = userService.getStatus(username, password);
	}

}
