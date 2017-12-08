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
import com.niit.SayhiBackend.model.Users;

@RestController

@RequestMapping("/user")
public class UserController {
@Autowired
UsersDAO userDAO;
@Autowired
JobDAO jobDAO;	
	

	 @RequestMapping(value="/getAllUsers",method=RequestMethod.GET)
		public ResponseEntity<ArrayList<Users>> getAllUser(){
			
			if(userDAO.getAllUser().isEmpty()){
				
			}
			return new ResponseEntity<ArrayList<Users>>(userDAO.getAllUser(),HttpStatus.OK);
					
		}
	 
	 
	 @RequestMapping(value="/register",method=RequestMethod.POST)
		public ResponseEntity<Users> createUser(@RequestBody Users user){
			System.out.println("In register controller");
			boolean isSaved=userDAO.saveUser(user);
			if(isSaved) {
			return new ResponseEntity<Users>(user,HttpStatus.OK);
			}
			else
				return new ResponseEntity<Users>(user,HttpStatus.BAD_REQUEST);
			
		}
	
	 
	 
	 @RequestMapping(value="/getUser/{userid}",method=RequestMethod.GET)
		public ResponseEntity<Users> getUser(@PathVariable("userid") int userId){
			
		 if(userDAO.getUser(userId)==null){
				
			}
			return new ResponseEntity<Users>(userDAO.getUser(userId),HttpStatus.OK);
					
		}
	 @RequestMapping(value="/updateOnlineStatus/{userid}",method=RequestMethod.GET)
		public ResponseEntity<Users> updateOnlineStatus(@PathVariable("userid") int userId){
			
			if(!(userDAO.getUser(userId)==null)){
				Users users=userDAO.getUser(userId);
				userDAO.updateOnlineStatus(users);
				return new ResponseEntity<Users>(users,HttpStatus.OK);
			}
			
			return null;		
		}
	
	 @RequestMapping(value="/job",method=RequestMethod.POST)
		public ResponseEntity<Job> getJob(){
		
			
				return new ResponseEntity<Job>(jobDAO.getjob(201),HttpStatus.BAD_REQUEST);
			
		}
}
