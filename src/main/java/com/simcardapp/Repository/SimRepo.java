package com.simcardapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simcardapp.entity.SimRecord;

@Repository
public interface SimRepo extends JpaRepository<SimRecord, Integer>{
	
	@Query(value ="SELECT * FROM SIM_RECORD WHERE EXPIRY_DATE =TRUNC(NOW())+30",nativeQuery = true)
	public List<SimRecord> findExpiringRecords();
}
