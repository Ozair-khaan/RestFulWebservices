package com.rest.practice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.practice.Service.UserDaoService;
import com.rest.practice.bean.User;
import com.rest.practice.bean.UserNotFoundException;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService daoService;

	@GetMapping(path = "/users")
	public List<User> retriveAllUsers() {
		return daoService.findAll();
	}

	/*
	 * @GetMapping(path = "/user/{id}") public User retriveUser(@PathVariable int
	 * id) { return daoService.findOne(id); }
	 */

	@PostMapping("/users")
	public void createUser(@RequestBody User user) {
		User savedUser = daoService.save(user);
	}

	@GetMapping(path= "user/{id}")
	public User retrieUser(@PathVariable int id) {
		User user = daoService.findOne(id);
		if (user == null)
			throw new UserNotFoundException("id : " + id);
		return user;
	}

}
