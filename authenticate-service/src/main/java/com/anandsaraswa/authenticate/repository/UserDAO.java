package com.anandsaraswa.authenticate.repository;

import java.util.List;

import com.anandsaraswa.authenticate.entity.Users;

public interface UserDAO {
	
	//use dao methods-----------------------------------------
	public List<Users> findAll();
	
	public Users findUserById(int id);
	
	public void save(Users user);
	
	public void deleteById(int id);
	
	public Users findUsernamePassword(String username);
	
}
