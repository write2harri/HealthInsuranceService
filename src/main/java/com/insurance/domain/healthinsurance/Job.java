package com.insurance.domain.healthinsurance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "job")
public class Job implements Serializable
{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name = "jobid")
  private int jobId;
  
  public int getId()
  {
    return jobId;
  }

  public void setId(final int jobId)
  {
    this.jobId = jobId;
  }
  
  @Column(name = "jobname")
  private String jobName;

  public String getJobName()
  {
    return jobName;
  }

  public void setJobName(final String jobName)
  {
    this.jobName = jobName;
  }
}
