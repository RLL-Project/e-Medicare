package com.medicare.controller;

public interface UserService {
 void insertUser(User user);
 AuthenticationStatus getStatus(String username,String password);
}
