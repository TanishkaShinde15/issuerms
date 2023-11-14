package com.issuer.issuerms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.issuer.model.Issuer;

@Repository
public interface IssuerRepository  extends JpaRepository <Issuer,String> {

	
}
