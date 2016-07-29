package com.insurance.domain.policymaster;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblWeb_Data")
public class TblWebData implements Serializable
{
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  @Column(name = "job_number")
	  private int jobNumber;
	  
	  public int getJobNumber()
	  {
	    return jobNumber;
	  }

	  public void setJobNumber(final int jobNumber)
	  {
	    this.jobNumber = jobNumber;
	  }
	  
	  @Column(name = "revision")
	  private Integer revision;

	  public Integer getRevision()
	  {
	    return revision;
	  }

	  public void setRevision(final Integer revision)
	  {
	    this.revision = revision;
	  }
}
