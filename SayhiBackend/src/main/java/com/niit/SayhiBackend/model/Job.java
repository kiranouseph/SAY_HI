package com.niit.SayhiBackend.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Job")
public class Job implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue 
    @Column(name="Job")
	private int jobid;
	 @Column(name="JobProfile")
		private String jobprofile;
	 @Column(name="JobDesc")
		private String jobdesc;
	 @Column(name="Qualification")
		private String quanlification;
	 @Column(name="Status")
		private String status;
	 @Column(name="CreateDate")
		private Date createdate;
	

}
