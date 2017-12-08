package com.niit.SayhiBackend.dao;

import java.util.ArrayList;


import com.niit.SayhiBackend.model.Job;

public interface JobDAO {
	public boolean addjob(Job job);
	public boolean updatejob(Job job);
	public boolean deletejob(Job job);
	public Job getjob(int jobId);
	public ArrayList<Job> getAlljobs();

}
