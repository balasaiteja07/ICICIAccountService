package com.icici.account.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icici.account.exception.ICICIAccountNotFoundException;
import com.icici.account.model.ICICIAccountDetails;
import com.icici.account.repository.ICICIAccountRepo;

@RestController
@RequestMapping("/icici/account")
public class ICICIAccountController {

	@Autowired
	private ICICIAccountRepo iciciAccountRepo;
	

	@PostMapping("/create")
	public ResponseEntity<ICICIAccountDetails> createAccount(@RequestBody ICICIAccountDetails iciciAccount) {
		return new ResponseEntity<ICICIAccountDetails>(iciciAccountRepo.save(iciciAccount), HttpStatus.CREATED);

	}
	
	@GetMapping("/getAccount/{accountNo}")
	public ResponseEntity<ICICIAccountDetails> getAccountDetails(@PathVariable String accountNo) throws ICICIAccountNotFoundException{
		Optional<ICICIAccountDetails> hdfcAccount = iciciAccountRepo.findById(accountNo);
		if(hdfcAccount.isPresent()) {
			return new ResponseEntity<ICICIAccountDetails>(hdfcAccount.get(),HttpStatus.OK);
		}else {
			throw new ICICIAccountNotFoundException(String.format("Account Details not found for the provided Account Number %s", accountNo));
		}
		
	}

}
