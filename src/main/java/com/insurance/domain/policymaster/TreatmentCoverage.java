package com.insurance.domain.policymaster;

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
@Table(name = "treatmentcoverage")
public class TreatmentCoverage implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "pid")
	private int pid;
	
	@Column(name = "treatmentid")
	private String treatmentId;

	@Column(name = "coverageamt")
	private int coverageAmt;

	@Column(name = "policytype")
	private String policyType;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(String treatmentId) {
		this.treatmentId = treatmentId;
	}

	public int getCoverageAmt() {
		return coverageAmt;
	}

	public void setCoverageAmt(int coverageAmt) {
		this.coverageAmt = coverageAmt;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
}
