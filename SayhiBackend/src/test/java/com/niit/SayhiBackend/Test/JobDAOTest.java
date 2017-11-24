package com.niit.SayhiBackend.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SayhiBackend.dao.BlogDAO;
import com.niit.SayhiBackend.dao.JobDAO;
import com.niit.SayhiBackend.model.Job;

public class JobDAOTest {
	
	@Autowired
	private static  JobDAO jobDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.SayhiBackend");
		context.refresh();
		
		jobDAO=(JobDAO)context.getBean("jobDAO");
	}

	@Test
	public void addjob()
	{
		Job job=new Job();
		job.setJobdesc("Devops");
		job.setJobid(8523);
		job.setJobprofile("Web App developer");
		job.setQuanlification("Graduation");
		job.setStatus("N");
		assertTrue("Problem in inserting job",jobDAO.addjob(job));		
	}
	
	@Test
	public void getJob()
	{
		Job job=jobDAO.getjob(41);
		System.out.println(job.getJobdesc());
		
		
	}
	
	
	@Test
	public void getAllJobs()
	{
		
		ArrayList<Job> job=(ArrayList<Job>)jobDAO.getAlljobs();
		for(Job j:job)
		{
			System.out.println(j.getJobdesc());
			
		}
		
	}

@Test
public void updateJob()
{

	Job job=jobDAO.getjob(41);
	job.setJobdesc("software developer");
	assertTrue("problem in updating Job",jobDAO.updatejob(job));
	
}
	@Test
	public void deletejob()
	{
		
		Job job=jobDAO.getjob(41);
		assertTrue("problem in deleting Job",jobDAO.deletejob(job));
	}
}
