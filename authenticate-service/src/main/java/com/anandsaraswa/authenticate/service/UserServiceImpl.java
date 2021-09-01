package com.anandsaraswa.authenticate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anandsaraswa.authenticate.entity.Users;
import com.anandsaraswa.authenticate.repository.UserDAO;



@Service
public class UserServiceImpl implements UserService{
	
	private UserDAO userDao;
	
	@Autowired
	public UserServiceImpl(@Qualifier("userHibernateImpl") UserDAO userDao) {
		this.userDao  =  userDao;
		
	}

	@Override
	@Transactional
	public List<Users> findAll() {
		return userDao.findAll();
	}

	@Override
	@Transactional
	public Users findUserById(int id) {
		return userDao.findUserById(id);
	}

	@Override
	@Transactional
	public void save(Users user) {
		userDao.save(user);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		userDao.deleteById(id);
	}

	@Override
	@Transactional
	public Users findUsernamePassword(String username) {
	
		return userDao.findUsernamePassword(username) ;
	}

}
