package com.capgemini.capstone.LMS.services;
import java.util.*;
import com.capgemini.capstone.LMS.entities.BorrowRecord;

public interface BorrowRecordServices {
	
	public BorrowRecord createRecord(BorrowRecord record);
	public BorrowRecord updateRecordById( Long id , BorrowRecord record);
	public BorrowRecord findRecordById(Long id);
	public List<BorrowRecord> findAllRecords(); 
	public Boolean deleteRecordById(Long id);

}
