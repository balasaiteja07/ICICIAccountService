package com.icici.account.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icici.account.dto.HDFCAccountDTO;
import com.icici.account.model.HDFCAccountDetails;
import com.icici.account.repository.HDFCAccountRepo;

@Service
public class HDFCAccountService {

	@Autowired
	private HDFCAccountRepo hdfcAccountRepo;

	public HDFCAccountDetails saveAccoutnDetails(HDFCAccountDetails hdfcAccountDet) {

		HDFCAccountDetails response = hdfcAccountRepo.save(hdfcAccountDet);
		HDFCAccountDTO dto = new HDFCAccountDTO();
		BeanUtils.copyProperties(response, dto);
		ObjectMapper obj = new ObjectMapper();
		File file = new File("C:\\Users\\bala srinadh\\OneDrive\\Desktop\\Sai\\HDFCAccountDetails.json");
		try {
			obj.writeValue(file, dto);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;

	}

}
