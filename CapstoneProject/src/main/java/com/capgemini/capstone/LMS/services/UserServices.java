package com.capgemini.capstone.LMS.services;

import java.util.List;

import com.capgemini.capstone.LMS.entities.User;

public interface UserServices {
	public User createUser(User u);
	public User updateUserById( Long id ,User u);
	public User findUserById(Long id);
	public Boolean deleteUserById(Long id);
	public List<User> findAllUsers();
}
