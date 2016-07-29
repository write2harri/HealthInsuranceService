package com.insurance.repository.policymaster;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.domain.policymaster.TblWebData;


public interface TblWebRepository extends JpaRepository<TblWebData, Long>
{
}
