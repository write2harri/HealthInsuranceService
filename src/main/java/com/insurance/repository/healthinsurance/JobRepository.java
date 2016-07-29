package com.insurance.repository.healthinsurance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.domain.healthinsurance.Job;


public interface JobRepository extends JpaRepository<Job, Long>
{
}
