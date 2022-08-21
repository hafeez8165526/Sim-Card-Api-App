package com.simcardapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
public class SimRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="sim_card_no")
	@Size(min = 10,max=10,message = "length not valid")
	String Sim_card_no;
	
	@Column(name="mobile_no")
	@Size(min=10,max=10,message = "length not valid")
	String Mobile_no;
	
	@Column(name="status")
	String Status;
	
	@Temporal(TemporalType.DATE)
	@Column(name="expiry_date")
	Date Expiry_date;
	
	@Column(name="state_of_registration")
	String State_of_registration;
	
	@Column(name="kyc")
	String KYC;
	
	@Column(name="telecom_provider")
	String Telecom_Provider;
	
	@Column(name="full_name")
	String Full_name;
	
	public SimRecord() {
		super();
	}
	public SimRecord(int Id,String sim_card_no, String mobile_no, String status, Date expiry_date, String state_of_registration,
			String kYC, String telecom_Provider, String full_name) {
		super();
		id=Id;
		Sim_card_no = sim_card_no;
		Mobile_no = mobile_no;
		Status = status;
		Expiry_date = expiry_date;
		State_of_registration = state_of_registration;
		KYC = kYC;
		Telecom_Provider = telecom_Provider;
		Full_name = full_name;
	}
	public int getId() { return id;}
	public void setId(int i) {
		this.id=id;
	}
	public String getSim_card_no() {
		return Sim_card_no;
	}
	public void setSim_card_no(String sim_card_no) {
		Sim_card_no = sim_card_no;
	}
	public String getMobile_no() {
		return Mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		Mobile_no = mobile_no;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Date getExpiry_date() {
		return Expiry_date;
	}
	public void setExpiry_date(Date expiry_date) {
		Expiry_date = expiry_date;
	}
	public String getState_of_registration() {
		return State_of_registration;
	}
	public void setState_of_registration(String state_of_registration) {
		State_of_registration = state_of_registration;
	}
	public String getKYC() {
		return KYC;
	}
	public void setKYC(String kYC) {
		KYC = kYC;
	}
	public String getTelecom_Provider() {
		return Telecom_Provider;
	}
	public void setTelecom_Provider(String telecom_Provider) {
		Telecom_Provider = telecom_Provider;
	}
	public String getFull_name() {
		return Full_name;
	}
	public void setFull_name(String full_name) {
		Full_name = full_name;
	}
	

}
