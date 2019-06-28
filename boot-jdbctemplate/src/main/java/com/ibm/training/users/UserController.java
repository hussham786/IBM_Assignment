package com.ibm.training.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.training.bean.User;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping("/users")
	List<User> getUsers(){
		return service.getUsers();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/users")
	void insertUser(@RequestBody User user) {
		service.insertUser(user);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	void updateUser(@RequestBody User user, @PathVariable Integer id) {
		service.updateUser(user, id);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	void deleteUser(@PathVariable Integer id) {
		service.deleteUser(id);
	}
	
	@RequestMapping("/users/{id}")
	User getUser(@PathVariable("id") int userId) {
		return service.getUser(userId);
	}
}
