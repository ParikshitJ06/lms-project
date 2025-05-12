package com.capgemini.capstone.LMS.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstone.LMS.entities.User;
import com.capgemini.capstone.LMS.services.UserServices;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	private UserServices userServices ;
	
	@Autowired
	public UsersController(UserServices userServices) {
		// TODO Auto-generated constructor stub
		this.userServices =  userServices;
		
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(userServices.createUser(user));
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsersList()
	{
		List<User> allUsersList = userServices.findAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(allUsersList);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<User> findUserById(@PathVariable Long id)
	{
		return ResponseEntity.status(200).body(userServices.findUserById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUserById(@PathVariable Long id,@RequestBody User user )
	{
		return ResponseEntity.status(200).body(userServices.updateUserById(id, user));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUserById(@PathVariable Long id )
	{
		userServices.deleteUserById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	

}
