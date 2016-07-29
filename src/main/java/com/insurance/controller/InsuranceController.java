package com.insurance.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.service.InsuranceService;

@RestController
public class InsuranceController {
	@Autowired
	InsuranceService es;
	
	
	@RequestMapping("/healthinsurance/{policyNumber}")
	public ResponseEntity<?> getInsurance(@PathVariable("policyNumber") int policyNumber) {
		JSONObject restrictedInsurancePolicy =  es.getRestrictedInsurance(policyNumber);
		return new ResponseEntity<>(restrictedInsurancePolicy, HttpStatus.OK);
	}
	
	@RequestMapping("/healthinsurance/{policyNumber}/treatment/{treatmentid}")
	public ResponseEntity<?> getTreatmentDetails(@PathVariable("policyNumber") int policyNumber, @PathVariable("treatmentid") String treatmentid) {
		JSONObject treatmentDetails = es.getTreatmentDetails(policyNumber, treatmentid);
		return new ResponseEntity<>(treatmentDetails, HttpStatus.OK);
	}	
	
	@RequestMapping("/healthinsurance/testservice")
	public ResponseEntity<?> testService() {
		JSONObject testData = new JSONObject();
		testData.put("Status", true);
		return new ResponseEntity<>(testData, HttpStatus.OK);
	}
}

