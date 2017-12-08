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

import com.niit.SayhiBackend.model.Job;

@RestController
@RequestMapping("/jobs")
public class JobController {
@Autowired
JobDAO jobDAO;




@RequestMapping(value="/addJob",method=RequestMethod.POST)
public ResponseEntity<String> addJob(@RequestBody Job job){
	
	boolean isSaved=jobDAO.addjob(job);
	if(isSaved)
	return new ResponseEntity<String>("Job addes ok",HttpStatus.OK);
	else
		return new ResponseEntity<String>("Job add error",HttpStatus.BAD_REQUEST);
	
}



@RequestMapping(value="/getJob/{jobid}",method=RequestMethod.GET)
public ResponseEntity<Job> getBlog(@PathVariable("jobid") int jobId){


if(jobDAO.getjob(jobId)==null){
	return new ResponseEntity<Job>(jobDAO.getjob(jobId),HttpStatus.OK);	
}
else
{
return new ResponseEntity<Job>(jobDAO.getjob(jobId),HttpStatus.OK);	
}


}

@RequestMapping(value="/getAllJobs",method=RequestMethod.GET)
public ResponseEntity<ArrayList<Job>> getAllJobs(){
	
	if(jobDAO.getAlljobs().isEmpty()){
		return new ResponseEntity<ArrayList<Job>>(jobDAO.getAlljobs(),HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<ArrayList<Job>>(jobDAO.getAlljobs(),HttpStatus.OK);	
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





}
