package com.insurance.repository.healthinsurance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.domain.healthinsurance.InsurancePolicy;


public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long>
{
	InsurancePolicy findByPolicynumber(int policyNumber);
}
