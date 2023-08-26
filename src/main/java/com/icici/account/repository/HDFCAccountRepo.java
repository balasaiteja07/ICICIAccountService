package com.icici.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icici.account.model.HDFCAccountDetails;

@Repository
public interface HDFCAccountRepo  extends JpaRepository<HDFCAccountDetails, String>{

}
