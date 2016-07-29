package com.insurance.repository.policymaster;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.domain.healthinsurance.InsurancePolicy;
import com.insurance.domain.policymaster.TreatmentCoverage;


public interface TreatmentCoverageRepository extends JpaRepository<TreatmentCoverage, Long>
{
	TreatmentCoverage findByTreatmentIdAndPolicyType(String treatmentId, String policyType);
}
