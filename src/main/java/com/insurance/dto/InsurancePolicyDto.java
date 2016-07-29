package com.insurance.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Id;

public class InsurancePolicyDto implements Serializable {

	private int policynumber;
	
	private String firstName;

	private String lastName;
	
	private Date dob;
	
	
	@JsonFormat(pattern="yyyy-MM-dd", timezone="IST")
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getPolicynumber() {
		return policynumber;
	}

	public void setPolicynumber(int policynumber) {
		this.policynumber = policynumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
