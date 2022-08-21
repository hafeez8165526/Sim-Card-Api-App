package com.simcardapp.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simcardapp.Exceptions.RecordNotFoundException;
import com.simcardapp.Repository.SimRepo;
import com.simcardapp.entity.SimRecord;

@Service
public class SimService {
	@Autowired
	SimRepo repo;
	
	//add new record
	public String addNewRecord(SimRecord record) {
		repo.saveAndFlush(record);
		return "new record with id "+record.getSim_card_no()+" added";
	}
	
	//get all records
	public List<SimRecord> getAllRecords(){
		return repo.findAll();
	}
	
	//get all records which are expiring in next 30 days
		public List<SimRecord> getExpiringRecords(){
			return repo.findExpiringRecords();
		}
	//update a record with id
	public String updateExistingRecord(int id,SimRecord record) throws RecordNotFoundException{
		try {
			SimRecord re=repo.findById(id).get();
			re.setExpiry_date(record.getExpiry_date());
			re.setFull_name(record.getFull_name());
			re.setKYC(record.getKYC());
			re.setMobile_no(record.getMobile_no());
			re.setSim_card_no(record.getSim_card_no());
			re.setState_of_registration(record.getState_of_registration());
			re.setStatus(record.getStatus());
			re.setTelecom_Provider(record.getTelecom_Provider());
			repo.saveAndFlush(re);
			return "Record with id: "+id+" Updated Succesfully!!!!!";
		}catch(Exception e) {
			throw new RecordNotFoundException("No record Found with id: "+id);
		}
	}
	
	//update validity of a record
	public String updateValidityOfExpiredRecord(int id)  throws RecordNotFoundException{
		try {
			SimRecord re=repo.findById(id).get();
			re.setStatus("working");
			Date l=re.getExpiry_date();
			Calendar c = Calendar.getInstance();
			c.setTime(l);
			c.add(Calendar.DAY_OF_MONTH, 30);
			re.setExpiry_date(c.getTime());
			repo.saveAndFlush(re);
			return "Record with id: "+id+" Renewed Succesfully!!!!!";
		}catch(Exception e) {
			throw new RecordNotFoundException("No record Found with id: "+id);
		}
	}
	
	//delete a record with id
		public String deleteExistingRecord(int id) throws RecordNotFoundException{
			try {
				repo.deleteById(id);
				return "Record with id: "+id+" deleted Succesfully!!!!!";
			}catch(Exception e) {
				throw new RecordNotFoundException("No record Found with id: "+id);
			}
		}
	
}
