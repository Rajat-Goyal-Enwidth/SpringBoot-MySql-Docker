package com.root.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.entity.User;
import com.root.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User createUser(User user)
	{
		return userRepository.save(user);
	}
	
	public List<User> findAllUsers()
	{
		return userRepository.findAll();
	}
	
	public User updateUser(int userId, User user)
	{
		userRepository.findById(userId);
		user.setName(user.getName());
		user.setCountry(user.getCountry());
		return userRepository.save(user);
	}
	
	public List<User> deleteUser(int userId)
	{
		userRepository.deleteById(userId);
		return userRepository.findAll();
	}
	
	public Optional<User> findUserById(int userId)
	{
		return userRepository.findById(userId);
	}
	
}
