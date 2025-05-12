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

import com.capgemini.capstone.LMS.entities.BorrowRecord;
import com.capgemini.capstone.LMS.services.BorrowRecordServices;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/borrowRecords")
public class BorrowRecordsController {
	
	private BorrowRecordServices borrowRecordServices;
	
	@Autowired
	public BorrowRecordsController( BorrowRecordServices borrowRecordServices) {
		// TODO Auto-generated constructor stub
		this.borrowRecordServices = borrowRecordServices;
	}
	
	@GetMapping
	public ResponseEntity<List<BorrowRecord>> getAllBorrowRecord()
	{
		List<BorrowRecord> allBorrowRecordsList = borrowRecordServices.findAllRecords();
		return ResponseEntity.status(HttpStatus.OK).body(allBorrowRecordsList);
	}
	
	@PostMapping
	public ResponseEntity<BorrowRecord> createRecord(@RequestBody BorrowRecord record) {
		return ResponseEntity.status(201).body(borrowRecordServices.createRecord(record));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BorrowRecord> updateRecordById(@PathVariable Long id , @RequestBody BorrowRecord record) {
		return ResponseEntity.status(200).body(borrowRecordServices.updateRecordById(id, record));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BorrowRecord> findRecordById(@PathVariable Long id) {
		return ResponseEntity.status(200).body(borrowRecordServices.findRecordById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteRecordById(@PathVariable Long id) {
		return ResponseEntity.status(204).body(borrowRecordServices.deleteRecordById(id));
	}

}
