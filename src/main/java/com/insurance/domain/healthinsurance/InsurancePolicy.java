package com.insurance.domain.healthinsurance;

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

@Entity
@Table(name = "insurancepolicy")
@JsonFilter("myInsurancePolicyFilter")
public class InsurancePolicy implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "policynumber")
	private int policynumber;
	
	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "dob")
	private Date dob;
	
	@Column(name = "dateofissue")
	private Date dateOfIssue;
	
	@Column(name = "insurancetype")
	private String insuranceType;
	
	@Column(name = "sumassured")
	private int sumAssured;
	
	@Column(name = "premiumamount")
	private int premiumAmount;

	@Column(name = "startdate")
	private Date startDate;
	
	@Column(name = "maturitydate")
	private Date maturityDate;
	
	@JsonFormat(pattern="yyyy-MM-dd", timezone="IST")
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@JsonFormat(pattern="yyyy-MM-dd", timezone="IST")
	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public int getSumAssured() {
		return sumAssured;
	}

	public void setSumAssured(int sumAssured) {
		this.sumAssured = sumAssured;
	}

	public int getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(int premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	@JsonFormat(pattern="yyyy-MM-dd", timezone="IST")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@JsonFormat(pattern="yyyy-MM-dd", timezone="IST")
	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
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
