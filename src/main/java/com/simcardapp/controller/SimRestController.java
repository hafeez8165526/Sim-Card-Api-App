package com.simcardapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.simcardapp.Exceptions.RecordNotFoundException;
import com.simcardapp.entity.SimRecord;
import com.simcardapp.service.SimService;

@RestController
public class SimRestController {
	@Autowired
	SimService ser;

	// check status
	@GetMapping("/")
	@ResponseStatus(code = HttpStatus.OK, reason = "OK")
	public String status() {
		return HttpStatus.OK.toString();
	}

	// get all records
	@GetMapping("/listall")
	public List<SimRecord> getAll() {
		return ser.getAllRecords();
	}

	// get all records which are expiring in next 30 days
	@GetMapping("/to-renew")
	public List<SimRecord> getExpiring() {
		return ser.getExpiringRecords();
	}

	// update records validity
	@PutMapping("/to-renew/{id}")
		public String updateValidity(@PathVariable("id") int id) throws RecordNotFoundException {
			return ser.updateValidityOfExpiredRecord(id);
		}

	// add a new record
	@PostMapping("/add")
	public String addRecord(@RequestBody SimRecord record) {
		return ser.addNewRecord(record);
	}

	// update a record with id
	@PutMapping("/{id}")
	public String updateRecord(@PathVariable("id") int id, @RequestBody SimRecord record)
			throws RecordNotFoundException {
		return ser.updateExistingRecord(id, record);
	}

	// delete a record with id
	@DeleteMapping("/{id}")
	public String deleteRecord(@PathVariable("id") int id) throws RecordNotFoundException {
		return ser.deleteExistingRecord(id);
	}

}
