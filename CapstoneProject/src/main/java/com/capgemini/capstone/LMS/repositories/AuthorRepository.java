package com.capgemini.capstone.LMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.capstone.LMS.entities.Author;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
	
}
