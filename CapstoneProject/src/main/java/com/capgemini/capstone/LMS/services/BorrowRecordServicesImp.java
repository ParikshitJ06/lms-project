package com.capgemini.capstone.LMS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstone.LMS.entities.BorrowRecord;
import com.capgemini.capstone.LMS.repositories.BorrowRecordRepository;

@Service
public class BorrowRecordServicesImp implements BorrowRecordServices{

	private BorrowRecordRepository borrowRecordRepository;
	
	@Autowired
	public BorrowRecordServicesImp(BorrowRecordRepository borrowRecordRepository) {
		// TODO Auto-generated constructor stub
		this.borrowRecordRepository = borrowRecordRepository;
	}
	
	@Override
	public BorrowRecord createRecord(BorrowRecord record) {
		// TODO Auto-generated method stub
		return borrowRecordRepository.save(record);
	}

	@Override
	public BorrowRecord updateRecordById( Long id ,BorrowRecord rec) {
		// TODO Auto-generated method stub
		BorrowRecord br  = borrowRecordRepository.findById(id).orElseThrow(()-> new RuntimeException("Book record with this id not found"+id));
		br.setBorrowDate(rec.getBorrowDate());
		br.setReturnDate(rec.getReturnDate());
		br.setStatus(br.getStatus());
		br.setBookId(rec.getBookId()); // no need of this actually
		br.setUserId(rec.getUserId());
		return borrowRecordRepository.save(br);
	}

	@Override
	public BorrowRecord findRecordById(Long id) {
		// TODO Auto-generated method stub
		return borrowRecordRepository.findById(id).orElseThrow(()-> new RuntimeException("Book record with this id not found"+id));
	}

	@Override
	public List<BorrowRecord> findAllRecords() {
		// TODO Auto-generated method stub
		return borrowRecordRepository.findAll();
	}

	@Override
	public Boolean deleteRecordById(Long id) {
		// TODO Auto-generated method stub
		BorrowRecord rec =  borrowRecordRepository.findById(id).orElseThrow(()-> new RuntimeException("Book record with this id not found"+id));
		borrowRecordRepository.delete(rec);
		return true ;
		
	}

}
