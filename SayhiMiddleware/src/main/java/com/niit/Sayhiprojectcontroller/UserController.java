package com.niit.Sayhiprojectcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SayhiBackend.dao.UsersDAO;
import com.niit.SayhiBackend.model.Users;

@RestController

@RequestMapping("/user")
public class UserController {
@Autowired
UsersDAO udao;
	
	

	 @RequestMapping(value="/getAllUsers",method=RequestMethod.GET)
		public ResponseEntity getAllUser(){
			
			if(udao.getAllUser().isEmpty()){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No User registerd..");
			}
			return new ResponseEntity(udao.getAllUser(),HttpStatus.OK);
					
		}
	 
	 @RequestMapping(value="/register",method=RequestMethod.POST)
		public ResponseEntity<Users> createUser(@RequestBody Users user){
			System.out.println("In register cvontrolelr");
			boolean isSaved=udao.saveUser(user);
			if(isSaved)
			return new ResponseEntity<Users>(user,HttpStatus.OK);
			else
				return new ResponseEntity<Users>(user,HttpStatus.BAD_REQUEST);
			
		}
		
	 @RequestMapping(value="/getUser/{userid}",method=RequestMethod.GET)
		public ResponseEntity getUser(@PathVariable("userid") int userId){
			
		 if(udao.getUser(userId)==null){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such User registerd..");
			}
			return new ResponseEntity(udao.getUser(userId),HttpStatus.OK);
					
		}
	 @RequestMapping(value="/updateOnlineStatus/{userid}",method=RequestMethod.GET)
		public ResponseEntity updateOnlineStatus(@PathVariable("userid") int userId){
			
			if(udao.getUser(userId)==null){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No User registerd..");
			}
			return new ResponseEntity(udao.updateOnlineStatus(udao.getUser(userId)),HttpStatus.OK);
					
		}
	 
}
