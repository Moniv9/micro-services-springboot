package com.todo.todoapp.controllers;

import java.util.ArrayList;
import java.util.List;

import com.todo.todoapp.model.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class UserController {

	@RequestMapping(value = "/users", produces = "application/json", method = RequestMethod.GET)
	public List<User> getUsers() {
		return getUserList();
	}

	@RequestMapping(value = "/user", produces = "application/json", method = RequestMethod.GET)
	public User getUser(@RequestParam("id") String id) {
		List<User> users = getUserList();
		return users.get(Integer.parseInt(id));
	}

	private List<User> getUserList() {
		List<User> users = new ArrayList<User>();
		users.add(new User("Mohit"));
		users.add(new User("Rahul"));
		users.add(new User("Moniv"));

		return users;
	}

}