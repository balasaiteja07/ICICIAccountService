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

import com.icici.account.exception.HDFCAcccountNotFoundException;
import com.icici.account.model.HDFCAccountDetails;
import com.icici.account.repository.HDFCAccountRepo;
import com.icici.account.service.HDFCAccountService;

@RestController
@RequestMapping("/hdfc/account")
public class HDFCAccountController {

	@Autowired
	private HDFCAccountRepo hdfcAccountRepo;
	
	@Autowired
	private HDFCAccountService hdfcAccountService;

	@PostMapping("/create")
	public ResponseEntity<HDFCAccountDetails> createAccount(@RequestBody HDFCAccountDetails hdfcAccount) {
		return new ResponseEntity<HDFCAccountDetails>(hdfcAccountService.saveAccoutnDetails(hdfcAccount), HttpStatus.CREATED);

	}
	
	@GetMapping("/getAccount/{accountNo}")
	public ResponseEntity<HDFCAccountDetails> getAccountDetails(@PathVariable String accountNo){
		Optional<HDFCAccountDetails> hdfcAccount = hdfcAccountRepo.findById(accountNo);
		if(hdfcAccount.isPresent()) {
			return new ResponseEntity<HDFCAccountDetails>(hdfcAccount.get(),HttpStatus.OK);
		}else {
			throw new HDFCAcccountNotFoundException(String.format("Account Details not found for the provided Account Number %s", accountNo));
		}
		
	}

}
