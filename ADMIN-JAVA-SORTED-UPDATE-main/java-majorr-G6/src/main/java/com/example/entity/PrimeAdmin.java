package com.example.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("primeAdmin")
public class PrimeAdmin extends User{

	public PrimeAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PrimeAdmin(String username, String email, String password, boolean locked, boolean activated, String role) {
		super(username, email, password, locked, activated, role);
		// TODO Auto-generated constructor stub
	}

}