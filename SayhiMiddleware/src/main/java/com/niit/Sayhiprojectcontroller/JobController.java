  package com.niit.Sayhiprojectcontroller;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SayhiBackend.dao.JobDAO;
import com.niit.SayhiBackend.dao.UsersDAO;
import com.niit.SayhiBackend.model.Job;
import com.niit.SayhiBackend.model.JobApplications;
import com.niit.SayhiBackend.model.Users;

@RestController
@RequestMapping("/jobs")
public class JobController {
@Autowired
JobDAO jobDAO;

@Autowired
UsersDAO userDAO;


@RequestMapping(value="/addJob",method=RequestMethod.POST)
public ResponseEntity<String> addJob(@RequestBody Job job){
	
	boolean isSaved=jobDAO.addjob(job);
	if(isSaved)
	return new ResponseEntity<String>("Job addes ok",HttpStatus.OK);
	else
		return new ResponseEntity<String>("Job add error",HttpStatus.BAD_REQUEST);
	
}

@RequestMapping(value="/getJob/{jobid}",method=RequestMethod.GET,headers = "Accept=application/json")
public ResponseEntity<Job> getBlog(@PathVariable("jobid") int jobId){

System.out.println("In get job controller"+jobId);
if(jobDAO.getjob(jobId)==null){
	return new ResponseEntity<Job>(jobDAO.getjob(jobId),HttpStatus.BAD_REQUEST);	
	
}
else
{
	return new ResponseEntity<Job>(jobDAO.getjob(jobId),HttpStatus.OK);	
}


}

@RequestMapping(value="/getAllJobs",method=RequestMethod.GET,headers = "Accept=application/json")
public ArrayList<Job> getAllJobs(){
	ArrayList<Job> jobs=(ArrayList<Job>)jobDAO.getAlljobs();
	if(jobs.isEmpty()){
		return null;
	}
	else
	{
		return jobs;	
	}
	
			
}



@RequestMapping(value="/deleteJob/{jobid}",method=RequestMethod.DELETE)
public ResponseEntity<String> deleteBlog(@PathVariable("jobid") int jobId){

Job job=jobDAO.getjob(jobId);
if(jobDAO.deletejob(job))
{
	return new ResponseEntity<String>("Job deleted successfully",HttpStatus.OK);	
}
return new ResponseEntity<String>("Job deletion error",HttpStatus.BAD_REQUEST);	
		



}

@RequestMapping(value="/updateJob",method=RequestMethod.PUT)
public ResponseEntity<String> updateBlog(@RequestBody Job job){
	
	boolean isSaved=jobDAO.updatejob(job);
	if(isSaved)
	return new ResponseEntity<String>("job update succcess",HttpStatus.OK);
	else
		return new ResponseEntity<String>("job update failure",HttpStatus.BAD_REQUEST);
	
}


@RequestMapping(value="/applyJob/{jobid}/{myid}",method=RequestMethod.GET)
public ResponseEntity<String> applyJob(@PathVariable("jobid") int jobid,@PathVariable("myid") int myid)
{
	JobApplications jobapplications=new JobApplications();
	jobapplications.setJobid(jobid);
	jobapplications.setUserid(myid);
	boolean isSaved=jobDAO.applyJob(jobapplications);
	if(isSaved)
	{
		return new ResponseEntity<String>("job applied successfully",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("job apply failed",HttpStatus.BAD_REQUEST);
	}
}


@RequestMapping(value="/myjobs/{myid}",method=RequestMethod.GET)
public ArrayList<Job> myjobs(@PathVariable("myid") int myid)
{ArrayList<Job> myjobs=new ArrayList<Job>();
	ArrayList<JobApplications> jobappli =jobDAO.myjobs(myid);
	for(JobApplications jobapp:jobappli)
	{
		
		myjobs.add(jobDAO.getjob(jobapp.getJobapplyid()));
		
	}
	return myjobs;
}

@RequestMapping(value="/checkifapplied/{jobid}/{myid}",method=RequestMethod.GET)
public ArrayList<JobApplications> checkifapplied(@PathVariable("jobid") int jobid,@PathVariable("myid") int myid)
{
	return jobDAO.checkIfApplied(jobid, myid);
}

@RequestMapping(value="/jobapplicants/{jobid}",method=RequestMethod.GET)
public ArrayList<Users> jobapps(@PathVariable("jobid") int jobid)
{ArrayList<Users> u=new ArrayList<Users>();
	ArrayList<JobApplications> jobapps=jobDAO.jobapps(jobid);
	for(JobApplications j:jobapps)
	{
		Users us=userDAO.getUser(j.getUserid());
		u.add(us);
	}
	return u;
}




}
