package com.root.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.root.entity.User;
import com.root.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/create")
	public User create(@RequestBody User user) {
		return userService.createUser(user);
	}

	@GetMapping("/users")
	public List<User> findAll() {
		return userService.findAllUsers();
	}

	@PutMapping("/update/{user_id}")
	public User update(@PathVariable("user_id") int userId, @RequestBody User userObject) {
		Optional<User> user = userService.findUserById(userId);
		User oldUser = user.get();
		oldUser.setName(userObject.getName());
		oldUser.setCountry(userObject.getCountry());

		return userService.createUser(oldUser);
	}

	@DeleteMapping("/delete/{user_id}")
	public List<User> delete(@PathVariable("user_id") int userId) {
		userService.deleteUser(userId);
		return userService.findAllUsers();
	}

	@GetMapping("/find/{user_id}")
	public User findByUserId(@PathVariable("user_id") int userId) {
		Optional<User> user = userService.findUserById(userId);
		User userold = user.get();
		return userold;
	}

}
