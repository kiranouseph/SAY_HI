package com.niit.SayhiBackend.daoimpl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SayhiBackend.dao.JobDAO;

import com.niit.SayhiBackend.model.Job;

public class JobDAOImpl implements JobDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public JobDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	public boolean addjob(Job job) {
		
		try
		{
		sessionFactory.getCurrentSession().save(job);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
		
	}

	public boolean updatejob(Job job) {

		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(job);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}

	public boolean deletejob(Job job) {
		

		try
		{
		sessionFactory.getCurrentSession().delete(job);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
		
	}

	public Job getjob(int jobId) {
		
		Session session=sessionFactory.openSession();
		Job job = (Job) session.get(Job.class, jobId);
		session.close();
		return job;
		
	}

	public ArrayList<Job> getAlljobs() {
		
		Session session = sessionFactory.openSession();
		ArrayList<Job> jobList=(ArrayList<Job>)session.createQuery("from Job");
		session.close();
		return jobList;
		
	}

}
