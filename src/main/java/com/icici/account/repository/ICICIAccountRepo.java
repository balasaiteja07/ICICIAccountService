package com.icici.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icici.account.model.ICICIAccountDetails;

@Repository
public interface ICICIAccountRepo extends JpaRepository<ICICIAccountDetails, String>{

}
