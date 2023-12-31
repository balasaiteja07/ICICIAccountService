package com.icici.account.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	Logger logger = LoggerFactory.getLogger(ICICIAccountController.class);

	@Autowired
	private ICICIAccountRepo iciciAccountRepo;

	@PostMapping("/create")
	public ResponseEntity<ICICIAccountDetails> createAccount(@RequestBody ICICIAccountDetails iciciAccount) {
		return new ResponseEntity<ICICIAccountDetails>(iciciAccountRepo.save(iciciAccount), HttpStatus.CREATED);

	}
	
	@GetMapping("/getAccount/{accountNo}")
	public ResponseEntity<ICICIAccountDetails> getAccountDetails(@PathVariable String accountNo) throws ICICIAccountNotFoundException{
		logger.info("Entered into getAccountDetails method");
		Optional<ICICIAccountDetails> hdfcAccount = iciciAccountRepo.findById(accountNo);
		if(hdfcAccount.isPresent()) {
			logger.info("Exiting from getAccountDetails method");
			return new ResponseEntity<ICICIAccountDetails>(hdfcAccount.get(),HttpStatus.OK);
		}else {
			logger.error(String.format("Account Details not found for the provided Account Number %s", accountNo));
			throw new ICICIAccountNotFoundException(String.format("Account Details not found for the provided Account Number %s", accountNo));
			
		}
		
		
	}

}
