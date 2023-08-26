package com.icici.account.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class HDFCAccountDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String accountNo;
	
	private String accountHolderName;
	private String gender;
	private double balance;
	private String address;
	private String ifscCode;
	private Date dateOfBirth;
	private long phoneNumber;
	

}
