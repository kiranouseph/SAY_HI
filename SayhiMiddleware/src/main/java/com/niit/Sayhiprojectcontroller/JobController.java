package com.niit.Sayhiprojectcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SayhiBackend.dao.JobDAO;
import com.niit.SayhiBackend.model.Blog;
import com.niit.SayhiBackend.model.Job;

@RestController
@RequestMapping("/jobs")
public class JobController {
@Autowired
JobDAO jobDAO;




@RequestMapping(value="/addJob",method=RequestMethod.POST)
public ResponseEntity<Job> addJob(@RequestBody Job job){
	
	boolean isSaved=jobDAO.addjob(job);
	if(isSaved)
	return new ResponseEntity<Job>(job,HttpStatus.OK);
	else
		return new ResponseEntity<Job>(job,HttpStatus.BAD_REQUEST);
	
}

@RequestMapping(value="/getJob/{jobid}",method=RequestMethod.GET)
public ResponseEntity getBlog(@PathVariable("jobid") int jobId){


if(jobDAO.getjob(jobId)==null){
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such job exists");
}
return new ResponseEntity(jobDAO.getjob(jobId),HttpStatus.OK);	
}

@RequestMapping(value="/getAllJobs",method=RequestMethod.GET,headers="Accept=application/json")
public ResponseEntity getAllJobs(){
	
	if(jobDAO.getAlljobs().isEmpty()){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No jobs registerd..");
	}
	return new ResponseEntity(jobDAO.getAlljobs(),HttpStatus.OK);
			
}



@RequestMapping(value="/deleteJob/{jobid}",method=RequestMethod.DELETE)
public ResponseEntity deleteBlog(@PathVariable("jobid") int jobId){

Job job=jobDAO.getjob(jobId);
jobDAO.deletejob(job);
if(jobDAO.getjob(jobId)==null){
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such job exists");
}
return new ResponseEntity(job,HttpStatus.OK);	
		



}

@RequestMapping(value="/updateJob",method=RequestMethod.PUT)
public ResponseEntity updateBlog(@RequestBody Job job){
	
	boolean isSaved=jobDAO.updatejob(job);
	if(isSaved)
	return new ResponseEntity(job,HttpStatus.OK);
	else
		return new ResponseEntity(job,HttpStatus.BAD_REQUEST);
	
}





}
