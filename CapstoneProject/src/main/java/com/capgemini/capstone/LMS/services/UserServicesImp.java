package com.capgemini.capstone.LMS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstone.LMS.entities.User;
import com.capgemini.capstone.LMS.repositories.UserRepository;

@Service
public class UserServicesImp implements UserServices{

	private UserRepository ur;
	
	@Autowired
	public UserServicesImp(UserRepository ur) {
		// TODO Auto-generated constructor stub
		this.ur = ur;
	}
	@Override
	public User createUser(User u) {
		// TODO Auto-generated method stub
		return ur.save(u);
	}
	@Override
	public User updateUserById( Long id ,User u) {
		// TODO Auto-generated method stub
		User us = ur.findById(id).orElseThrow( ()->new RuntimeException("user with this id not found"+id));
		us.setName(u.getName());
		us.setEmail(u.getEmail()); // need to remove this as we shouldnt allow this for user
		us.setPassword(u.getPassword());
		us.setPhone(u.getPhone());
		return ur.save(us);
	}
	@Override
	public User findUserById(Long id) {
		// TODO Auto-generated method stub
		return ur.findById(id).orElseThrow(()->new RuntimeException("user with this id not found"+id));
	}
	@Override
	public Boolean deleteUserById(Long id) {
		// TODO Auto-generated method stub
		System.err.println("we are deleting this id"+id);
		User user = ur.findById(id).orElseThrow(()->new RuntimeException("user with this id not found"+id));
		ur.delete(user);
		System.out.println("user with id "+id+" deleted ");
		return true;
	}
	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return ur.findAll();
	}
	
}
