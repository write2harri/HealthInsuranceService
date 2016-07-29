package com.insurance.service;

import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.insurance.domain.healthinsurance.InsurancePolicy;
import com.insurance.domain.policymaster.TblWebData;
import com.insurance.domain.policymaster.TreatmentCoverage;
import com.insurance.dto.InsurancePolicyDto;
import com.insurance.repository.healthinsurance.InsurancePolicyRepository;
import com.insurance.repository.policymaster.TreatmentCoverageRepository;

@Service
public class InsuranceService {
	
	@Autowired
	InsurancePolicyRepository insurancePolicyRepository;
	
	@Autowired
	TreatmentCoverageRepository treatmentCoverageRepository;

	public InsurancePolicy getInsurance(int policyNumber) {
		//List<InsurancePolicy> insurancePolicy = insurancePolicyRepository.findAll();
		InsurancePolicy insurancePolicy = insurancePolicyRepository.findByPolicynumber(policyNumber);
		return insurancePolicy;		
	}
	
	public JSONObject getRestrictedInsurance(int policyNumber) {
		/* Get all Insurance data */
		InsurancePolicy insurancePolicy = getInsurance(policyNumber);
		/* Filter Insurance data and send only restricted fields */
		InsurancePolicyDto insurancePolicyDto = null;
		ObjectMapper mapper = new ObjectMapper();
		String[] ignorableFieldNames = { "policynumber", "firstName", "lastName", "dob" };
		FilterProvider filters = new SimpleFilterProvider().addFilter("myInsurancePolicyFilter",
			    SimpleBeanPropertyFilter.filterOutAllExcept(ignorableFieldNames));
		mapper.setFilterProvider(filters);
		String json = null;
		try {
			/* Object to JSON */
			json = mapper.writeValueAsString(insurancePolicy);
			System.out.println("json " + json);
			/* JSON to DTO Object */
			ObjectMapper mapperObj = new ObjectMapper();
			insurancePolicyDto = mapperObj.readValue(json, InsurancePolicyDto.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		/* Custom JSON structure is sent back to Client */
		JSONObject jsonObject = new JSONObject();
		if(insurancePolicy!=null) {
			jsonObject.put("insurancePolicy", insurancePolicyDto);
			jsonObject.put("status", true);
		} else {
			jsonObject.put("status", false);
		}
		return jsonObject;
	}

	public JSONObject getTreatmentDetails(int policyNumber, String treatmentId) {
		System.out.println("policyNumber " + policyNumber + "treatmentId" + treatmentId);
		boolean status = true;
		String errorMsg = null;
		TreatmentCoverage treatmentCoverage = null;
		/* Get all Insurance data */
		InsurancePolicy insurancePolicy = getInsurance(policyNumber);
		/* Validate the Policy# */
		if (insurancePolicy == null) {
			status = false;
			errorMsg = "Invalid Policy# " + policyNumber;
		} else {
			/* Check whether Treatment applicable for the Policy */
			treatmentCoverage = treatmentCoverageRepository.findByTreatmentIdAndPolicyType(treatmentId, insurancePolicy.getInsuranceType());
			if (treatmentCoverage == null) {
				status = false;
				errorMsg = "Invalid TreatmentId " + treatmentId + " or Treatment not applicable for Policy# " + policyNumber;
			}
		}
		System.out.println(errorMsg);
		JSONObject jsonObject = new JSONObject();
		if(errorMsg == null) {
			jsonObject.put("treatmentCoverage", treatmentCoverage);
			jsonObject.put("status", status);
		} else {
			jsonObject.put("message", errorMsg);
			jsonObject.put("status", status);
		}
		return jsonObject;
	}
}
