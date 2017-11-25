package com.niit.SayhiBackend.daoimpl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.SayhiBackend.dao.JobDAO;

import com.niit.SayhiBackend.model.Job;
@Repository("jobDAO")
public class JobDAOImpl implements JobDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public JobDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
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
	@Transactional
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
	@Transactional
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
	@Transactional
	public Job getjob(int jobId) {
		
		Session session=sessionFactory.openSession();
		Job job = (Job) session.get(Job.class, jobId);
		session.close();
		return job;
		
	}

	@Transactional
	public ArrayList<Job> getAlljobs() {
		
		Session session = sessionFactory.openSession();
		ArrayList<Job> jobList=(ArrayList<Job>)session.createQuery("from Job").list();
		session.close();
		return jobList;
		
	}

}
