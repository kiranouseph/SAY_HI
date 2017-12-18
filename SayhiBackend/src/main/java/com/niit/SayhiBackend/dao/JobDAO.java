package com.niit.SayhiBackend.dao;

import java.util.ArrayList;


import com.niit.SayhiBackend.model.Job;
import com.niit.SayhiBackend.model.JobApplications;

public interface JobDAO {
	public boolean addjob(Job job);
	public boolean updatejob(Job job);
	public boolean deletejob(Job job);
	public Job getjob(int jobId);
	public ArrayList<Job> getAlljobs();
	public boolean applyJob(JobApplications jobapplications);
	public ArrayList<JobApplications> myjobs(int myid);
	public ArrayList<JobApplications> checkIfApplied(int jobid,int myid);

}
